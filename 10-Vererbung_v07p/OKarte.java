/**
 * Eine Oben-Karte, die von Karte eerbt.
 */
class OKarte extends Karte {
	OKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", "^^^", spielfeld);
    }
}