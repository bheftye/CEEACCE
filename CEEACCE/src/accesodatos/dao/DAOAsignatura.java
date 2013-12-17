package accesodatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Asignatura;

public class DAOAsignatura extends DAO<Asignatura> {

    private static DAOAsignatura daoAsignatura = new DAOAsignatura();

    private DAOAsignatura() {
    }

    public static DAOAsignatura getDAOAsignatura() {
        return daoAsignatura;
    }

    @Override
    public int insertar(Asignatura asignatura) {
        String claveAsignatura = asignatura.getClave();
        String nombreAsignatura = asignatura.getNombreAsignatura();
        boolean esSerializada = asignatura.isSerializacion();
        double creditosAsignatura = asignatura.getCreditos();
        int duracionAsignatura = asignatura.getDuracion();
        String queryInsercion = "INSERT INTO asignatura (clvasig,nomasig, serializacion, creditos, duracion)"
                + " VALUES ('" + claveAsignatura + "','" + nombreAsignatura + "'," + esSerializada + "," + creditosAsignatura + "," + duracionAsignatura + ")";
        int numFilasAfectadas = 0;
        Connection conexion = getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            numFilasAfectadas = sentencia.executeUpdate(queryInsercion);
            sentencia.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        cerrarConexion(conexion);
        return numFilasAfectadas;
    }

    @Override
    public int actualizar(Asignatura asignatura) {
        String claveAsignatura = asignatura.getClave();
        String nombreAsignatura = asignatura.getNombreAsignatura();
        boolean esSerializada = asignatura.isSerializacion();
        double creditosAsignatura = asignatura.getCreditos();
        int duracionAsignatura = asignatura.getDuracion();
        String queryInsercion = "INSERT INTO asignatura (clvasig,nomasig, serializacion, creditos, duracion)"
                + " VALUES ('" + claveAsignatura + "','" + nombreAsignatura + "'," + esSerializada + "," + creditosAsignatura + "," + duracionAsignatura + ")";
        int numFilasAfectadas = 0;
        Connection conexion = getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            numFilasAfectadas = sentencia.executeUpdate(queryInsercion);
            sentencia.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        cerrarConexion(conexion);
        return numFilasAfectadas;
    }

    @Override
    public ArrayList<Asignatura> consultar(String querySeleccion) {
        ArrayList<Asignatura> resultadoAsignatura = new ArrayList<>();
        try {
            Connection conexion = getConexion();
            Statement sentencia = conexion.createStatement();
            ResultSet resultadoDeDatos = sentencia.executeQuery(querySeleccion);
            while (resultadoDeDatos.next()) {
                String claveAsignatura = resultadoDeDatos.getString("clvasig").trim().toString();
                String nombreAsignatura = resultadoDeDatos.getString("nomasig").trim().toString();
                boolean esSerializada = Boolean.parseBoolean(resultadoDeDatos.getString("serializacion").trim().toString());
                double creditosAsignatura = Double.parseDouble(resultadoDeDatos.getString("creditos").trim().toString());
                int duracionAsignatura = Integer.parseInt(resultadoDeDatos.getString("duracion").trim().toString());
                Asignatura asignatura = new Asignatura(nombreAsignatura, claveAsignatura, 0, esSerializada, "", "", creditosAsignatura, duracionAsignatura);
                resultadoAsignatura.add(asignatura);
            }
            sentencia.close();
            cerrarConexion(conexion);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return resultadoAsignatura;
    }

    public int ejecutaQuery(String query) {
        int numFilasAfectadas = 0;
        Connection conexion = getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            numFilasAfectadas = sentencia.executeUpdate(query);
            sentencia.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        cerrarConexion(conexion);
        return numFilasAfectadas;
    }

    public int obtenerCalificacion(String query) {
        int calificacion = 0;
        Connection conexion = getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultadoDatos = sentencia.executeQuery(query);
            while (resultadoDatos.next()) {
                calificacion = resultadoDatos.getInt("calificacion");
            }
            sentencia.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        cerrarConexion(conexion);
        return calificacion;
    }

    public String obtenerFechaImparticion(String query) {
        String fechaImparticion = "";
        Connection conexion = getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultadoDatos = sentencia.executeQuery(query);
            while (resultadoDatos.next()) {
                fechaImparticion = resultadoDatos.getString("fechaimparticion");
            }
            sentencia.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        cerrarConexion(conexion);
        return fechaImparticion;
    }

    public boolean ejecutaTransaccion(ArrayList<String> queries) {
        Connection conexion = getConexion();
        setAutoCommitFalse(conexion);
        boolean transaccionExitosa = false;
        try {
            ArrayList<PreparedStatement> queriesPreparados = obtenerStatementsDeTransaccion(queries, conexion);
            ejecutaLasActualizacionesDeTransaccion(queriesPreparados);
            conexion.commit();
            cerrarQueriesPreparados(queriesPreparados);
            transaccionExitosa = true;
            setAutoCommitTrue(conexion);
        } catch (SQLException exception) {
            exception.printStackTrace();
            try {
                conexion.rollback();
                cerrarConexion(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(DAOAsignatura.class.getName()).log(Level.SEVERE, null, ex);
            }

        } finally {
            return transaccionExitosa;
        }
    }

    private void setAutoCommitFalse(Connection connection) {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setAutoCommitTrue(Connection connection) {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<PreparedStatement> obtenerStatementsDeTransaccion(ArrayList<String> queries, Connection conexion) throws SQLException {
        ArrayList<PreparedStatement> queriesPreparados = new ArrayList();
            for (int i = 0; i < queries.size(); i++) {
                queriesPreparados.add(conexion.prepareStatement(queries.get(i)));
            }
        return queriesPreparados;
    }

    private void ejecutaLasActualizacionesDeTransaccion(ArrayList<PreparedStatement> queriesPreparados) throws SQLException {
            for (int i = 0; i < queriesPreparados.size(); i++) {
                queriesPreparados.get(i).executeUpdate();
            }
    }
    
    private void cerrarQueriesPreparados(ArrayList<PreparedStatement> queriesPreparados) throws SQLException{
        for (int i = 0; i < queriesPreparados.size(); i++) {
                queriesPreparados.get(i).close();
            }
    }
}
