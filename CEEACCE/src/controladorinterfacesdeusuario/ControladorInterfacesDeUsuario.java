/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorinterfacesdeusuario;

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
public class ControladorInterfacesDeUsuario {
    private static ControladorInterfacesDeUsuario controladorInterfaces = new ControladorInterfacesDeUsuario();
    private ControladorDePeticiones controladorDePeticiones = ControladorDePeticiones.getControladorDePeticiones();
    
    private ControladorInterfacesDeUsuario(){}
    
    /**
     *
     * @return
     */
    public static ControladorInterfacesDeUsuario getControladorInterfacesDeUsuario(){
        return controladorInterfaces;
    }
    
    public boolean agregarAlumno(Alumno alumno){
        boolean agrego = controladorDePeticiones.agregarAlumno(alumno);
        if(agrego){
            ArrayList<Alumno> listaDeAlumnos = ListaDeAlumnos.getListaDeAlumnos().getAlumnos();  
            listaDeAlumnos.add(alumno);
            ListaDeAlumnos.getListaDeAlumnos().setAlumnos(listaDeAlumnos);
        }
        return agrego;
    }
    
    public boolean modificarAlumno(Alumno alumno){
        boolean modifico = controladorDePeticiones.modificarAlumno(alumno);
        boolean esEsteAlumno = false;
        if(modifico){
            ArrayList<Alumno> listaDeAlumnos = ListaDeAlumnos.getListaDeAlumnos().getAlumnos();
            for (int i = 0; i < listaDeAlumnos.size(); i++) {
                esEsteAlumno = listaDeAlumnos.get(i).getMatricula().equalsIgnoreCase(alumno.getMatricula());
                if(esEsteAlumno){
                    listaDeAlumnos.add(i,alumno);
                    break;
                }
            }
            ListaDeAlumnos.getListaDeAlumnos().setAlumnos(listaDeAlumnos);
        }
        return modifico;
    }
    
    public boolean agregarPlanDeEstudio(PlanDeEstudio planDeEstudio){
        boolean agrego = controladorDePeticiones.agregarPlanDeEstudio(planDeEstudio);
        if(agrego){
            ArrayList<PlanDeEstudio> listaDePlanesDeEstudio = ListaDePlanesDeEstudio.getListaDePlanesDeEstudio().getPlanesDeEstudio();  
            listaDePlanesDeEstudio.add(planDeEstudio);
            ListaDePlanesDeEstudio.getListaDePlanesDeEstudio().setPlanesDeEstudio(listaDePlanesDeEstudio);
        }
        return agrego;
    }
    
    public boolean agregarCurso(Curso curso){
        boolean agrego = controladorDePeticiones.agregarCurso(curso);
        if(agrego){
            ArrayList<Curso> listaDeCursos = ListaDeCursos.getListaDeCursos().getCursos();  
            listaDeCursos.add(curso);
            ListaDeCursos.getListaDeCursos().setCursos(listaDeCursos);
        }
        return agrego;
    }
    
    public boolean darAltaUsuario(Usuario usuario){
        boolean agrego = controladorDePeticiones.darAltaUsuario(usuario);
        if(agrego){
            ArrayList<Usuario> listaDeUsuarios = ListaDeUsuarios.getListaDeUsuarios().getUsuarios();
            listaDeUsuarios.add(usuario);
            ListaDeUsuarios.getListaDeUsuarios().setUsuarios(listaDeUsuarios);
        }
        return agrego;
    }
    
    public boolean verificarUsario(String usuario, String contrasenia){
        int indiceUsuarioAVerificar = encuentraIndiceDeUsuario(usuario);
        if(indiceUsuarioAVerificar != -1){
            boolean contraseniaValida = ListaDeUsuarios.getListaDeUsuarios().getUsuarios().get(indiceUsuarioAVerificar).getContrasenia().equals(contrasenia);
            if(contraseniaValida){
                return true;
            }
        }
        return false;
    }
    
    private int encuentraIndiceDeUsuario(String usuario){
        ArrayList<Usuario> usuarios = ListaDeUsuarios.getListaDeUsuarios().getUsuarios();
        for (int i = 0; i < ListaDeUsuarios.getListaDeUsuarios().getUsuarios().size(); i++) {
            if(usuarios.get(i).getNombreDeUsuario().equalsIgnoreCase(usuario)){
                return i;
            }
        }
        return -1;
    }
}    