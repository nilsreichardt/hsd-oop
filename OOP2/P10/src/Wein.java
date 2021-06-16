public class Wein {
    double alkoholgehalt;

    public Wein(double alkoholgehalt) {
        this.alkoholgehalt = alkoholgehalt;
    }

    @Override
    public String toString() {
        return "Wein{" +
                "alkoholgehalt=" + alkoholgehalt +
                '}';
    }
}
