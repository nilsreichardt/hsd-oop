/**<br>
 * "5Crush" ein Spiel in 5 Praktika - Teil1<br>
 * Hochschule D&uuml;sseldorf - Fachbereich Medien Objektorientierte Progammierung 1<br>
 * Prof. Markus Dahm<br>
 <br>*/
class Karte {    
	/**<br>
    * F&auml;ngt bei der obersten Zeile an. Somit ist 0 die oberste Zeile.<br>
    * Der Wert darf nicht negativ sein.<br>
    <br>*/
	private int zeile = 0;
    
    /**<br>
    * F&auml;ngt bei am linken Rand an. Somit ist 0 ist Spalte ganz links.<br>
    * Der Wert darf nicht negativ sein.<br>
    <br>*/
    private int spalte = 0;

	/**<br>
    * G&uuml;ltige Farben: "rot", "gelb", "gruen", "blau", "schwarz", "wei&szlig;", "cyan", "magenta"<br>
    <br>*/
	private String farbe = null;
    
    /**<br>
    * Der Text darf nicht l&auml;nger als 50 Zeichen sein.<br>
    <br>*/
    private String text = null;
    
    /**<br>
    * Der Text f&uuml;r die Grafik-Konsoel<br>
    <br>*/
    private Text grafikText = null;
    
    /**<br>
    * Die Zeilenh&ouml;he in Pixel eines Rasters.<br>
    * Der Wert darf nicht negativ sein.<br>
    <br>*/
    private int rasterZeilenhoehe = 40;
    
    /**<br>
    * Die Spaltenbreite in Pixel eines Rasters.<br>
    * Der Wert darf nicht negativ sein.<br>
    <br>*/
    private int rasterSpaltenbreite = 80;
    
    /**<br>
    * Das Spielfeld, auf welchem die Karte ist.<br>
    <br>*/
    private Spielfeld meinSpielfeld;
    
    /**<br>
    * G&uuml;ltige Farben <br>
    <br>*/
    private String[] gueltigeFarben = {"schwarz", "weiß", "rot", "grün", "blau", "gelb", "magenta", "cyan"};
    
    /**<br>
    * Erstellt eine Karte mit eigenen Parametern.<br>
    * @param neueZeile Die Zeile des Textes<br>
    * @param neueSpalte Die Spalte des Textes<br>
    * @param neueFarbe Farbe des Texts<br>
    * @param neuerText Der Text der Karte<br>
    * @param spielfeld Spielfeld<br>
    <br>*/
    public Karte(int neueZeile, int neueSpalte, String neueFarbe, String neuerText, Spielfeld spielfeld) {
    	if(neueFarbe.equals("zufall")) {
        	neueFarbe = zufallsFarbe();
        }
    
    	meinSpielfeld = spielfeld;
        
        String id = neueZeile + ", " + neueSpalte;
        
    	grafikText = new Text(neueZeile, neueSpalte, neuerText, farbInHex(neueFarbe), 20, id);
        
    	setzePosition(neueZeile, neueSpalte);
        setzeAussehen(neueFarbe, neuerText);
    }
    
    private int zufallsZahl(int max) {
        if(max>1) {
	     	return 1+((int)(Math.random()*max));
        } else {
        	return 1;
        }
    }
    
    String zufallsFarbe() {
    	int max = gueltigeFarben.length - 1; // Zufallszahl zwischen 0 und 7
        return gueltigeFarben[zufallsZahl(max)];
    }
    
    String farbInHex(String neueFarbe) {
        switch(neueFarbe) {
            case "schwarz": return "#000000";
            case "weiß": return "#FFFFFF";
            case "rot": return "#FF0000";
            case "gruen":
            case "grün": return "#00FF00";
            case "blau": return "#0000FF";
            case "gelb": return "#FFFF00";
            case "magenta": return "#FF00FF";
            case "cyan": return "#00FFFF";
        }
        return null;
    }
    
	/** 2.3.1 Karte auf dem Spielfeld positionieren<br>
	* Implementieren Sie<br>
	* Setzt die Position der Karte und des grafikText neu. <br>
    * Falls Zeile oder/und spalte nicht positiv sind, wird die neue Positon NICHT &uuml;bernommen.<br>
	* @author Reichardt, Nils<br>
	* @param neueZeile - Die neue Zeile<br>
    * @param neueSpalte - Die neue Spalte<br>
	<br>*/
	void setzePosition(int neueZeile, int neueSpalte) {
        if(neueZeile >= 0 && neueSpalte >= 0) {
        	zeile = neueZeile;
            spalte = neueSpalte;
            
            if(grafikText != null) {
                grafikText.moveTo(zeile * rasterZeilenhoehe, spalte * rasterSpaltenbreite);
            }
        }
     
        meinSpielfeld.setzePosition(this, neueZeile, neueSpalte);
	}

