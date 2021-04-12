/**<br>
 * Hochschule D&uuml;sseldorf - Fachbereich Medien - Objektorientierte Programmierung 1<br>
 *  Prof. Dr. Markus Dahm Praktikum 9 - Spiel<br>
 * <br>
 * "5Crush" ein Spiel in 6 Praktika - Teil 3<br>
 * <br>
 * Das ist die Hauptklasse, mit der das Spiel gestartet wird. Δe_1ffiji Δ <br>
 * <br>
 * @author Prof. Dr. Markus Dahm, Jens Lambert, Jennifer Rose 2020WiSe<br>
 * @version 20.9.1<br>
 <br>*/
class FiveCrush {
	
    /**  4.2 Ablauf zun&auml;chst in main() als Test Methode main() <br>
	* Hauptmethode, die beim Starten der Klasse aufgerufen wird <br>
    * @param args Argumente beim Aufruf &uuml;ber die Kommandozeile <br>
    <br>*/
    public static void main(String[] args) {

		// Initialisierung der Grafik-Konsole (!)
        GrafikKonsole.clearGrafik();

		// Spielfeld erzeugen
    	Spielfeld spielfeld = new Spielfeld(4,6);
        
		// Spielfeld auf einfache Weise füllen und auf der Grafik-Konsole anzeigen
		// spielfeld.einfachFuellen();
        spielfeld.zufaelligFuellen();
        
        // Immer, wenn auf ein Grafik-Objekt geklickt wird, wird der Reaktions-String
        //   auf die Text-Konsole ausgegeben.
        // Brechen Sie das Programm mit dem roten Abbrechen-Button ab.
		System.out.println("/// Dreimal auf eine Karte Klicken: ");
        
		String geklickt;
		for(int i=0; i<3; i++)	{
  			geklickt = Konsole.eingabeString();
    		System.out.println("Klick auf " + geklickt);
		}

	} // ende main()

} // ende class