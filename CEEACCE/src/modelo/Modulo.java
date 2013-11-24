package modelo;

import java.util.ArrayList;

public class Modulo {
    private String nombre;
    private ArrayList<Asignatura> asignaturas;

    
    public Modulo(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * @return the asignaturas
     */
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    /**
     * @param asignaturas the asignaturas to set
     */
    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	 
}
 
