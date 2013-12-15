package accesodatos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;

public class DAOUsuario extends DAO<Usuario>{
    private static DAOUsuario daoUsuario = new DAOUsuario();
    
    private DAOUsuario(){}
    
    public static DAOUsuario getDAOUsuario(){
        return daoUsuario;
    }

    @Override
    public int insertar(Usuario usuario) {
        String nombreUsuario = usuario.getNombreDeUsuario();
        String contrasenia = usuario.getContrasenia();
        String queryInsercion = "INSERT INTO usuario (nomusuario,contrasenia) VALUES ('"+nombreUsuario+"','"+contrasenia+"')";
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
    public int actualizar(Usuario usuario) {
        String nombreUsuario = usuario.getNombreDeUsuario();
        String contrasenia = usuario.getContrasenia();
        int claveUsuario = usuario.getClaveUsuario();
        String queryActualizacion = "UPDATE usuario SET nomusuario = '"+nombreUsuario+"', contrasenia = '"+contrasenia+"' WHERE clvusuario = "+claveUsuario;
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
    public ArrayList<Usuario> consultar(String querySeleccion) {
        ArrayList<Usuario> resultadoUsuarios = new ArrayList();
        try{
        Connection conexion = getConexion(); 
        Statement sentencia =  conexion.createStatement();
        ResultSet resultadoDeDatos = sentencia.executeQuery(querySeleccion); 
            while(resultadoDeDatos.next()){
                String nombreUsuario = resultadoDeDatos.getString("nomusuario").trim().toString();
                String contrasenia = resultadoDeDatos.getString("contrasenia").trim().toString();                
                String claveUsuario = resultadoDeDatos.getString("clvusuario").trim().toString();
                Usuario usuario = new Usuario(nombreUsuario, contrasenia, Integer.valueOf(claveUsuario));
                resultadoUsuarios.add(usuario);
            }
        sentencia.close();
        cerrarConexion(conexion);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return resultadoUsuarios;
    }

   
	 
}
 
