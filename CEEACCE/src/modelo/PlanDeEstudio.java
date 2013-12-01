package modelo;

import java.util.ArrayList;

public class PlanDeEstudio {
        private int clave;
        private String nombre;
	private ArrayList<Modulo> modulos;

    public PlanDeEstudio(String nombre, ArrayList<Modulo> modulos, int clave) {
        this.nombre = nombre;
        this.modulos = modulos;
       
    }

        
    /**
     * @return the modulos
     */
    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    /**
     * @param modulos the modulos to set
     */
    public void setModulos(ArrayList<Modulo> modulos) {
        this.modulos = modulos;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }
    
    
}
 
