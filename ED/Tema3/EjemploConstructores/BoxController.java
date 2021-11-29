import java.util.Scanner;

public class BoxController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box whatIsInTheBox = new Box();

        System.out.print("Enter the length: ");
        double inputLength = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter the width: ");
        double inputWidth = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter the height: ");
        double inputHeight = Double.parseDouble(scanner.nextLine());

        whatIsInTheBox.setHeight(inputHeight).setLength(inputLength).setWidth(inputWidth);

        System.out.printf("The volume of the box is %.2f%n", whatIsInTheBox.getVolume());
    }
}
