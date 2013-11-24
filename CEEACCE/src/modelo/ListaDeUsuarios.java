package modelo;

import java.util.ArrayList;

public class ListaDeUsuarios {
        private static ListaDeUsuarios listaDeUsuarios = new ListaDeUsuarios();
	private ArrayList<Usuario> usuarios;
        
        private ListaDeUsuarios(){}
        
        public static ListaDeUsuarios getListaDeUsuarios(){
            return listaDeUsuarios;
        }

    /**
     * @return the usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
	 
}
 
