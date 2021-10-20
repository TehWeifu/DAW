import java.util.Scanner;
public class Exercici1{
    public static void main(String[] args){
        String n;
        Scanner entrada = new Scanner(System.in);

        System.out.println("intoduce la frase");
        n = entrada.nextLine();
        String nM = n.toUpperCase();

        System.out.println(nM);
        System.out.println(nM.length());

        String de3a18 = n.substring(3,18);
        System.out.println(de3a18.length());

        int num=0, posicion=0;
        while(posicion!=-1){
            posicion = n.indexOf(" ",posicion+1);
            num++;
        }
        System.out.println(num);
    }
}

