/**
 * Eine Unten-Karte, die von Karte eerbt.
 */
class FKarte extends Karte {
	FKarte(int zeile, int spalte, Spielfeld spielfeld) {
    	super(zeile, spalte, "zufall", "FFF", spielfeld);
    }
    
    /**
    * Übernimmt das Aussehen bei allen Karten
    */
    void klickAuf() {
    	super.klickAuf();
        
        meinSpielfeld.addPunkte(-3);
        
        if (meinSpielfeld.sucheNachbar(id, "links") != null){
            (meinSpielfeld.sucheNachbar(id, "links")).uebernehmeAussehen(this);
        }
        if (meinSpielfeld.sucheNachbar(id, "rechts") != null){
            (meinSpielfeld.sucheNachbar(id, "rechts")).uebernehmeAussehen(this);
        }
        if (meinSpielfeld.sucheNachbar(id, "oben") != null){
            (meinSpielfeld.sucheNachbar(id, "oben")).uebernehmeAussehen(this);
        }
        if (meinSpielfeld.sucheNachbar(id, "unten") != null){
            (meinSpielfeld.sucheNachbar(id, "unten")).uebernehmeAussehen(this);
        }
    }
}