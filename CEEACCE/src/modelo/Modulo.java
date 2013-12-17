package modelo;

import java.util.ArrayList;

public class Modulo {

    
    public Modulo(String nombre, int clvModulo){
        this.nombre = nombre;
    }

    public int getClvModulo() {
        return clvModulo;
    }

    public void setClvModulo(int clvModulo) {
        this.clvModulo = clvModulo;
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
    
    private int clvModulo;
    private String nombre;
    private ArrayList<Asignatura> asignaturas;
	 
}
 
