package dao;

import java.util.ArrayList;
import modelo.PlanDeEstudio;

public class DAOPlanDeEstudio extends DAO<PlanDeEstudio> {
    private static DAOPlanDeEstudio daoPlanDeEstudio = new DAOPlanDeEstudio();
    
    private DAOPlanDeEstudio(){}
    
    public static DAOPlanDeEstudio getDAOPlanDeEstudio(){
        return daoPlanDeEstudio;
    }
    @Override
    public int insertar(PlanDeEstudio planDeEstudio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizar(PlanDeEstudio planDeEstudio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList consultar(String peticion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
	 
}
 
