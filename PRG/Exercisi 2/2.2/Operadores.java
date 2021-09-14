public class Operadores { 
	public static void main(String[] args) { 
		
		// Declaracio de variables 
		double pelicula1; 
		double pelicula2; 
		
		// Asignacio de valors 
		pelicula1 = 2.95; 
		pelicula2 = 3.50; 
				
		// Aquestes 4 sentencies es poden combinar en una sola: double pelicula1 = 2.95, pelicula2 = 3.50; 
		// Altres variables a utilitzar en aquest programa 
		
		int numeroDeDias = 2; 
		boolean alquilar; 
		double totalAlquiler, total, porcentajeImpuesto = 1.17; 
		
		// Mostra el preu de les dues pel·lícules 
		System.out.println("Odisea 2001 : " + pelicula1); 
		System.out.println("El Padrino : " + pelicula2); 
		
		// Calcula el lloguer total 
		totalAlquiler =pelicula1*numeroDeDias + pelicula2*numeroDeDias; 
		System.out.println("Total Alquiler = " + totalAlquiler); 
		
		// Calcula el total de la venda aplicant el impost 
		total = totalAlquiler*porcentajeImpuesto; 
		System.out.println("Total Venta = " + total); 
		
		// Verifica si es poden llogar
		alquilar = total < 10; 
		System.out.println("Puedo Alquilar? " + alquilar); 
		} 
} 
