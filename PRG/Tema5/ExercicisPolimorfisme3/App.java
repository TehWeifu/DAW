public class App {
    // Array de objectes SeleccionFutbol.
    public static SeleccionFutbol[] integrantes = new SeleccionFutbol[3];

    public static void main(String[] args) {
        SeleccionFutbol delBosque = new Entrenador(1, "Vicente", "Del Bosque", 60, 28489);
        SeleccionFutbol iniesta = new Futbolista(2, "Andres", "Iniesta", 29, 6, "Interior Derecho");
        SeleccionFutbol raulMartinez = new Masajista(3, "Raúl", "Martinez", 41, "Licenciado en Fisioterapia", 18);
        integrantes[0] = delBosque;
        integrantes[1] = iniesta;
        integrantes[2] = raulMartinez;
// CONCENTRACIO
        System.out.println("Todos los integrantes comienzan una concentracion. (Todos ejecutan el mismo método)");
        for (int i = 0; i < integrantes.length; i++) {
            System.out.print(integrantes[i].getNombre() + " " + integrantes[i].getApellidos() + " -> ");
            integrantes[i].concentrarse();
        }
// VIATJE
        System.out.println("\nTodos los integrantes viajan para jugar un partido. (Todos ejecutan el mismo método)");
        for (int i = 0; i < integrantes.length; i++) {
            System.out.print(integrantes[i].getNombre() + " " + integrantes[i].getApellidos() + " -> ");
            integrantes[i].viajar();
        }
// ENTRENAMENT
        System.out.println("\nEntrenamiento: Todos los integrantes tienen su función en un entrenamiento (Especialización)");
        for (int i = 0; i < integrantes.length; i++) {
            System.out.print(integrantes[i].getNombre() + " " + integrantes[i].getApellidos() + " -> ");
            integrantes[i].entrenamiento();
        }
// PARTIT DE FUTBOL
        System.out.println("\nPartido de Fútbol: Todos los integrantes tienen su función en un partido (Especialización)");
        for (int i = 0; i < integrantes.length; i++) {
            System.out.print(integrantes[i].getNombre() + " " + integrantes[i].getApellidos() + " -> ");
            integrantes[i].partidoFutbol();
        }
// PLANIFICAR ENTRENAMENT
        System.out.println("\nPlanificar Entrenamiento: Solo el entrenador tiene el método para planificar un entrenamiento:");
        System.out.print(delBosque.getNombre() + " " + delBosque.getApellidos() + " -> ");
        ((Entrenador) delBosque).planificarEntrenamiento();
// ENTREVISTA
        System.out.println("\nEntrevista: Solo el futbolista tiene el método para dar una entrevista:");
        System.out.print(iniesta.getNombre() + " " + iniesta.getApellidos() + " -> ");
        ((Futbolista) iniesta).entrevista();
// MASSATGE
        System.out.println("\nMasaje: Solo el masajista tiene el método para dar un masaje:");
        System.out.print(raulMartinez.getNombre() + " " + raulMartinez.getApellidos() + " -> ");
        ((Masajista) raulMartinez).darMasaje();
    }
}
