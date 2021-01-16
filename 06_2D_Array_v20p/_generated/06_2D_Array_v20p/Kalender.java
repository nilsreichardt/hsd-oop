/**<br>
 * Ein interaktiver Adventskalender <br>
 * Zuerst auf der Text-Konsole, dann auf der Grafik-Konsole<br>
 <br>*/
 
class Kalender {
	
   	/** Haupt-Prozedur, wird beim Programmstart aufgerufen<br>
    <br>*/
    public static void main(String[] args) { 
		// int[][] adventskalender = { {3, 7, 12, 21, 1, }, 20 };
        // ausgabeAdventskalender(adventskalender);
        
        int[][] zufallsAdventskalender = new int[4][6];
        fuelleMitEinmaligenZufallszahlen(zufallsAdventskalender);
        fertigerKalender(zufallsAdventskalender);
    }
   	
	/** 1.5 Kalender anzeigen<br>
	* Definieren Sie eine Prozedur<br>
	* Die Methode gibt den gesamten Kalender in der Konsole aus<br>
	* @author Reichardt, Nils<br>
	* @param adventskalender - Ein 2D Array-Int, welches den Adventskalender behinhaltet. <br>
	<br>*/
	static void ausgabeAdventskalender(int[][] adventskalender) {
		for(int zeile = 0; zeile < adventskalender.length; zeile++) {
        	for(int spalte = 0; spalte < adventskalender[zeile].length; spalte++) {
            	System.out.print(adventskalender[zeile][spalte] + "\t");
            }
            System.out.println("");
        }
	}

  	/** 1.6.1. Kalender mit Zufallszahlen initialisieren vorgegebene Prozedur<br>
    *  Gibt eine Zufallszahl zwischen 1 und max zur&uuml;ck<br>
    *  Im Fehlerfall gibt sie eine 1 zur&uuml;ck. <br>
	* @author Dahm, Markus<br>
    * @param max Maximaler Wert der Zufallszahl, muss gr&ouml;sser als 1 sein <br>
    <br>*/
    static int zufallsZahl(int max) {
        if(max>1) {
	     	return 1+((int)(Math.random()*max));
        } else {
        	return 1;
        }
    }

    
	/** 1.6.1 F&uuml;llen mit ungeprüften Zufallszahlen<br>
	* Zufallszahlen von 1 bis 24 f&uuml;llt<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	* @param <br>
	* @return <br>
	<br>*/
	static void fuelleMitZufaelligenZahlen(int[][] adventskalender) {
		for(int zeile = 0; zeile < adventskalender.length; zeile++) {
        	for(int spalte = 0; spalte < adventskalender[zeile].length; spalte++) {
            	adventskalender[zeile][spalte] = zufallsZahl(24);
            }
        }
	}

	/** 1.6.2 Ist die Zahl bereits im Kalender vorhanden?<br>
	* ob eine als Parameter angegebene Zahl bereits im Kalender vorhanden ist<br>
	* Die Methode &uuml;berprüft, ob die übergebene Zahl bereits im Kalender vorhanden ist<br>
	* @author Reichardt, Nils<br>
	* @param pruefendeZahl - Die Zahl, die gepr&uuml;ft wird<br>
    * @param adventskalender - Der Kalender, in dem die Zahl gesucht wird<br>
	* @return gibt an, ob die Zahl vorhanden oder nicht vorhanden ist<br>
	<br>*/
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

	/** 1.6.3 F&uuml;llen mit einmaligen Zufallszahlen<br>
	* Kalender mit einmaligen Zufallszahlen f&uuml;llt<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	* @param <br>
	* @return <br>
	<br>*/
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

	/** 1.7 T&uuml;ren &ouml;ffnen<br>
	* T&uuml;re mit einer bestimmten Zahl &ouml;ffnet<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	* @param <br>
	* @return <br>
	<br>*/
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

	/** 1.8.1 Eingabe von der Tastatur holen vorgegebene Funktion<br>
     * Wartet bis Return gedr&uuml;ckt wird und <br>
     * gibt dann die in der Konsole eingegebene Zahl zur&uuml;ck.<br>
     * oder -1, wenn es keine g&uuml;ltige int-Zahl war.<br>
 	 * @author Dahm, Markus<br>
	 * @return die eingegebene Zahl.<br>
     <br>*/
    static int eingabeZahl() {
		String input;
        int zahl = -1;
        System.out.println(">>>> Bitte Zahl eingeben");
        try { input = bufferedReader.readLine();
        	   zahl = Integer.parseInt(input); 
            } catch (Exception e) { }
	    return zahl;
    }

    
    /** Vorgegebene Variable f&uuml;r die Eingabe, <strong>nicht &auml;ndern!</strong> <br>*/
    static java.io.BufferedReader bufferedReader = 
	      new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

    
    
	/** 1.9 Der fertige Adventskalender<br>
	* definieren Sie eine Prozedur<br>
	* L&ouml;sungskonzept<br>
	* @author Reichardt, Nils<br>
	* @param <br>
	* @return <br>
	<br>*/
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