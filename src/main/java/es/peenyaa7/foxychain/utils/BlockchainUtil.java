package es.peenyaa7.foxychain.utils;

import java.util.List;

import es.peenyaa7.foxychain.models.Block;

/**
 * Utilidades para el blockchain
 */
public class BlockchainUtil {
    
    /**
     * Comprueba si el blockchain es válido
     * @param blockchain Blockchain a comprobar
     * @return true si el blockchain es válido, false en caso contrario
     */
    public static boolean validateChain(List<Block> blockchain) {
    
        for (int i = 1; i < blockchain.size(); i++) {

            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);
            
            // Si el hash del bloque actual no coincide con el hash calculado, el blockchain no es válido
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("El hash almacenado en el bloque actual (" + i + ") no coincide con el hash calculado");
                return false;
            }
            
            // Si el hash del bloque anterior no coincide con el hash guardado del bloque anterior, el blockchain no es válido
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("El hash del bloque anterior (" + (i - 1) + ") no coincide con el hash anterior del bloque actual (" + i + ")");
                return false;
            }
        }

        return true;

    }

}
