/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import modelo.Curso;
import modelo.ListaDeCursos;

/**
 *
 * @author Jorge
 */
public class HelperVistaAdministradorDeCursos {
    public DefaultListModel llenarJListConCursos(){
        ArrayList<Curso> cursos = ListaDeCursos.getListaDeCursos().getCursos();
        DefaultListModel listModel = new DefaultListModel();
        int numCursos = cursos.size();
        for (int i = 0; i < numCursos; i++) {
            Curso cursoIndexado = cursos.get(i);
            listModel.addElement(cursoIndexado.getNombre());
        }
        return listModel;
    }
}
