/**
 * "5Crush" ein Spiel in 5 Praktika - Teil1
 * Hochschule Düsseldorf - Fachbereich Medien Objektorientierte Progammierung 1
 * Prof. Markus Dahm
 */
class Karte {    
	/**
    * Fängt bei der obersten Zeile an. Somit ist 0 die oberste Zeile.
    * Der Wert darf nicht negativ sein.
    */
	int zeile = 0;
    
    /**
    * Fängt bei am linken Rand an. Somit ist 0 ist Spalte ganz links.
    * Der Wert darf nicht negativ sein.
    */
    int spalte = 0;

	/**
    * Gültige Farben: "rot", "gelb", "gruen", "blau", "schwarz", "weiß", "cyan", "magenta"
    */
	String farbe = null;
    
    /**
    * Der Text darf nicht länger als 50 Zeichen sein.
    */
    String text = null;
    
    /**
    * Der Text für die Grafik-Konsoel
    */
    Text grafikText = null;
    
    /**
    * Die Zeilenhöhe in Pixel eines Rasters.
    * Der Wert darf nicht negativ sein.
    */
    int rasterZeilenhoehe = 40;
    
    /**
    * Die Spaltenbreite in Pixel eines Rasters.
    * Der Wert darf nicht negativ sein.
    */
    int rasterSpaltenbreite = 80;
    
    /**
    * Erstellt die Karte mit Default-Werten
    */
    Karte() {
    	this(0, 0, "schwarz", "Default");
    }
    
    /**
    * Erstellt eine Karte mit eigenen Parametern.
    * @param neueZeile Die Zeile des Textes
    * @param neueSpalte Die Spalte des Textes
    * @param neueFarbe Farbe des Texts
    * @param neuerText Der Text der Karte
    */
    Karte(int neueZeile, int neueSpalte, String neueFarbe, String neuerText) {
    	grafikText = new Text(neueZeile, neueSpalte, neuerText, farbInHex(neueFarbe), 20, "1");
    	setzePosition(neueZeile, neueSpalte);
        setzeAussehen(neueFarbe, neuerText);
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
    
	/** 2.3.1 Karte auf dem Spielfeld positionieren
	* Δe_kf5e2u Implementieren SieΔ
	* Setzt die Position der Karte und des grafikText neu. 
    * Falls Zeile oder/und spalte nicht positiv sind, wird die neue Positon NICHT übernommen.
	* @author Reichardt, Nils
	* @param neueZeile - Die neue Zeile
    * @param neueSpalte - Die neue Spalte
	*/
	void setzePosition(int neueZeile, int neueSpalte) {
        if(neueZeile >= 0 && neueSpalte >= 0) {
        	zeile = neueZeile;
            spalte = neueSpalte;
            
            if(grafikText != null) {
                grafikText.moveTo(zeile * rasterZeilenhoehe, spalte * rasterSpaltenbreite);
            }
        }
	}

	/** 2.3.2 Farbe der Karte ändern
	* Δe_57263z Implementieren SieΔ
	* Setzt die neue Farbe der Karte
    * Gültige Farben sind "rot", "gelb", "gruen", "blau", "schwarz", "weiß", "cyan", "magenta".
    * Falls eine Farbe nicht gültig ist, wird die neue Farbe NICHT übernommen.
    *
    * Zudem wird die Farbe des Grafik-Text geändert, falls die Farbe gültig ist.
    *
	* @author Reichardt, Nils
	* @param neueFarbe - Die neue Farbe
	*/
	void setzeAussehen(String neueFarbe) {
    	// Damit wird sichergestellt, dass der parameter immer in kleinen Buchstaben verglichen wird. Somit sind auch "Rot", "RoT", "roT", etc. ebenfalls zulässige Werte (das ist optional)
    	neueFarbe = neueFarbe.toLowerCase();
        
        String[] gueltigeFarben = {"schwarz", "weiß", "rot", "grün", "blau", "gelb", "magenta", "cyan"};
        
        for(String gueltigeFarbe : gueltigeFarben) {
        	if(neueFarbe.equals(gueltigeFarbe)) {
            	farbe = neueFarbe;
            	
                if(grafikText != null) {
					grafikText.setFillcolor(farbInHex(neueFarbe));
				}
            }
        }
	}
    
	/** 2.3.3 Farbe und Text der Karte ändern
	* Δe_svmy4r Implementieren Sie diese MethodeΔ
	* Setzt die neue Farbe und den neuen Text
	* @author Reichardt, Nils
	* @param neueFarbe - Die neue Farbe
    * @param neuerText - Der neue Text
	*/
	void setzeAussehen(String neueFarbe, String neuerText) {
    	setzeAussehen(neueFarbe);
        setzeText(neuerText);
    }

	/**
    * Setzte den Text und den grafischen Text. Der Text muss kürzer als 50 Zeichen sein.
    * Falls die Zeichen länger als 50 Zeichen sind, wird der neue Text nicht übernommen.
    * @param neuerText - neuerText
    **/
	void setzeText(String neuerText) {
    	if(neuerText.length() <= 50) {
        	text = neuerText;
            
            if(grafikText != null) {
            	grafikText.setText(neuerText);
            }
        }
    }
    
	/** 2.3.4 Einen String zur Beschreibung einer Karte erzeugen 
	* Δe_272zf8 Implementieren Sie Δ
	* Gibt alle Werte der Klasse als String aus
	* @author Reichardt, Nils
	* @return String der Klasse
	*/
	public String toString() {
		return "[Karte] spalte: " + spalte + ", zeile: " + zeile + ", farbe: " + farbe + ", text " + text; 
	}
	
    /** 2.4 Methode main() definieren
	* Δe_ma19a1 Definieren SieΔ
	* Die main-Methode der Klasse
	* @author Reichardt, Nils
    * @param args - Argumente
	*/
	public static void main(String[] args) {
		GrafikKonsole.clearGrafik();
        
        Karte d = new Karte();
        Karte b = new Karte(1, 1, "blau", "text2");
        Karte c = new Karte(2, 2, "rot", "text2");
    }
    
	/** 2.5.1 Mit einer anderen Karte tauschen.
	* Δe_z0zfsw Implementieren SieΔ
	* Lösungskonzept
	* @author Reichardt, Nils
	* @param andereKarte - Die andere Karte
	*/
	void tauschePositionMit(Karte andereKarte) {
    	// Die Werte von der anderen Karte zwischenspeichern
        int tempZeile = andereKarte.zeile;
        int tempSpalte = andereKarte.spalte;
        
        // Die Werte von dieser Karte (this) der anderen Karte zuweisen
        andereKarte.setzePosition(this.zeile, this.spalte);
        
        // Die Werte von der anderen Karte (wurde zwischen gespeichert) zu dieser Karte übernehmen.
        this.setzePosition(tempZeile, tempSpalte);
	}

	/** 2.5.2 Aussehen einer anderen Karte übernehmen
	* Δe_4x974o Implementieren SieΔ
	* Übernimmt den Text und die Farben
	* @author Reichardt, Nils
	* @param andereKarte - Die andere Karte, von der das Aussehen übernommenw erden soll.
	*/
	void uebernehmeAussehen(Karte andereKarte) {
		this.setzeAussehen(andereKarte.farbe, andereKarte.text);
	}
	
    /**
    * Überprüft ob eine andere Karte die selbe Farbe hat.
    * @param andereKarte - Andere Karte
    * @return Gibt den Vergleichswert des Aussehens zurück
    */
    boolean hatSelbeFarbe(Karte andereKarte) {
    	return this.farbe.equals(andereKarte.farbe); 
    }
}