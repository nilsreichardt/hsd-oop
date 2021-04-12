/**<br>
 * Eine Zufalls-Karte, die von Karte eerbt.<br>
 <br>*/
class ZKarte extends Karte {
	ZKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", "ZZZ", spielfeld);
    }
    
    /**<br>
    * &Uuml;bernimmt das Aussehen mit dem unteren Nachbarn und gibt die Karte in der Konsole aus<br>
    <br>*/
    void klickAuf() {
    	super.klickAuf();
        setzeAussehen(zufallsFarbe());
    }
}