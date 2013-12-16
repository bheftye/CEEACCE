/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

import accesodatos.dao.DAOAsignatura;
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
    
    private ControladorDAOAsignatura(){}
    
    private static ControladorDAOAsignatura controladorDAOAsignatura = new ControladorDAOAsignatura();
    
}
