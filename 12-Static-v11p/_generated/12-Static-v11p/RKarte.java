/**<br>
 * Eine Rechts-Karte, die von Karte eerbt.<br>
 <br>*/
class RKarte extends Karte {
	/**<br>
    * Erstellung einer RRKarte<br>
    * @param zeile Die jeweilige Zeile<br>
    * @param spalte Die jeweilige Spalte<br>
    * @param spielfeld Das jeweilige Spielfeld<br>
    <br>*/
	RKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", ">>>", spielfeld);
    }
    
    /**<br>
    * Tauscht die Position mit dem rechten Nachbarn und gibt die Karte in der Konsole aus<br>
    <br>*/
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