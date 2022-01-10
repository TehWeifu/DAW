public class Hijo extends Padre {
    public int m1() {
        return super.m1();
    }

    public void m2() {
        super.m2();
        System.out.println("Hijo.m2");
    }

    public void m3() {
        super.m3();
        System.out.println("Hijo.m3");
    }
}