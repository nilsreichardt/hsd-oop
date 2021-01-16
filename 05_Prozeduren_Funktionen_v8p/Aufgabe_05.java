/**
 * Dies ist das Java-File für eine Klasse namens Aufgabe_05.
 * In dieser Datei ergänzen wir nun unsere Lösungen für diese Aufgaben.
 */
public class Aufgabe_05 {
	
    /** 
     * Diese Startprozedur wird beim Compilieren und Ausführen dieser .java-Datei ausgeführt.
     * @param args
     */
    public static void main(String[] args) {        
        einMalEinsUeberschrift(5);
    } // Ende public static void main
    
	/** 2.5 Ziffer an Stelle s berechnen
	* Δe_f488zq Diese Funktion ist hier bereits vorgegeben.Δ
    * Berechne die Ziffer an der Stelle stelle einer 9-stelligen Zahl
    * Werte von stelle beginnen dabei von links mit 1 und enden rechts bei 9
    *
    * Beispiel: die Ziffer an der Stelle 3 der Zahl 123456789 ist 3.
    *
    * @author Markus Dahm
    * @param zahl - die 9-stellige Zahl
    * @param stelle - die Stelle, deren Ziffer ermittelt wird (1-9)
    * @return die Ziffer von zahl an der Stelle stelle, -1 für eine falsche stelle
    */
    static int zifferVonZahlAnStelle(int zahl, int stelle)
    {

        // Es sind nur Werte für stelle zwischen 1 und 9 erlaubt
        // Andernfalls gibt die Funktion -1 zurück

        if((stelle <1) || (stelle>9))
            return -1;

        // Die Ziffer an der _letzten_ Stelle kann ich
        // sofort ermitteln: mit dem Modulo-Operator
        //
        // Dafür muss ich die übrigen Stellen "abschneiden",
        // z.B. durch fortgesetzes Teilen durch 10.
        // Wieviele Stellen muss ich abschneiden?
        // Bei stelle==9: 0, bei stelle==8: 1, bei stelle==1: 8, d.h. allgemein:
        // ich muss 9-stelle Stellen "abschneiden":

        for(int i=0; i<9-stelle;i++) {
            zahl = zahl / 10;
        }

        // Jetzt ist die Ziffer der gewünschten Stelle die Einer-Stelle der zahl
        // Diese kann ich ermitteln mit dem Modulo-Operator:

        int ziffer = zahl%10;

        // fertig, jetzt nur noch die Ziffer zurückgeben:

        return ziffer;
    }
    
    /** 1.6.1 Prozedur static void begruessung()
	* Δe_2hrh5a Begrüßungstext auf die KonsoleΔ
	* Lösungskonzept
	* @author Reichardt, Nils
	*/
    static void begruessung() {
    	System.out.println("Moin moin :)");
    }

	/** 1.11.1 Definition von überladenen Prozeduren
	* Δe_mgndne Begrüßung einer PersonΔ
	* Lösungskonzept
	* @author Reichardt, Nils
	* @param name - Name der Person, die gegrüßgt werden soll
	*/
	static void begruessung(String name) {
		System.out.println("Moin moin, " + name + " :)");
	}

	/** 1.11.1 Definition von überladenen Prozeduren
	* Δe_zvhix2 Prozedur zur wiederholten BegrüßungΔ
	* Lösungskonzept
	* @author Reichardt, Nils
	* @param name - Name der Person, die gegrüßgt werden soll
    * @param anzahl - Gibt an, wie oft die Person gegrüßt werden soll
	*/
	static void begruessung(String name, int anzahl) {
		for(int i = 0; i < anzahl; i++) {
        	System.out.println("Moin moin, " + name + " :)");
        }
	}

	/** 2.6 ISBN-Prüfziffer als char
	* Δe_f1qqqh Umwandlung in charsΔ
	* Die Zahl wird als Char zurückgegeben. Ausnahme ist die Zahl 10, die als X zurückgegeben wird.
	* @author Reichardt, Nils
	* @param zahl - Von dieser Zahl wird die Prüfziffer berchnet
	* @return die Prüfziffer als Char
	*/
	static char pruefzifferIntZuChar(int zahl) {
		if(zahl == 10) return 'X';
        // Die Zahl wird auf den ASCII-Wert der 0 addiert, womit man den ASCII-Wert der jeweiligen Zahl erhält.
        char ergebnis = '0';
        ergebnis += zahl;
        return ergebnis;
	}

	/** 2.7 ISBN-Prüfziffer errechnen
	* Δe_f5q8yz Berechnung der ISBN-PrüfzifferΔ
	* Lösungskonzept
	* @author Reichardt, Nils
	* @param 
	* @return Rückgabe der Prüfziffer
	*/
	static char berechnePruefziffer(int zahl) {
    	int summe = 0;
		for(int stelle = 1; stelle < 10; i++) {
        	summe += stelle * zifferVonZahlAnStelle(zahl, stelle);
        }
        return pruefzifferIntZuChar(summe % 11);
	}

	/** 2.8 Zahl und Prüfziffer zu ISBN-10 formatieren
	* Δe_p2jla7 formatierte ISBN-AusgabeΔ
	* Lösungskonzept
	* @author Reichardt, Nils
	* @param zahl - Die Zahl aus die ISBN generiert wird
	* @return die formarierte vollständige ISBN
	*/
	static String erstelleFormatierteIsbn(int zahl) {
		String isbn = "";
        for(int i = 1; i < 10; i++) {
        	isbn += zifferVonZahlAnStelle(zahl, i);
            if(i == 3 || i == 7 || i == 9) {
            	isbn += '-';
            }
        }
        return isbn + berechnePruefziffer(zahl);
	}

	/** 3.1.1 Einmal-Eins - Definition
	* Δe_gtewl9 Ausgabe des Einmal-EinsΔ
	* Lösungskonzept
	* @author Reichardt, Nils
	* @param 
	* @return 
	*/
	static void einMalEinsBis(int grenze) {
		for(int zeile = 1; zeile <= grenze; zeile++) {
  			for(int spalte = 1; spalte <= grenze; spalte++) {
      			int rechnung = zeile * spalte;
        		System.out.print(rechnung + " ");
    		}
    		System.out.println("");
		}
	}

	/** 3.2.1 Überschrift - Definition
	* Δe_xymmge ÜberschriftΔ
	* Lösungskonzept
	* @author Reichardt, Nils
	* @param 
	* @return 
	*/
	static void einMalEinsUeberschrift(int grenze) {
		for(int i = 0; i < grenze; i++) {
        	if(i == 0) {
            	System.out.print("*");
            } else {
            	System.out.print(i);
            }
            System.out.print("\t");
        }
        
        System.out.println("");
        
        for(int i = 0; i < grenze; i++) {
            System.out.print("--------");
        }
	}

} // Ende public class Aufgabe