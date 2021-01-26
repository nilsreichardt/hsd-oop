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
            	//spielfeld[zeile][spalte] = new Karte(zeile, spalte, "zufall", "Karte", this);
                
                spielfeld[zeile][spalte] = erstelleRichtungsKarte(zufallsZahl(4), zeile, spalte);
            }
        }
    }
    
    /**<br>
    * Generiert eine zuf&auml;llige Zahl von 1 bis max (einschlie&szlig;lich max). Also wenn max = 7 ist, wird eine Zahl zwischen 0 und 7 erstellt.<br>
    <br>*/
    private int zufallsZahl(int max) {
        if(max>1) {
	     	return 1+((int)(Math.random()*max));
        } else {
        	return 1;
        }
    }
    
    /**<br>
    * Erstellt eine Richtungskarte, je nach Richtung.<br>
    * @param richtung Eine Zahl zwischen 0 und 3<br>
    * @param zeile Die Zeile der Karte<br>
    * @param spalte Die Spalte der Karte<br>
    * @return Die jeweilige Richtungskarte<br>
    <br>*/
    private Karte erstelleRichtungsKarte(int richtung, int zeile, int spalte) {
    	if(richtung == 1) return new OKarte(zeile, spalte, this);
        if(richtung == 2) return new RKarte(zeile, spalte, this);
        if(richtung == 3) return new UKarte(zeile, spalte, this);
        return new LKarte(zeile, spalte, this);
    }
    
	/** 2.1.3 Finden der angeklickten Karte im Spielfeld Δe_ug6fl0 Δ<br>
    * Sucht im Karten-Array nach einer Karte mit der passenden ID<br>
    *<br>
    * @param id Nach dieser ID wird die Karte gesucht<br>
    * @return Die gefundende Karte wird zur&uuml;ckgegeben. Falls keine Karte gefunden wurde, wird null zurückgegeben.<br>
    <br>*/
	public Karte sucheKarte(String id) {
    	for(int zeile = 0; zeile < zeilen; zeile++) {
        	for(int spalte = 0; spalte < spalten; spalte++) {
            	Karte karte = spielfeld[zeile][spalte];
                
                if(karte != null && karte.hatId(id)) {
                	// System.out.println("Gefunden bei: " + zeile + " (Zeile), " + spalte + " (Spalte).");
                	return karte;
                }
            }
        }
        
        // Es wurde keine Karte mit der `id` gefunden, weswegen null zurückgegeben wird.
        return null;
    }
    
    /**<br>
    * Gibt die Nachbar-Karte der jeweiligen Karte mit der ID zur&uuml;ck, die in der Richtung der Nachbar ist.<br>
    * @param id Die ID der Karte<br>
    * @param Die Richtung des zu suchenden Nachbarn (g&uuml;ltige Richtungen: oben, unten, rechts, links)<br>
    * @return Die gefunden Karte<br>
    <br>*/
    public Karte sucheNachbar(String id, String richtung) {
    	int karteZeile = -1;
        int karteSpalte = -1;
    
    	// Sucht die Karte mit der `id`, um die Position 
    	for(int zeile = 0; zeile < zeilen && karteZeile == -1; zeile++) {
        	for(int spalte = 0; spalte < spalten && karteSpalte == -1; spalte++) {
            	Karte karte = spielfeld[zeile][spalte];
                
                if(karte != null && karte.hatId(id)) {
                	karteZeile = zeile;
                    karteSpalte = spalte;
                }
            }
        }
        
        if(karteZeile == -1 && karteSpalte == -1) {
        	// Es konnte keine Karte gefunden werden.
            return null;
        }
        
        if(!istRichtungGueltig(richtung)) {
        	// Richtung ist nicht gültig.
        	return null;
        }
        
        if(richtung.equals("oben")) {
        	if(karteZeile == 0) {
            	// Es gibt keinen oberen Nachbarn, weil sich die Karte bereits ganz oben befindet.
            	return null;
            }
            
            karteZeile--;
        }
        
        if(richtung.equals("unten")) {
        	if(karteZeile == zeilen) {
            	// Es gibt keinen unteren Nachbarn, weil sich die Karte berits ganz unten befindet.
            	return null;
            }
            
            karteZeile++;
        }
        
        if(richtung.equals("rechts")) {
        	if(karteSpalte == spalten) {
            	// Es gibt keinen rechten Nachbarn, weil sich die Karte berits ganz rechts befindet.
            	return null;
            }
            
            karteSpalte++;
        }
        
        if(richtung.equals("links")) {
        	if(karteSpalte == 0) {
            	// Es gibt keinen links Nachbarn, weil sich die Karte berits ganz links befindet.
            	return null;
            }
            
            karteSpalte--;
        }
        
        return this.sucheKarte(karteZeile + ", " + karteSpalte);
    }
    
    /**<br>
    * &Uuml;berpr&uuml;ft ob die Richtung gültig ist.<br>
    * @param richtung Die zu pr&uuml;fende Richtung<br>
    * @return Gibt an, ob die Richtung g&uuml;ltig ist.<br>
    <br>*/
    private boolean istRichtungGueltig(String richtung) {
    	String[] gueltigeRichtungen = {"oben", "unten", "rechts", "links"};
        for(String r : gueltigeRichtungen) {
        	if(r.equals(richtung)) return true;
        }
        return false;
    }
}