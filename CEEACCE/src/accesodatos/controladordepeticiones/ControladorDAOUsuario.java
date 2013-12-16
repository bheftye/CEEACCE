/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

import accesodatos.dao.DAOUsuario;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author brentheftye
 */
public class ControladorDAOUsuario extends ControladorDAO<Usuario> {
    
    protected static ControladorDAOUsuario getControladorDAOUsuario(){
        return controladorDAOUsuario;
    }

    @Override
    protected boolean agregar(Usuario usuario) {
        DAOUsuario dao = DAOUsuario.getDAOUsuario();
        int numeroFilasAfectadas = dao.insertar(usuario);
        return determinarExitoDeTransaccion(numeroFilasAfectadas);
    }

    @Override
    protected boolean modificar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean eliminar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    protected ArrayList<Usuario> obtenTodosLosUsuarios(){
        DAOUsuario dao = DAOUsuario.getDAOUsuario();
        ArrayList<Usuario> usuarios = dao.consultar("select * from usuario order by clvusuario asc");
        return usuarios;
    }
    
    private ControladorDAOUsuario(){}
    
    private static ControladorDAOUsuario controladorDAOUsuario = new ControladorDAOUsuario();
    
    
}
