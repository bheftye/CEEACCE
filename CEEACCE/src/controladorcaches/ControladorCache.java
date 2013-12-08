/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorcaches;

import controladordepeticiones.ControladorDePeticiones;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.ListaDePlanesDeEstudio;
import modelo.ListaDeUsuarios;
import modelo.PlanDeEstudio;
import modelo.Usuario;

/**
 *
 * @author brentheftye
 */
public class ControladorCache {
    private static final ControladorCache controladorCache = new ControladorCache();
    
    
    private ControladorCache(){}
    
    public static ControladorCache getControladorCache(){
        return controladorCache;
    }
    
    public void llenarListaDeAlumnos(){
        ArrayList<Alumno> alumnos = ControladorDePeticiones.getControladorDePeticiones().obtenerAlumnos();
        
    }
    
    public void llenarListaDePlanesDeEstudio(){
        ArrayList<PlanDeEstudio> planesDeEstudio = ControladorDePeticiones.getControladorDePeticiones().obtenerPlanesDeEstudio();
        ListaDePlanesDeEstudio.getListaDePlanesDeEstudio().setPlanesDeEstudio(planesDeEstudio);
    }
    
    public void llenarListaDeCursos(){
    
    }
    
    public void llenarListaDeUsuarios(){
        ArrayList<Usuario> usuarios = ControladorDePeticiones.getControladorDePeticiones().obtenerUsuarios();
        ListaDeUsuarios.getListaDeUsuarios().setUsuarios(usuarios);
    }
    
}
