/**
 * Eine Zufalls-Karte, die von Karte eerbt.
 */
class ZKarte extends Karte {
	ZKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", "ZZZ", spielfeld);
    }
    
    /**
    * Übernimmt das Aussehen mit dem unteren Nachbarn und gibt die Karte in der Konsole aus
    */
    void klickAuf() {
    	super.klickAuf();
        setzeAussehen(zufallsFarbe());
    }
}