/**
 * Eine Rechts-Karte, die von Karte eerbt.
 */
class RKarte extends Karte {
	RKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", ">>>", spielfeld);
    }
}