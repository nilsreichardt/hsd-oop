public class Studi implements Comparable {
    String name;
    String matrikelnummer;

    public Studi(String name, String matrikelnummer) {
        this.name = name;
        this.matrikelnummer = matrikelnummer;
    }

    @Override
    public String toString() {
        return "Studi{" +
                "name='" + name + '\'' +
                ", matrikelnummer='" + matrikelnummer + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return toString().compareTo(o.toString());
    }
}
