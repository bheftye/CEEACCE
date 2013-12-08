package modelo;

public class Asignatura {
 
	private String nombreAsignatura;
        
        private String clave;

	private int calificacion;
	 
	private boolean serializacion;
	 
	private String maestroQueImparte;
	 
	private String fechaImparticion;
	 
	private double creditos;
	 
	private int duracion;
    
    public Asignatura(){}    

    public Asignatura(String nombreAsignatura, String clave, int calificacion, boolean serializacion, String maestroQueImparte, String fechaImparticion, double creditos, int duracion){
        this.calificacion = calificacion;
        this.clave = clave;
        this.creditos = creditos;
        this.duracion = duracion;
        this.fechaImparticion = fechaImparticion;
        this.maestroQueImparte = maestroQueImparte;
        this.nombreAsignatura = nombreAsignatura;
        this.serializacion = serializacion;
    }    
    /**
     * @return the nombreAsignatura
     */
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    /**
     * @param nombreAsignatura the nombreAsignatura to set
     */
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    /**
     * @return the calificaciones
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificaciones the calificaciones to set
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the serializacion
     */
    public boolean isSerializacion() {
        return serializacion;
    }

    /**
     * @param serializacion the serializacion to set
     */
    public void setSerializacion(boolean serializacion) {
        this.serializacion = serializacion;
    }

    /**
     * @return the maestroQueImparte
     */
    public String getMaestroQueImparte() {
        return maestroQueImparte;
    }

    /**
     * @param maestroQueImparte the maestroQueImparte to set
     */
    public void setMaestroQueImparte(String maestroQueImparte) {
        this.maestroQueImparte = maestroQueImparte;
    }

    /**
     * @return the fechaImparticion
     */
    public String getFechaImparticion() {
        return fechaImparticion;
    }

    /**
     * @param fechaImparticion the fechaImparticion to set
     */
    public void setFechaImparticion(String fechaImparticion) {
        this.fechaImparticion = fechaImparticion;
    }

    /**
     * @return the creditos
     */
    public double getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }
	 
}
 
