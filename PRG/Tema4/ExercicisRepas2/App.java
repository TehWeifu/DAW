import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    // Collection to store the Product objects of the store
    private static final List<Product> products = new ArrayList<>();

    // Method that prints the main menu and prompts the user to input an option
    // Validates the option and returns it
    private static int mainMenu() {
        int inputOption;

        System.out.println("╔═══════════════ MENU ═══════════════╗");
        System.out.println("║ 1. Añadir un producto              ║");
        System.out.println("║ 2. Modificar cantidad              ║");
        System.out.println("║ 3. Eliminar producto               ║");
        System.out.println("║ 4. Mostrar por categoría           ║");
        System.out.println("║ 5. Numero total productos          ║");
        System.out.println("║ 6. Generar productos aleatorios    ║");
        System.out.println("║ 7. Salir                           ║");
        System.out.println("╚════════════════════════════════════╝");

        do {
            System.out.print("Introduzca una opción: ");
            inputOption = Integer.parseInt(scanner.nextLine());
        } while (inputOption < 1 || inputOption > 7);

        return inputOption;
    }

    // Method that add a new product object to the collection of products
    // Prompts the user to input a product name and checks the product doesnt not exist already
    // If so, prompts the user to input a category and a quantity, validating this last one
    // Finally appends to the collection the new product
    private static void addProduct() {
        System.out.print("Introduzca el nombre del producto: ");
        String inputName = scanner.nextLine();

        if (findProductByName(inputName) == -1) {
            System.out.print("Introduzca la categoría del producto: ");
            String inputCategory = scanner.nextLine();

            long inputQuantity;
            do {
                System.out.print("Introduzca la cantidad (1 o mayor): ");
                inputQuantity = Long.parseLong(scanner.nextLine());
            } while (inputQuantity < 1);

            products.add(new Product(inputName, inputCategory, inputQuantity));
        } else {
            System.out.println("Error, ya existe un producto con dicho nombre.");
        }
    }

    // Method to change the quantity of an existing product
    // Prompts the user to input a product name and check that it exists in the collection
    // If so prompts user to input a new quantity validating it
    private static void changeQuantity() {
        System.out.print("Introduzca el nombre del producto: ");
        String inputName = scanner.nextLine();

        int productPosition = findProductByName(inputName);

        if (productPosition != -1) {
            long inputQuantity;
            do {
                System.out.printf("Introduzca la nueva cantidad del producto \"%s\" (1 o mayor): ",
                        products.get(productPosition).getName());
                inputQuantity = Long.parseLong(scanner.nextLine());
            } while (inputQuantity < 1);
            products.get(productPosition).setQuantity(inputQuantity);
        } else {
            System.out.println("Error, no existe ningún producto con dicho nombre.");
        }
    }

    // Method to delete an existing product based on its name
    // Prompts user to input a product name and check if it exists in the collection
    // If so deletes the object from the collection and prints a message
    private static void deleteProduct() {
        System.out.print("Introduzca el nombre del producto: ");
        String inputName = scanner.nextLine();

        int productPosition = findProductByName(inputName);

        if (productPosition != -1) {
            if (products.get(productPosition).getQuantity() <= 1) {
                System.out.printf("Se ha eliminado el producto \"%s\" satisfactoriamente.",
                        products.get(productPosition).getName());
                products.get(productPosition).setQuantity(0);
                products.remove(productPosition);
                Product.decreaseCount();
            } else {
                System.out.printf("Error. El producto \"%s\" tiene una cantidad de %d. Modifique la cantidad antes de borrarlo.",
                        products.get(productPosition).getName(), products.get(productPosition).getQuantity());
            }
        } else {
            System.out.println("Error, no existe ningún producto con dicho nombre.");
        }
    }

    // Method that prints objects depending on the category
    // Prompts user to input a category
    // Creates a new Collection to store the products which such category
    // Then loops through the new colelction, printing the name and quantity of every product
    private static void printByCategory() {
        System.out.print("Introduzca la categoría: ");
        String inputStr = scanner.nextLine();

        List<Product> tmpList = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().equals(inputStr)) {
                tmpList.add(product);
            }
        }

        if (tmpList.isEmpty()) {
            System.out.printf("No hay productos de la categoría \"%s\".%n", inputStr);
        } else {
            System.out.printf("Productos de la categoría \"%s\" (total: %d)%n", inputStr, tmpList.size());
            System.out.printf("%-20s%s%n", "Nombre", "Cantidad");
            for (Product product : tmpList) {
                System.out.printf("%-20s%,d%n", product.getName(), product.getQuantity());
            }
        }
    }

    // Method that print the total products and its total quantity
    private static void printTotalQuantity() {
        System.out.printf("La cantidad total de todos los %d productos es: %,d%n",
                Product.getTotalCount(), Product.getTotalQuantity());
    }

    // Method that generates Random products and appends them to the collection
    // Prompts user to input a number of products to be generated
    // Then loops a many times generating a random name, checking it doesn't exist already
    // Then crates a new object with random values and appends it to the collection
    private static void generateRndProducts() {
        final String[] categories = {"Food", "Games", "IT", "Sports", "Fashion"};
        System.out.print("Introduzca el numero de objetos aleatorios a generar: ");
        int inputNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputNum; i++) {
            String rndName = generateRndStr();
            if (findProductByName(rndName) == -1) {
                products.add(new Product(rndName, categories[random.nextInt(categories.length)],
                        1 + random.nextInt(1_000_000)));
            }
        }
    }

    // Helper function to find a product in the collection by its name
    // Returns a positive number if found, the position which is located
    // Return -1 if it is not found in the collection
    private static int findProductByName(final String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) return i;
        }
        return -1;
    }

    // Helper method to generate a random string
    // Random length between 5 and 15 chars, first char is uppercase
    private static String generateRndStr() {
        StringBuilder res = new StringBuilder();

        res.append((char) ('A' + random.nextInt(26)));
        for (int i = 0; i < 4 + random.nextInt(11); i++) {
            res.append((char) ('a' + random.nextInt(26)));
        }

        return res.toString();
    }

    // Main method that calls the menu method and then loop over it until the user chooses to exit
    public static void main(String[] args) {
        int menuOption;
        do {
            menuOption = mainMenu();

            switch (menuOption) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    changeQuantity();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    printByCategory();
                    break;
                case 5:
                    printTotalQuantity();
                    break;
                case 6:
                    generateRndProducts();
                    break;
            }
            System.out.println();
        } while (menuOption != 7);
    }
}
