package modelo;

import java.util.ArrayList;

public class Curso {
        

    public Curso(String nombre, PlanDeEstudio planDeEstudio){
        this.nombre = nombre;
        this.planDeEstudio = planDeEstudio;
    }
    /**
     * @return the planDeEstudio
     */
    public PlanDeEstudio getPlanDeEstudio() {
        return planDeEstudio;
    }

    /**
     * @param planDeEstudio the planDeEstudio to set
     */
    public void setPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        this.planDeEstudio = planDeEstudio;
    }

    /**
     * @return the planeacion
     */
    public ArrayList<String> getPlaneacion() {
        return planeacion;
    }

    /**
     * @param planeacion the planeacion to set
     */
    public void setPlaneacion(ArrayList<String> planeacion) {
        this.planeacion = planeacion;
    }
    
    /**
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private String nombre;
    private PlanDeEstudio planDeEstudio;
    private ArrayList<String> planeacion;
	 
}
 
