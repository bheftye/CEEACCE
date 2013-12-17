package accesodatos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class DAO<T> {
    
    public DAO(){
        cargarDriver();
    }

    public abstract int insertar(T entidad) throws SQLException;

    public abstract int actualizar(T entidad) throws SQLException;

    public abstract ArrayList<T> consultar(String peticion) throws SQLException;

    public Connection getConexion(String host, String nombreDeBD, String usuario, String contrasenia) {
        Connection conexion = null;
        String urlConexion = "jdbc:postgresql://"+ host +"/" + nombreDeBD;
        try {
            conexion = DriverManager.getConnection(urlConexion, usuario, contrasenia);
        }catch (SQLException e) { 
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hubo un error al conectar a la base de datos. No podrá acceder a la aplicación.");
            System.exit(0);

        }
        return conexion;
    }

     /**
     *Metodo encargado de obtener la conexión de la base de datos
     *
     */
    public Connection getConexion(){
        return getConexion(host, nombreDeBD, usuario, contrasenia);
    }
    
    public void cerrarConexion(Connection conexion) {
        try {
            if (conexion != null ){
                if (!conexion.isClosed()){  
                    conexion.close();
                }
            }
        } catch (SQLException e) { 
            e.printStackTrace();
            
        }
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the nombreDeBD
     */
    public String getNombreDeBD() {
        return nombreDeBD;
    }

    /**
     * @param nombreDeBD the nombreDeBD to set
     */
    public void setNombreDeBD(String nombreDeBD) {
        this.nombreDeBD = nombreDeBD;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    /**
     *Cargado de Driver
     */
    private void cargarDriver(){
        try {
            if (!PosgreSQLDriverCargado ) {
                Class.forName("org.postgresql.Driver");
                PosgreSQLDriverCargado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String host ="localhost";
    private String nombreDeBD = "CEEACCE";
    private String usuario = "postgres";
    private String contrasenia = "heftye92";
    private boolean PosgreSQLDriverCargado = false;
}

    
