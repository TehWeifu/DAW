public class TestJava {
    public static void main(String[] args) {
        final String GRADES_STR = "Juan Carlos\n 8.5\n Andrés\n 4.9\n Pedro\n 3.8\n Juan \n 6.3";

        int tmpPosBegin = 0;
        int tmpPosEnd = 0;

        // Gets name and grade of first student
        tmpPosEnd = GRADES_STR.indexOf('\n', tmpPosBegin);
        String studentA = GRADES_STR.substring(tmpPosBegin, tmpPosEnd).trim();
        tmpPosBegin = tmpPosEnd + 1;

        tmpPosEnd = GRADES_STR.indexOf('\n', tmpPosBegin);
        double gradeA = Double.parseDouble(GRADES_STR.substring(tmpPosBegin, tmpPosEnd));
        tmpPosBegin = tmpPosEnd + 1;


        // Gets name and grade of second student
        tmpPosEnd = GRADES_STR.indexOf('\n', tmpPosBegin);
        String studentB = GRADES_STR.substring(tmpPosBegin, tmpPosEnd).trim();
        tmpPosBegin = tmpPosEnd + 1;

        tmpPosEnd = GRADES_STR.indexOf('\n', tmpPosBegin);
        double gradeB = Double.parseDouble(GRADES_STR.substring(tmpPosBegin, tmpPosEnd));
        tmpPosBegin = tmpPosEnd + 1;


        // Gets name and grade of first student
        tmpPosEnd = GRADES_STR.indexOf('\n', tmpPosBegin);
        String studentC = GRADES_STR.substring(tmpPosBegin, tmpPosEnd).trim();
        tmpPosBegin = tmpPosEnd + 1;

        tmpPosEnd = GRADES_STR.indexOf('\n', tmpPosBegin);
        double gradeC = Double.parseDouble(GRADES_STR.substring(tmpPosBegin, tmpPosEnd));
        tmpPosBegin = tmpPosEnd + 1;


        // Gets name and grade of first student
        tmpPosEnd = GRADES_STR.indexOf('\n', tmpPosBegin);
        String studentD = GRADES_STR.substring(tmpPosBegin, tmpPosEnd).trim();
        tmpPosBegin = tmpPosEnd + 1;

        double gradeD = Double.parseDouble(GRADES_STR.substring(tmpPosBegin));

        // variable declaration for sorting the grades with its corresponding student name
        String student1 = studentA;
        String student2 = studentB;
        String student3 = studentC;
        String student4 = studentD;
        double grade1 = gradeA;
        double grade2 = gradeB;
        double grade3 = gradeC;
        double grade4 = gradeD;

        // temporal variables to swap values 
        String tmpStr;
        double tmpGrade;
        

        // """""""Bubble sort"""""""" (but without loop ^^)
        // First "outer loop". Leaves higher grade first
        if (grade4 > grade3) {
            tmpGrade = grade3;
            tmpStr = student3;

            grade3 = grade4;
            student3 = student4;

            grade4 = tmpGrade;
            student4 = tmpStr;
        }
        if (grade3 > grade2) {
            tmpGrade = grade2;
            tmpStr = student2;

            grade2 = grade3;
            student2 = student3;

            grade3 = tmpGrade;
            student3 = tmpStr;
        }
        if (grade2 > grade1) {
            tmpGrade = grade1;
            tmpStr = student1;

            grade1 = grade2;
            student1 = student2;

            grade2 = tmpGrade;
            student2 = tmpStr;
        }

        // Second "outer loop". Leaves second grade second
        if (grade4 > grade3) {
            tmpGrade = grade3;
            tmpStr = student3;

            grade3 = grade4;
            student3 = student4;

            grade4 = tmpGrade;
            student4 = tmpStr;
        }
        if (grade3 > grade2) {
            tmpGrade = grade2;
            tmpStr = student2;

            grade2 = grade3;
            student2 = student3;

            grade3 = tmpGrade;
            student3 = tmpStr;
        }

        // First "outer loop". Leaves third grade third and forth grade forth
        if (grade4 > grade3) {
            tmpGrade = grade3;
            tmpStr = student3;

            grade3 = grade4;
            student3 = student4;

            grade4 = tmpGrade;
            student4 = tmpStr;
        }
        
        // Outputs each name and grade in order
        System.out.println("L'alumne " + student1 + " ha tret la nota " + grade1);
        System.out.println("L'alumne " + student2 + " ha tret la nota " + grade2);
        System.out.println("L'alumne " + student3 + " ha tret la nota " + grade3);
        System.out.println("L'alumne " + student4 + " ha tret la nota " + grade4);
    }
}

