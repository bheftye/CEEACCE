package accesodatos.dao;

import modelo.CargaAcademica;
import java.util.ArrayList;

public class DAOCargaAcademica extends DAO<CargaAcademica> {
    private static DAOCargaAcademica daoCargaAcademica = new DAOCargaAcademica();
    
    private DAOCargaAcademica(){}
    
    public static DAOCargaAcademica getDAOCargaAcademica(){
        return daoCargaAcademica;
    }

    @Override
    public int insertar(CargaAcademica cargaAcademica) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizar(CargaAcademica cargaAcademica) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList consultar(String peticion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
  
	 
}
 
