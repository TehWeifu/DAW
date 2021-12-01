package buzon;

import buzon.correo.Correo;

public class Buzon {
    private Correo[] array;
    private int cont;

    public Buzon(int n) {
        array = new Correo[n];
    }

    public Buzon() {
        array = new Correo[100];
    }

    int numeroDeCorreos() {
        return cont;
    }

    void anade(Correo c) {
        if (cont >= array.length) {
            System.out.println("Buzón lleno");
            return;
        }
        if (c == null) {
            System.out.println("No puedo añadir " + "un correo " + "no instanciado");
            return;
        }
        array[cont] = c;
        cont++;
    }

    boolean porLeer() {
        for (int i = 0; i < cont; i++) {
            if (!array[i].isLeido()) return true;
        }
        return false;
    }

    String muestraPrimerNoLeido() {
        for (int i = 0; i < cont; i++) {
            if (!array[i].isLeido()) {
                array[i].setLeido(true);
                return array[i].getTexto();
            }
        }
        return "Todos leídos";
    }

    String muestra(int k) {
        if (k > 0 && k <= cont) {
            array[k - 1].setLeido(true);
            return array[k - 1].getTexto();
        }
        return "No hay tal numero de correo" + k;
    }

    void elimina(int k) {
        if (k > 0 && k <= cont) {
            // elimino la casilla k-1 compactando el array
            for (int i = k - 1; i < cont - 1; i++)
                array[i] = array[i + 1];
            cont--;
        } // fin if
    }

    void muestraNoLeidos() {
        while (porLeer()) {
            System.out.println(this.muestraPrimerNoLeido());
        }
    }
}
