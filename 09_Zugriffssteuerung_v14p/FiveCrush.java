/**
 * Hochschule Düsseldorf - Fachbereich Medien - Objektorientierte Programmierung 1
 *  Prof. Dr. Markus Dahm Praktikum 9 - Spiel
 * 
 * "5Crush" ein Spiel in 6 Praktika - Teil 3
 * 
 * Das ist die Hauptklasse, mit der das Spiel gestartet wird. Δe_1ffiji Δ 
 * 
 * @author Prof. Dr. Markus Dahm, Jens Lambert, Jennifer Rose 2020WiSe
 * @version 20.9.1
 */
class FiveCrush {
	
    /**  4.2 Ablauf zunächst in main() als Test Δe_j4mn1u Methode main()Δ 
	* Hauptmethode, die beim Starten der Klasse aufgerufen wird 
    * @param args Argumente beim Aufruf über die Kommandozeile 
    */
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
		/// Dreimal auf eine Karte Klicken: 
        
		String geklickt;
		for(int i=0; i<3; i++)	{
  			geklickt = Konsole.eingabeString();
    		System.out.println("Klick auf " + geklickt);
		}

	} // ende main()

} // ende class