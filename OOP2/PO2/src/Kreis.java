public class Kreis extends Grafik {
    /**
     * Der Radius des Kreises als ganzzahlige Zahl.
     */
    private int radius;

    /**
     * Der Konstruktur von "Kreis"
     * @param x Ist die horizontale Richtung. Sollte keine negative Werte haben
     * @param y Ist die vertikale Richtung. Sollte keine negative Werte haben
     * @param farbe Ist die Farbe der Grafik als Interger
     * @param radius Ist der Radius des Kreises
     */
    public Kreis(int x, int y, int farbe, int radius) {
        super(x, y, farbe);
        this.radius = radius;
    }

    /**
     * Setzt den Radius-Wert neu
     * @param radius Der neue Wert des Radius. Sollte kein negativer Wert sein.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Gibt einen Text in der Konsole aus.
     */
    @Override
    void draw() {
        System.out.println("Hier soll irgendwas gemalt werden...");
    }

    @Override
    public String toString() {
        return "Kreis{" +
                "radius=" + radius +
                '}';
    }
}
