package modelo;

public class Asignatura {

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
    public int getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
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
    
    private String nombreAsignatura;
    private String clave;
    private int calificacion;
    private boolean serializacion;
    private String maestroQueImparte;
    private String fechaImparticion;
    private int creditos;
    private int duracion;
	 
}
 
