package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
<<<<<<< HEAD
import modelo.Asignatura;
=======
import modelo.Alumno;
>>>>>>> 200086631ca5babc69fcf30e12e31015faefa89b

public class DAOAsignatura extends DAO<Asignatura> {
    private static DAOAsignatura daoAsignatura = new DAOAsignatura();
    
    private DAOAsignatura(){}
    
    public static DAOAsignatura getDAOAsignatura(){
        return daoAsignatura;
    }

    @Override
    public int insertar(Asignatura asignatura) {
        String claveAsignatura = asignatura.getClave();
        String nombreAsignatura = asignatura.getNombreAsignatura();
<<<<<<< HEAD
        int calificacion = 0;
=======
>>>>>>> 200086631ca5babc69fcf30e12e31015faefa89b
        boolean esSerializada = asignatura.isSerializacion();
        String maestroImparteAsignatura = "";
        String fechaImparticion = "";
        double creditosAsignatura = asignatura.getCreditos();
        int duracionAsignatura = asignatura.getDuracion();
        String queryInsercion = "INSERT INTO asignatura (clvasig,nomasig, serializacion, maestro, fechaimparticion, creditos, duracion)"
                + " VALUES ('"+claveAsignatura+"','"+nombreAsignatura+"',"+esSerializada+",'"+maestroImparteAsignatura+"','"+fechaImparticion+"',"+creditosAsignatura+","+duracionAsignatura+")";
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

    public int actualizar(Alumno alumno, Asignatura asignatura) {
        String claveAlumno = alumno.getMatricula();
        String claveAsignatura = asignatura.getClave();
        int calificacion = asignatura.getCalificacion();
        String queryActualizacion = "UPDATE calificaciones SET calificacion = "+calificacion+" WHERE clvasig = '"+claveAsignatura+"' AND clvalumno = '"+claveAlumno+"'";
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
    public ArrayList<Asignatura> consultar(String querySeleccion) {
        ArrayList<Asignatura> resultadoAsignatura = new ArrayList<>();
        try{
        Connection conexion = getConexion(); 
        Statement sentencia =  conexion.createStatement();
        ResultSet resultadoDeDatos = sentencia.executeQuery(querySeleccion); 
            while(resultadoDeDatos.next()){
                String nombreAsignatura = resultadoDeDatos.getString("nomasig");
                int calificacion = Integer.parseInt(resultadoDeDatos.getString("calificacion"));
                boolean esSerializada = Boolean.parseBoolean(resultadoDeDatos.getString("serializacion"));
                String maestroImparteAsignatura = resultadoDeDatos.getString("maestro");
                String fechaImparticion = resultadoDeDatos.getString("fechaimparticion");
                int creditosAsignatura = Integer.parseInt(resultadoDeDatos.getString("creditos"));
                int duracionAsignatura = Integer.parseInt(resultadoDeDatos.getString("duracion"));
                Asignatura asignatura = new Asignatura();
                //Asignatura asignatura = new Asignatura(nombreAsignatura,calificacion,esSerializada,maestroImparteAsignatura,fechaImparticion,creditosAsignatura,duracionAsignatura);
                resultadoAsignatura.add(asignatura);
            }
        sentencia.close();
        cerrarConexion(conexion);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return resultadoAsignatura;
    }

    @Override
    public int actualizar(Asignatura entidad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
<<<<<<< HEAD
    
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

=======

 
	 
>>>>>>> 200086631ca5babc69fcf30e12e31015faefa89b
}
 
