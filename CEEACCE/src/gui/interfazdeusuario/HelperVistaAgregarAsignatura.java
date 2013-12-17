/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import java.util.Observable;

/**
 *
 * @author Jorge
 */
public class HelperVistaAgregarAsignatura extends Observable{
    String clave;
    String nombre;
    String creditos;
    String duracion;
    
    public boolean validaLlenadoDeCampos(){
        boolean campoClaveVacio = "".equals(clave);
        boolean campoNombreVacio = "".equals(nombre);
        boolean campoCreditosVacio = "".equals(creditos);
        boolean campoDuracionVacio = "".equals(duracion);
        
        if(!campoClaveVacio && !campoNombreVacio && !campoCreditosVacio && !campoDuracionVacio){
            return true;
        }
        return false;
    }

    protected void setClave(String clave) {
        this.clave = clave;
    }

    protected void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    protected void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
