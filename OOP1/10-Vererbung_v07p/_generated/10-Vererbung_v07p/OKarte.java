/**<br>
 * Eine Oben-Karte, die von Karte eerbt.<br>
 <br>*/
class OKarte extends Karte {
	OKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", "^^^", spielfeld);
    }
}