/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazdeusuario;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author brentheftye
 */
public class CentradorDeVistas {
    private static CentradorDeVistas centradorDeVistas = new CentradorDeVistas();
    
    private CentradorDeVistas(){}
    
    public void centrarJFrame(JFrame vista){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        vista.setLocation(dimension.width/2-vista.getSize().width/2, dimension.height/2-vista.getSize().height/2);
    }
    
    public static CentradorDeVistas getCentradorDeVistas(){
        return centradorDeVistas;
    }
}
