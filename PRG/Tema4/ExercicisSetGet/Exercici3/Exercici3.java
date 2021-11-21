public class Exercici3 {

    // Method that receives a "Data" object and the variable name and prints its contents with some format
    private static void printDate(Data data, String name) {
        System.out.println(name);
        System.out.print(data.getDia() + " de " + monthToStr(data.getMes()) + " de ");
        System.out.println((data.getAny()) >= 0 ? data.getAny() + " A.D" : -data.getAny() + " B.C");
        System.out.println();
    }

    // Method that receives a month number and returns the month in a string format
    private static String monthToStr(final int month) {
        String[] strMonths = {"", "Gener", "Febrer", "Març", "Abril", "Mai", "Juny", "Juliol", "August", "Setembre",
                "Octubre", "Novembre", "Desembre"};
        return strMonths[month];
    }

    public static void main(String[] args) {
        // Creates a Data object using the non-argument constructor and prints its contents
        // Modifies the state of the object and prints it again
        Data myData = new Data();
        printDate(myData, "myData");

        myData.setAny(-123);
        myData.setMes(4);
        myData.setDia(10);
        printDate(myData, "myData");
    }
}
