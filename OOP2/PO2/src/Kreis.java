public class Kreis extends Grafik {
    private int radius;

    public Kreis(int x, int y, int farbe, int radius) {
        super(x, y, farbe);
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

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
