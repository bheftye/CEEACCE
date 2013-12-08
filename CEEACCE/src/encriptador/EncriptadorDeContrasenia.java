/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brentheftye
 */
public class EncriptadorDeContrasenia {

    public static String encriptaContrasenia(String contrasenia) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(contrasenia.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));   
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncriptadorDeContrasenia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }
}
