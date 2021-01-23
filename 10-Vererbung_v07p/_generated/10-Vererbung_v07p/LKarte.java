/**<br>
 * Eine Links-Karte, die von Karte eerbt.<br>
 <br>*/
class LKarte extends Karte {
	LKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", ">>>", spielfeld);
    }
}