public class Data {
    private int any;
    private int mes;
    private int dia;

    public Data() {
        this(0, 1, 1);
    }

    public Data(final int any, final int mes, final int dia) {
        this.any = any;

        this.mes = (isMonthValid(mes) ? mes : 1);

        this.dia = (isDayValid(dia, mes, any) ? dia : 1);
    }

    public int getAny() {
        return any;
    }

    public void setAny(final int any) {
        this.any = any;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(final int mes) {
        this.mes = (isMonthValid(mes) ? mes : 1);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(final int dia) {
        this.dia = (isDayValid(dia, this.mes, this.any) ? dia : 1);
    }

    public static boolean isMonthValid(final int month) {
        return (month > 0 && month < 13);
    }

    public static boolean isDayValid(final int day, final int month, final int year) {
        if (day < 1 || day > 31) return false;
        if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 1)) return false;
        if (day > 28 && month == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) return false;
        return true;
    }
}
