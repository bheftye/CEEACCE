package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Curso;
import java.util.ArrayList;
import modelo.*;

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
        int numFilasAfectadas = 0;
        for (int i = 0; i < 6; i++) {
                    Modulo moduloIndexado = curso.getPlanDeEstudio().getModulos().get(i);
                    int numAsignaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
                    for (int j = 0; j < numAsignaturasDeModuloIndexado; j++) {
                        Asignatura asignaturaIndexada = moduloIndexado.getAsignaturas().get(j);
                        String clvasignatura = asignaturaIndexada.getClave();
                        String fechaImparticion = asignaturaIndexada.getFechaImparticion();
                        String queryInsercion = "INSERT INTO curso (nomcurso, clvplan, clvasign, fechaimparticion) VALUES ('"+nombreCurso+"',"+clvplan+",'"+clvasignatura+"','"+fechaImparticion+"')";
                        numFilasAfectadas = ejecutaQuery(queryInsercion);
                    }
                }
        return numFilasAfectadas;
    }

    @Override
    public int actualizar(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Curso> consultar(String querySeleccion) {
        ArrayList<Curso> resultadoCursos = new ArrayList();
        try{
        Connection conexion = getConexion(); 
        Statement sentencia =  conexion.createStatement();
        ResultSet resultadoDeDatos = sentencia.executeQuery(querySeleccion); 
            while(resultadoDeDatos.next()){
                String nombreCurso = resultadoDeDatos.getString("nomcurso");
                String clavePlanDeEstudio = resultadoDeDatos.getString("clvplan").trim().toString();
                PlanDeEstudio planDeEstudio = getPlanDeEstudioDeListaDePlanesDeEstudio(clavePlanDeEstudio);
                PlanDeEstudio copiaPlanDeEstudio = new PlanDeEstudio(planDeEstudio.getNombre(), planDeEstudio.getModulos(), planDeEstudio.getClave());
                Curso curso = new Curso(nombreCurso, copiaPlanDeEstudio);
                resultadoCursos.add(curso);
            }
        sentencia.close();
        cerrarConexion(conexion);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return resultadoCursos;
    }
    
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
 
