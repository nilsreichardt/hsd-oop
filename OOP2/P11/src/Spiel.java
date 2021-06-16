import java.util.Map;
import java.util.TreeMap;

public class Spiel {
    //Aufgabe 2a)
    TreeMap<Treffer, Integer> schaden;

    Spiel() {
        this.schaden = new TreeMap<>();
    }

    //Aufgabe 2b)
    public void registieren(Treffer t) {
        if (schaden.containsKey(t)) {
            int neueAnzahl = schaden.get(t) + 1;
            schaden.put(t, neueAnzahl);
        } else {
            schaden.put(t, 1);
        }
    }

    //Aufgabe 2c)
    public void testeTreffer() {
        registieren(new Treffer(100));
        registieren(new Treffer(200));
        registieren(new Treffer(500));
        registieren(new Treffer(1000));
        registieren(new Treffer(50));
        registieren(new Treffer(200));
        registieren(new Treffer(100));
        registieren(new Treffer(100));
        registieren(new Treffer(100));
        registieren(new Treffer(200));
        registieren(new Treffer(500));
        registieren(new Treffer(750));
        registieren(new Treffer(180));//Wert der nicht gültig ist
        registieren(new Treffer(50));
        registieren(new Treffer(171));//Wert der nicht gültig ist
    }

    //Aufgabe 3b)

    public String trefferBericht() {

        String bericht = "";

        /* for (Treffer key : schaden.keySet()) //Durchlauf der Treemap mit hilfe von Set das Alle Key-Value-Paare enthält
        {
            Integer value = schaden.get(key);
            bericht += "Punktzahl: " + key + " Anzahl: " + value;
        } */

        for (Map.Entry<Treffer, Integer> entry : schaden.entrySet()) //es wird über den map entry von schaden iteriert
        {
            bericht += "Punktzahl: " + entry.getKey() + " Anzahl: " + entry.getValue() + "\n";
        }
        return bericht;
    }

    public static void main(String[] args) {
        //Aufgabe 3c)
        System.out.println("Aufgabe 3c)");
        Spiel meinSpiel = new Spiel();

        //zufälliger treffer hinzufügen
        System.out.println("zufälliger Treffer hinzufügen");
        meinSpiel.testeTreffer();

        //Treffer Ausgeben
        System.out.println("Treffer und score ausgeben " + "\n" + meinSpiel.trefferBericht());

        //Aufgabe 4b) mit richtigem datentyp ohne fehler
        meinSpiel.testExceptions(new Treffer(50));
        //Aufgabe 4c) mit flaschem datentyp
        //meinSpiel.testExceptions("moin");
        //meinSpiel.testExceptions(null);

        //Aufgabe 5b)
        meinSpiel.catchExceptions(new Treffer(50));
        //meinSpiel.catchExceptions("moin");
        //meinSpiel.catchExceptions(null);


    }

    //Aufgabe 4a)
    public void testExceptions(Object o) {
        System.out.println("");
        System.out.println("Test von Exceptions - Ohne catch");
        System.out.println("Parameter o= " + o);
        Integer anzahl = schaden.get(o);
        System.out.println(anzahl);
    }

    //Aufgabe 5a)
    public void catchExceptions(Object o) {
        System.out.println("");
        System.out.println("Test von Exceptions - mit catch");
        System.out.println("Parameter o= " + o);

        try {
            Integer anzahl = schaden.get(o);
            System.out.println(anzahl);
        }
        /*catch (Exception e) //Muss ans ende gesetzt werden sonst würde  null/classCast exception bei den catches ignoriert da Exception auf alle arten von exception reagiert
        {
            //Aufgabe 5c)
            System.err.println("Allgemeiner Fehler: " + e);
        }*/ catch (NullPointerException e) {
            System.err.println("Null Pointer Exception: " + e); //gibt die nullpointer Exception aus
        } catch (ClassCastException e) {
            System.err.println("Class Cast Execption: " + e);
        } catch (Exception e) //Muss ans ende gesetzt werden sonst würde  null/classCast exception bei den catches ignoriert da Exception auf alle arten von exception reagiert
        {
            //Aufgabe 5c)
            System.err.println("Allgemeiner Fehler: " + e);
        } finally { //finally wird immer ausgeführt nachdem die exception ausgeführt wurde
            System.out.println("Testen nun beendet");
        }
    }
}