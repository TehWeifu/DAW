public class Peliculas {
    public static void mostrarReparto(Actor[] lista, String pelicula) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getPelicula().equals(pelicula)) {
                System.out.println(lista[i].toString());
            }
        }
    }

    public static void main(String[] args) {
        mostrarReparto(new Actor[]{
                new Actor("Di Capdrio", "Shutter Island"),
                new Actor("Paco Sanz", "El hombre de los 2000 tumores"),
                new Actor("Mark Ruffalo", "Shutter Island"),
                new Actor("Willyrex", "La historia de los NFT")
        }, "Shutter Island");
    }
}
