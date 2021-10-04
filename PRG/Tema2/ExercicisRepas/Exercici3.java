//3. Escriu un programa que mostra el signe zodiacal d'una persona. Per a això l'usuari
//        ha d'introduir únicament el dia i el mes de naixement i el programa
//        determinarà immediatament el signe zodiacal de la persona.

import java.util.Scanner;

public class TestJava {
    public static void main(String[] args) {
        // variable declaration
        Scanner input = new Scanner(System.in);
        byte inputDay;
        byte inputMonth;

        do {
            // Prompts user asking for his birthday day and month;
            System.out.print("Introduïsca el seu dia de naixement: ");
            inputDay = input.nextByte();
            System.out.print("Introduïsca el seu mes de naixement: ");
            inputMonth = input.nextByte();
        } while (inputDay < 0 || inputDay > 31 || inputMonth < 0 || inputMonth > 12);

        // outputs the correct zodiac sign according to the birthday
        System.out.print("El seu signe del zodiac es ");
        switch (inputMonth) {
            case 1 -> System.out.println(inputDay < 21 ? "Capricorn" : "Aquari");
            case 2 -> System.out.println(inputDay < 21 ? "Aquari" : "Peixos");
            case 3 -> System.out.println(inputDay < 21 ? "Peixos" : "Àries");
            case 4 -> System.out.println(inputDay < 21 ? "Àries" : "Taure");
            case 5 -> System.out.println(inputDay < 21 ? "Taure" : "Gèmini");
            case 6 -> System.out.println(inputDay < 21 ? "Gèmini" : "Càncer");
            case 7 -> System.out.println(inputDay < 21 ? "Càncer" : "Lleó");
            case 8 -> System.out.println(inputDay < 21 ? "Lleó" : "Verge");
            case 9 -> System.out.println(inputDay < 21 ? "Verge" : "Balança");
            case 10 -> System.out.println(inputDay < 21 ? "Balança" : "Escorpió");
            case 11 -> System.out.println(inputDay < 21 ? "Escorpió" : "Sagitari");
            case 12 -> System.out.println(inputDay < 21 ? "Sagitari" : "Capricorn");
        }
    }
}