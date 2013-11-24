package dao;

import modelo.Curso;
import java.util.ArrayList;

public class DAOCurso extends DAO<Curso> {
    private static DAOCurso daoCurso = new DAOCurso();
    
    private DAOCurso(){}
    
    public static DAOCurso getDAOCurso(){
        return daoCurso;
    }

    @Override
    public int insertar(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizar(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList consultar(String peticion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

	 
}
 
