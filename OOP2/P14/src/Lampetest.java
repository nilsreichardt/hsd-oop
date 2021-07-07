public class Lampetest {
    public static void main(String[] args) {
        // Task 2 a)
        // eineLamp();

        // Task 2 b)
        zweiLampen();
    }

    static void eineLamp() {
        Thread threadLampe = new Thread(new Lampe("rot", 500, 10));
        threadLampe.start();
    }

    static void zweiLampen() {
        Thread threadLampe1 = new Thread(new Lampe("rot", 500, 10));
        Thread threadLampe2 = new Thread(new Lampe("blau", 400, 5));

        threadLampe1.start();
        threadLampe2.start();
    }
}
