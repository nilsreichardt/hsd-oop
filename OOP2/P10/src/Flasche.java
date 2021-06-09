import java.util.LinkedList;

public class Flasche<T extends Wein> {
    T inhalt;

    public Flasche(T inhalt) {
        this.inhalt = inhalt;
    }

    void fuelleMit(T _inhalt) {
        inhalt = _inhalt;
    }

    T ausgiessen() {
        return inhalt;
    }

    public static void main(String[] args) {

        // 3a
        Wein wein = new Wein(4);
        Weisswein weisswein = new Weisswein(5);
        Rotwein rotwein = new Rotwein(15);

        // 3b
        Flasche<Wein> weinFlasche = new Flasche<>(wein);
        Flasche<Weisswein> weissweinFlasche = new Flasche<>(weisswein);
        Flasche<Rotwein> rotweinFlasche = new Flasche<>(rotwein);

        // 3c
        Flasche<Rotwein> rw = new Flasche<Rotwein>(rotwein);
        // Flasche<Rotwein> ff = new Flasche<Wein>(wein);
        // Flasche<Rotwein> fr = new Flasche<Weisswein>(weisswein);

        Flasche<Weisswein> ww = new Flasche<Weisswein>(weisswein);
        // Flasche <Weisswein> pe = new Flasche<Wein>(wein);
        // Flasche <Weisswein> pg = new Flasche<Rotwein>(rotwein);

        Flasche<Wein> wf = new Flasche<Wein>(wein);
        // Flasche <Wein> gh = new Flasche<Weisswein>(weisswein);
        // Flasche <Wein> gk = new Flasche<Rotwein>(rotwein);

        weinFlasche = new Flasche<>(weisswein);
        weinFlasche = new Flasche<>(rotwein);
        weinFlasche = new Flasche<>(weisswein);

        //weissweinFlasche = new Flasche<>(wein);
        weissweinFlasche = new Flasche<>(weisswein);
        //weissweinFlasche = new Flasche<>(rotwein);

        //rotweinFlasche = new Flasche<>(wein);
        //rotweinFlasche = new Flasche<>(weisswein);
        rotweinFlasche = new Flasche<>(rotwein);

        // 4a
        Flasche wirdGetrunkenRaw;

        // Nur vom Typ Wein
        Flasche<? extends Wein> wirdGetrunkenWild;

        // 4b
        // 3 Flaschen für 2 Varianten
        wirdGetrunkenRaw = weinFlasche;
        wirdGetrunkenRaw = rotweinFlasche;
        wirdGetrunkenRaw = weissweinFlasche;

        wirdGetrunkenWild = weinFlasche;
        wirdGetrunkenWild = rotweinFlasche;
        wirdGetrunkenWild = weissweinFlasche;

        // 4c Fall H
        wirdGetrunkenRaw.fuelleMit(wein);
        wirdGetrunkenRaw.fuelleMit(rotwein);
        wirdGetrunkenRaw.fuelleMit(weisswein);


        // wirdGetrunkenWild.fuelleMit(wein);
        // wirdGetrunkenWild.fuelleMit(rotwein);
        // wirdGetrunkenWild.fuelleMit(weisswein);

        // 5a
        LinkedList<Flasche<Weisswein>> weissweinliste = new LinkedList<>();

        weissweinliste.add(new Flasche<>(new Weisswein(96)));
        weissweinliste.add(new Flasche<>(new Weisswein(87)));

        // 5b Flasche vom Typ Weisswein
        for(Flasche<Weisswein> current : weissweinliste) {
            System.out.println(current.ausgiessen());

            // 5c
            // weissweinliste.add(new Weisswein(6));
            // weissweinliste.add(new Flasche<Wein>(new  Wein(12)));
            // weissweinliste.add(new Flasche<Rotwein>(new  Rotwein(5)));
            // Geht vom Typ Weisswein aus, deshhalb geht Diamond Operator nicht
        }
    }

        @Override
    public String toString() {
        return "Flasche{" +
                "inhalt=" + inhalt +
                '}';
    }
}
