public class Studi implements Comparable<Studi> {
    String name;
    int matrikelnummer;

    public Studi(String name, int matrikelnummer) {
        this.name = name;
        this.matrikelnummer = matrikelnummer;
    }

    @Override
    public String toString() {
        return name + ", " + matrikelnummer;
    }

    void test(String course) {
        System.out.println(name + ", " + matrikelnummer + ": " + course);
    }

    @Override
    public int compareTo(Studi o) {
        return toString().compareTo(o.toString());
    }
}
