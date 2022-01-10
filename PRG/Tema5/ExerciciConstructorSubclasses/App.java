public class App {
    public static void main(String[] args) {
        Hijo h = new Hijo();
        System.out.println("\nm1 devuelve:" + h.m1());
        System.out.println("\nm2:");
        h.m2();
        System.out.println("\nm3:");
        h.m3();
        System.out.println("\nm4:");
        h.m4();
    }
}

// El programa imprime

// m1 devuelve: 1

// m2: Abuelo.m2
// Padre.m2
// Hijo.m2

// m3: Abuelo.m3
// Hijo.m3

// m4: Abuelo.m4
//
