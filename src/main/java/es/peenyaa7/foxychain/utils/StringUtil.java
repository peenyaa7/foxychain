package es.peenyaa7.foxychain.utils;

import java.security.MessageDigest;

/**
 * Utilidades para los Strings
 */
public class StringUtil {
    
    /**
     * Aplica el algoritmo SHA-256 a un String y devuelve el resultado
     * @param input String a aplicar el algoritmo
     * @return String resultado del algoritmo
     */
    public static String generateSha256(String input) {

        try {
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
    
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
    
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
    
            return hexString.toString();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}
