public class Data {
    private int any;
    private int mes;
    private int dia;

    // Constructor with no arguments that delegates to main constructor with default values
    public Data() {
        this(0, 1, 1);
    }

    // Main Constructor that receives an argument for each property to initialize its values
    // If the arguments don't represent a valid date, then they get as a default date
    public Data(final int any, final int mes, final int dia) {
        if (isDateValid(any, mes, dia)) {
            this.any = any;
            this.mes = mes;
            this.dia = dia;
        } else {
            this.any = 0;
            this.mes = 1;
            this.dia = 1;
        }
    }

    // static method to check whether a date represented by year, month and day is valid
    public static boolean isDateValid(final int year, final int month, final int day) {
        if (month < 1 || month > 12) return false;
        if (day < 1 || day > 31) return false;
        if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 1)) return false;
        if (day > 28 && month == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) return false;
        return true;
    }

    // Setters and Getters for each property
    public int getAny() {
        return any;
    }

    public void setAny(final int any) {
        if (isDateValid(any, this.mes, this.dia)) {
            this.any = any;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(final int mes) {
        if (isDateValid(this.any, mes, this.dia)) {
            this.mes = mes;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(final int dia) {
        if (isDateValid(this.any, this.mes, dia)) {
            this.dia = dia;
        }
    }
}
