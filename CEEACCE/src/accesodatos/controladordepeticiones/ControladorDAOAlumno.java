/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

import accesodatos.dao.DAOAlumno;
import accesodatos.dao.DAOAsignatura;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Asignatura;
import modelo.Modulo;
import modelo.PlanDeEstudio;

/**
 *
 * @author brentheftye
 */
public class ControladorDAOAlumno extends ControladorDAO<Alumno>{
    
    protected static ControladorDAOAlumno getControladorDAOAlumno() {
        return controladorDAOAlumno;
    }
    
     @Override
    protected boolean agregar(Alumno alumno) {
         DAOAlumno daoAlumno = DAOAlumno.getDAOAlumno();
        int numeroFilasAfectadas = daoAlumno.insertar(alumno);
        return determinarExitoDeTransaccion(numeroFilasAfectadas);
    }

    @Override
    protected boolean modificar(Alumno alumno) {
        DAOAlumno daoAlumno = DAOAlumno.getDAOAlumno();
        int numeroFilasAfectadas = daoAlumno.actualizar(alumno);
        return determinarExitoDeTransaccion(numeroFilasAfectadas);
    }

    @Override
    protected boolean eliminar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    protected boolean modificarCalificacionesAlumno(Alumno alumno) {
        PlanDeEstudio planDeEstudio = alumno.getPlanDeEstudio();
        int clavePlanDeEstudio = planDeEstudio.getClave();
        int claveModulo = 0;
        String claveAsignatura = "";
        String calificacion = ""; 
        String claveAlumno = alumno.getMatricula();
        int NUM_DE_MODULOS = 6;
        for (int i = 0; i < NUM_DE_MODULOS; i++) {
            claveModulo = i + 1;
            Modulo moduloIndexado = planDeEstudio.getModulos().get(i);
            int NUM_ASIGNATURAS_DEL_MODULO = moduloIndexado.getAsignaturas().size();
            for (int j = 0; j < NUM_ASIGNATURAS_DEL_MODULO; j++) {
                Asignatura asignaturaIndexada = moduloIndexado.getAsignaturas().get(j);
                claveAsignatura = asignaturaIndexada.getClave();
                calificacion = asignaturaIndexada.getCalificacion()+"";
                String query = "UPDATE calificaciones SET calificacion = " + calificacion + " WHERE clvalumno = '" + claveAlumno + "' AND clvplan = " + clavePlanDeEstudio + " AND clvmodulo = " + claveModulo + " AND clvasign = '" + claveAsignatura + "'";
                determinarExitoDeTransaccion(DAOAsignatura.getDAOAsignatura().ejecutaQuery(query));
            }
        }
        return false;
    }
    
    protected void registrarBoletaVaciaDeAlumno(Alumno alumno) {
        PlanDeEstudio planDeEstudio = alumno.getPlanDeEstudio();
        int clavePlanDeEstudio = planDeEstudio.getClave();
        int claveModulo = 0;
        String claveAsignatura = "";
        int NUM_DE_MODULOS = 6;
        for (int i = 0; i < NUM_DE_MODULOS; i++) {
            Modulo moduloIndexado = planDeEstudio.getModulos().get(i);
            claveModulo = moduloIndexado.getClvModulo();
            int NUM_ASIGNATURAS_DEL_MODULO = moduloIndexado.getAsignaturas().size();
            for (int j = 0; j < NUM_ASIGNATURAS_DEL_MODULO; j++) {
                Asignatura asignaturaIndexada = moduloIndexado.getAsignaturas().get(j);
                claveAsignatura = asignaturaIndexada.getClave();
                String query = "insert into calificaciones (clvalumno,clvplan,clvmodulo,clvasign) values ('" + alumno.getMatricula() + "','" + clavePlanDeEstudio + "','" + claveModulo + "','" + claveAsignatura + "')";
                DAOAsignatura.getDAOAsignatura().ejecutaQuery(query);
            }
        }
    }
    
     public ArrayList<Alumno> obtenerAlumnos() {
        ArrayList<Alumno> alumnos = DAOAlumno.getDAOAlumno().consultar("select * from alumno");
        ControladorDAOPlanDeEstudio controladorDAOPlanDeEstudio = ControladorDAOPlanDeEstudio.getControladorDAOPlanDeEstudio();
        int NUM_ALUMNOS = alumnos.size();
        for (int i = 0; i < NUM_ALUMNOS; i++) {
            Alumno alumnoIndexado = alumnos.get(i);
            PlanDeEstudio copiaPlanDeEstudio = controladorDAOPlanDeEstudio.obtenerCopiaPlanDeEstudioPorClave(alumnoIndexado.getPlanDeEstudio().getClave());
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
        
    private ControladorDAOAlumno() {
    }
    
    private static ControladorDAOAlumno controladorDAOAlumno = new ControladorDAOAlumno();

   

   
}
