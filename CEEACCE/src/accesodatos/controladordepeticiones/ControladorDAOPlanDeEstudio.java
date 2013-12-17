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
    
    protected ArrayList<PlanDeEstudio> obtenerTodosLosPlanesDeEstudio() {
        ControladorDAOAsignatura controladorDAOAsignatura = ControladorDAOAsignatura.getControladorDAOAsignatura();
        int NUM_DE_MODULOS = 6;
        ArrayList<PlanDeEstudio> planesDeEstudio = obtenerPlanesDeEstudioSinModulosNiAsignaturas();
        for (int i = 0; i < planesDeEstudio.size(); i++) {
            PlanDeEstudio planDeEstudioIndexado = planesDeEstudio.get(i);
            int clvPlanDeEstudioIndexado = planDeEstudioIndexado.getClave();
            ArrayList<Modulo> modulosDePlanDeEstudioIndexado = planDeEstudioIndexado.getModulos();
            for (int j = 0; j < NUM_DE_MODULOS; j++) {
                Modulo moduloIndexado = modulosDePlanDeEstudioIndexado.get(j);
                int clvModuloIndexado = j + 1;
                ArrayList<Asignatura> asignaturasDelModulo = controladorDAOAsignatura.obtenAsignaturasPorModulo(clvPlanDeEstudioIndexado, clvModuloIndexado);
                moduloIndexado.setAsignaturas(asignaturasDelModulo);
            }
        }
        return planesDeEstudio;
    }
    
    private ArrayList<PlanDeEstudio> obtenerPlanesDeEstudioSinModulosNiAsignaturas(){
        String queryDePlanesDeEstudio = "select * from plandeestudio order by clvplan asc ";
        DAOPlanDeEstudio dao = DAOPlanDeEstudio.getDAOPlanDeEstudio();
        ArrayList<PlanDeEstudio> planesDeEstudio =  dao.consultar(queryDePlanesDeEstudio);
        return planesDeEstudio;
    }
    
    private ControladorDAOPlanDeEstudio(){}
    
    private static ControladorDAOPlanDeEstudio controladorDAOPlanDeEstudio = new ControladorDAOPlanDeEstudio();
    
}
