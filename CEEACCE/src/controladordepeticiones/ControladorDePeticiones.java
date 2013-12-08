/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladordepeticiones;

import dao.DAOAlumno;
import dao.DAOAsignatura;
import dao.DAOCurso;
import dao.DAOPlanDeEstudio;
import dao.DAOUsuario;
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
    private static ControladorDePeticiones  controladorDePeticiones = new ControladorDePeticiones();
    
    private ControladorDePeticiones(){}
    
    public static ControladorDePeticiones getControladorDePeticiones(){
    return controladorDePeticiones;
    }
    
    public boolean agregarAlumno(Alumno alumno){
        int numeroFilasAfectadas = DAOAlumno.getDAOAlumno().insertar(alumno);
        if(numeroFilasAfectadas > 0){
            return true;
        }
        return false;
    }
    
    public boolean modificarAlumno(Alumno alumno){
        int numeroFilasAfectadas = DAOAlumno.getDAOAlumno().actualizar(alumno);
        if(numeroFilasAfectadas > 0){
            return true;
        }
        return false;
    }
    
    public boolean agregarPlanDeEstudio(PlanDeEstudio planDeEstudio){
        int numeroFilasAfectadas = DAOPlanDeEstudio.getDAOPlanDeEstudio().insertar(planDeEstudio);
        if(numeroFilasAfectadas > 0){
            return true;
        }
        return false;
    }
    
    public boolean agregarCurso(Curso curso){
        int numeroFilasAfectadas = DAOCurso.getDAOCurso().insertar(curso);
        if(numeroFilasAfectadas > 0){
            return true;
        }
        return false;
    }
    
    public boolean darAltaUsuario(Usuario usuario){
        int numeroFilasAfectadas = DAOUsuario.getDAOUsuario().insertar(usuario);
        if(numeroFilasAfectadas > 0){
            return true;
        }
        return false;
    }
    
    public ArrayList<Usuario> obtenerUsuarios(){
        return DAOUsuario.getDAOUsuario().consultar("select * from usuario order by clvusuario asc");
    }
    
    public boolean agregarAsignatura(Asignatura nuevaAsignatura){
        int numeroFilasAfectadas = DAOAsignatura.getDAOAsignatura().insertar(nuevaAsignatura);
        if(numeroFilasAfectadas > 0){
            return true;
        }
        return false;
    }
    
    public boolean registraAsignaturaEnPlanDeEstudio(int clavePlanDeEstudio, int modulo, String claveAsignatura ){
        String queryDeRegistro = "INSERT INTO planmoduloasignatura (clvplan, clvmodulo,clvasign) VALUES ("+clavePlanDeEstudio+","+modulo+",'"+claveAsignatura+"')";
        int numeroFilasAfectadas = DAOAsignatura.getDAOAsignatura().ejecutaQuery(queryDeRegistro);
        if(numeroFilasAfectadas > 0){
            return true;
        }
        return false;
    }
    
    public int obtenClaveDePlanDeEstudioPorNombre(String nombrePlanDeEstudio){
        String queryDeConsulta = "SELECT * FROM plandeestudio WHERE nomplan = '"+nombrePlanDeEstudio+"'";
        return DAOPlanDeEstudio.getDAOPlanDeEstudio().obtenerClaveDePlanDeEstudioPorNombre(queryDeConsulta);
    }
    
    public boolean eliminarPlanDeEstudio(PlanDeEstudio planDeEstudio){
        int numeroFilasAfectadas = DAOPlanDeEstudio.getDAOPlanDeEstudio().eliminar(planDeEstudio);
        if(numeroFilasAfectadas > 0){
            return true;
        }
        return false;
    }
}   
