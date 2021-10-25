public class TestJava {
    public static void main(String[] args) {
        final String GRADES_STR = "Juan Carlos\n 8.5\n Andrés\n 4.9\n Pedro\n 3.8\n Juan \n 6.3";

        // Declares variables to store each name in the string, grabbing it specifically
        String student1 = GRADES_STR.substring(0, 11);
        String student2 = GRADES_STR.substring(18, 24);
        String student3 = GRADES_STR.substring(31, 36);
        String student4 = GRADES_STR.substring(43, 47);

        // Declares variables to store each grade, grabbing it and parsing it specifically
        double grade1 = Double.parseDouble(GRADES_STR.substring(13, 16));
        double grade2 = Double.parseDouble(GRADES_STR.substring(26, 29));
        double grade3 = Double.parseDouble(GRADES_STR.substring(38, 41));
        double grade4 = Double.parseDouble(GRADES_STR.substring(50, 53));

        // Outputs each name and grade in order
        System.out.println("L'alumne " + student2 + " ha tret la nota " + grade2);
        System.out.println("L'alumne " + student4 + " ha tret la nota " + grade4);
        System.out.println("L'alumne " + student1 + " ha tret la nota " + grade1);
        System.out.println("L'alumne " + student3 + " ha tret la nota " + grade3);
    }
}

