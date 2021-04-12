/**<br>
 * Das Spielfeld, welches die Karten kennt.<br>
 <br>*/
class Spielfeld {
	/**<br>
    * Zeilen des Spielfeldes;<br>
    <br>*/
	private int zeilen;
    
    /**<br>
    * Spalten des Spielfeldes;<br>
    <br>*/
	private int spalten;

    /**<br>
    * Speicherung der Karten in einem 2D-Array<br>
    <br>*/
	private Karte[][] spielfeld;
    
    /**<br>
    * Das Spielfeld, welches die Karten verwaltet.<br>
    * @param _zeilen Die Zeilen des Spielfeldes<br>
    * @param _spalten Die Spalten des Spielfeldes<br>
    <br>*/
    public Spielfeld(int _zeilen, int _spalten) {
    	spielfeld = new Karte[_zeilen][_spalten];
        
        zeilen = _zeilen;
        spalten = _spalten;
    }
    
    /**<br>
    * Setzt die Position der Karte im Spielfeld<br>
    * @param karte Die Karte, wo die Position gesetzt werden soll<br>
    * @param zeile Die Zeile<br>
    * @param spalte Die Spalte<br>
    <br>*/
    public void setzePosition(Karte karte, int zeile, int spalte) {
    	spielfeld[zeile][spalte] = karte;
    }
    
    /**<br>
    * F&uuml;llt das gesamte Spielfeld mit Karten<br>
    <br>*/
    public void zufaelligFuellen() {
    	for(int zeile = 0; zeile < zeilen; zeile++) {
        	for(int spalte = 0; spalte < spalten; spalte++) {
            	spielfeld[zeile][spalte] = new Karte(zeile, spalte, "zufall", "Karte", this);
            }
        }
    }
}