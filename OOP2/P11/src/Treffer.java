public class Treffer implements Comparable<Treffer> {
    public Treffer(int punkte) {
        setPunkte(punkte);
    }

    private int punkte;

    public void setPunkte(int givenPoint) {
        int[] allowedPoints = {50, 100, 200, 500, 750, 100};
        for (int point: allowedPoints) {
            if(point == givenPoint) {
                punkte = givenPoint;
                return;
            }
        }
        punkte = allowedPoints[0];
    }

    @Override
    public int compareTo(Treffer o) {
        return Integer.compare(o.getPunkte(), this.getPunkte());
    }

    public int getPunkte() {
        return punkte;
    }

    @Override
    public String toString() {
        return String.valueOf(punkte);
    }
}
