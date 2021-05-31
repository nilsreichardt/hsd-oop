public class Studi implements Comparable {
    String name;
    String matrikelnummer;

    public Studi(String name, String matrikelnummer) {
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
    public int compareTo(Object o) {
        return toString().compareTo(o.toString());
    }
}
