/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controladorinterfacesdeusuario;

import accesodatos.controladordepeticiones.ControladorDePeticiones;
import controladorcaches.ControladorCache;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Asignatura;
import modelo.Curso;
import modelo.ListaDeUsuarios;
import modelo.Modulo;
import modelo.PlanDeEstudio;
import modelo.Usuario;

/**
 *
 * @author brentheftye
 */
public class ControladorInterfacesDeUsuario {

    private static ControladorInterfacesDeUsuario controladorInterfaces = new ControladorInterfacesDeUsuario();
    private ControladorDePeticiones controladorDePeticiones = ControladorDePeticiones.getControladorDePeticiones();

    private ControladorInterfacesDeUsuario() {
    }

    /**
     *
     * @return
     */
    public static ControladorInterfacesDeUsuario getControladorInterfacesDeUsuario() {
        return controladorInterfaces;
    }

    public boolean agregarAlumno(Alumno alumno) {
        boolean agrego = controladorDePeticiones.agregarAlumno(alumno);
        if (agrego) {
            controladorDePeticiones.registrarBoletaVaciaDeAlumno(alumno);
            ControladorCache.getControladorCache().llenarListaDeAlumnos();
        }
        return agrego;
    }

    public boolean modificarCalificacionAlumno(Alumno alumno) {
        boolean modifico = controladorDePeticiones.modificarCalificacionesAlumno(alumno);
        if(modifico){
        actulizarListaDeAlumnos();
        }
        return modifico;
    }

    public boolean modificarAlumno(Alumno alumno) {
        boolean modifico = controladorDePeticiones.modificarAlumno(alumno);
        if(modifico){
        actulizarListaDeAlumnos();
        }
        return modifico;
    }

    public boolean agregarPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        boolean agrego = controladorDePeticiones.agregarPlanDeEstudio(planDeEstudio);
        if (agrego) {
            int clavePlanDeEstudio = controladorDePeticiones.obtenClaveDePlanDeEstudioPorNombre(planDeEstudio.getNombre());
            if (clavePlanDeEstudio != -1) {
                for (int i = 0; i < 6; i++) {
                    Modulo moduloIndexado = planDeEstudio.getModulos().get(i);
                    int numAsignaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
                    ArrayList<Asignatura> asigunaturasDeModuloIndexado = moduloIndexado.getAsignaturas();
                    for (int j = 0; j < numAsignaturasDeModuloIndexado; j++) {
                        Asignatura asignaturaIndexada = asigunaturasDeModuloIndexado.get(j);
                        controladorDePeticiones.agregarAsignatura(asignaturaIndexada);
                        int numModulo = i + 1;
                        controladorDePeticiones.registraAsignaturaEnPlanDeEstudio(clavePlanDeEstudio, numModulo, asignaturaIndexada.getClave());
                    }
                }
            } else {
                return false;
            }
            ControladorCache.getControladorCache().llenarListaDePlanesDeEstudio();
        }
        return agrego;
    }

    public boolean agregarCurso(Curso curso) {
        boolean agrego = controladorDePeticiones.agregarCurso(curso);
        if(agrego){
        actualizarListaDeCursos();
        }
        return agrego;
    }

    public boolean darAltaUsuario(Usuario usuario) {
        boolean agrego = controladorDePeticiones.darAltaUsuario(usuario);
        if (agrego) {
            actualizarListaDeUsuarios();
        }
        return agrego;
    }

    public boolean verificarUsario(String usuario, String contrasenia) {
        int indiceUsuarioAVerificar = encuentraIndiceDeUsuario(usuario);
        if (indiceUsuarioAVerificar != -1) {
            ListaDeUsuarios listaDeUsuarios = ListaDeUsuarios.getListaDeUsuarios();
            ArrayList<Usuario> usuarios = listaDeUsuarios.getUsuarios();
            Usuario usuarioAVerificar = usuarios.get(indiceUsuarioAVerificar);
            String contraseniaAVerificar = usuarioAVerificar.getContrasenia();
            boolean contraseniaValida = contraseniaAVerificar.equals(contrasenia);
            if (contraseniaValida) {
                return true;
            }
        }
        return false;
    }

    private int encuentraIndiceDeUsuario(String usuario) {
        ListaDeUsuarios listaDeUsuarios = ListaDeUsuarios.getListaDeUsuarios();
        ArrayList<Usuario> usuarios = listaDeUsuarios.getUsuarios();
        int numUsuarios = usuarios.size();
        for (int i = 0; i < numUsuarios; i++) {
            if (usuarios.get(i).getNombreDeUsuario().equalsIgnoreCase(usuario)) {
                return i;
            }
        }
        return -1;
    }

    public boolean existeUsuario(String nuevoUsuario) {
        ArrayList<Usuario> usuarios = ListaDeUsuarios.getListaDeUsuarios().getUsuarios();
        int numUsuarios = usuarios.size();
        for (int i = 0; i < numUsuarios; i++) {
            Usuario usuarioIndexado = usuarios.get(i);
            if (usuarioIndexado.getNombreDeUsuario().equalsIgnoreCase(nuevoUsuario)) {
                return true;
            }
        }
        return false;
    }

    public PlanDeEstudio obtenerPlanDeEstudioPorClave(int clavePlanDeEstudio) {
        
        return controladorDePeticiones.obtenerCopiaPlanDeEstudioPorClave(clavePlanDeEstudio);
    }

    private void actualizarListaDeUsuarios() {
        ControladorCache.getControladorCache().llenarListaDeUsuarios();
    }
    
    private void actulizarListaDeAlumnos(){
        ControladorCache.getControladorCache().llenarListaDeAlumnos();
    }
    
    private void actualizarListaDeCursos(){
        ControladorCache.getControladorCache().llenarListaDeCursos();
    }
}
