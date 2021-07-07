public class Lampetest {
    public static void main(String[] args) {
        // Task 2 a)
        eineLamp();
    }

    static void eineLamp() {
        Thread threadLampe = new Thread(new Lampe("rot", 500, 10));
        threadLampe.start();
    }
}
