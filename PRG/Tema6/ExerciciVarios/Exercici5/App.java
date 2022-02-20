import java.io.IOException;

public class App {
    private static String direccion = "https://www.solvam.es/";

    public static void abrirNavegadorPredeterminadorWindows(String url) throws IOException {
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
    }

    public static void abrirNavegadorPredeterminadorLinux(String url) throws IOException {
        Runtime.getRuntime().exec("xdg-open " + url);
    }

    public static void abrirNavegadorPredeterminadorMacOsx(String url) throws IOException {
        Runtime.getRuntime().exec("open " + url);
    }

    public static void abrirNavegadorPorDefecto(String url) throws IOException {
        String osName = System.getProperty("os.name");
        if (osName.contains("Windows"))
            abrirNavegadorPredeterminadorWindows(url);
        else if (osName.contains("Linux"))
            abrirNavegadorPredeterminadorLinux(url);
        else if (osName.contains("Mac OS X"))
            abrirNavegadorPredeterminadorMacOsx(url);
    }

    public static void main(String[] args) {
        try {
            abrirNavegadorPorDefecto(direccion);
        } catch (IOException e) {
            System.out.println("Fallo al iniciar el navegador para abrir la url " + direccion);
            e.printStackTrace();
        }
    }
}

// La clase runtime permite a las applicaciones Java interactuar con el ordenador, a través de comandos
// Se crea por defecto un objeto de esta clase al lanzar una aplicacion, pero no se pueden crear mas objetos
