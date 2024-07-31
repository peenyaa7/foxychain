package es.peenyaa7.foxychain.models;

import es.peenyaa7.foxychain.utils.StringUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Block {
    
    /**
     * Hash del bloque actual
     */
    private String hash;

    /**
     * Hash del bloque anterior
     */
    private String previousHash;

    /**
     * Datos del bloque actual
     */
    private String data;

    /**
     * Epoch en segundos de la fecha de creación del bloque
     */
    private long timeStamp;

    /**
     * Número de iteraciones necesarias para encontrar el hash del bloque
     */
    private int nonce;

    /**
     * Constructor parametrizado
     * @param data Datos del bloque
     * @param previousHash Hash del bloque anterior
     */
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        this.hash = calculateHash();
    }

    /**
     * Calcula el hash del bloque actual en base a la información del bloque
     * @return
     */
    public String calculateHash() {
        String blockDataStr = previousHash + Long.toString(timeStamp) + data;
        String calculatedhash = StringUtil.generateSha256(blockDataStr);
        return calculatedhash;
    }

    /**
     * Mina el bloque actual
     * @param difficulty Nivel de dificultad de la mina
     */
    public void mine(int difficulty) {
        long start = System.currentTimeMillis();
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        long end = System.currentTimeMillis();
        System.out.println("Bloque minado en " + (end - start) + " ms");
        System.out.println("Bloque minado: " + hash);

    }


}
