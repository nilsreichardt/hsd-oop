/**
 * Eine Links-Karte, die von Karte eerbt.
 */
class LKarte extends Karte {
	/**
    * Erstellung einer LRKarte
    * @param zeile Die jeweilige Zeile
    * @param spalte Die jeweilige Spalte
    * @param spielfeld Das jeweilige Spielfeld
    */
	LKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", "<<<", spielfeld);
    }
    
    /**
    * Tauscht die Position mit dem linken Nachbarn und gibt die Karte in der Konsole aus
    */
    void klickAuf() {
    	System.out.println(this.toString());
        
        meinSpielfeld.addPunkte(1);
        
        Karte linkerNachbar = meinSpielfeld.sucheNachbar(id, "links");
        
        // Falls die Karte am Rand ist, gibt es keinen rechten Nachbarn, 
        // weswegen überprüft werden muss, ob ein rechter Nachbar gefunden 
        // werden konnte.
        if(linkerNachbar != null) {
        	tauschePositionMit(linkerNachbar);
        }
    }
}