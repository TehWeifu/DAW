import Ciphers.*;

import java.util.Scanner;

public class App {
    // Containers to store the original and the encrypted messages
    private static final Scanner scanner = new Scanner(System.in);

    private static final ListOfCiphers messages = new ListOfCiphers();
    private static final ListOfCiphers ciphers = new ListOfCiphers();

    // Method that prints the main menu and prompts user to input an option
    // Does basic validation and returns it
    private static int mainMeu() {
        int inputOption;

        System.out.println("╔════════════ MENU ════════════╗");
        System.out.println("║ 1. Cifrar mensaje            ║");
        System.out.println("║ 2. Descifrar mensaje         ║");
        System.out.println("║ 3. Mostrar mensajes          ║");
        System.out.println("║ 4. Instrucciones             ║");
        System.out.println("║ 5. Salir                     ║");
        System.out.println("╚══════════════════════════════╝");

        do {
            System.out.print("Introduzca una opcion: ");
            inputOption = Integer.parseInt(scanner.nextLine());

        } while (inputOption < 1 || inputOption > 5);
        return inputOption;
    }

    // Method that prints the algorithm menu and prompts user to input an option
    // Does basic validation and returns it
    private static int algorithmMenu() {
        int inputOption;

        System.out.println();
        System.out.println("╔══════════════ ALGORITMOS ══════════════╗");
        System.out.println("║ 1. Cifrado César                       ║");
        System.out.println("║ 2. Cifrado Vernam                      ║");
        System.out.println("║ 3. Cifrado por transposición (cajas)   ║");
        System.out.println("║ 4. Cifrado RSA                         ║");
        System.out.println("╚════════════════════════════════════════╝");

        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());

        } while (inputOption < 1 || inputOption > 4);
        return inputOption;

    }

    // Method to call the algorithm menu and chose and encode option depending on returned result
    private static void encodeMsg() {
        int menuOption = algorithmMenu();

        switch (menuOption) {
            case 1:
                encodeWithCaesar();
                break;
            case 2:
                encodeWithVernam();
                break;
            case 3:
                encodeWithTransposition();
                break;
            case 4:
                encodeWithRsa();
                break;
        }
    }

    // Prompts user to input a message to be encrypted, then a key or nothing to generate it randomly
    // Creates an object with the corresponding constructor
    // Prints the encrypted message and stores it in the collection
    private static void encodeWithCaesar() {
        System.out.print("Introduzca un mensaje: ");
        String inputMsg = scanner.nextLine();
        System.out.print("Introduzca la clave (0 para generarla aleatoriamente): ");
        int inputKey = Integer.parseInt(scanner.nextLine());

        Caesar tmpObj;
        if (inputKey == 0) {
            tmpObj = new Caesar(inputMsg);
        } else {
            tmpObj = new Caesar(inputMsg, inputKey);
        }

        System.out.printf("El mensaje cifrado (clave %s) es: %s%n", tmpObj.getKey(), tmpObj.encode());
        messages.addCipher(tmpObj);
    }

    // Prompts user to input a message to be encrypted, then a key or nothing to generate it randomly
    // Creates an object with the corresponding constructor
    // Prints the encrypted message and stores it in the collection
    private static void encodeWithVernam() {
        System.out.print("Introduzca un mensaje: ");
        String inputMsg = scanner.nextLine();
        String inputKey;
        do {
            System.out.printf("Introduzca una clave (%d caracteres) o pulse \"Enter\" para generarla aleatoriamente: ", inputMsg.length());
            inputKey = scanner.nextLine();
        } while (inputKey.length() != inputMsg.length() && !inputKey.isEmpty());

        Vernam tmpObj;
        if (inputKey.isEmpty()) {
            tmpObj = new Vernam(inputMsg);
        } else {
            tmpObj = new Vernam(inputMsg, inputKey);
        }

        System.out.println("El mensaje cifrado es: " + tmpObj.encode());
        System.out.println("La clave es: " + tmpObj.getKey());

        messages.addCipher(tmpObj);
    }

    // Prompts user to input a message to be encrypted, then a key
    // Creates an object with the corresponding constructor
    // Prints the encrypted message and stores it in the collection
    private static void encodeWithTransposition() {
        System.out.print("Introduzca un mensaje: ");
        String inputMsg = scanner.nextLine();
        System.out.print("Introduzca la clave: ");
        String inputKey = scanner.nextLine();

        Transposition tmpObj = new Transposition(inputMsg, inputKey);

        System.out.println("El mensaje cifrado es: " + tmpObj.encode());
        messages.addCipher(tmpObj);
    }

    // Prompts user to input a message to be encrypted, then a key
    // Creates an object with the corresponding constructor
    // Prints the encrypted message and stores it in the collection
    private static void encodeWithRsa() {
        System.out.print("Introduzca un mensaje: ");
        String inputMsg = scanner.nextLine();

        Rsa tmpObj = Rsa.create(inputMsg);

        System.out.println("El mensaje cifrado es: " + tmpObj.encode());
        System.out.println("La clave pública es: " + tmpObj.getPublicKey());
        System.out.println("La clave privada es: " + tmpObj.getPrivateKey());
        System.out.printf("P=%d, Q=%d%n", tmpObj.getP(), tmpObj.getQ());
        messages.addCipher(tmpObj);
    }

    // Method to call the algorithm menu and choose a decode option depending on returned result
    private static void decodeMsg() {
        int menuOption = algorithmMenu();

        switch (menuOption) {
            case 1:
                decodeWithCaesar();
                break;
            case 2:
                decodeWithVernam();
                break;
            case 3:
                decodeWithTransposition();
                break;
            case 4:
                decodeWithRsa();
                break;
        }
    }

    // Prompts user to input a crypto to be decoded, then the key
    // Creates an object with the corresponding constructor
    // Prints the original message and stores it in the collection
    private static void decodeWithCaesar() {
        System.out.print("Introduzca un criptograma: ");
        String inputMsg = scanner.nextLine();
        System.out.print("Introduzca la clave: ");
        int inputKey = Integer.parseInt(scanner.nextLine());

        Caesar tmpObj = new Caesar(inputMsg, inputKey);

        System.out.println("El mensaje descifrado es: " + tmpObj.decode());
        ciphers.addCipher(tmpObj);
    }

    // Prompts user to input a crypto to be decoded, then the key
    // Creates an object with the corresponding constructor
    // Prints the original message and stores it in the collection
    private static void decodeWithVernam() {
        System.out.print("Introduzca un criptograma: ");
        String inputMsg = scanner.nextLine();
        String inputKey;
        do {
            System.out.printf("Introduzca la clave (%d caracteres): ", inputMsg.length());
            inputKey = scanner.nextLine();
        } while (inputKey.length() != inputMsg.length());

        Vernam tmpObj = new Vernam(inputMsg, inputKey);

        System.out.println("El mensaje descifrado es: " + tmpObj.decode());
        ciphers.addCipher(tmpObj);
    }

    // Prompts user to input a crypto to be decoded, then the key
    // Creates an object with the corresponding constructor
    // Prints the original message and stores it in the collection
    private static void decodeWithTransposition() {
        System.out.print("Introduzca un criptograma: ");
        String inputMsg = scanner.nextLine();
        System.out.print("Introduzca la clave: ");
        String inputKey = scanner.nextLine();

        Transposition tmpObj = new Transposition(inputMsg, inputKey);

        System.out.println("El mensaje descifrado es: " + tmpObj.decode());
        ciphers.addCipher(tmpObj);
    }

    // Prompts user to input a crypto to be decoded, then the starting values to generate the key
    // Creates an object with the corresponding constructor
    // Prints the original message and stores it in the collection
    private static void decodeWithRsa() {
        System.out.print("Introduzca un criptograma: ");
        String inputMsg = scanner.nextLine();
        System.out.print("Introduzca el valor de P: ");
        int inputP = Integer.parseInt(scanner.nextLine());
        System.out.print("Introduzca el valor de Q: ");
        int inputQ = Integer.parseInt(scanner.nextLine());

        Rsa tmpObj = Rsa.create(inputMsg, inputP, inputQ);

        System.out.println("El mensaje descifrado es: " + tmpObj.decode());
        ciphers.addCipher(tmpObj);
    }

    // Method to call the algorithm menu and choose a decode option depending on returned result
    // outputs the corresponding instruction by using the static string
    private static void printInstructions() {
        int menuOption;

        menuOption = algorithmMenu();

        switch (menuOption) {
            case 1:
                System.out.println(Caesar.description);
                break;
            case 2:
                System.out.println(Vernam.description);
                break;
            case 3:
                System.out.println(Transposition.description);
                break;
            case 4:
                System.out.println(Rsa.description);
                break;
        }
    }

    private static void printMsgs() {
        System.out.println("Lista de mensajes");
        messages.printAll();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        System.out.println("Lista de criptogramas");
        ciphers.printAll();
    }

    // Main method that call the main menu and loops through it returned value until the user chooses to exit
    public static void main(String[] args) {
        int menuOption;

        do {
            menuOption = mainMeu();

            switch (menuOption) {
                case 1:
                    encodeMsg();
                    break;
                case 2:
                    decodeMsg();
                    break;
                case 3:
                    printMsgs();
                    break;
                case 4:
                    printInstructions();
                    break;
            }
            System.out.println();
        } while (menuOption != 5);
    }
}
