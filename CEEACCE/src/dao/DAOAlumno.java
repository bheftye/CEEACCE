package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import modelo.Alumno;
import modelo.ListaDePlanesDeEstudio;
import modelo.PlanDeEstudio;

public class DAOAlumno extends DAO<Alumno> {
    
    public static DAOAlumno getDAOAlumno(){
        return daoAlumno;
    }
    
    @Override
    public int insertar(Alumno alumno) {
        String nombreAlumno = alumno.getNombre();
        String apellidos = alumno.getApellidos();
        String sexo = alumno.getSexo();
        String email = alumno.getEmail();
        String curp = alumno.getCURP();
        String lugarNacimiento = alumno.getLugarDeNacimiento();
        String fechaNacimiento = alumno.getFechaDeNacimiento();
        int edad = generarEdad(fechaNacimiento);
        String fechaInscripcion = alumno.getFechaDeInscripcion();
        String turno = alumno.getTurno();
        int clvplan = alumno.getPlanDeEstudio().getClave();
        String queryInsercion = "INSERT INTO alumno (nombre,apellidos,edad,sexo,email,curp,lugarnacimiento,fechanacimiento,fechainscripcion,turno,clvplan)"
                + " VALUES ('"+nombreAlumno+"','"+apellidos+"','"+edad+"','"+sexo+"','"+email+"','"+curp+"'"
                + ",'"+lugarNacimiento+"','"+fechaNacimiento+"','"+fechaInscripcion+"','"+turno+"','"+clvplan+"')";
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
    public int actualizar(Alumno alumno) {
        String matricula = alumno.getMatricula();
        String nombreAlumno = alumno.getNombre();
        String apellidos = alumno.getApellidos();
        String sexo = alumno.getSexo();
        String email = alumno.getEmail();
        String curp = alumno.getCURP();
        String lugarNacimiento = alumno.getLugarDeNacimiento();
        String fechaNacimiento = alumno.getFechaDeNacimiento();
        int edad = generarEdad(fechaNacimiento);
        //No puede moficar fecha de inscripcion ni plan de estudio
        String turno = alumno.getTurno();
        String queryActualizacion = "UPDATE alumno SET nombre = '"+nombreAlumno+"'"
                + ", apellidos = '"+apellidos+"', edad = '"+edad+"', sexo = '"+sexo+"'"
                + ", email = '"+email+"', curp = '"+curp+"', lugarnacimiento = '"+lugarNacimiento+"'"
                + ", fechanacimiento = '"+fechaNacimiento+"', turno = '"+turno+"' WHERE matricula = '"+matricula+"'";
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
    public ArrayList<Alumno> consultar(String peticion) throws SQLException {
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
        Connection con = getConexion(); 
        String orden; 
        Statement sentencia = null; 
        ResultSet rs = null; 
        
        if(peticion.equalsIgnoreCase("")){
            orden = "select * from Alumnos"; 
        }
        else{
            orden = "select * from Alumnos where " + peticion;  
        }
            sentencia = con.createStatement();
            rs = sentencia.executeQuery(orden); 
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String sexo =  rs.getString("sexo");
                String email = rs.getString("email");
                String curp = rs.getString("CURP");
                String matricula = rs.getString("matricula");
                String lugarDeNacimiento =  rs.getString("lugarNacimiento");
                String fechaDeNacimiento = rs.getString("fechaNacimiento");
                String fechaDeInscripcion = rs.getString("fechaInscripcion");
                String turno = rs.getString("turno");
                String clavePlanDeEstudio = rs.getString("planDeEstudio");
                PlanDeEstudio planDeEstudio = getPlanDeEstudioDeListaDePlanesDeEstudio(clavePlanDeEstudio);
                PlanDeEstudio copiaPlanDeEstudio = new PlanDeEstudio(planDeEstudio.getNombre(),planDeEstudio.getModulos(),planDeEstudio.getClave());
                
                if(planDeEstudio!=null){
                    listaAlumnos.add(new Alumno(nombre,apellidos,sexo,email,curp,matricula,lugarDeNacimiento,fechaDeNacimiento,fechaDeInscripcion,turno,copiaPlanDeEstudio));
                }
            }
            
            //String nombre, String apellidos, String sexo, String email, String matricula, String CURP, String lugarDeNacimiento, String fechaDeNacimiento, String fechaDeInscripcion, String turno, PlanDeEstudio planDeEstudio
        
        sentencia.close();
        cerrarConexion(con);
        return listaAlumnos;
    }
    
    private DAOAlumno(){}
    
    private PlanDeEstudio getPlanDeEstudioDeListaDePlanesDeEstudio(String clave){
        ListaDePlanesDeEstudio listaPlanesDeEstudio = ListaDePlanesDeEstudio.getListaDePlanesDeEstudio();
        int tamañoListaDePlanesDeEstudio = listaPlanesDeEstudio.getPlanesDeEstudio().size();
        for (int i = 0; i < tamañoListaDePlanesDeEstudio; i++) {
            PlanDeEstudio planDeEstudioIndexado = listaPlanesDeEstudio.getPlanesDeEstudio().get(i);
            if(clave.equalsIgnoreCase(planDeEstudioIndexado.getClave()+"")){
                return planDeEstudioIndexado;
            }
        }
        return null;
    }
    
    private int generarEdad(String fechaNacimiento){
        Calendar cal = Calendar.getInstance();
        int anioHoy = cal.get(Calendar.YEAR);
        int mesHoy = cal.get(Calendar.MONTH);
        int diaHoy = cal.get(Calendar.DAY_OF_MONTH);
        int anioNacimiento = Integer.valueOf((fechaNacimiento.split("/"))[0]);
        int mesNacimiento = Integer.valueOf((fechaNacimiento.split("/"))[1]);
        int diaNacimiento = Integer.valueOf((fechaNacimiento.split("/"))[2]);
        double hoy = anioHoy + mesHoy*.01 + diaHoy*.0001;
        double nacimiento = anioNacimiento + mesNacimiento*.01 + diaNacimiento*.0001;
        return (int)(hoy-nacimiento);
    }
    
    private static DAOAlumno daoAlumno = new DAOAlumno();

}