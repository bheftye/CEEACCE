/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Asignatura;
import modelo.ListaDePlanesDeEstudio;
import modelo.Modulo;
import modelo.PlanDeEstudio;

/**
 *
 * @author Jorge
 */
public class HelperVistaAltaCurso {
    ArrayList<Asignatura> listaAsignaturasEnCurso = new ArrayList();
    
    public DefaultTableModel llenarListaAsignaturas(ArrayList<Modulo> modulos){
        Vector titulosTabla = llenarTitulosDeTabla();
        Vector datosAsignaturas = new Vector<Vector<String>>();
        int numeroDeModulos = modulos.size();
        for (int i = 0; i < numeroDeModulos; i++) {
                Modulo moduloIndexado = modulos.get(i);
                int numeroDeAsignaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
                for (int j = 0; j < numeroDeAsignaturasDeModuloIndexado; j++) {
                    Asignatura asignaturaIndexada = moduloIndexado.getAsignaturas().get(j);
                    llenarListaAsignaturasEnCurso(asignaturaIndexada);
                    Vector<String>  filaDatosDeAsignaturaIndexada = llenarFilaDatosDeAsignatura(asignaturaIndexada);
                    filaDatosDeAsignaturaIndexada.add(0,moduloIndexado.getNombre());
                    datosAsignaturas.add(filaDatosDeAsignaturaIndexada);
            }
        }
        DefaultTableModel modelo = new DefaultTableModel(datosAsignaturas,titulosTabla){
            public boolean isCellEditable(int row, int column){return false;}};
        return modelo;
    }
    
    public ArrayList<Asignatura> obtenerListaAsignaturasEnCurso(){
        return listaAsignaturasEnCurso;
    }
    
    private void llenarListaAsignaturasEnCurso(Asignatura asignatura){
        listaAsignaturasEnCurso.add(asignatura);
    }
    
    private Vector llenarTitulosDeTabla(){
        Vector titulos = new Vector();
        titulos.add("Módulo");
        titulos.add("Asignatura");
        titulos.add("Fecha de Impartición");
        titulos.add("Duración");
        return titulos;
    }

    private Vector<String> llenarFilaDatosDeAsignatura(Asignatura asignatura){
        Asignatura asignaturaIndexada = asignatura;
        Vector<String> filaDatosDeAsignaturaIndexada = new Vector<String>();
        filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getNombreAsignatura());
        filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getFechaImparticion());
        filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getDuracion() + "");
        return filaDatosDeAsignaturaIndexada;
    }

    public boolean validarCamposFechaLlenos(JTable jTable1){
        int NUM_TOTAL_CAMPOS = 40;
        for (int i = 0; i < NUM_TOTAL_CAMPOS; i++) {
            if("".equals(jTable1.getValueAt(i, 3)))
                return false;
        }
        return true;
    }
}
