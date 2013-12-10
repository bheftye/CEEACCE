/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfacesdeusuario;

import controladorcaches.ControladorCache;
import controladordepeticiones.ControladorDePeticiones;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Asignatura;
import modelo.Curso;
import modelo.ListaDeAlumnos;
import modelo.ListaDeCursos;
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
            ControladorDePeticiones.getControladorDePeticiones().registrarBoletaVaciaDeAlumno(alumno);
            ControladorCache.getControladorCache().llenarListaDeAlumnos();
        }
        return agrego;
    }

    public void modificarCalificacionAlumno(Alumno alumno) {
        controladorDePeticiones.modificarCalificacionAlumno(alumno);
      
    }

    public boolean modificarAlumno(Alumno alumno) {
        boolean modifico = controladorDePeticiones.modificarAlumno(alumno);
        boolean esEsteAlumno = false;
        if (modifico) {
            ArrayList<Alumno> listaDeAlumnos = ListaDeAlumnos.getListaDeAlumnos().getAlumnos();
            for (int i = 0; i < listaDeAlumnos.size(); i++) {
                esEsteAlumno = listaDeAlumnos.get(i).getMatricula().equalsIgnoreCase(alumno.getMatricula());
                if (esEsteAlumno) {
                    listaDeAlumnos.add(i, alumno);
                    break;
                }
            }
            ListaDeAlumnos.getListaDeAlumnos().setAlumnos(listaDeAlumnos);
        }
        return modifico;
    }

    public boolean agregarPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        boolean agrego = controladorDePeticiones.agregarPlanDeEstudio(planDeEstudio);
        if (agrego) {
            int clavePlanDeEstudio = ControladorDePeticiones.getControladorDePeticiones().obtenClaveDePlanDeEstudioPorNombre(planDeEstudio.getNombre());
            if (clavePlanDeEstudio != -1) {
                for (int i = 0; i < 6; i++) {
                    Modulo moduloIndexado = planDeEstudio.getModulos().get(i);
                    int numAsignaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
                    ArrayList<Asignatura> asigunaturasDeModuloIndexado = moduloIndexado.getAsignaturas();
                    for (int j = 0; j < numAsignaturasDeModuloIndexado; j++) {
                        Asignatura asignaturaIndexada = asigunaturasDeModuloIndexado.get(j);
                        ControladorDePeticiones.getControladorDePeticiones().agregarAsignatura(asignaturaIndexada);
                        int numModulo = i + 1;
                        ControladorDePeticiones.getControladorDePeticiones().registraAsignaturaEnPlanDeEstudio(clavePlanDeEstudio, numModulo, asignaturaIndexada.getClave());
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
        if (agrego) {
            ArrayList<Curso> listaDeCursos = ListaDeCursos.getListaDeCursos().getCursos();
            listaDeCursos.add(curso);
            ListaDeCursos.getListaDeCursos().setCursos(listaDeCursos);
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
            boolean contraseniaValida = ListaDeUsuarios.getListaDeUsuarios().getUsuarios().get(indiceUsuarioAVerificar).getContrasenia().equals(contrasenia);
            if (contraseniaValida) {
                return true;
            }
        }
        return false;
    }

    private int encuentraIndiceDeUsuario(String usuario) {
        ArrayList<Usuario> usuarios = ListaDeUsuarios.getListaDeUsuarios().getUsuarios();
        for (int i = 0; i < ListaDeUsuarios.getListaDeUsuarios().getUsuarios().size(); i++) {
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
        return ControladorDePeticiones.getControladorDePeticiones().obtenerNuevoPlanDeEstudioPorClave(clavePlanDeEstudio);
    }

    private void actualizarListaDeUsuarios() {
        ControladorCache.getControladorCache().llenarListaDeUsuarios();
    }
}
