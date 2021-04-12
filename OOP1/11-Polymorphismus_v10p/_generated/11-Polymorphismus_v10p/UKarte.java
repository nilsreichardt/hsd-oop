/**<br>
 * Eine Unten-Karte, die von Karte eerbt.<br>
 <br>*/
class UKarte extends Karte {
	UKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", "vvv", spielfeld);
    }
    
    /**<br>
    * &Uuml;bernimmt das Aussehen mit dem unteren Nachbarn und gibt die Karte in der Konsole aus<br>
    <br>*/
    void klickAuf() {
    	super.klickAuf();
        
        meinSpielfeld.addPunkte(1);
        
        Karte untererNachbar = meinSpielfeld.sucheNachbar(id, "unten");
        
        // Falls die Karte am Rand ist, gibt es keinen unteren Nachbarn, 
        // weswegen überprüft werden muss, ob ein unterer Nachbar gefunden 
        // werden konnte.
        if(untererNachbar != null) {
        	untererNachbar.uebernehmeAussehen(this);
        }
    }
}