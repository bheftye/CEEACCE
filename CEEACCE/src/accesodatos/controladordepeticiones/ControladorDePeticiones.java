/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

import accesodatos.dao.DAOCurso;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Asignatura;
import modelo.Curso;
import modelo.PlanDeEstudio;
import modelo.Usuario;

/**
 *
 * @author brentheftye
 */
public class ControladorDePeticiones {

    public static ControladorDePeticiones getControladorDePeticiones() {
        return controladorDePeticiones;
    }

    public boolean agregarAlumno(Alumno alumno) {
        ControladorDAOAlumno controladorDAOAlumno = ControladorDAOAlumno.getControladorDAOAlumno();
        boolean agrego = controladorDAOAlumno.agregar(alumno);
        return agrego;
    }

    public boolean modificarAlumno(Alumno alumno){
        ControladorDAOAlumno controladorDAOAlumno = ControladorDAOAlumno.getControladorDAOAlumno();
        boolean modifico = controladorDAOAlumno.modificar(alumno);
        return modifico;
    }

    public boolean agregarPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        ControladorDAOPlanDeEstudio controladorDAOPlanDeEstudio = ControladorDAOPlanDeEstudio.getControladorDAOPlanDeEstudio();
        boolean agrego = controladorDAOPlanDeEstudio.agregar(planDeEstudio);
        return agrego;
    }

    public boolean agregarCurso(Curso curso) {
        ControladorDAOCurso controladorDAOCurso = ControladorDAOCurso.getControladorDAOCurso();
        boolean agrego = controladorDAOCurso.agregar(curso);
        return agrego;
    }

    public boolean darAltaUsuario(Usuario usuario) {
        ControladorDAOUsuario controladorDAOUsuario = ControladorDAOUsuario.getControladorDAOUsuario();
        boolean dioAlta = controladorDAOUsuario.agregar(usuario);
        return dioAlta;
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        ControladorDAOUsuario controladorDAOUsuario = ControladorDAOUsuario.getControladorDAOUsuario();
        return controladorDAOUsuario.obtenTodosLosUsuarios();
    }

    public ArrayList<Curso> obtenerCursos() {
        ControladorDAOCurso controladorDAOCurso = ControladorDAOCurso.getControladorDAOCurso();
        ArrayList<Curso> cursos = controladorDAOCurso.obtenerCursos();
        return cursos;

    }

    public boolean agregarAsignatura(Asignatura nuevaAsignatura) {
        ControladorDAOAsignatura controladorDAOAsignatura = ControladorDAOAsignatura.getControladorDAOAsignatura();
        boolean agrego = controladorDAOAsignatura.agregar(nuevaAsignatura);
        return agrego;
    }

    public boolean registraAsignaturaEnPlanDeEstudio(int clavePlanDeEstudio, int modulo, String claveAsignatura) {
        ControladorDAOAsignatura controladorDAOAsignatura = ControladorDAOAsignatura.getControladorDAOAsignatura();
        boolean registro = controladorDAOAsignatura.registraAsignaturaEnPlanDeEstudio(clavePlanDeEstudio, modulo, claveAsignatura);
        return registro;
    }

    public int obtenClaveDePlanDeEstudioPorNombre(String nombrePlanDeEstudio) {
        ControladorDAOPlanDeEstudio controladorDAOPlanDeEstudio = ControladorDAOPlanDeEstudio.getControladorDAOPlanDeEstudio();
        int clavePlanDeEstudio = controladorDAOPlanDeEstudio.obtenClaveDePlanDeEstudioPorNombre(nombrePlanDeEstudio);
        return clavePlanDeEstudio;
    }

    public ArrayList<PlanDeEstudio> obtenerPlanesDeEstudio() {
        ControladorDAOPlanDeEstudio  controladorDAOPlanDeEstudio = ControladorDAOPlanDeEstudio.getControladorDAOPlanDeEstudio();
        ArrayList<PlanDeEstudio> planesDeEstudio = controladorDAOPlanDeEstudio.obtenerPlanesDeEstudioConAsignaturas();
        return planesDeEstudio;
    }

    public ArrayList<Alumno> obtenerAlumnos() {
        ControladorDAOAlumno controladorDAOAlumno = ControladorDAOAlumno.getControladorDAOAlumno();
        ArrayList<Alumno> alumnos = controladorDAOAlumno.obtenerAlumnos();
        return alumnos;
    }

    public PlanDeEstudio obtenerCopiaPlanDeEstudioPorClave(int clavePlanDeEstudio) {
        ControladorDAOPlanDeEstudio controladorDAOPlanDeEstudio = ControladorDAOPlanDeEstudio.getControladorDAOPlanDeEstudio();
        PlanDeEstudio planDeEstudio = controladorDAOPlanDeEstudio.obtenerCopiaPlanDeEstudioPorClave(clavePlanDeEstudio);
        return planDeEstudio;
    }

    public boolean modificarCalificacionesAlumno(Alumno alumno) {
        ControladorDAOAlumno controladorDAOAlumno = ControladorDAOAlumno.getControladorDAOAlumno();
        boolean modifico = controladorDAOAlumno.modificarCalificacionesAlumno(alumno);
        return modifico;
    }

    public void registrarBoletaVaciaDeAlumno(Alumno alumno) {
        ControladorDAOAlumno controladorDAOAlumno = ControladorDAOAlumno.getControladorDAOAlumno();
        controladorDAOAlumno.registrarBoletaVaciaDeAlumno(alumno);
    }
    
    private ControladorDePeticiones() {
    }
    
    private static ControladorDePeticiones controladorDePeticiones = new ControladorDePeticiones();

}
