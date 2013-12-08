package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Modulo;
import java.util.ArrayList;

public class DAOModulo extends DAO<Modulo> {
    private static DAOModulo daoModulo = new DAOModulo();
    
    private DAOModulo(){}
    
    public static DAOModulo getDAOModulo(){
        return daoModulo;
    }

    @Override
    public int insertar(Modulo modulo) {
        String nombreModulo = modulo.getNombre();
        String queryInsercion = "INSERT INTO plandeestudio (nomplan) VALUES ('"+nombreModulo+"')";
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
    public int actualizar(Modulo modulo) {
        String nombreModulo = modulo.getNombre();
        int claveModulo = generarClaveModulo(nombreModulo);
        String queryActualizacion = "UPDATE plandeestudio SET nommod = '"+nombreModulo+"' WHERE clvmodulo = "+claveModulo;
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
    public ArrayList<Modulo> consultar(String querySeleccion) {
        ArrayList<Modulo> resultadoModulos = new ArrayList<>();
        try{
        Connection conexion = getConexion(); 
        Statement sentencia =  conexion.createStatement();
        ResultSet resultadoDeDatos = sentencia.executeQuery(querySeleccion); 
            while(resultadoDeDatos.next()){
                String nombreModulo = resultadoDeDatos.getString("nommod");
                Modulo modulo = new Modulo(nombreModulo);
                resultadoModulos.add(modulo);
            }
        sentencia.close();
        cerrarConexion(conexion);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return resultadoModulos;
    }
    
    private int generarClaveModulo(String nombreModulo){
        switch(nombreModulo){
            case "Modulo I":
                return 1;
            case "Modulo II":
                return 2;
            case "Modulo III":
                return 3;
            case "Modulo IV":
                return 4;
            case "Modulo V":
                return 5;
            case "Modulo VI":
                return 6;
            default:
                return 0;
        }
    }
 
	
	 
}
 
