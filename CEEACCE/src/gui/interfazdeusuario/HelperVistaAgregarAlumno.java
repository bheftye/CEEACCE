/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import java.util.Observable;

/**
 *
 * @author Jorge
 */
public class HelperVistaAgregarAlumno extends Observable{
    private String matricula;
    private String nombre;
    private String apellidos;
    private int indiceDia;
    private int indiceMes;
    private int indiceAnio;
    private int indiceSexo;
    private String email;
    private String curp;
    private String lugar;
    private int indiceTurno;
    private int indicePlan;

    protected String getApellidos() {
        return apellidos;
    }

    protected String getCurp() {
        return curp;
    }

    protected String getEmail() {
        return email;
    }

    protected int getIndiceAnio() {
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

    protected void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    protected void setCurp(String curp) {
        this.curp = curp;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected void setIndiceAnio(int indiceAnio) {
        this.indiceAnio = indiceAnio;
    }

    protected void setIndiceDia(int indiceDia) {
        this.indiceDia = indiceDia;
    }

    protected void setIndiceMes(int indiceMes) {
        this.indiceMes = indiceMes;
    }

    protected void setIndicePlan(int indicePlan) {
        this.indicePlan = indicePlan;
    }

    protected void setIndiceSexo(int indiceSexo) {
        this.indiceSexo = indiceSexo;
    }

    protected void setIndiceTurno(int indiceTurno) {
        this.indiceTurno = indiceTurno;
    }

    protected void setLugar(String lugar) {
        this.lugar = lugar;
    }

    protected void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    protected boolean validarLlenadoDeCampos(){
        int INDICE_COMBO_VACIO = 0;
        
        boolean campoMatriculaVacio = "".equals(matricula);
        boolean campoNombreVacio = "".equals(nombre);
        boolean campoApellidosVacio = "".equals(apellidos);
        boolean campoDiaVacio = indiceDia == INDICE_COMBO_VACIO? true : false;
        boolean campoMesVacio = indiceMes == INDICE_COMBO_VACIO? true : false;
        boolean campoAnioVacio = indiceAnio == INDICE_COMBO_VACIO? true : false;
        boolean campoSexoVacio = indiceSexo == INDICE_COMBO_VACIO? true : false;
        boolean campoEmailVacio = "".equals(email);
        boolean campoCurpVacio = "".equals(curp);
        boolean campoLugarVacio = "".equals(lugar);
        boolean campoTurnoVacio = indiceTurno == 0? true : false;
        boolean campoPlanVacio = indicePlan == 0? true : false;
        
        
        if(!campoMatriculaVacio && !campoNombreVacio && !campoApellidosVacio && !campoDiaVacio && !campoMesVacio
                && !campoAnioVacio && !campoSexoVacio && !campoEmailVacio && !campoCurpVacio && !campoLugarVacio
                && !campoTurnoVacio && !campoPlanVacio){
            return true;
        }
        return false;
    }
}
