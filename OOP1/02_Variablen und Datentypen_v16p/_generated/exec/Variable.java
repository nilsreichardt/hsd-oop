class Variable
{
public static void main(String[] args)
{ System.setOut(new FiveCodePrintStream(System.out));

/** * Verzwickte Anwendung von pre/post in/decrement-Operatoren *  
* Dokumentieren Sie die Ergebnisse im Code,  
* um sie beim späteren Nachschlagen sofort zur Hand zu haben. */

int i = 55;  // Variable definieren und sofort auf einen Anfangswert setzen
int j = 67;  
i = j+34;       // Welche Werte haben die Variablen  i = 101 j = 67              
///" vars = " + i + "     " + j
    
System.out.println("1. i =" + i + "  j =" + j ); 

j = i + j + 12; // Erwartung: i = 101  j = 180
                // Ergebnis:  i = 101  j = 180
System.out.println("2. i =" + i + "  j =" + j ); 

i = j++ + 17;   // Erwartung: i = 198  j = 181 <--!!!!!!!!!!!
                // Ergebnis:  i = 197  j = 181
System.out.println("3. i =" + i + "  j =" + j ); 

j = --i;        // Erwartung: i = 196  j = 196
                // Ergebnis:  i = ?  j = ?

System.out.println("4. i =" + i + "  j =" + j ); 

// Es folgt eine knifflige Kombination von Operationen.
// Sie sollte Ihnen vor allem zeigen, dass solche Operatoren
//     mit Bedacht zu verwenden sind.
System.out.println("5. i =" + (++i) + "  i =" + (i--) );
          // Erwartung: 197 = ?  j = 196 <--!!!!!!!!!!!
                // Ergebnis:  i = 197  j = 197


}


Variable() {
}
}