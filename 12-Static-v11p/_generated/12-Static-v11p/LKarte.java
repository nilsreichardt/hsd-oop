/**<br>
 * Eine Links-Karte, die von Karte eerbt.<br>
 <br>*/
class LKarte extends Karte {
	/**<br>
    * Erstellung einer LRKarte<br>
    * @param zeile Die jeweilige Zeile<br>
    * @param spalte Die jeweilige Spalte<br>
    * @param spielfeld Das jeweilige Spielfeld<br>
    <br>*/
	LKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", "<<<", spielfeld);
    }
    
    /**<br>
    * Tauscht die Position mit dem linken Nachbarn und gibt die Karte in der Konsole aus<br>
    <br>*/
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