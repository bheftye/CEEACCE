package dao;

import modelo.Usuario;
import java.util.ArrayList;

public class DAOUsuario extends DAO<Usuario> {
    private static DAOUsuario daoUsuario = new DAOUsuario();
    
    private DAOUsuario(){}
    
    public static DAOUsuario getDAOUsuario(){
        return daoUsuario;
    }

    @Override
    public int insertar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList consultar(String peticion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
	 
}
 
