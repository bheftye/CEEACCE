/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import gui.controladorinterfacesdeusuario.ControladorInterfacesDeUsuario;
import java.util.Observable;

/**
 *
 * @author Jorge
 */
public class HelperVistaAltaUsuario extends Observable{
    String nombreUsuario;
    String contraseniaUsuario;
    String contraseniaRepetida;
    
    public boolean validarNombreUsuario(){
        boolean nombreUsuarioEsAdmin = "Admin".equalsIgnoreCase(nombreUsuario);
        boolean nombreUsuarioVacio = nombreUsuario.equalsIgnoreCase("");
        if(nombreUsuarioEsAdmin || nombreUsuarioVacio){
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean validarContrasenias(){
        boolean contraseniaEsIgualAContraseniaRepetida = contraseniaUsuario.equals(contraseniaRepetida);
        boolean contraseniaUsuarioVacia = contraseniaUsuario.equalsIgnoreCase("");
        boolean contraseniaRepetidaVacia = contraseniaRepetida.equalsIgnoreCase("");
        if(!contraseniaEsIgualAContraseniaRepetida || contraseniaUsuarioVacia || contraseniaRepetidaVacia){
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean validarExistenciaUsuario(){
        boolean existeUsuario =  ControladorInterfacesDeUsuario.getControladorInterfacesDeUsuario().existeUsuario(nombreUsuario);
        if(existeUsuario){
            return true;
        }
        else{
            return false;
        }
    }

    protected void setContraseniaRepetida(String contraseniaRepetida) {
        this.contraseniaRepetida = contraseniaRepetida;
    }

    protected void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    protected void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
