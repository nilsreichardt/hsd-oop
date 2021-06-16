public class Weisswein extends Wein{
    public Weisswein(double alkoholgehalt) {
        super(alkoholgehalt);
    }

    @Override
    public String toString() {
        return "Weisswein{" +
                "alkoholgehalt=" + alkoholgehalt +
                '}';
    }
}
