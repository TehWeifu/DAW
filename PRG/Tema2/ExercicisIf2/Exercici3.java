// 3. Què imprimirà el següent programa?

// El seguent programa dona error de compilacio, ja que la variable "dentroAmbito" es declarada dins del if
// i al utilitzar-la fora del if, no existeix en el scope de fora.

class Exercisi3{
    public static void main(String [] args){
        int numero=100;
        if (numero<103){
            int dentroAmbito=3;
            System.out.println("Dentro del bloque");
            System.out.print("dentroambito= "+dentroAmbito+ " numero= "+numero);
        } // Cierra el bloque del if //
        System.out.println("Fuera del bloque " + dentroAmbito); // 
        System.out.println("\n Fuera del bloque\n"+ "Solo existe numero "+numero);
    } // Cierra el bloque del main
} // Cierra la clase
