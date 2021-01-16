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
	int zeile = 0;
    
    /**<br>
    * F&auml;ngt bei am linken Rand an. Somit ist 0 ist Spalte ganz links.<br>
    * Der Wert darf nicht negativ sein.<br>
    <br>*/
    int spalte = 0;

	/**<br>
    * G&uuml;ltige Farben: "rot", "gelb", "gruen", "blau", "schwarz", "wei&szlig;", "cyan", "magenta"<br>
    <br>*/
	String farbe = null;
    
    /**<br>
    * Der Text darf nicht l&auml;nger als 50 Zeichen sein.<br>
    <br>*/
    String text = null;
    
	/** 2.3.1 Karte auf dem Spielfeld positionieren<br>
	* Implementieren Sie<br>
	* Setzt die neue Position. <br>
    * Falls Zeile oder/und spalte nicht positiv sind, wird die neue Positon NICHT &uuml;bernommen.<br>
	* @author Reichardt, Nils<br>
	* @param neueZeile - Die neue Zeile<br>
    * @param neueSpalte - Die neue Spalte<br>
	<br>*/
	void setzePosition(int neueZeile, int neueSpalte) {
        if(neueZeile >= 0 && neueSpalte >= 0) {
        	zeile = neueZeile;
            spalte = neueSpalte;
        }
	}

	/** 2.3.2 Farbe der Karte &auml;ndern<br>
	* Implementieren Sie<br>
	* Setzz die neue Farbe<br>
    * G&uuml;ltige Farben sind "rot", "gelb", "gruen", "blau", "schwarz", "wei&szlig;", "cyan", "magenta".<br>
    * Falls eine Farbe nicht g&uuml;ltig ist, wird die neue Farbe NICHT übernommen.<br>
	* @author Reichardt, Nils<br>
	* @param neueFarbe - Die neue Farbe<br>
	<br>*/
	void setzeFarbeUndText(String neueFarbe) {
    	// Damit wird sichergestellt, dass der parameter immer in kleinen Buchstaben verglichen wird. Somit sind auch "Rot", "RoT", "roT", etc. ebenfalls zulässige Werte (das ist optional)
    	neueFarbe = neueFarbe.toLowerCase();
        
		if(neueFarbe.equals("rot") || neueFarbe.equals("gelb") || neueFarbe.equals("gruen") || neueFarbe.equals("blau") || neueFarbe.equals("schwarz") || neueFarbe.equals("weiß") || neueFarbe.equals("cyan") || neueFarbe.equals("magenta")) {
        	farbe = neueFarbe;
        }
	}
    
	/** 2.3.3 Farbe und Text der Karte &auml;ndern<br>
	* Implementieren Sie diese Methode<br>
	* Setzt die neue Farbe und den neuen Text<br>
	* @author Reichardt, Nils<br>
	* @param neueFarbe - Die neue Farbe<br>
    * @param neuerText - Der neue Text<br>
	<br>*/
	void setzeFarbeUndText(String neueFarbe, String neuerText) {
    	setzeFarbeUndText(neueFarbe);
        setzeText(neuerText);
    }

	/**<br>
    * Setzte den Text. Der Text muss k&uuml;rzer als 50 Zeichen sein.<br>
    * Falls die Zeichen l&auml;nger als 50 Zeichen sind, wird der neue Text nicht &uuml;bernommen.<br>
    * @param neuerText - neuerText<br>
    *<br>*/
	void setzeText(String neuerText) {
    	if(neuerText.length() <= 50) {
        	text = neuerText;
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
	
    /** 2.4 Methode main() definieren<br>
	* Definieren Sie<br>
	* Die main-Methode der Klasse<br>
	* @author Reichardt, Nils<br>
    * @param args - Argumente<br>
	<br>*/
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
		this.setzeFarbeUndText(andereKarte.farbe, andereKarte.text);
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