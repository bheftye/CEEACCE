/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

import accesodatos.dao.DAOAsignatura;
import java.util.ArrayList;
import modelo.Asignatura;

/**
 *
 * @author brentheftye
 */
public class ControladorDAOAsignatura extends ControladorDAO<Asignatura> {
    
    protected static ControladorDAOAsignatura getControladorDAOAsignatura(){
        return controladorDAOAsignatura;
    }

    @Override
    protected boolean agregar(Asignatura asignatura) {
        DAOAsignatura dao = DAOAsignatura.getDAOAsignatura();
        int numeroFilasAfectadas = dao.insertar(asignatura);
        return determinarExitoDeTransaccion(numeroFilasAfectadas);
    }

    @Override
    protected boolean modificar(Asignatura asignatura) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean eliminar(Asignatura asignatura) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    protected boolean registraAsignaturaEnPlanDeEstudio(int clavePlanDeEstudio, int modulo, String claveAsignatura) {
        String queryDeRegistro = "INSERT INTO planmoduloasignatura (clvplan, clvmodulo,clvasign) VALUES (" + clavePlanDeEstudio + "," + modulo + ",'" + claveAsignatura + "')";
        DAOAsignatura dao =  DAOAsignatura.getDAOAsignatura();
        int numeroFilasAfectadas = dao.ejecutaQuery(queryDeRegistro);
        return determinarExitoDeTransaccion(numeroFilasAfectadas);
    }
    
    protected ArrayList<Asignatura> obtenAsignaturasPorModulo(int clvPlanDeEstudio, int clvModulo){
        DAOAsignatura dao = DAOAsignatura.getDAOAsignatura();
        String queryDeAsignaturasDeModulo = "select clvasig,nomasig,serializacion,creditos,duracion from planmoduloasignatura,asignatura where clvplan = " + clvPlanDeEstudio + " and clvmodulo = " + clvModulo + " and clvasign = clvasig";
        ArrayList<Asignatura> asignaturasDelModulo = dao.consultar(queryDeAsignaturasDeModulo);
        return asignaturasDelModulo;
    }
    
    protected boolean actualizarCalificacionDeAlumno(int calificacion, String claveAlumno, int clavePlanDeEstudio, int claveModulo, String claveAsignatura){
        String queryActualizacionAsignatura = "UPDATE calificaciones SET calificacion = " + calificacion + " WHERE clvalumno = '" + claveAlumno + "' AND clvplan = " + clavePlanDeEstudio + " AND clvmodulo = " + claveModulo + " AND clvasign = '" + claveAsignatura + "'";
        DAOAsignatura dao = DAOAsignatura.getDAOAsignatura();
        int numeroFilasAfectadas = dao.ejecutaQuery(claveAlumno);
        return determinarExitoDeTransaccion(numeroFilasAfectadas);
    }
    
    protected boolean registraAsignaturasComoTransaccion(ArrayList<String> registrosDeAsignaturas){
       DAOAsignatura dao = DAOAsignatura.getDAOAsignatura();
       return dao.ejecutaTransaccion(registrosDeAsignaturas);
    }
    private ControladorDAOAsignatura(){}
    
    private static ControladorDAOAsignatura controladorDAOAsignatura = new ControladorDAOAsignatura();
    
}
