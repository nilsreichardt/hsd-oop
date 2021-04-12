/**
 * Eine Rechts-Karte, die von Karte eerbt.
 */
class RKarte extends Karte {
	/**
    * Erstellung einer RRKarte
    * @param zeile Die jeweilige Zeile
    * @param spalte Die jeweilige Spalte
    * @param spielfeld Das jeweilige Spielfeld
    */
	RKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", ">>>", spielfeld);
    }
    
    /**
    * Tauscht die Position mit dem rechten Nachbarn und gibt die Karte in der Konsole aus
    */
    void klickAuf() {
    	super.klickAuf();
        
        meinSpielfeld.addPunkte(1);
        
        Karte rechterNachbar = meinSpielfeld.sucheNachbar(id, "rechts");
        
        // Falls die Karte am Rand ist, gibt es keinen linken Nachbarn, 
        // weswegen überprüft werden muss, ob ein linker Nachbar gefunden 
        // werden konnte.
        if(rechterNachbar != null) {
        	tauschePositionMit(rechterNachbar);
        }
    }
}