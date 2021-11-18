public class Exercici3 {
    private static void printDate(Data data, String name) {
        System.out.println(name);
        System.out.print(data.getDia() + " de " + monthToStr(data.getMes()) + " de ");
        System.out.println((data.getAny()) >= 0 ? data.getAny() + " A.D" : -data.getAny() + " B.C");
        System.out.println();
    }

    private static String monthToStr(final int month) {
        if (!Data.isMonthValid(month)) return null;
        String[] strMonths = {"", "Gener", "Febrer", "Març", "Aril", "Mai", "Juny", "Juliol", "August", "Septembre",
                "Octobre", "Novembre", "Desembre"};
        return strMonths[month];
    }

    public static void main(String[] args) {
        Data myData = new Data();
        printDate(myData, "myData");

        myData.setAny(-123);
        myData.setMes(3);
        myData.setDia(5);
        printDate(myData, "myData");
    }
}
