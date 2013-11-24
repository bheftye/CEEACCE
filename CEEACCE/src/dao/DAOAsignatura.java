package dao;

import modelo.Asignatura;
import java.util.ArrayList;

public class DAOAsignatura extends DAO<Asignatura> {
    private static DAOAsignatura daoAsignatura = new DAOAsignatura();
    
    private DAOAsignatura(){}
    
    public static DAOAsignatura getDAOAsignatura(){
        return daoAsignatura;
    }

    @Override
    public int insertar(Asignatura asignatura) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizar(Asignatura asignatura) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList consultar(String peticion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
	 
}
 
