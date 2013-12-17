/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import modelo.ListaDeUsuarios;
import modelo.Usuario;

/**
 *
 * @author Jorge
 */
public class HelperVistaAdministradorUsuarios {
    public DefaultListModel llenarJListConUsuarios(){
        ArrayList<Usuario> usuarios = ListaDeUsuarios.getListaDeUsuarios().getUsuarios();
        DefaultListModel listModel = new DefaultListModel();
        int numUsuarios = usuarios.size();
        for (int i = 0; i < numUsuarios; i++) {
            Usuario usuarioIndexado = usuarios.get(i);
            listModel.addElement(usuarioIndexado.getNombreDeUsuario());
        }
        return listModel;
    }
}
