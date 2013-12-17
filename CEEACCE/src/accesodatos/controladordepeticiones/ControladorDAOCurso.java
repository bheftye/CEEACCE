/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

import accesodatos.dao.DAOCurso;
import java.util.ArrayList;
import modelo.Asignatura;
import modelo.Curso;
import modelo.Modulo;
import modelo.PlanDeEstudio;

/**
 *
 * @author brentheftye
 */
public class ControladorDAOCurso extends ControladorDAO<Curso> {
    
    protected static ControladorDAOCurso getControladorDAOCurso(){
        return controladorDAOCurso;
    }

    @Override
    protected boolean agregar(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean modificar(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean eliminar(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    protected ArrayList<Curso> obtenerCursos() {
        ArrayList<Curso> cursos = obtenerCursosSinPlanDeEstudio();
        ControladorDAOPlanDeEstudio controladorDAOPlanDeEstudio = ControladorDAOPlanDeEstudio.getControladorDAOPlanDeEstudio();
        ControladorDAOAsignatura controladorDAOAsignatura = ControladorDAOAsignatura.getControladorDAOAsignatura();
        int NUM_ALUMNOS = cursos.size();
        for (int i = 0; i < NUM_ALUMNOS; i++) {
            Curso cursoIndexado = cursos.get(i);
            int clvPlanDeEstudio = cursoIndexado.getPlanDeEstudio().getClave();
            PlanDeEstudio copiaPlanDeEstudio =  controladorDAOPlanDeEstudio.obtenerCopiaPlanDeEstudioPorClave(clvPlanDeEstudio);
            cursoIndexado.setPlanDeEstudio(copiaPlanDeEstudio);
            int clavePlanDeEstudio = copiaPlanDeEstudio.getClave();
            int NUM_DE_MODULOS = 6;
            for (int j = 0; j < NUM_DE_MODULOS; j++) {
                int claveModulo = j + 1;
                Modulo moduloIndexado = copiaPlanDeEstudio.getModulos().get(j);
                int NUM_ASIGNATURAS_DEL_MODULO = moduloIndexado.getAsignaturas().size();
                for (int k = 0; k < NUM_ASIGNATURAS_DEL_MODULO; k++) {
                    Asignatura asignaturaIndexada = moduloIndexado.getAsignaturas().get(k);
                    String claveAsignatura = asignaturaIndexada.getClave();
                    String fechaImparticion =  controladorDAOAsignatura.obtenerFechaDeImparticionDeAsignatura(cursoIndexado.getNombre(), clavePlanDeEstudio, claveModulo, claveAsignatura);
                    asignaturaIndexada.setFechaImparticion(fechaImparticion);
                }
            }

        }
        return cursos;

    }
    
    protected ArrayList<Curso> obtenerCursosSinPlanDeEstudio(){
        DAOCurso dao = DAOCurso.getDAOCurso();
        String query = "select * from curso";
        ArrayList<Curso> cursos = dao.consultar(query);
        return cursos;
    }
    
    private ControladorDAOCurso(){}
    
    private static ControladorDAOCurso controladorDAOCurso = new ControladorDAOCurso();
    
    
}
