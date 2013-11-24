package modelo;

import java.util.ArrayList;

public class ListaDeCursos {
        private static ListaDeCursos listaDeCursos = new ListaDeCursos();
	private ArrayList<Curso> cursos;
        
        private ListaDeCursos(){}
        
        public static ListaDeCursos getListaDeCursos(){
            return listaDeCursos;
        }
    /**
     * @return the cursos
     */
    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
	 
}
 
