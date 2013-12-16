/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

/**
 *
 * @author brentheftye
 */
public abstract class ControladorDAO<T> {
    
    protected abstract boolean agregar(T object);
    
    protected abstract boolean modificar(T object);
    
    protected abstract boolean eliminar(T object);
    
    protected boolean determinarExitoDeTransaccion(int numFilasAfectadas){
        if (numFilasAfectadas > 0) {
            return true;
        }
        return false;
    }
}
