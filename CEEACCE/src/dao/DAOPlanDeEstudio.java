package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Modulo;
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
        String queryInsercion = "INSERT INTO plandeestudio (nomplan) VALUES ('"+nombrePlanEstudio+"')";
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
        String queryActualizacion = "UPDATE plandeestudio SET nomplan = '"+nombrePlanEstudio+"' WHERE clvplan = "+clavePlanEstudio;
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
    public ArrayList consultar(String querySeleccion) {
<<<<<<< HEAD
        ArrayList<PlanDeEstudio> resultadoPlanEstudio = new ArrayList();
=======
            ArrayList<PlanDeEstudio> resultadoPlanEstudio = new ArrayList();
>>>>>>> 200086631ca5babc69fcf30e12e31015faefa89b
        try{
        Connection conexion = getConexion(); 
        Statement sentencia =  conexion.createStatement();
        ResultSet resultadoDeDatos = sentencia.executeQuery(querySeleccion); 
            while(resultadoDeDatos.next()){
                String nombre = resultadoDeDatos.getString("nombre");
                ArrayList<Modulo> modulos = (ArrayList) resultadoDeDatos.getArray("modulos");
                int clave = Integer.parseInt(resultadoDeDatos.getString("clave"));
                PlanDeEstudio planEstudio = new PlanDeEstudio(nombre, modulos, clave);
                resultadoPlanEstudio.add(planEstudio);
            }
        sentencia.close();
        cerrarConexion(conexion);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return resultadoPlanEstudio;
    }
    
    public int obtenerClaveDePlanDeEstudioPorNombre(String queryDeConsulta){
        Connection conexion = getConexion();
        int clavePlanDeEstudio = -1;
        try{
        Statement sentencia = conexion.createStatement();
        ResultSet resultadoDeDatos = sentencia.executeQuery(queryDeConsulta);
         while(resultadoDeDatos.next()){
                clavePlanDeEstudio = Integer.parseInt(resultadoDeDatos.getString("clvplan").trim().toString());
            }
        sentencia.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        cerrarConexion(conexion);
        return clavePlanDeEstudio ;   
    }
 
	public int eliminar(PlanDeEstudio planDeEstudio) {
        String nombrePlanEstudio = planDeEstudio.getNombre();
        String queryInsercion = "DELETE FROM plandeestudio WHERE nomplan = "+nombrePlanEstudio;
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
}
 
