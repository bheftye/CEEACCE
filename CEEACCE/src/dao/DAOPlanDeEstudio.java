package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.PlanDeEstudio;

public class DAOPlanDeEstudio extends DAO<PlanDeEstudio> {
    private static DAOPlanDeEstudio daoPlanDeEstudio = new DAOPlanDeEstudio();
    
    private DAOPlanDeEstudio(){}
    
    public static DAOPlanDeEstudio getDAOPlanDeEstudio(){
        return daoPlanDeEstudio;
    }
    @Override
    public int insertar(PlanDeEstudio planDeEstudio) {
        String nombrePlanEstudio = planDeEstudio.getNombre();
        String queryInsercion = "INSERT INTO plandeestudio (nomplan) VALUES ("+nombrePlanEstudio+")";
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
    public int actualizar(PlanDeEstudio planDeEstudio) {
        String nombrePlanEstudio = planDeEstudio.getNombre();
        int clavePlanEstudio = planDeEstudio.getClave();
        String queryActualizacion = "UPDATE plandeestudio SET nomplan = "+nombrePlanEstudio+" WHERE clvplan = "+clavePlanEstudio;
        int numFilasAfectadas = 0; 
        Connection conexion = getConexion();
        try{
        Statement sentencia = conexion.createStatement();
        numFilasAfectadas = sentencia.executeUpdate(queryActualizacion);
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
    public ArrayList consultar(String peticion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
	 
}
 
