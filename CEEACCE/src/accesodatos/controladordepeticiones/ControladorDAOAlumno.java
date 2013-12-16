/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

import accesodatos.dao.DAOAlumno;
import modelo.Alumno;

/**
 *
 * @author brentheftye
 */
public class ControladorDAOAlumno extends ControladorDAO<Alumno>{
    
    protected static ControladorDAOAlumno getControladorDAOAlumno() {
        return controladorDAOAlumno;
    }
    
     @Override
    protected boolean agregar(Alumno alumno) {
         DAOAlumno daoAlumno = DAOAlumno.getDAOAlumno();
        int numeroFilasAfectadas = daoAlumno.insertar(alumno);
        return determinarExitoDeTransaccion(numeroFilasAfectadas);
    }

    @Override
    protected boolean modificar(Alumno alumno) {
        DAOAlumno daoAlumno = DAOAlumno.getDAOAlumno();
        int numeroFilasAfectadas = daoAlumno.actualizar(alumno);
        return determinarExitoDeTransaccion(numeroFilasAfectadas);
    }

    @Override
    protected boolean eliminar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private ControladorDAOAlumno() {
    }
    
    private static ControladorDAOAlumno controladorDAOAlumno = new ControladorDAOAlumno();

   

   
}
