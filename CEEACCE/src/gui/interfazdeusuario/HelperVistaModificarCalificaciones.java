/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import modelo.Asignatura;
import modelo.Modulo;

/**
 *
 * @author Jorge
 */
public class HelperVistaModificarCalificaciones {
    /**
     * Método que llena la Tabla con las filas de las asignaturas.
     */
    public DefaultTableModel llenarListaAsignaturas(ArrayList<Modulo> listaDeModulos) {
        Vector titulosTabla = llenarTitulosDeTabla();
        Vector datosAsignaturas = new Vector<Vector<String>>();
        int numeroDeModulos = listaDeModulos.size();
        for (int i = 0; i < numeroDeModulos; i++) {
            Modulo moduloIndexado = listaDeModulos.get(i);
            int numeroDeAsignaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
            for (int j = 0; j < numeroDeAsignaturasDeModuloIndexado; j++) {
                Asignatura asignaturaIndexada = moduloIndexado.getAsignaturas().get(j);
                Vector<String> filaDatosDeAsignaturaIndexada = new Vector<String>();
                filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getNombreAsignatura());
                filaDatosDeAsignaturaIndexada.add(moduloIndexado.getNombre());
                filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getCalificacion() + "");
                datosAsignaturas.add(filaDatosDeAsignaturaIndexada);
            }
        }

        DefaultTableModel modelo = new DefaultTableModel(datosAsignaturas, titulosTabla) {
            public boolean isCellEditable(int row, int column) {
                if(column == 2){
                    return true;
                }
                else{
                    return false;
                }
            }
        };
        return modelo;
    }

    /**
     * Método que crea los titulos de la tabla a mostrar.
     *
     * @return Vector Títulos de la JTable.
     */
    private Vector llenarTitulosDeTabla() {
        Vector titulos = new Vector();
        titulos.add("Asignatura");
        titulos.add("Módulo");
        titulos.add("Calificación");
        return titulos;
    }
}
