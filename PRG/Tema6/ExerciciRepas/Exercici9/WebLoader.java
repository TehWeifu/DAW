import java.io.IOException;

public class WebLoader {
    private static void abrirNavegadorPredeterminadorWindows(String url) throws IOException {
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
    }

    private static void abrirNavegadorPredeterminadorLinux(String url) throws IOException {
        Runtime.getRuntime().exec("sensible-browser " + url);
//        Runtime.getRuntime().exec("xdg-open " + url);
    }

    private static void abrirNavegadorPredeterminadorMacOsx(String url) throws IOException {
        Runtime.getRuntime().exec("open " + url);
    }

    private static void abrirNavegadorPorDefecto(String url) throws IOException {
        String osName = System.getProperty("os.name");
        if (osName.contains("Windows"))
            abrirNavegadorPredeterminadorWindows(url);
        else if (osName.contains("Linux"))
            abrirNavegadorPredeterminadorLinux(url);
        else if (osName.contains("Mac OS X"))
            abrirNavegadorPredeterminadorMacOsx(url);
    }

    public static void loadUrl(final String url) {
        try {
            abrirNavegadorPorDefecto(url);
        } catch (IOException e) {
            System.out.println("Fallo al iniciar el navegador para abrir la url " + url);
            e.printStackTrace();
        }
    }
}
