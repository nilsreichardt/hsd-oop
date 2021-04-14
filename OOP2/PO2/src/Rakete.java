import java.lang.Comparable;

public class Rakete extends Grafik implements Warpable, Comparable<Rakete> {
    /**
     * Konstruktur der Rakete
     * @param x Ist die horizontale Richtung. Sollte keine negative Werte haben
     * @param y Ist die vertikale Richtung. Sollte keine negative Werte haben
     * @param farbe Ist die Farbe der Rakete als Interger
     */
    public Rakete(int x, int y, int farbe) {
        super(x, y, farbe);
    }

    /**
     * Gibt einen Text auf der Konsole aus
     */
    @Override
    void draw() {
        System.out.println("Jetzt sollte irgendwas gemalt werden...");
    }

    /**
     * ?
     * @param wf
     * @return
     */
    @Override
    public int warp(float wf) {
        return 0;
    }

    /**
     * Vergleicht zwei Objekte der Klasse "Rakete"
     * @param o Die andere Rakete, die vergleicht werden soll
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object. (Übernommen aus Comparable.compareTo)
     */
    @Override
    public int compareTo(Rakete o) {
        return 0;
    }
}
