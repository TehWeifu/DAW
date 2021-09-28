import java.util.Scanner;

public class Exercici6 {
	public static void main(String[] args) {
		// variable declaration
		Scanner input = new Scanner(System.in);
		int numOfValues;
		int tmpNum;
		int sum = 0;
		int maxNum = Integer.MIN_VALUE;
		int minNum = Integer.MAX_VALUE;
		
		// ask user how many values will they input		
		System.out.print("Indique quants dades vols introuir: ");	
		numOfValues = input.nextInt();
		
		// ask for every value one by one, adding it to the sum value 
		// and comparing it to the max and min variables
		for (int i = 1; i <= numOfValues; i++) {
			System.out.print("Introduisca la " + i + "º dada: " );
			tmpNum = input.nextInt();
			
			sum += tmpNum;
			
			maxNum = Math.max(maxNum, tmpNum);
			minNum = Math.min(minNum, tmpNum);
		}
		
		// Outputs the number of values, sum, average, min and max
		System.out.println();
		System.out.println("Has introduit un total de " + numOfValues + " dades");
		System.out.println("La suma de les dades introduides es " + sum);
		System.out.println("La mitjana de les dades introduides es " + ((double)sum / numOfValues));
		System.out.println("El valor maxim introduit es " + maxNum); 
		System.out.println("El valor minim introduit es " + minNum);
	}
}
