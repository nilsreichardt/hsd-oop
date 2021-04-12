/**<br>
 * Dies ist das Java-File f&uuml;r eine Klasse namens Aufgabe_05.<br>
 * In dieser Datei erg&auml;nzen wir nun unsere L&ouml;sungen f&uuml;r diese Aufgaben.<br>
 <br>*/
public class Aufgabe_05 {
	
    /** <br>
     * Diese Startprozedur wird beim Compilieren und Ausf&uuml;hren dieser .java-Datei ausgeführt.<br>
     * @param args<br>
     <br>*/
    public static void main(String[] args) {        
        einMalEinsUeberschrift(5);
    } // Ende public static void main
    
	/** 2.5 Ziffer an Stelle s berechnen<br>
	* Diese Funktion ist hier bereits vorgegeben.<br>
    * Berechne die Ziffer an der Stelle stelle einer 9-stelligen Zahl<br>
    * Werte von stelle beginnen dabei von links mit 1 und enden rechts bei 9<br>
    *<br>
    * Beispiel: die Ziffer an der Stelle 3 der Zahl 123456789 ist 3.<br>
    *<br>
    * @author Markus Dahm<br>
    * @param zahl - die 9-stellige Zahl<br>
    * @param stelle - die Stelle, deren Ziffer ermittelt wird (1-9)<br>
    * @return die Ziffer von zahl an der Stelle stelle, -1 f&uuml;r eine falsche stelle<br>
    <br>*/
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
    
    /** 1.6.1 Prozedur static void begruessung()<br>
	* Begr&uuml;&szlig;ungstext auf die Konsole<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	<br>*/
    static void begruessung() {
    	System.out.println("Moin moin :)");
    }

	/** 1.11.1 Definition von &uuml;berladenen Prozeduren<br>
	* Begr&uuml;&szlig;ung einer Person<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	* @param name - Name der Person, die gegr&uuml;&szlig;gt werden soll<br>
	<br>*/
	static void begruessung(String name) {
		System.out.println("Moin moin, " + name + " :)");
	}

	/** 1.11.1 Definition von &uuml;berladenen Prozeduren<br>
	* Prozedur zur wiederholten Begr&uuml;&szlig;ung<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	* @param name - Name der Person, die gegr&uuml;&szlig;gt werden soll<br>
    * @param anzahl - Gibt an, wie oft die Person gegr&uuml;&szlig;t werden soll<br>
	<br>*/
	static void begruessung(String name, int anzahl) {
		for(int i = 0; i < anzahl; i++) {
        	System.out.println("Moin moin, " + name + " :)");
        }
	}

	/** 2.6 ISBN-Pr&uuml;fziffer als char<br>
	* Umwandlung in chars<br>
	* Die Zahl wird als Char zur&uuml;ckgegeben. Ausnahme ist die Zahl 10, die als X zurückgegeben wird.<br>
	* @author Reichardt, Nils<br>
	* @param zahl - Von dieser Zahl wird die Pr&uuml;fziffer berchnet<br>
	* @return die Pr&uuml;fziffer als Char<br>
	<br>*/
	static char pruefzifferIntZuChar(int zahl) {
		if(zahl == 10) return 'X';
        // Die Zahl wird auf den ASCII-Wert der 0 addiert, womit man den ASCII-Wert der jeweiligen Zahl erhält.
        return (char) (zahl + '0');
	}

	/** 2.7 ISBN-Pr&uuml;fziffer errechnen<br>
	* Berechnung der ISBN-Pr&uuml;fziffer<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	* @param <br>
	* @return <br>
	<br>*/
	static char berechnePruefziffer(int zahl) {
    	int summe = 0;
		for(int i = 1; i < 10; i++) {
        	summe += i * zifferVonZahlAnStelle(zahl, i);
        }
        return pruefzifferIntZuChar(summe % 11);
	}

	/** 2.8 Zahl und Pr&uuml;fziffer zu ISBN-10 formatieren<br>
	* formatierte ISBN-Ausgabe<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	* @param zahl - Die Zahl aus die ISBN generiert wird<br>
	* @return die formarierte vollst&auml;ndige ISBN<br>
	<br>*/
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

	/** 3.1.1 Einmal-Eins - Definition<br>
	* Ausgabe des Einmal-Eins<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	* @param <br>
	* @return <br>
	<br>*/
	static void einMalEinsBis(int grenze) {
		for(int zeile = 1; zeile <= grenze; zeile++) {
  			for(int spalte = 1; spalte <= grenze; spalte++) {
      			int rechnung = zeile * spalte;
        		System.out.print(rechnung + " ");
    		}
    		System.out.println("");
		}
	}

	/** 3.2.1 &Uuml;berschrift - Definition<br>
	* &Uuml;berschrift<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	* @param <br>
	* @return <br>
	<br>*/
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