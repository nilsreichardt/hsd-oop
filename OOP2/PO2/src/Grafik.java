public abstract class Grafik {
    /**
     * Die horizontale Richtung. Sollte keine negative Werte haben
     */
    private int x;

    /**
     * Die vertikale Richtung. Sollte keine negative Werte haben
     */
    private int y;

    /**
     * Die Farbe der Grafik als Integer
     */
    private int farbe;

    /**
     * Konstruktor von "Grafik"
     * @param x Ist die horizontale Richtung. Sollte keine negative Werte haben
     * @param y Ist die vertikale Richtung. Sollte keine negative Werte haben
     * @param farbe Ist die Farbe der Grafik als Interger
     */
    public Grafik(int x, int y, int farbe) {
        this.x = x;
        this.y = y;
        this.farbe = farbe;
    }

    /**
     * Setzt die X-Koordinate auf einen neuen Wert
     * @param x Die neue X-Koordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setzt die Y-Koordinate auf einen neuen Wert
     * @param y Die neue Y-Koordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Setzt die Farbe auf einen neuen Wert
     * @param farbe Die neue Farbe als Integer-Wert
     */
    public void setFarbe(int farbe) {
        this.farbe = farbe;
    }

    abstract void draw();

    @Override
    public String toString() {
        return "Grafik{" +
                "x=" + x +
                ", y=" + y +
                ", farbe=" + farbe +
                '}';
    }
}

