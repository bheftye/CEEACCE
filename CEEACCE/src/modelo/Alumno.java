package modelo;

import java.util.ArrayList;

public class Alumno {
 
	private String nombre;
	 
	private String apellidos;
	 	 
	private String sexo;
	 
	private String email;
	 
	private String matricula;
	 
	private String CURP;
	 
	private String lugarDeNacimiento;
	 
	private String fechaDeNacimiento;
	 
	private String fechaDeInscripcion;
	 
	private String turno;
	 
	private PlanDeEstudio planDeEstudio;
	 
	private ArrayList<CargaAcademica> cargasAcademicas;
        

    public Alumno(String nombre, String apellidos, String sexo, String email, String matricula, String CURP, String lugarDeNacimiento, String fechaDeNacimiento, String fechaDeInscripcion, String turno, PlanDeEstudio planDeEstudio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.email = email;
        this.matricula = matricula;
        this.CURP = CURP;
        this.lugarDeNacimiento = lugarDeNacimiento;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeInscripcion = fechaDeInscripcion;
        this.turno = turno;
        this.planDeEstudio = planDeEstudio;
    }

        
        
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the CURP
     */
    public String getCURP() {
        return CURP;
    }

    /**
     * @param CURP the CURP to set
     */
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    /**
     * @return the lugarDeNacimiento
     */
    public String getLugarDeNacimiento() {
        return lugarDeNacimiento;
    }

    /**
     * @param lugarDeNacimiento the lugarDeNacimiento to set
     */
    public void setLugarDeNacimiento(String lugarDeNacimiento) {
        this.lugarDeNacimiento = lugarDeNacimiento;
    }

    /**
     * @return the fechaDeNacimiento
     */
    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     * @param fechaDeNacimiento the fechaDeNacimiento to set
     */
    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    /**
     * @return the fechaDeInscripcion
     */
    public String getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    /**
     * @param fechaDeInscripcion the fechaDeInscripcion to set
     */
    public void setFechaDeInscripcion(String fechaDeInscripcion) {
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
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
     * @return the cargasAcademicas
     */
    public ArrayList<CargaAcademica> getCargasAcademicas() {
        return cargasAcademicas;
    }

    /**
     * @param cargasAcademicas the cargasAcademicas to set
     */
    public void setCargasAcademicas(ArrayList<CargaAcademica> cargasAcademicas) {
        this.cargasAcademicas = cargasAcademicas;
    }
}
 
