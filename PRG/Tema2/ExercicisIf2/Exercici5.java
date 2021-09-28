// 5. Es vol saber si: “Es deu fer la declaració de la renda”
//    Per a fer la declaració de la renda es deu tenir al menys 18 anys i menys de 66, o bé si, tenim al menys 66 anys, els
//    ingressos anuals son més de 20000

import java.util.Scanner;

public class Exercici5 {
    public static void main(String[] args) {
        byte age;
        int earnings;
        Scanner input = new Scanner(System.in);

        System.out.print("Introduïsca la seva edat: ");
        age = input.nextByte();
        System.out.print("Introduïsca els seus ingressos: ");
        earnings = input.nextInt();

        if ((age >= 18 && age < 66) || (earnings > 20_000)) {
            System.out.println("Ha de fer la declaració de la Renda");
        } else {
            System.out.println("No ha de fer la Renda");
        }
    }
}