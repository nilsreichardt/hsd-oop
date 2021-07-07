public class Lampetest {
    public static void main(String[] args) {
        // Task 2 a)
        // eineLamp();

        // Task 2 b)
        // zweiLampen();

        // Task 3 a)
        lampenWarten();
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

    static void lampenWarten() {
        Thread threadLampe1 = new Thread(new Lampe("gelb", 500, 10));
        Thread threadLampe2 = new Thread(new Lampe("lila", 400, 10));

        try {
            threadLampe1.start();
            threadLampe1.join();

            threadLampe2.start();
            threadLampe2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
