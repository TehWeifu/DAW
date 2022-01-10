public class Padre extends Abuelo {
    public int m1() {
        return 1;
    }

    public void m2() {
        super.m2();
        System.out.println("Padre.m2");
    }

    public void m4(int i) {
        super.m4();
        System.out.println("Padre.m4");
    }
}
