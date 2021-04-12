public abstract class Grafik {
    private int x;
    private int y;
    private int farbe;

    public Grafik(int x, int y, int farbe) {
        this.x = x;
        this.y = y;
        this.farbe = farbe;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

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

