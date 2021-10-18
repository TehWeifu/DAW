import java.util.Scanner;

public class Exercici5 {

    // Method that calculates the discount amount based on the quantity
    public static double obtainDiscount(final long quantity) {
        final byte QUANTITY_40_OFF = 101;
        final byte QUANTITY_20_OFF = 25;
        final byte QUANTITY_10_OFF = 10;
        
        
        if (quantity >= QUANTITY_40_OFF) return 0.4;
        else if (quantity >= QUANTITY_20_OFF) return 0.2;
        else if (quantity >= QUANTITY_10_OFF) return 0.1;
        return 0.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompts user to input a quantity and a price per unit
        System.out.print("Introduïsca la quantitat de productes comprats: ");
        final long inputQuantity = sc.nextLong();

        System.out.print("Introduïsca el preu per unitat: ");
        final double inputPrice = sc.nextDouble();


        // Calculates the final price using the "obtainDiscount" method
        final double totalPrice = inputQuantity * inputPrice;
        final double discount = totalPrice  * obtainDiscount(inputQuantity);
        final double finalPrice = totalPrice - discount;

        // Outputs the final price
        System.out.println("El preu amb el descompte és " + finalPrice + "$");
    }
}

