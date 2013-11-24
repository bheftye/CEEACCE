package modelo;

import java.util.ArrayList;

public class ListaDePlanesDeEstudio {
        private static ListaDePlanesDeEstudio listaPlanesEstudio = new ListaDePlanesDeEstudio();
	private ArrayList<PlanDeEstudio> planesDeEstudio;

     private ListaDePlanesDeEstudio(){}   
     
     public static ListaDePlanesDeEstudio getListaDePlanesDeEstudio(){
         return listaPlanesEstudio;
     }
    /**
     * @return the planesDeEstudio
     */
    public ArrayList<PlanDeEstudio> getPlanesDeEstudio() {
        return planesDeEstudio;
    }

    /**
     * @param planesDeEstudio the planesDeEstudio to set
     */
    public void setPlanesDeEstudio(ArrayList<PlanDeEstudio> planesDeEstudio) {
        this.planesDeEstudio = planesDeEstudio;
    }
}
 
