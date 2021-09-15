// Exercici 1. Prova de canvis de tipus - cast

public class TestTipos { 
	public static void main(String[] args) { 
		
		// Test de cast 
		//part 1 : TestTipus1
		int b=10; 
		short c=5; 
		int a = b + c; 
		char mas = '+'; 
		System.out.print(b); 
		System.out.print(mas); 
		System.out.print(c); 
		System.out.print('='); 
		System.out.println(a);
		 
		//part 2 : TestTipus2
		int d = 1024;  // canvia 1024 por 65535
		// Al canviar 1024 per 65535 la variable "e" no pot almacenar el valor y dona un valor erroni per overflow
		short e = (short)d; 
		System.out.print(d + "\t"); 
		System.out.println(e); 
		long g = 2048; 
		double f = g; 
		g = (long)f; 
		System.out.print(f + "\t"); 
		System.out.println(g);
		 
		//part 3 : TestTipus3
		long p = (long) 12345.56;

		// Si se elimina "(int)" la següent línia da error de compilació ja que no es pot assignar un tipus "long"
		// a un tipus "int" implícitament, cal fer un casting
		int q = (int)p;  // elimina (int)

		System.out.print(p + "\t"); 
		System.out.println(q);

		// Si se canvia 't' per 65535 dona un la variable "k" tindria un valor erroni perquè un
		// "short" pot tenir com a molt el valor 2^16 - 1
		char t = 't';  // canvia 't' por 65535 
		int j = t;
		// Si se elimina "short" de la línia dona un error de compilació perque no es pot passar de "char" a "short"
		// implícitament, cal fer-ho explícitament amb un casting
		short k = (short) t;  // elimina (short)


		System.out.println(t); 
		System.out.println(j); 
		System.out.println(k);

		// Si se lleva la F final dona error de compilació, ja que un "float" no es pot inicialitzar amb
		// un "double" literal
		float r = 12.35F;  //lleva la F final 
		System.out.println(r); 
		
		// Test infinito 
		System.out.println(1.0/0); 
		
		// La seguent línia causa una execpció al ser una divisió de "integers" entre 0
		System.out.println(1/0);  //comenta aquesta línia 
	} 
}
