// 4. Es desitja escriure un programa a la classe Ciutadà que calcule si una persona acompleix les condicions per a
//    ser resident a Espanya.
//    Suposem que, per a ser resident, es deu acomplir al menys una de les següents condicions:
//      • Ser de nacionalidad española
//      • Ser estudiante matriculado en algún estudio oficial
//      • Ser menor de 18 años y que al menos uno de los padres sea residente
//      • Ser ciudadano de la EU y tener trabajo o que el cónyuge sea residente
//      • Ser extranjero y que el cónyuge sea residente
//    Utiliza para resolver el problema if anidados.

public class Ciudadano {
    private static final int edad = 20;
    private static final char nacionalidad = 'F'; //francesa
    private static final boolean conyuge = false;
    private static final boolean padreResidente = false;
    private static final boolean madreResidente = false;
    private static final boolean estudiando = false;
    private static final boolean trabajando = true;
    private static final boolean ciudadanoEU = true;

    public static void main(String[] args) {
        if (nacionalidad == 'E') {
            System.out.println("És resident en Espanya");
        } else {
            if (estudiando) {
                System.out.println("És resident en Espanya");
            } else {
                if (edad < 18 && (padreResidente || madreResidente)) {
                    System.out.println("És resident en Espanya");
                } else {
                    // En aquest exercici, la següent condició és la que ens dona el resultat
                    if (ciudadanoEU && (trabajando || conyuge)) {
                        System.out.println("És resident en Espanya");
                    } else {
                        if (!ciudadanoEU && conyuge) {
                            System.out.println("És resident en Espanya");
                        } else {
                            System.out.println("No pot ser resident a Espanya");
                        }
                    }
                }
            }
        }
    }
}
