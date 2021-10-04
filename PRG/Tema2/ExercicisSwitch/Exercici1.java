// Exercici1. Donada la següent seqüencia de sentencies if-else transforma-les 
// a una seqüencia equivalent utilitzant una única sentència switch:
// if (opcion==’u’)
//	x=x+1;
// else
// 	if (opcion==’d’)
//		x=x+2;
// 	else
// 		if (opcion==’t’)
// 			x=x+3;
// 		else
// 			x=x+4;

public class Exercici1 {
	public static void main(String[] args) {
		char opcion;
		int x;
		
		switch (opcion) {
			case 'd':
				x = x + 2;
				break;
			case 't':
				x = x + 3;
				break;
			default:
				x = x + 4;
				break;
		}
	}
}

