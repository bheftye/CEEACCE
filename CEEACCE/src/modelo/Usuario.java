package modelo;

public class Usuario {
    
    public Usuario(String nombreUsuario, String contrasenia, int claveUsuario){
        this.nombreDeUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.claveUsuario = claveUsuario;
    }
    
    /**
     * @return the nombreDeUsuario
     */
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    /**
     * @param nombreDeUsuario the nombreDeUsuario to set
     */
    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(int claveUsuario) {
        this.claveUsuario = claveUsuario;
    }
   
    private String nombreDeUsuario;
    private String contrasenia;
    private int claveUsuario;
	 
}
 
