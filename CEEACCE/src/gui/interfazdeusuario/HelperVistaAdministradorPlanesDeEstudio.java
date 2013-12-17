/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import modelo.ListaDePlanesDeEstudio;
import modelo.PlanDeEstudio;

/**
 *
 * @author Jorge
 */
public class HelperVistaAdministradorPlanesDeEstudio {
    public DefaultListModel llenarJListConPlanesDeEstudio(){
        ArrayList<PlanDeEstudio> planesDeEstudio = ListaDePlanesDeEstudio.getListaDePlanesDeEstudio().getPlanesDeEstudio();
        DefaultListModel listModel = new DefaultListModel();
        int numPlanes = planesDeEstudio.size();
        for (int i = 0; i < numPlanes; i++) {
            PlanDeEstudio planDeEstudioIndexado = planesDeEstudio.get(i);
            listModel.addElement(planDeEstudioIndexado.getNombre());
        }
        return listModel;
    }
}
