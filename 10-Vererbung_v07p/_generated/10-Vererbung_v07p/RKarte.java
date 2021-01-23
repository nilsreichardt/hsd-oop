/**<br>
 * Eine Rechts-Karte, die von Karte eerbt.<br>
 <br>*/
class RKarte extends Karte {
	RKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", ">>>", spielfeld);
    }
}