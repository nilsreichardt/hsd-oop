public class Lampetest {
    public static void main(String[] args) {
        // Task 2 a)
        // eineLamp();

        // Task 2 b)
        // zweiLampen();

        // Task 3 a)
        // lampenWarten();

        // Task 4 b)
        lampenUeberwachen();
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

    static void lampenUeberwachen() {
        Lampe rot = new Lampe("rot", 500, 10);
        Lampe blau = new Lampe("blau", 400, 10);
        Lampe schwarz = new Lampe("schwarz", 300, 10);

        Thread threadLampe1 = new Thread(rot);
        Thread threadLampe2 = new Thread(blau);
        Thread threadLampe3 = new Thread(schwarz);

        threadLampe1.start();
        threadLampe2.start();
        threadLampe3.start();

        while(threadLampe1.isAlive() || threadLampe2.isAlive() || threadLampe3.isAlive()) {
            System.out.println(rot.state() + "," + blau.state() + "," + schwarz.state());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
