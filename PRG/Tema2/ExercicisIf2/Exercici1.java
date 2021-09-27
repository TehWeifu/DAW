// 1. Quin es el resultat d’aquest programa?

class Exercici1 {
    public static void main(String[] args) {
        int i = 3;
        int j = 4;
        boolean etiqueta = false;

        //Ejemplo de y lógico
        if (i == 3 && j == 4) { // true && true == true
            System.out.println("La condicion 1 se cumple"); // S'executa aquesta línia
        } else {
            System.out.println("La condicion 1 no se cumple");
        }

        //Ejemplo de o lógico
        if (i == 1 || j == 4) { // false || true == true
            System.out.println("La condicion 2 se cumple"); // S'executa aquesta línia
        } else {
            System.out.println("La condicion 2 no se cumple");
        }

        //Ejemplo de no lógico
        if (!etiqueta) { // !false == true
            System.out.println("La condicion 3 se cumple"); // S'executa aquesta línia
        } else {
            System.out.println("La condicion 3 no se cumple");
        }
    }//fin main
}//fin clase
