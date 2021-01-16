/**
 * 
 */
class Spielfeld {
	/**
    * Zeilen des Spielfeldes;
    */
	private int zeilen;
    
    /**
    * Spalten des Spielfeldes;
    */
	private int spalten;

    /**
    * Speicherung der Karten in einem 2D-Array
    */
	private Karte[][] spielfeld;
    
    /**
    * Das Spielfeld, welches die Karten verwaltet.
    * @param zeilen Die Zeilen des Spielfeldes
    * @param spalten Die Spalten des Spielfeldes
    */
    public Spielfeld(int _zeilen, int _spalten) {
    	spielfeld = new Karte[_zeilen][_spalten];
        
        zeilen = _zeilen;
        spalten = _spalten;
    }
    
    /**
    * Setzt die Position der Karte im Spielfeld
    */
    public void setzePosition(Karte karte, int zeile, int spalte) {
    	spielfeld[zeile][spalte] = karte;
    }
    
    /**
    * Füllt das gesamte Spielfeld mit Karten
    */
    public void zufaelligFuellen() {
    	for(int zeile = 0; zeile < zeilen; zeile++) {
        	for(int spalte = 0; spalte < spalten; spalte++) {
            	spielfeld[zeile][spalte] = new Karte(zeile, spalte, "zufall", "Karte", this);
            }
        }
    }
}