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
    
	/** 2.3.1 Karte auf dem Spielfeld positionieren
	* Δe_kf5e2u Implementieren SieΔ
	* Setzt die neue Position. 
    * Falls Zeile oder/und spalte nicht positiv sind, wird die neue Positon NICHT übernommen.
	* @author Reichardt, Nils
	* @param neueZeile - Die neue Zeile
    * @param neueSpalte - Die neue Spalte
	*/
	void setzePosition(int neueZeile, int neueSpalte) {
        if(neueZeile >= 0 && neueSpalte >= 0) {
        	zeile = neueZeile;
            spalte = neueSpalte;
        }
	}

	/** 2.3.2 Farbe der Karte ändern
	* Δe_57263z Implementieren SieΔ
	* Setzz die neue Farbe
    * Gültige Farben sind "rot", "gelb", "gruen", "blau", "schwarz", "weiß", "cyan", "magenta".
    * Falls eine Farbe nicht gültig ist, wird die neue Farbe NICHT übernommen.
	* @author Reichardt, Nils
	* @param neueFarbe - Die neue Farbe
	*/
	void setzeFarbeUndText(String neueFarbe) {
    	// Damit wird sichergestellt, dass der parameter immer in kleinen Buchstaben verglichen wird. Somit sind auch "Rot", "RoT", "roT", etc. ebenfalls zulässige Werte (das ist optional)
    	neueFarbe = neueFarbe.toLowerCase();
        
		if(neueFarbe.equals("rot") || neueFarbe.equals("gelb") || neueFarbe.equals("gruen") || neueFarbe.equals("blau") || neueFarbe.equals("schwarz") || neueFarbe.equals("weiß") || neueFarbe.equals("cyan") || neueFarbe.equals("magenta")) {
        	farbe = neueFarbe;
        }
	}
    
	/** 2.3.3 Farbe und Text der Karte ändern
	* Δe_svmy4r Implementieren Sie diese MethodeΔ
	* Setzt die neue Farbe und den neuen Text
	* @author Reichardt, Nils
	* @param neueFarbe - Die neue Farbe
    * @param neuerText - Der neue Text
	*/
	void setzeFarbeUndText(String neueFarbe, String neuerText) {
    	setzeFarbeUndText(neueFarbe);
        setzeText(neuerText);
    }

	/**
    * Setzte den Text. Der Text muss kürzer als 50 Zeichen sein.
    * Falls die Zeichen länger als 50 Zeichen sind, wird der neue Text nicht übernommen.
    * @param neuerText - neuerText
    **/
	void setzeText(String neuerText) {
    	if(neuerText.length() <= 50) {
        	text = neuerText;
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
// 		Karte karte1 = new Karte();
//         Karte karte2 = new Karte();
//         Karte karte3 = new Karte();
//     	System.out.println(karte1.toString());
//         
//         karte1.setzePosition(10, 5);
//         karte2.setzePosition(500, 13);
//         System.out.println(karte1.toString());
//         System.out.println(karte2.toString());
//         
//         karte1.setzeFarbeUndText("blau", "Der Text von Karte 1");
//         karte2.setzeFarbeUndText("rot", "Der Text von Karte 2");
//         System.out.println(karte1.toString());
//         System.out.println(karte2.toString());
//         
//         karte1.tauscheMit(karte2);

		Karte karteA = new Karte();
        Karte karteB = new Karte();
        
        karteA.setzePosition(1, 2);
        karteA.setzeFarbeUndText("rot", "Text A");
        
        karteB.setzePosition(3, 4);
        karteB.setzeFarbeUndText("blau", "Text B");
        
        System.out.println("karteA:" + karteA.toString());
        System.out.println("karteB:" + karteB.toString());
        
//         karteA.tauschePositionMit(karteB);
//         
//         System.out.println("--------");
//         
//         System.out.println("karteA:" + karteA.toString());
//         System.out.println("karteB:" + karteB.toString());

		karteA.uebernehmeAussehen(karteB);
        
        System.out.println("--------");
        
        System.out.println("karteA:" + karteA.toString());
        System.out.println("karteB:" + karteB.toString());
        
        System.out.println("hatSelbeFarbe:" + karteA.hatSelbeFarbe(karteB));
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
		this.setzeFarbeUndText(andereKarte.farbe, andereKarte.text);
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