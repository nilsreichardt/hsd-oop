public class Lampe implements Runnable {
    /**
     * Gibt an, ob die Lamp an oder aus ist.
     */
    boolean istAn = false;

    /**
     * Gibt die Farbe der Lampe als String an, z.B. rot
     */
    String farbe;

    /**
     * Die Verweil-Dauer gibt an, wie lange eine Lampe an oder aus bleibt. Diese Zeitangabe wird in Millisekunden
     * angegeben.
     */
    int verweilDauer;

    /**
     * Gibt die Anzahl an, wie oft der Zustand (an/aus) im [verweilDauer] gewechselt werden soll.
     */
    int anzahlWechsel;

    public Lampe(String farbe, int verweilDauer, int anzahlWechsel) {
        this.farbe = farbe;
        this.verweilDauer = verweilDauer;
        this.anzahlWechsel = anzahlWechsel;
    }

    @Override
    public void run() {
        System.out.println("Moin, moin, meine aktiven Freunde :)");

        for (int i = 0; i < anzahlWechsel; i++) {
            istAn = !istAn;
            System.out.println("Der Zustand der Lampe (Farbe: " + farbe + ") wurde geändert. Der neue Zustand lautet: " + istAn);

            try {
                Thread.sleep(verweilDauer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Jetzt ist aber auch mal Schluss mit dem Wechseln! Davon noch die Lampe kaputt!!!");
    }
}
