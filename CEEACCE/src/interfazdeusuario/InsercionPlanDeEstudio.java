/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazdeusuario;

import java.util.ArrayList;
import modelo.Asignatura;
import modelo.Modulo;
import modelo.PlanDeEstudio;

/**
 *
 * @author brentheftye
 */
public class InsercionPlanDeEstudio {
    public static void main(String[] args) {
        Modulo m1 = new Modulo("Modulo 1");
        Modulo m2 = new Modulo("Modulo 2");
        Modulo m3 = new Modulo("Modulo 3");
        Modulo m4 = new Modulo("Modulo 4");
        Modulo m5 = new Modulo("Modulo 5");
        Modulo m6 = new Modulo("Modulo 6");
        ArrayList<Asignatura> asignaturas1 = new ArrayList();
        ArrayList<Asignatura> asignaturas2 = new ArrayList();
        ArrayList<Asignatura> asignaturas3 = new ArrayList();
        ArrayList<Asignatura> asignaturas4 = new ArrayList();
        ArrayList<Asignatura> asignaturas5 = new ArrayList();
        ArrayList<Asignatura> asignaturas6 = new ArrayList();
        //String nombreAsignatura, String clave, int calificacion, boolean serializacion, String maestroQueImparte, String fechaImparticion, double creditos, int duracion
        asignaturas1.add(new Asignatura("Taller de Lectura y Redacción I","C-TLR01", 0, true, "", "", 2.6, 2));
        asignaturas1.add(new Asignatura("Etimologías Grecolatinas","C-ETI01", 0, false, "", "", 5.2, 4));
        asignaturas1.add(new Asignatura("Matemáticas I","M-MAT01", 0, true, "", "", 5.2, 4));
        asignaturas1.add(new Asignatura("Química I","CE-QUI01", 0, true, "", "", 5.7, 4));
        asignaturas1.add(new Asignatura("Inglés I","C-ING01", 0, true, "", "", 2.6, 2));
        m1.setAsignaturas(asignaturas1);
        
        asignaturas2.add(new Asignatura("Taller de Lectura y Redacción II","C-TLR02", 0, true, "", "", 2.6, 2));
        asignaturas2.add(new Asignatura("Informática I","C-INF01", 0, true, "", "", 2.6, 2));
        asignaturas2.add(new Asignatura("Matemáticas II","M-MAT02", 0, true, "", "", 5.2, 4));
        asignaturas2.add(new Asignatura("Química II","CE-QUI02", 0, true, "", "", 4.3, 3));
        asignaturas2.add(new Asignatura("Inglés II","C-ING02", 0, true, "", "", 2.3, 2));
        asignaturas2.add(new Asignatura("Biología I","CE-BIO01", 0, true, "", "", 4.1, 3));
        m2.setAsignaturas(asignaturas2);
        
        asignaturas3.add(new Asignatura("Historia de México I","CS-HIS01", 0, true, "", "", 2.3, 2));
        asignaturas3.add(new Asignatura("Informática II","C-INF02", 0, true, "", "", 2.6, 2));
        asignaturas3.add(new Asignatura("Matemáticas III","M-MAT03", 0, true, "", "", 5.2, 4));
        asignaturas3.add(new Asignatura("Física I","CE-FIS01", 0, true, "", "", 4.3, 3));
        asignaturas3.add(new Asignatura("Inglés III","C-ING03", 0, true, "", "", 2.3, 2));
        asignaturas3.add(new Asignatura("Biología II","CE-BIO02", 0, true, "", "", 4.1, 3));
        m3.setAsignaturas(asignaturas3);
        
        asignaturas4.add(new Asignatura("Historia de México II","CS-HIS02", 0, true, "", "", 2.6, 2));
        asignaturas4.add(new Asignatura("Filosofía","CS-FIL01", 0, false, "", "", 2.6, 2));
        asignaturas4.add(new Asignatura("Matemáticas IV","M-MAT04", 0, true, "", "", 3.9, 3));
        asignaturas4.add(new Asignatura("Física II","CE-FIS02", 0, true, "", "", 4.3, 3));
        asignaturas4.add(new Asignatura("Inglés IV","C-ING04", 0, true, "", "", 2.3, 2));
        asignaturas4.add(new Asignatura("Contabilidad I","CS-CON01", 0, true, "", "", 2.6, 2));
        asignaturas4.add(new Asignatura("Literatura I","C-LIT01", 0, true, "", "", 2.3, 2));
        m4.setAsignaturas(asignaturas4);
        
        asignaturas5.add(new Asignatura("Probabilidad y Estadística","M-PRO01", 0, false, "", "", 2.6, 2));
        asignaturas5.add(new Asignatura("Administración","CS-ADM01", 0, false, "", "", 2.6, 2));
        asignaturas5.add(new Asignatura("Historia de Nuestro Tiempo","CS-HIS01", 0, false, "", "", 2.3, 2));
        asignaturas5.add(new Asignatura("Economía","CS-ECO01", 0, false, "", "", 2.3, 2));
        asignaturas5.add(new Asignatura("Ética y Valores","CS-ETI01", 0, false, "", "", 2.6, 2));
        asignaturas5.add(new Asignatura("Historia de Yucatán","CS-HIS04", 0, false, "", "", 2.3, 2));
        asignaturas5.add(new Asignatura("Literatura II","C-LIT02", 0, true, "", "", 2.6, 2));
        asignaturas5.add(new Asignatura("Contabilidad II","CS-CON02", 0, true, "", "", 2.6, 2));
        m5.setAsignaturas(asignaturas5);
        
        asignaturas6.add(new Asignatura("Ecología y Medio Ambiente","CE-ECG01", 0, false, "", "", 2.6, 2));
        asignaturas6.add(new Asignatura("Metodología de la Investigación","CE-MET01", 0, false, "", "", 2.6, 2));
        asignaturas6.add(new Asignatura("Derecho","CS-DER01", 0, false, "", "", 2.6, 2));
        asignaturas6.add(new Asignatura("Psicología","CS-PSI01", 0, false, "", "", 2.3, 2));
        asignaturas6.add(new Asignatura("Introducción a las Ciencias Sociales","CS-INT01", 0, false, "", "", 2.3, 2));
        asignaturas6.add(new Asignatura("Anatomía y Fisiología Humana","CE-ANA01", 0, false, "", "", 2.6, 2));
        asignaturas6.add(new Asignatura("Estructura Socioeconómica de México","CS-EST01", 0, false, "", "", 2.6, 2));
        asignaturas6.add(new Asignatura("Informática Contable","CS-INF01", 0, false, "", "", 2.6, 2));
        m6.setAsignaturas(asignaturas6);
        
        ArrayList<Modulo> modulos = new ArrayList();
        modulos.add(m1);
        modulos.add(m2);
        modulos.add(m3);
        modulos.add(m4);
        modulos.add(m5);
        modulos.add(m6);
        PlanDeEstudio planDeEstudio = new PlanDeEstudio("Plan 2011", modulos);
        
        
        
        
        
        
    }
}
