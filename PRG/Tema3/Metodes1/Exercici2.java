import java.util.Scanner;

public class Exercici2 {
	public static int num1, num2, resuN1, resuMaq;
	public static char desea;
	public static int opcion;
	public static Scanner lector;
	
	public static void main(String[] args) {
		lector = new Scanner(System.in);
		
		do {
			System.out.println("Te puedo ayudar a:");
			System.out.println("1. SUMAR");
			System.out.println("2. RESTAR");
			System.out.println("3. MULTIPLICAR");
			System.out.println("4. DIVIDIR");
			System.out.println("5. FIN");
			System.out.print("\n OPCION: ");
			opcion = lector.nextInt();
			switch(opcion) {
				case 1:
					ayudaSumar();
					break;
				case 2: 
					ayudaRestar();
					break;
				case 3:
					ayudaMultiplicar();
					break;
				case 4:
					ayudaDividir();
					break;
			}			
			
		} while (opcion != 5);
	}
	
	public static void ayudaSumar() {
		System.out.print("Introduzca el primer sumando: ");
		num1 = lector.nextInt();
		System.out.print("Introduzca el segundo sumando: ");
		num2 = lector.nextInt();
		
		resuN1 = num1 + num2;
		
		System.out.println("El resultado de sumar " + num1 + " + " + num2 + " es " + resuN1);		
	}
	
		public static void ayudaRestar() {
		System.out.print("Introduzca el minuendo: ");
		num1 = lector.nextInt();
		System.out.print("Introduzca el sustraendo: ");
		num2 = lector.nextInt();
		
		resuN1 = num1 - num2;
		
		System.out.println("El resultado de restar " + num1 + " - " + num2 + " es " + resuN1);		
	}
	
		public static void ayudaMultiplicar() {
		System.out.print("Introduzca el primer factor: ");
		num1 = lector.nextInt();
		System.out.print("Introduzca el segundo factor: ");
		num2 = lector.nextInt();
		
		resuN1 = num1 * num2;
		
		System.out.println("El resultado de multiplicar " + num1 + " * " + num2 + " es " + resuN1);		
	}
	
		public static void ayudaDividir() {
		System.out.print("Introduzca el dividendo: ");
		num1 = lector.nextInt();
		System.out.print("Introduzca el divisor: ");
		num2 = lector.nextInt();
		
		resuN1 = num1 / num2;
		
		System.out.println("El resultado de dividir " + num1 + " / " + num2 + " es " + resuN1);		
	}	
}

