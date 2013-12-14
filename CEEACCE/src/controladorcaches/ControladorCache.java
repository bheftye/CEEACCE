/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorcaches;

import controladordepeticiones.ControladorDePeticiones;
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
        ArrayList<Alumno> alumnos = ControladorDePeticiones.getControladorDePeticiones().obtenerAlumnos();
        ListaDeAlumnos.getListaDeAlumnos().setAlumnos(alumnos);

    }

    public void llenarListaDePlanesDeEstudio() {
        ArrayList<PlanDeEstudio> planesDeEstudio = ControladorDePeticiones.getControladorDePeticiones().obtenerPlanesDeEstudio();
        ListaDePlanesDeEstudio.getListaDePlanesDeEstudio().setPlanesDeEstudio(planesDeEstudio);
    }

    public void llenarListaDeCursos(String nombreCurso) {
        ArrayList<Curso> curso = ControladorDePeticiones.getControladorDePeticiones().obtenerCursos(nombreCurso);
        ListaDeCursos.getListaDeCursos().setCursos(curso);
        

    }

    public void llenarListaDeUsuarios() {
        ArrayList<Usuario> usuarios = ControladorDePeticiones.getControladorDePeticiones().obtenerUsuarios();
        ListaDeUsuarios.getListaDeUsuarios().setUsuarios(usuarios);
    }
}
