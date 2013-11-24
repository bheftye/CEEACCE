/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladordepeticiones;

import dao.DAOAlumno;
import dao.DAOCurso;
import dao.DAOPlanDeEstudio;
import dao.DAOUsuario;
import modelo.Alumno;
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

    
}
