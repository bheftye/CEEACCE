/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import accesodatos.controladordepeticiones.ControladorDePeticiones;
import gui.controladorinterfacesdeusuario.ControladorInterfacesDeUsuario;
import modelo.Alumno;
import modelo.PlanDeEstudio;

/**
 *
 * @author pedro
 */
public class HelperVistaModificarAlumno {

    private String matricula;
    private String nombre;
    private String apellidos;
    private int indiceDia;
    private int indiceMes;
    private String indiceAnio;
    private int indiceSexo;
    private String email;
    private String curp;
    private String lugar;
    private int indiceTurno;
    private int indicePlan;
    private String fechaInscripcion;
    private String planDeEstudio;

    
    
    protected String getPlanDeEstudio() {
        return planDeEstudio;

    }

    protected String getFechaInscripcion() {
        return fechaInscripcion;
    }

    protected String getApellidos() {
        return apellidos;
    }

    protected String getCurp() {
        return curp;
    }

    protected String getEmail() {
        return email;
    }

    protected String getIndiceAnio() {
        return indiceAnio;
    }

    protected int getIndiceDia() {
        return indiceDia;
    }

    protected int getIndiceMes() {
        return indiceMes;
    }

    protected int getIndicePlan() {
        return indicePlan;
    }

    protected int getIndiceSexo() {
        return indiceSexo;
    }

    protected int getIndiceTurno() {
        return indiceTurno;
    }

    protected String getLugar() {
        return lugar;
    }

    protected String getMatricula() {
        return matricula;
    }

    protected String getNombre() {
        return nombre;
    }

    private void llenaInformacionAlumno(Alumno alumno) {

        this.nombre = alumno.getNombre();
        this.apellidos = alumno.getApellidos();
        if (alumno.getSexo().equalsIgnoreCase("Hombre")) {
            this.indiceSexo = 1;
        } else {
            this.indiceSexo = 2;
        }
        this.indiceDia = (Integer.valueOf((alumno.getFechaDeNacimiento().split("-"))[2]));
        this.indiceMes = (Integer.valueOf((alumno.getFechaDeNacimiento().split("-"))[1]));
        this.indiceAnio = (alumno.getFechaDeNacimiento().split("-"))[0];
        this.lugar = alumno.getLugarDeNacimiento();
        this.curp = alumno.getCURP();
        this.email = alumno.getEmail();
        this.matricula = alumno.getMatricula();
        this.fechaInscripcion = alumno.getFechaDeInscripcion();


        switch (alumno.getTurno()) {
            case "Matutino":
                this.indiceTurno = 1;
                break;
            case "Vespertino:":
                this.indiceTurno = 2;
                break;
            case "Diurno":
                this.indiceTurno = 3;
                break;
            case "Nocturno":
                this.indiceTurno = 4;
                break;
            default:
                break;
        }

        this.planDeEstudio = (alumno.getPlanDeEstudio().getNombre());


    }
}
