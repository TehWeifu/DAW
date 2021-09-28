public class Exercici7 {
	public static void main(String[] args) {
		System.out.println("Els numeros, quadrats i cubs dels 10 primers numeros son:");
		System.out.println("Num\tQuadrat\tCub");
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "\t" + (int)Math.pow(i,2) + "\t" + (int)Math.pow(i, 3));
		}
	}
}
