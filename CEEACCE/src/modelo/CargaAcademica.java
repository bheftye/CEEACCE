/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author brentheftye
 */

import java.util.ArrayList;

public class CargaAcademica {
	private Curso curso;
	private ArrayList<Asignatura> cargaDeAsignaturas;
    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the cargaDeAsignaturas
     */
    public ArrayList<Asignatura> getCargaDeAsignaturas() {
        return cargaDeAsignaturas;
    }

    /**
     * @param cargaDeAsignaturas the cargaDeAsignaturas to set
     */
    public void setCargaDeAsignaturas(ArrayList<Asignatura> cargaDeAsignaturas) {
        this.cargaDeAsignaturas = cargaDeAsignaturas;
    }
	 
}
 
