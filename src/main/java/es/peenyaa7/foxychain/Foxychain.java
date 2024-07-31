package es.peenyaa7.foxychain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.gson.GsonBuilder;

import es.peenyaa7.foxychain.models.Block;
import es.peenyaa7.foxychain.utils.BlockchainUtil;

@Component
public class Foxychain implements CommandLineRunner {

    private static List<Block> blockchain = new ArrayList<>();
    private static int difficulty = 5;
    
    @Override
    public void run(String... args) throws Exception {

        // Menú
        int option = 0;
        while (option != 5) {
            System.out.println("########################");
            System.out.println("Bienvenido a Foxychain!!\n");
            System.out.println("1. Visualizar blockchain");
            System.out.println("2. Añadir bloques al blockchain");
            System.out.println("3. Validar blockchain");
            System.out.println("4. Modificar un bloque del blockchain");
            System.out.println("5. Salir");
            System.out.print("Introduce una opción: ");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            scanner.close();

            switch (option) {
                case 1:
                    printBlockchain();
                    break;
                case 2:
                    createBlockchain();
                    break;
                case 3:
                    validateBlockchain();
                    break;
                case 4:
                    modifyBlock();
                    break;
                case 5:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }

    }

    private void createBlockchain() {

        long start = System.currentTimeMillis();
        /**
         * El primer bloque de la cadena se le denomina 'genesis'
         * y no posee hash de bloque anterior
         */
        blockchain.add(new Block("Genesis Block", "0"));
        blockchain.add(new Block("Second Block", blockchain.get(blockchain.size() - 1).getHash()));
        blockchain.add(new Block("Third Block", blockchain.get(blockchain.size() - 1).getHash()));
        blockchain.add(new Block("Fourth Block", blockchain.get(blockchain.size() - 1).getHash()));
        blockchain.add(new Block("Fifth Block", blockchain.get(blockchain.size() - 1).getHash()));
        long end = System.currentTimeMillis();
        System.out.println("Se ha creado un blockchain de 5 bloques en " + (end - start) + " milisegundos");
        
    }

    private void printBlockchain() {
        // Mostramos la información de los bloques creados
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("Información de los bloques:");
        System.out.println(blockchainJson);
    }

    private void validateBlockchain() {
        // Comprobamos si el blockchain es válido
        System.out.println("¿El blockchain es válido? " + BlockchainUtil.validateChain(blockchain));
    }

    private void modifyBlock() {
        // Modificamos el contenido del bloque 2
        blockchain.get(2).setData("Third Block - MODIFICADO");
        System.out.println("Se ha modificado el contenido del bloque 2");
    }

}
