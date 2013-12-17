/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

import accesodatos.dao.DAOAlumno;
import accesodatos.dao.DAOAsignatura;
import accesodatos.dao.DAOCurso;
import accesodatos.dao.DAOPlanDeEstudio;
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

    public static ControladorDePeticiones getControladorDePeticiones() {
        return controladorDePeticiones;
    }

    public boolean agregarAlumno(Alumno alumno) {
        ControladorDAOAlumno controladorDAOAlumno = ControladorDAOAlumno.getControladorDAOAlumno();
        boolean agrego = controladorDAOAlumno.agregar(alumno);
        return agrego;
    }

    public boolean modificarAlumno(Alumno alumno){
        ControladorDAOAlumno controladorDAOAlumno = ControladorDAOAlumno.getControladorDAOAlumno();
        boolean modifico = controladorDAOAlumno.modificar(alumno);
        return modifico;
    }

    public boolean agregarPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        ControladorDAOPlanDeEstudio controladorDAOPlanDeEstudio = ControladorDAOPlanDeEstudio.getControladorDAOPlanDeEstudio();
        boolean agrego = controladorDAOPlanDeEstudio.agregar(planDeEstudio);
        return agrego;
    }

    public boolean agregarCurso(Curso curso) {
        int numeroFilasAfectadas = DAOCurso.getDAOCurso().insertar(curso);
        if (numeroFilasAfectadas > 0) {
            return true;
        }
        return false;
    }

    public boolean darAltaUsuario(Usuario usuario) {
        ControladorDAOUsuario controladorDAOUsuario = ControladorDAOUsuario.getControladorDAOUsuario();
        boolean dioAlta = controladorDAOUsuario.agregar(usuario);
        return dioAlta;
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        ControladorDAOUsuario controladorDAOUsuario = ControladorDAOUsuario.getControladorDAOUsuario();
        return controladorDAOUsuario.obtenTodosLosUsuarios();
    }

    public ArrayList<Curso> obtenerCursos() {
        ArrayList<Curso> cursos = DAOCurso.getDAOCurso().consultar("select * from curso");
        int NUM_ALUMNOS = cursos.size();
        for (int i = 0; i < NUM_ALUMNOS; i++) {
            Curso cursoIndexado = cursos.get(i);
            PlanDeEstudio copiaPlanDeEstudio = obtenerCopiaPlanDeEstudioPorClave(cursoIndexado.getPlanDeEstudio().getClave());
            cursoIndexado.setPlanDeEstudio(copiaPlanDeEstudio);
            int clavePlanDeEstudio = copiaPlanDeEstudio.getClave();
            int NUM_DE_MODULOS = 6;
            for (int j = 0; j < NUM_DE_MODULOS; j++) {
                int claveModulo = j + 1;
                Modulo moduloIndexado = copiaPlanDeEstudio.getModulos().get(j);
                int NUM_ASIGNATURAS_DEL_MODULO = moduloIndexado.getAsignaturas().size();
                for (int k = 0; k < NUM_ASIGNATURAS_DEL_MODULO; k++) {
                    Asignatura asignaturaIndexada = moduloIndexado.getAsignaturas().get(k);
                    String claveAsignatura = asignaturaIndexada.getClave();
                    String queryFechaImparticion = "select fechaimparticion from curso where nomcurso = '" + cursoIndexado.getNombre() + "' and clvplan = " + clavePlanDeEstudio + " and clvmodulo = " + claveModulo + " and clvasign = '" + claveAsignatura + "'";
                    String fechaImparticion = DAOAsignatura.getDAOAsignatura().obtenerFechaImparticion(queryFechaImparticion);
                    asignaturaIndexada.setFechaImparticion(fechaImparticion);
                }
            }

        }
        return cursos;

    }

    public boolean agregarAsignatura(Asignatura nuevaAsignatura) {
        ControladorDAOAsignatura controladorDAOAsignatura = ControladorDAOAsignatura.getControladorDAOAsignatura();
        boolean agrego = controladorDAOAsignatura.agregar(nuevaAsignatura);
        return agrego;
    }

    public boolean registraAsignaturaEnPlanDeEstudio(int clavePlanDeEstudio, int modulo, String claveAsignatura) {
        ControladorDAOAsignatura controladorDAOAsignatura = ControladorDAOAsignatura.getControladorDAOAsignatura();
        boolean registro = controladorDAOAsignatura.registraAsignaturaEnPlanDeEstudio(clavePlanDeEstudio, modulo, claveAsignatura);
        return registro;
    }

    public int obtenClaveDePlanDeEstudioPorNombre(String nombrePlanDeEstudio) {
        ControladorDAOPlanDeEstudio controladorDAOPlanDeEstudio = ControladorDAOPlanDeEstudio.getControladorDAOPlanDeEstudio();
        int clavePlanDeEstudio = controladorDAOPlanDeEstudio.obtenClaveDePlanDeEstudioPorNombre(nombrePlanDeEstudio);
        return clavePlanDeEstudio;
    }

    public ArrayList<PlanDeEstudio> obtenerPlanesDeEstudio() {
        ControladorDAOPlanDeEstudio  controladorDAOPlanDeEstudio = ControladorDAOPlanDeEstudio.getControladorDAOPlanDeEstudio();
        ArrayList<PlanDeEstudio> planesDeEstudio = controladorDAOPlanDeEstudio.obtenerPlanesDeEstudioConAsignaturas();
        return planesDeEstudio;
    }

    public ArrayList<Alumno> obtenerAlumnos() {
        ArrayList<Alumno> alumnos = DAOAlumno.getDAOAlumno().consultar("select * from alumno");
        int NUM_ALUMNOS = alumnos.size();
        for (int i = 0; i < NUM_ALUMNOS; i++) {
            Alumno alumnoIndexado = alumnos.get(i);
            PlanDeEstudio copiaPlanDeEstudio = obtenerCopiaPlanDeEstudioPorClave(alumnoIndexado.getPlanDeEstudio().getClave());
            alumnoIndexado.setPlanDeEstudio(copiaPlanDeEstudio);
            int clavePlanDeEstudio = copiaPlanDeEstudio.getClave();
            int NUM_DE_MODULOS = 6;
            for (int j = 0; j < NUM_DE_MODULOS; j++) {
                int claveModulo = j + 1;
                Modulo moduloIndexado = copiaPlanDeEstudio.getModulos().get(j);
                int NUM_ASIGNATURAS_DEL_MODULO = moduloIndexado.getAsignaturas().size();
                for (int k = 0; k < NUM_ASIGNATURAS_DEL_MODULO; k++) {
                    Asignatura asignaturaIndexada = moduloIndexado.getAsignaturas().get(k);
                    String claveAsignatura = asignaturaIndexada.getClave();
                    String queryCalificacion = "select calificacion from calificaciones where clvalumno = '" + alumnoIndexado.getMatricula() + "' and clvplan = " + clavePlanDeEstudio + " and clvmodulo = " + claveModulo + " and clvasign = '" + claveAsignatura + "'";
                    int calificacion = DAOAsignatura.getDAOAsignatura().obtenerCalificacion(queryCalificacion);
                    asignaturaIndexada.setCalificacion(calificacion);
                }
            }

        }
        return alumnos;
    }

    public PlanDeEstudio obtenerCopiaPlanDeEstudioPorClave(int clavePlanDeEstudio) {
        ControladorDAOPlanDeEstudio controladorDAOPlanDeEstudio = ControladorDAOPlanDeEstudio.getControladorDAOPlanDeEstudio();
        PlanDeEstudio planDeEstudio = controladorDAOPlanDeEstudio.obtenerCopiaPlanDeEstudioPorClave(clavePlanDeEstudio);
        return planDeEstudio;
    }

    public boolean modificarCalificacionesAlumno(Alumno alumno) {
        ControladorDAOAlumno controladorDAOAlumno = ControladorDAOAlumno.getControladorDAOAlumno();
        boolean modifico = controladorDAOAlumno.modificarCalificacionesAlumno(alumno);
        return modifico;
    }

    public void registrarBoletaVaciaDeAlumno(Alumno alumno) {
        PlanDeEstudio planDeEstudio = alumno.getPlanDeEstudio();
        int clavePlanDeEstudio = planDeEstudio.getClave();
        int claveModulo = 0;
        String claveAsignatura = "";
        int NUM_DE_MODULOS = 6;
        for (int i = 0; i < NUM_DE_MODULOS; i++) {
            claveModulo = i + 1;
            Modulo moduloIndexado = planDeEstudio.getModulos().get(i);
            int NUM_ASIGNATURAS_DEL_MODULO = moduloIndexado.getAsignaturas().size();
            for (int j = 0; j < NUM_ASIGNATURAS_DEL_MODULO; j++) {
                Asignatura asignaturaIndexada = moduloIndexado.getAsignaturas().get(j);
                claveAsignatura = asignaturaIndexada.getClave();
                String query = "insert into calificaciones (clvalumno,clvplan,clvmodulo,clvasign) values ('" + alumno.getMatricula() + "','" + clavePlanDeEstudio + "','" + claveModulo + "','" + claveAsignatura + "')";
                DAOAsignatura.getDAOAsignatura().ejecutaQuery(query);
            }
        }
    }
    
    private ControladorDePeticiones() {
    }
    
    private static ControladorDePeticiones controladorDePeticiones = new ControladorDePeticiones();

}
