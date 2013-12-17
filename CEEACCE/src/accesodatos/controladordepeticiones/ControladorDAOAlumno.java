/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

import accesodatos.dao.DAOAlumno;
import accesodatos.dao.DAOAsignatura;
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
        
    private ControladorDAOAlumno() {
    }
    
    private static ControladorDAOAlumno controladorDAOAlumno = new ControladorDAOAlumno();

   

   
}
