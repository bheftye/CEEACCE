/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import modelo.Alumno;
import modelo.ListaDeAlumnos;

/**
 *
 * @author Jorge
 */
public class HelperVistaAdministradorDeCalificaciones {
    private ArrayList<Alumno> alumnosOriginales = alumnosOriginales = ListaDeAlumnos.getListaDeAlumnos().getAlumnos();
    
    public DefaultListModel llenarJListConAlumnos(ArrayList<Alumno> alumnosCoincidentes){
        DefaultListModel listModel = new DefaultListModel();
        int NUM_DE_ALUMNOS = alumnosCoincidentes.size();
        for (int i = 0; i < NUM_DE_ALUMNOS; i++) {
            Alumno alumnoIndexado = alumnosCoincidentes.get(i);
            listModel.addElement(alumnoIndexado.getNombre()+" "+alumnoIndexado.getApellidos());
        }
        return listModel;
    }
    
    public ArrayList<Alumno>  encontrarAlumnoCoincidente(String textoABuscar){
        ArrayList<Alumno> alumnosCoincidentes = new ArrayList();
        for (int i = 0; i < obtenerNumeroTotalDeAlumnos(); i++) {
            Alumno alumnoIndexado = alumnosOriginales.get(i);
            boolean coincideNombre =  alumnoIndexado.getNombre().contains(textoABuscar);
            boolean coincideApellidos = alumnoIndexado.getApellidos().contains(textoABuscar);
            if(coincideApellidos || coincideNombre){
                alumnosCoincidentes.add(alumnoIndexado);
            }
        }
        return alumnosCoincidentes;
    }
    
    private int obtenerNumeroTotalDeAlumnos(){
        return alumnosOriginales.size();
    }
}
