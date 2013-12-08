/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladordepeticiones;

import dao.DAOAlumno;
import dao.DAOAsignatura;
import dao.DAOCurso;
import dao.DAOPlanDeEstudio;
import dao.DAOUsuario;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Asignatura;
import modelo.Curso;
import modelo.Modulo;
import modelo.PlanDeEstudio;
import modelo.Usuario;

/**
 *
 * @author brentheftye
 */
public class ControladorDePeticiones {

    private static ControladorDePeticiones controladorDePeticiones = new ControladorDePeticiones();

    private ControladorDePeticiones() {
    }

    public static ControladorDePeticiones getControladorDePeticiones() {
        return controladorDePeticiones;
    }

    public boolean agregarAlumno(Alumno alumno) {
        int numeroFilasAfectadas = DAOAlumno.getDAOAlumno().insertar(alumno);
        if (numeroFilasAfectadas > 0) {
            return true;
        }
        return false;
    }

    public boolean modificarAlumno(Alumno alumno) {
        int numeroFilasAfectadas = DAOAlumno.getDAOAlumno().actualizar(alumno);
        if (numeroFilasAfectadas > 0) {
            return true;
        }
        return false;
    }

    public boolean agregarPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        int numeroFilasAfectadas = DAOPlanDeEstudio.getDAOPlanDeEstudio().insertar(planDeEstudio);
        if (numeroFilasAfectadas > 0) {
            return true;
        }
        return false;
    }

    public boolean agregarCurso(Curso curso) {
        int numeroFilasAfectadas = DAOCurso.getDAOCurso().insertar(curso);
        if (numeroFilasAfectadas > 0) {
            return true;
        }
        return false;
    }

    public boolean darAltaUsuario(Usuario usuario) {
        int numeroFilasAfectadas = DAOUsuario.getDAOUsuario().insertar(usuario);
        if (numeroFilasAfectadas > 0) {
            return true;
        }
        return false;
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        return DAOUsuario.getDAOUsuario().consultar("select * from usuario order by clvusuario asc");
    }

    public ArrayList<Curso> obtenerCurso(String nombreCurso) {
        return DAOCurso.getDAOCurso().consultar("select * from curso WHERE nomCurso = '" + nombreCurso + "'");

    }

    public boolean agregarAsignatura(Asignatura nuevaAsignatura) {
        int numeroFilasAfectadas = DAOAsignatura.getDAOAsignatura().insertar(nuevaAsignatura);
        if (numeroFilasAfectadas > 0) {
            return true;
        }
        return false;
    }

    public boolean registraAsignaturaEnPlanDeEstudio(int clavePlanDeEstudio, int modulo, String claveAsignatura) {
        String queryDeRegistro = "INSERT INTO planmoduloasignatura (clvplan, clvmodulo,clvasign) VALUES (" + clavePlanDeEstudio + "," + modulo + ",'" + claveAsignatura + "')";
        int numeroFilasAfectadas = DAOAsignatura.getDAOAsignatura().ejecutaQuery(queryDeRegistro);
        if (numeroFilasAfectadas > 0) {
            return true;
        }
        return false;
    }

    public int obtenClaveDePlanDeEstudioPorNombre(String nombrePlanDeEstudio) {
        String queryDeConsulta = "SELECT * FROM plandeestudio WHERE nomplan = '" + nombrePlanDeEstudio + "'";
        return DAOPlanDeEstudio.getDAOPlanDeEstudio().obtenerClaveDePlanDeEstudioPorNombre(queryDeConsulta);
    }

    public boolean eliminarPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        int numeroFilasAfectadas = DAOPlanDeEstudio.getDAOPlanDeEstudio().eliminar(planDeEstudio);
        if (numeroFilasAfectadas > 0) {
            return true;
        }
        return false;
    }

    public ArrayList<PlanDeEstudio> obtenerPlanesDeEstudio() {
        int NUM_DE_MODULOS = 6;
        String queryDeConsulta = "select * from plandeestudio order by clvplan asc ";
        ArrayList<PlanDeEstudio> planesDeEstudio = DAOPlanDeEstudio.getDAOPlanDeEstudio().consultar(queryDeConsulta);
        for (int i = 0; i < planesDeEstudio.size(); i++) {
            PlanDeEstudio planDeEstudioIndexado = planesDeEstudio.get(i);
            for (int j = 0; j < NUM_DE_MODULOS; j++) {
                Modulo moduloIndexado = planDeEstudioIndexado.getModulos().get(j);
                String queryDeAsignaturasDeModulo = "select clvasig,nomasig,serializacion,creditos,duracion from planmoduloasignatura,asignatura where clvplan = " + planDeEstudioIndexado.getClave() + " and clvmodulo = " + (j + 1) + " and clvasign = clvasig";
                moduloIndexado.setAsignaturas(DAOAsignatura.getDAOAsignatura().consultar(queryDeAsignaturasDeModulo));
            }
        }
        return planesDeEstudio;
    }

    public ArrayList<Alumno> obtenerAlumnos() {
        ArrayList<Alumno> alumnos = DAOAlumno.getDAOAlumno().consultar("select * from alumno");
        int NUM_ALUMNOS = alumnos.size();
        for (int i = 0; i < NUM_ALUMNOS ; i++) {
            Alumno alumnoIndexado = alumnos.get(i);
            PlanDeEstudio copiaPlanDeEstudio = obtenerNuevoPlanDeEstudioPorClave(alumnoIndexado.getPlanDeEstudio().getClave());
            alumnoIndexado.setPlanDeEstudio(copiaPlanDeEstudio);
            int clavePlanDeEstudio = copiaPlanDeEstudio.getClave();
            int NUM_DE_MODULOS = 6;
            for (int j = 0; j < NUM_DE_MODULOS; j++) {
            int claveModulo = j+1;
            Modulo moduloIndexado = copiaPlanDeEstudio.getModulos().get(j);
            int NUM_ASIGNATURAS_DEL_MODULO = moduloIndexado.getAsignaturas().size();
            for (int k = 0; k < NUM_ASIGNATURAS_DEL_MODULO; k++) {
                Asignatura asignaturaIndexada = moduloIndexado.getAsignaturas().get(k);
                String claveAsignatura = asignaturaIndexada.getClave();
                String queryCalificacion = "select calificacion from calificaciones where clvalumno = '"+alumnoIndexado.getMatricula()+"' and clvplan = "+clavePlanDeEstudio+" and clvmodulo = "+claveModulo+" and clvasign = '"+claveAsignatura+"'";
                int calificacion = DAOAsignatura.getDAOAsignatura().obtenerCalificacion(queryCalificacion);
                asignaturaIndexada.setCalificacion(calificacion);
            }
        }
            
        }
        System.out.println(alumnos.size());
        return alumnos;
    }

    public PlanDeEstudio obtenerNuevoPlanDeEstudioPorClave(int clavePlanDeEstudio) {
        int NUM_DE_MODULOS = 6;
        String queryDeConsulta = "select * from plandeestudio where clvplan =" + clavePlanDeEstudio;
        PlanDeEstudio planDeEstudio = DAOPlanDeEstudio.getDAOPlanDeEstudio().obtenerPlanDeEstudio(queryDeConsulta);
        if (planDeEstudio != null) {
            for (int j = 0; j < NUM_DE_MODULOS; j++) {
                Modulo moduloIndexado = planDeEstudio.getModulos().get(j);
                String queryDeAsignaturasDeModulo = "select clvasig,nomasig,serializacion,creditos,duracion from planmoduloasignatura,asignatura where clvplan = " + planDeEstudio.getClave() + " and clvmodulo = " + (j + 1) + " and clvasign = clvasig";
                moduloIndexado.setAsignaturas(DAOAsignatura.getDAOAsignatura().consultar(queryDeAsignaturasDeModulo));
            }
            return planDeEstudio;
        }
        return null;
    }
    
    public void registrarBoletaVaciaDeAlumno(Alumno alumno){
        PlanDeEstudio planDeEstudio = alumno.getPlanDeEstudio();
        int clavePlanDeEstudio = planDeEstudio.getClave();
        int claveModulo = 0;
        String claveAsignatura = "";
        int NUM_DE_MODULOS = 6;
        for (int i = 0; i < NUM_DE_MODULOS; i++) {
            claveModulo = i+1;
            Modulo moduloIndexado = planDeEstudio.getModulos().get(i);
            int NUM_ASIGNATURAS_DEL_MODULO = moduloIndexado.getAsignaturas().size();
            for (int j = 0; j < NUM_ASIGNATURAS_DEL_MODULO; j++) {
                Asignatura asignaturaIndexada = moduloIndexado.getAsignaturas().get(j);
                claveAsignatura = asignaturaIndexada.getClave();
                String query = "insert into calificaciones (clvalumno,clvplan,clvmodulo,clvasign) values ('"+alumno.getMatricula()+"','"+clavePlanDeEstudio+"','"+claveModulo+"','"+claveAsignatura+"')";
                DAOAsignatura.getDAOAsignatura().ejecutaQuery(query);
            }
        }
    }
}
