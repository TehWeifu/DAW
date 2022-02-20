import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String formatedEmail;
        do {
            System.out.print("Introduzca un e-mail: ");
            String inputMail = scanner.nextLine();
            try {
                formatedEmail = formatEmail(inputMail);
                break;
            } catch (emailException e) {
                System.out.println("Se ha introducido un email con un formato no valido");
            }
        } while (true);

        System.out.printf("Se ha registrado el email %s correctamente%n", formatedEmail);
    }

    private static String formatEmail(final String email) throws emailException {
        String tmpEmail = email.trim().toLowerCase();

//        if (!tmpEmail.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
        if (!tmpEmail.matches("^(\\w{1,63}@\\w{1,63}(\\.\\w{1,64}){1,23})$")) {
            throw new emailException("Not a valid e-mail");
        }

        return tmpEmail;
    }
}
