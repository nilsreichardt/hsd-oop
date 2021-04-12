import java.lang.Comparable;

public class Rakete extends Grafik implements Warpable, Comparable<Rakete> {
    public Rakete(int x, int y, int farbe) {
        super(x, y, farbe);
    }

    @Override
    void draw() {
        System.out.println("Jetzt sollte irgendwas gemalt werden...");
    }

    @Override
    public int warp(float wf) {
        return 0;
    }

    @Override
    public int compareTo(Rakete o) {
        return 0;
    }
}
