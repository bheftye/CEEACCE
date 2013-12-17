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
    
    private ControladorDAOAsignatura(){}
    
    private static ControladorDAOAsignatura controladorDAOAsignatura = new ControladorDAOAsignatura();
    
}
