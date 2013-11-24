package dao;

import modelo.Modulo;
import java.util.ArrayList;

public class DAOModulo extends DAO<Modulo> {
    private static DAOModulo daoModulo = new DAOModulo();
    
    private DAOModulo(){}
    
    public static DAOModulo getDAOModulo(){
        return daoModulo;
    }

    @Override
    public int insertar(Modulo modulo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizar(Modulo modulo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList consultar(String peticion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
	
	 
}
 
