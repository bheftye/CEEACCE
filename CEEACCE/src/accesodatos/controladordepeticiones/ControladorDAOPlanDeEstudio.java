/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.controladordepeticiones;

import accesodatos.dao.DAOAsignatura;
import accesodatos.dao.DAOPlanDeEstudio;
import java.util.ArrayList;
import modelo.Asignatura;
import modelo.Modulo;
import modelo.PlanDeEstudio;

/**
 *
 * @author brentheftye
 */
public class ControladorDAOPlanDeEstudio extends ControladorDAO<PlanDeEstudio> {

    protected static ControladorDAOPlanDeEstudio getControladorDAOPlanDeEstudio(){
        return controladorDAOPlanDeEstudio;
    }
    @Override
    protected boolean agregar(PlanDeEstudio planDeEstudio) {
        DAOPlanDeEstudio dao =  DAOPlanDeEstudio.getDAOPlanDeEstudio();
        int numeroFilasAfectadas = dao.insertar(planDeEstudio);
        return determinarExitoDeTransaccion(numeroFilasAfectadas);
    }

    @Override
    protected boolean modificar(PlanDeEstudio planDeEstudio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean eliminar(PlanDeEstudio planDeEstudio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    protected int obtenClaveDePlanDeEstudioPorNombre(String nombrePlanDeEstudio) {
        String queryDeConsulta = "SELECT * FROM plandeestudio WHERE nomplan = '" + nombrePlanDeEstudio + "'";
        DAOPlanDeEstudio dao = DAOPlanDeEstudio.getDAOPlanDeEstudio();
        int clavePlanDeEstudio = dao.obtenerClaveDePlanDeEstudioPorNombre(queryDeConsulta);
        return clavePlanDeEstudio;
    }
    
    protected ArrayList<PlanDeEstudio> obtenerPlanesDeEstudioConAsignaturas() {
        ControladorDAOAsignatura controladorDAOAsignatura = ControladorDAOAsignatura.getControladorDAOAsignatura();
        int NUM_DE_MODULOS = 6;
        ArrayList<PlanDeEstudio> planesDeEstudio = obtenerPlanesDeEstudioSinAsignaturas();
        for (int i = 0; i < planesDeEstudio.size(); i++) {
            PlanDeEstudio planDeEstudioIndexado = planesDeEstudio.get(i);
            int clvPlanDeEstudioIndexado = planDeEstudioIndexado.getClave();
            ArrayList<Modulo> modulosDePlanDeEstudioIndexado = planDeEstudioIndexado.getModulos();
            for (int j = 0; j < NUM_DE_MODULOS; j++) {
                Modulo moduloIndexado = modulosDePlanDeEstudioIndexado.get(j);
                int clvModuloIndexado = moduloIndexado.getClvModulo();
                ArrayList<Asignatura> asignaturasDelModulo = controladorDAOAsignatura.obtenAsignaturasPorModulo(clvPlanDeEstudioIndexado, clvModuloIndexado);
                moduloIndexado.setAsignaturas(asignaturasDelModulo);
            }
            planDeEstudioIndexado.setModulos(modulosDePlanDeEstudioIndexado);
        }
        return planesDeEstudio;
    }
    
    protected PlanDeEstudio obtenerCopiaPlanDeEstudioPorClave(int clavePlanDeEstudio) {
        int NUM_DE_MODULOS = 6;
        PlanDeEstudio planDeEstudio = obtenerPlanDeEstudioSinAsignaturas(clavePlanDeEstudio);
        if (planDeEstudio != null) {
            for (int j = 0; j < NUM_DE_MODULOS; j++) {
                Modulo moduloIndexado = planDeEstudio.getModulos().get(j);
                String queryDeAsignaturasDeModulo = "select clvasig,nomasig,serializacion,creditos,duracion from planmoduloasignatura,asignatura where clvplan = " + planDeEstudio.getClave() + " and clvmodulo = " + (j + 1) + " and clvasign = clvasig";
                moduloIndexado.setAsignaturas(DAOAsignatura.getDAOAsignatura().consultar(queryDeAsignaturasDeModulo));
            }
            return planDeEstudio;
        }
        return null;
    }
    
    protected PlanDeEstudio obtenerPlanDeEstudioSinAsignaturas(int clvPlanDeEstudio){
        String queryDeConsulta = "select * from plandeestudio where clvplan =" + clvPlanDeEstudio;
        DAOPlanDeEstudio dao = DAOPlanDeEstudio.getDAOPlanDeEstudio();
        PlanDeEstudio planDeEstudio = dao.obtenerPlanDeEstudio(queryDeConsulta);
        return planDeEstudio;
    }
    
    private ArrayList<PlanDeEstudio> obtenerPlanesDeEstudioSinAsignaturas(){
        String queryDePlanesDeEstudio = "select * from plandeestudio order by clvplan asc ";
        DAOPlanDeEstudio dao = DAOPlanDeEstudio.getDAOPlanDeEstudio();
        ArrayList<PlanDeEstudio> planesDeEstudio =  dao.consultar(queryDePlanesDeEstudio);
        return planesDeEstudio;
    }
    
    private ControladorDAOPlanDeEstudio(){}
    
    private static ControladorDAOPlanDeEstudio controladorDAOPlanDeEstudio = new ControladorDAOPlanDeEstudio();
    
}