	/** 2.3.2 Farbe der Karte &auml;ndern<br>
	* Implementieren Sie<br>
	* Setzt die neue Farbe der Karte<br>
    * G&uuml;ltige Farben sind "rot", "gelb", "gruen", "blau", "schwarz", "wei&szlig;", "cyan", "magenta".<br>
    * Falls eine Farbe nicht g&uuml;ltig ist, wird die neue Farbe NICHT übernommen.<br>
    *<br>
    * Zudem wird die Farbe des Grafik-Text ge&auml;ndert, falls die Farbe g&uuml;ltig ist.<br>
    *<br>
	* @author Reichardt, Nils<br>
	* @param neueFarbe - Die neue Farbe<br>
	<br>*/
	void setzeAussehen(String neueFarbe) {
    	// Damit wird sichergestellt, dass der parameter immer in kleinen Buchstaben verglichen wird. Somit sind auch "Rot", "RoT", "roT", etc. ebenfalls zulässige Werte (das ist optional)
    	neueFarbe = neueFarbe.toLowerCase();
        
        for(String gueltigeFarbe : gueltigeFarben) {
        	if(neueFarbe.equals(gueltigeFarbe)) {
            	farbe = neueFarbe;
            	
                if(grafikText != null) {
					grafikText.setFillcolor(farbInHex(neueFarbe));
				}
            }
        }
	}
    
	/** 2.3.3 Farbe und Text der Karte &auml;ndern<br>
	* Implementieren Sie diese Methode<br>
	* Setzt die neue Farbe und den neuen Text<br>
	* @author Reichardt, Nils<br>
	* @param neueFarbe - Die neue Farbe<br>
    * @param neuerText - Der neue Text<br>
	<br>*/
	void setzeAussehen(String neueFarbe, String neuerText) {
    	setzeAussehen(neueFarbe);
        setzeText(neuerText);
    }

	/**<br>
    * Setzte den Text und den grafischen Text. Der Text muss k&uuml;rzer als 50 Zeichen sein.<br>
    * Falls die Zeichen l&auml;nger als 50 Zeichen sind, wird der neue Text nicht &uuml;bernommen.<br>
    * @param neuerText - neuerText<br>
    *<br>*/
	void setzeText(String neuerText) {
    	if(neuerText.length() <= 50) {
        	text = neuerText;
            
            if(grafikText != null) {
            	grafikText.setText(neuerText);
            }
        }
    }
    
	/** 2.3.4 Einen String zur Beschreibung einer Karte erzeugen <br>
	* Implementieren Sie <br>
	* Gibt alle Werte der Klasse als String aus<br>
	* @author Reichardt, Nils<br>
	* @return String der Klasse<br>
	<br>*/
	public String toString() {
		return "[Karte] spalte: " + spalte + ", zeile: " + zeile + ", farbe: " + farbe + ", text " + text; 
	}
    
	/** 2.5.1 Mit einer anderen Karte tauschen.<br>
	* Implementieren Sie<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	* @param andereKarte - Die andere Karte<br>
	<br>*/
	void tauschePositionMit(Karte andereKarte) {
    	// Die Werte von der anderen Karte zwischenspeichern
        int tempZeile = andereKarte.zeile;
        int tempSpalte = andereKarte.spalte;
        
        // Die Werte von dieser Karte (this) der anderen Karte zuweisen
        andereKarte.setzePosition(this.zeile, this.spalte);
        
        // Die Werte von der anderen Karte (wurde zwischen gespeichert) zu dieser Karte übernehmen.
        this.setzePosition(tempZeile, tempSpalte);
	}

	/** 2.5.2 Aussehen einer anderen Karte &uuml;bernehmen<br>
	* Implementieren Sie<br>
	* &Uuml;bernimmt den Text und die Farben<br>
	* @author Reichardt, Nils<br>
	* @param andereKarte - Die andere Karte, von der das Aussehen &uuml;bernommenw erden soll.<br>
	<br>*/
	void uebernehmeAussehen(Karte andereKarte) {
		this.setzeAussehen(andereKarte.farbe, andereKarte.text);
	}
	
    /**<br>
    * &Uuml;berpr&uuml;ft ob eine andere Karte die selbe Farbe hat.<br>
    * @param andereKarte - Andere Karte<br>
    * @return Gibt den Vergleichswert des Aussehens zur&uuml;ck<br>
    <br>*/
    boolean hatSelbeFarbe(Karte andereKarte) {
    	return this.farbe.equals(andereKarte.farbe); 
    }
}