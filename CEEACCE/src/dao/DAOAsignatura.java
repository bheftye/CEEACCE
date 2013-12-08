package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Asignatura;

public class DAOAsignatura extends DAO<Asignatura> {
    private static DAOAsignatura daoAsignatura = new DAOAsignatura();
    
    private DAOAsignatura(){}
    
    public static DAOAsignatura getDAOAsignatura(){
        return daoAsignatura;
    }

    @Override
    public int insertar(Asignatura asignatura) {
        String nombreAsignatura = asignatura.getNombreAsignatura();
        int calificacion = 0;
        boolean esSerializada = asignatura.isSerializacion();
        String maestroImparteAsignatura = "";
        String fechaImparticion = "";
        double creditosAsignatura = asignatura.getCreditos();
        int duracionAsignatura = asignatura.getDuracion();
        String queryInsercion = "INSERT INTO asignatura (nomasig,calificacion, serializacion, maestro, fechaimparticion, creditos, duracion)"
                + " VALUES ('"+nombreAsignatura+"','"+calificacion+"','"+esSerializada+"','"+maestroImparteAsignatura+"','"+fechaImparticion+"','"+creditosAsignatura+"','"+duracionAsignatura+"')";
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
    public int actualizar(Asignatura asignatura) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList consultar(String peticion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int ejecutaQuery(String query){
	int numFilasAfectadas = 0;
        Connection conexion = getConexion();
        try{
        Statement sentencia = conexion.createStatement();
        numFilasAfectadas = sentencia.executeUpdate(query);
        sentencia.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        cerrarConexion(conexion);
        return numFilasAfectadas;
}

}
 
