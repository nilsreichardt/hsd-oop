public class Rotwein extends Wein {
    public Rotwein(double alkoholgehalt) {
        super(alkoholgehalt);
    }

    @Override
    public String toString() {
        return "Rotwein{" +
                "alkoholgehalt=" + alkoholgehalt +
                '}';
    }
}
