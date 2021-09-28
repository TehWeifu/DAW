public class Exercici5 {
	public static void main(String[] args) {
		System.out.println("Els numeros entre 200 i 300 son: ");
		
		for (int i = 200; i < 301; i++) {
			System.out.print(i + "\t");
			if (i % 5 == 0) System.out.println();
		}	
	}
}
