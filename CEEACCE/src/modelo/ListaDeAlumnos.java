package modelo;

import java.util.ArrayList;

public class ListaDeAlumnos {
    private static ListaDeAlumnos listaDeAlumnos = new ListaDeAlumnos();
    private ArrayList<Alumno> alumnos;
    
    private ListaDeAlumnos(){}

    public static ListaDeAlumnos getListaDeAlumnos(){
        return listaDeAlumnos;
    }
    /**
     * @return the alumnos
     */
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * @param alumnos the alumnos to set
     */
    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
 
