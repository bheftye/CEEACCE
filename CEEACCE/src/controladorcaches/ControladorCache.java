/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorcaches;

import accesodatos.controladordepeticiones.ControladorDePeticiones;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Curso;
import modelo.ListaDeAlumnos;
import modelo.ListaDeCursos;
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

    private ControladorCache() {
    }

    public static ControladorCache getControladorCache() {
        return controladorCache;
    }

    public void llenarListaDeAlumnos() {
        ControladorDePeticiones controladorDePeticiones = ControladorDePeticiones.getControladorDePeticiones();
        ArrayList<Alumno> alumnos = controladorDePeticiones.obtenerAlumnos();
        ListaDeAlumnos.getListaDeAlumnos().setAlumnos(alumnos);

    }

    public void llenarListaDePlanesDeEstudio() {
        ControladorDePeticiones controladorDePeticiones = ControladorDePeticiones.getControladorDePeticiones();
        ArrayList<PlanDeEstudio> planesDeEstudio = controladorDePeticiones.obtenerPlanesDeEstudio();
        ListaDePlanesDeEstudio.getListaDePlanesDeEstudio().setPlanesDeEstudio(planesDeEstudio);
    }

    public void llenarListaDeCursos() {
        ControladorDePeticiones controladorDePeticiones = ControladorDePeticiones.getControladorDePeticiones();
        ArrayList<Curso> cursos = controladorDePeticiones.obtenerCursos();
        ListaDeCursos.getListaDeCursos().setCursos(cursos);
        

    }

    public void llenarListaDeUsuarios() {
        ControladorDePeticiones controladorDePeticiones = ControladorDePeticiones.getControladorDePeticiones();
        ArrayList<Usuario> usuarios = controladorDePeticiones.obtenerUsuarios();
        ListaDeUsuarios.getListaDeUsuarios().setUsuarios(usuarios);
    }
}
