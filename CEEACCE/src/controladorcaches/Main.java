/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorcaches;

import interfazdeusuario.VistaInicioSesion;

/**
 *
 * @author brentheftye
 */
public class Main {
    
    public static void main(String[] args) {
        ControladorCache.getControladorCache().llenarListaDeUsuarios();
        new VistaInicioSesion().setVisible(true);
    }
    
}
