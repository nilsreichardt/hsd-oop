/**
 * Eine Links-Karte, die von Karte eerbt.
 */
class LKarte extends Karte {
	LKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", ">>>", spielfeld);
    }
}