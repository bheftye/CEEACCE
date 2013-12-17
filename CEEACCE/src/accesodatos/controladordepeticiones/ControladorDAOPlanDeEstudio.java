/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

import accesodatos.dao.DAOPlanDeEstudio;
import modelo.PlanDeEstudio;

/**
 *
 * @author brentheftye
 */
public class ControladorDAOPlanDeEstudio extends ControladorDAO<PlanDeEstudio> {

    protected static ControladorDAOPlanDeEstudio getControladorDAOPlanDeEstudio(){
        return controladorDAOPlanDeEstudio;
    }
    @Override
    protected boolean agregar(PlanDeEstudio planDeEstudio) {
        DAOPlanDeEstudio dao =  DAOPlanDeEstudio.getDAOPlanDeEstudio();
        int numeroFilasAfectadas = dao.insertar(planDeEstudio);
        return determinarExitoDeTransaccion(numeroFilasAfectadas);
    }

    @Override
    protected boolean modificar(PlanDeEstudio planDeEstudio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean eliminar(PlanDeEstudio planDeEstudio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    protected int obtenClaveDePlanDeEstudioPorNombre(String nombrePlanDeEstudio) {
        String queryDeConsulta = "SELECT * FROM plandeestudio WHERE nomplan = '" + nombrePlanDeEstudio + "'";
        DAOPlanDeEstudio dao = DAOPlanDeEstudio.getDAOPlanDeEstudio();
        int clavePlanDeEstudio = dao.obtenerClaveDePlanDeEstudioPorNombre(queryDeConsulta);
        return clavePlanDeEstudio;
    }
    
    private ControladorDAOPlanDeEstudio(){}
    
    private static ControladorDAOPlanDeEstudio controladorDAOPlanDeEstudio = new ControladorDAOPlanDeEstudio();
    
}
