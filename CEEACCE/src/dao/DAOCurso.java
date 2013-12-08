package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Curso;
import java.util.ArrayList;

public class DAOCurso extends DAO<Curso> {
    private static DAOCurso daoCurso = new DAOCurso();
    
    private DAOCurso(){}
    
    public static DAOCurso getDAOCurso(){
        return daoCurso;
    }

    @Override
    public int insertar(Curso curso) {
        String nombreCurso = curso.getNombre();
        int clvplan = curso.getPlanDeEstudio().getClave();
        String queryInsercion = "INSERT INTO curso (nomcurso, clvplan) VALUES ('"+nombreCurso+"',"+clvplan+")";
        int numFilasAfectadas = 0; 
        Connection conexion = getConexion();
        try{
        Statement sentencia = conexion.createStatement();
        numFilasAfectadas = sentencia.executeUpdate(queryInsercion);
        sentencia.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        cerrarConexion(conexion);
        return numFilasAfectadas;
    }

    @Override
    public int actualizar(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList consultar(String peticion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

	 
}
 
