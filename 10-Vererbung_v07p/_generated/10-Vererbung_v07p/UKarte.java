/**<br>
 * Eine Unten-Karte, die von Karte eerbt.<br>
 <br>*/
class UKarte extends Karte {
	UKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", "vvv", spielfeld);
    }
}