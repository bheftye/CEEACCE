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
public class HelperVistasPlanDeEstudio {
    /**
    * Método que crea los 6 módulos. 
    */
    public ArrayList<Modulo> creaModulos(){
        int numeroDeModulosPorCrear = 6;
        ArrayList<Modulo> listaDeModulos = new ArrayList();
        for (int i = 0; i < numeroDeModulosPorCrear; i++) {
            Modulo modulo = new Modulo("Módulo "+(i+1));
            modulo.setAsignaturas(new ArrayList<Asignatura>());
            listaDeModulos.add(modulo);
        }
        return listaDeModulos;
    }
    
    /**
    * Método que llena la Tabla con las filas de las asignaturas.
    */
    public DefaultTableModel llenarListaDeAsignaturasCreadas(ArrayList<Modulo> modulos){
        Vector titulosTabla = llenarTitulosDeTabla();
        Vector datosAsignaturas = new Vector<Vector<String>>();
        int numeroDeModulos = modulos.size();
        for (int i = 0; i < numeroDeModulos; i++) {
            Modulo moduloIndexado = modulos.get(i);
            int numeroDeAsigaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
            for (int j = 0; j < numeroDeAsigaturasDeModuloIndexado; j++) {
                Vector<String>  filaDatosDeAsignaturaIndexada = llenarFilaDatosDeAsignatura(moduloIndexado.getAsignaturas().get(j));
                filaDatosDeAsignaturaIndexada.add(moduloIndexado.getNombre());
                datosAsignaturas.add(filaDatosDeAsignaturaIndexada);
            }
        }
        DefaultTableModel modelo = new DefaultTableModel(datosAsignaturas,titulosTabla){
        public boolean isCellEditable(int row, int column){return false;}};
        return modelo;
        }
    /**
    * Método que crea los titulos de la tabla a mostrar. 
    * @return Vector Títulos de la JTable. 
    */
    private Vector llenarTitulosDeTabla(){
        Vector titulos = new Vector();
        titulos.add("Clave");
        titulos.add("Nombre");
        titulos.add("Créditos");
        titulos.add("Duración(Semanas)");
        titulos.add("Módulo");
        return titulos;
    }
   
   /**
    * Método que crea y llena una fila de la tabla con datos de una
    * asignatura.
    * @param asignatura Instancia. 
    * @return Vector<String> Vector fila con los datos de la asignatura.
    */
    private Vector<String> llenarFilaDatosDeAsignatura(Asignatura asignatura){
        Asignatura asignaturaIndexada = asignatura;
        Vector<String> filaDatosDeAsignaturaIndexada = new Vector<String>();
        filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getClave());
        filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getNombreAsignatura());
        filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getCreditos() + "");
        filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getDuracion() + "");
        return filaDatosDeAsignaturaIndexada;
    }
}
