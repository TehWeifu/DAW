public class Exercici15 {
    public static void main(String[] args) {
        double radio = 5.2;
        double areaCircumferencia = Math.PI * Math.pow(radio, 2);

        System.out.println("El area de una circumferència amb radio 5.2cm es " + Math.round(areaCircumferencia * 100) / 100.0 + "cm²");
    }
}

