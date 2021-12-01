package buzon;

import buzon.Buzon;
import buzon.correo.Correo;

public class PruebaBuzon {
    public static void main(String[] args) {
        Buzon b = new Buzon();
        b.anade(new Correo("mensaje 1"));
        Correo c = new Correo("Mensaje 2");
        b.anade(c);
        System.out.println("Por leer " + b.porLeer());
        b.muestraNoLeidos();
        System.out.println("Por leer " + b.porLeer());
    }
}
