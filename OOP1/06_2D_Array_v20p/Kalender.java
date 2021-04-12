/**
 * Ein interaktiver Adventskalender 
 * Zuerst auf der Text-Konsole, dann auf der Grafik-Konsole
 */
 
class Kalender {
	
   	/** Haupt-Prozedur, wird beim Programmstart aufgerufen
    */
    public static void main(String[] args) { 
		// int[][] adventskalender = { {3, 7, 12, 21, 1, }, 20 };
        // ausgabeAdventskalender(adventskalender);
        
        int[][] zufallsAdventskalender = new int[4][6];
        fuelleMitEinmaligenZufallszahlen(zufallsAdventskalender);
        fertigerKalender(zufallsAdventskalender);
    }
   	
	/** 1.5 Kalender anzeigen
	* Δe_pajg9k Definieren Sie eine ProzedurΔ
	* Die Methode gibt den gesamten Kalender in der Konsole aus
	* @author Reichardt, Nils
	* @param adventskalender - Ein 2D Array-Int, welches den Adventskalender behinhaltet. 
	*/
	static void ausgabeAdventskalender(int[][] adventskalender) {
		for(int zeile = 0; zeile < adventskalender.length; zeile++) {
        	for(int spalte = 0; spalte < adventskalender[zeile].length; spalte++) {
            	System.out.print(adventskalender[zeile][spalte] + "\t");
            }
            System.out.println("");
        }
	}

  	/** 1.6.1. Kalender mit Zufallszahlen initialisieren Δe_brmfx2 vorgegebene ProzedurΔ
    *  Gibt eine Zufallszahl zwischen 1 und max zurück
    *  Im Fehlerfall gibt sie eine 1 zurück. 
	* @author Dahm, Markus
    * @param max Maximaler Wert der Zufallszahl, muss grösser als 1 sein 
    */
    static int zufallsZahl(int max) {
        if(max>1) {
	     	return 1+((int)(Math.random()*max));
        } else {
        	return 1;
        }
    }

    
	/** 1.6.1 Füllen mit ungeprüften Zufallszahlen
	* Δe_bx5i2t Zufallszahlen von 1 bis 24 fülltΔ
	* Lösungskonzept
	* @author Reichardt, Nils
	* @param 
	* @return 
	*/
	static void fuelleMitZufaelligenZahlen(int[][] adventskalender) {
		for(int zeile = 0; zeile < adventskalender.length; zeile++) {
        	for(int spalte = 0; spalte < adventskalender[zeile].length; spalte++) {
            	adventskalender[zeile][spalte] = zufallsZahl(24);
            }
        }
	}

	/** 1.6.2 Ist die Zahl bereits im Kalender vorhanden?
	* Δe_duoi1p ob eine als Parameter angegebene Zahl bereits im Kalender vorhanden istΔ
	* Die Methode überprüft, ob die übergebene Zahl bereits im Kalender vorhanden ist
	* @author Reichardt, Nils
	* @param pruefendeZahl - Die Zahl, die geprüft wird
    * @param adventskalender - Der Kalender, in dem die Zahl gesucht wird
	* @return gibt an, ob die Zahl vorhanden oder nicht vorhanden ist
	*/
	static boolean istVorhanden(int pruefendeZahl, int[][] adventskalender) {
		for(int zeile = 0; zeile < adventskalender.length; zeile++) {
        	for(int spalte = 0; spalte < adventskalender[zeile].length; spalte++) {
            	if(adventskalender[zeile][spalte] == pruefendeZahl) {
                	return true;
                }
            }
        }
        return false;
	}

	/** 1.6.3 Füllen mit einmaligen Zufallszahlen
	* Δe_c3d9gs Kalender mit einmaligen Zufallszahlen fülltΔ
	* Lösungskonzept
	* @author Reichardt, Nils
	* @param 
	* @return 
	*/
	static void fuelleMitEinmaligenZufallszahlen(int[][] adventskalender) {
		for(int zeile = 0; zeile < adventskalender.length; zeile++) {
        	for(int spalte = 0; spalte < adventskalender[zeile].length; spalte++) {
                int zufallsZahl = zufallsZahl(24);
                while(istVorhanden(zufallsZahl, adventskalender)) {
                	zufallsZahl = zufallsZahl(24);
                }
                adventskalender[zeile][spalte] = zufallsZahl;
            }
        }
	}

	/** 1.7 Türen öffnen
	* Δe_wq5ed7 Türe mit einer bestimmten Zahl öffnetΔ
	* Setzt den Tag auf 0.
	* @author Reichardt, Nils
	* @param tag - Tag des Kalenders
	*/
	static void oeffne(int tag, int[][] adventskalender) {
		for(int zeile = 0; zeile < adventskalender.length; zeile++) {
        	for(int spalte = 0; spalte < adventskalender[zeile].length; spalte++) {
                if(adventskalender[zeile][spalte] == tag) {
                	adventskalender[zeile][spalte] = 0;
                    
                    // Beende die Methode, weil diese fertig ist.
                    return;
                }
            }
        }
	}

	/** 1.8.1 Eingabe von der Tastatur holen Δe_xxsegm vorgegebene FunktionΔ
     * Wartet bis Return gedrückt wird und 
     * gibt dann die in der Konsole eingegebene Zahl zurück.
     * oder -1, wenn es keine gültige int-Zahl war.
 	 * @author Dahm, Markus
	 * @return die eingegebene Zahl.
     */
    static int eingabeZahl() {
		String input;
        int zahl = -1;
        System.out.println(">>>> Bitte Zahl eingeben");
        try { input = bufferedReader.readLine();
        	   zahl = Integer.parseInt(input); 
            } catch (Exception e) { }
	    return zahl;
    }

    
    /** Vorgegebene Variable für die Eingabe, **nicht ändern!** */
    static java.io.BufferedReader bufferedReader = 
	      new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

    
    
	/** 1.9 Der fertige Adventskalender
	* Δe_wdz3dl definieren Sie eine ProzedurΔ
	* Lösungskonzept
	* @author Reichardt, Nils
	* @param 
	* @return 
	*/
	static void fertigerKalender(int[][] adventskalender) {
		int heutigerTag = 1;
        ausgabeAdventskalender(adventskalender);
        System.out.println("----------------------------------------");
        while(heutigerTag <= 24) {
            System.out.println("Tag: " + heutigerTag);            
            
        	int eingabe = eingabeZahl();
            if(heutigerTag == eingabe) {
            	oeffne(heutigerTag, adventskalender);
                heutigerTag++;
                System.out.println("Richtiger Tag (" + eingabe + ")! ✅");
            } else {
            	System.out.println("Falscher Tag (" + eingabe + ")! ❌");
            }
            
            ausgabeAdventskalender(adventskalender);
            System.out.println("----------------------------------------");
        }
        System.out.println("Alle Türen geöffnet");
	}

} // Ende Java File