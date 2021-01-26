/**
 * Das Spielfeld, welches die Karten kennt.
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
    * @param _zeilen Die Zeilen des Spielfeldes
    * @param _spalten Die Spalten des Spielfeldes
    */
    public Spielfeld(int _zeilen, int _spalten) {
    	spielfeld = new Karte[_zeilen][_spalten];
        
        zeilen = _zeilen;
        spalten = _spalten;
    }
    
    /**
    * Setzt die Position der Karte im Spielfeld
    * @param karte Die Karte, wo die Position gesetzt werden soll
    * @param zeile Die Zeile
    * @param spalte Die Spalte
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
            	//spielfeld[zeile][spalte] = new Karte(zeile, spalte, "zufall", "Karte", this);
                
                spielfeld[zeile][spalte] = erstelleRichtungsKarte(zufallsZahl(4), zeile, spalte);
            }
        }
    }
    
    /**
    * Generiert eine zufällige Zahl von 1 bis max (einschließlich max). Also wenn max = 7 ist, wird eine Zahl zwischen 0 und 7 erstellt.
    */
    private int zufallsZahl(int max) {
        if(max>1) {
	     	return 1+((int)(Math.random()*max));
        } else {
        	return 1;
        }
    }
    
    /**
    * Erstellt eine Richtungskarte, je nach Richtung.
    * @param richtung Eine Zahl zwischen 0 und 3
    * @param zeile Die Zeile der Karte
    * @param spalte Die Spalte der Karte
    * @return Die jeweilige Richtungskarte
    */
    private Karte erstelleRichtungsKarte(int richtung, int zeile, int spalte) {
    	if(richtung == 1) return new OKarte(zeile, spalte, this);
        if(richtung == 2) return new RKarte(zeile, spalte, this);
        if(richtung == 3) return new UKarte(zeile, spalte, this);
        return new LKarte(zeile, spalte, this);
    }
    
	/** 2.1.3 Finden der angeklickten Karte im Spielfeld Δe_ug6fl0 Δ
    * Sucht im Karten-Array nach einer Karte mit der passenden ID
    *
    * @param id Nach dieser ID wird die Karte gesucht
    * @return Die gefundende Karte wird zurückgegeben. Falls keine Karte gefunden wurde, wird null zurückgegeben.
    */
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
    
    /**
    * Gibt die Nachbar-Karte der jeweiligen Karte mit der ID zurück, die in der Richtung der Nachbar ist.
    * @param id Die ID der Karte
    * @param Die Richtung des zu suchenden Nachbarn (gültige Richtungen: oben, unten, rechts, links)
    * @return Die gefunden Karte
    */
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
    
    /**
    * Überprüft ob die Richtung gültig ist.
    * @param richtung Die zu prüfende Richtung
    * @return Gibt an, ob die Richtung gültig ist.
    */
    private boolean istRichtungGueltig(String richtung) {
    	String[] gueltigeRichtungen = {"oben", "unten", "rechts", "links"};
        for(String r : gueltigeRichtungen) {
        	if(r.equals(richtung)) return true;
        }
        return false;
    }
}