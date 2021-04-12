class _2_Schleifen
{
public static void main(String[] args)
{ System.setOut(new FiveCodePrintStream(System.out));

int n = 5;
for(int zeile = 0; zeile <= n; zeile++) {
  for(int spalte = 0; spalte <= n; spalte++) {
    if(zeile == 0 && spalte == 0) {
        // Links oben in der Ecke soll ein leeres Feld ausgegeben werden
      System.out.print("\t");
    } else {
        if(zeile == 0) {
          // In der ersten Zeile sollen einfach nur die Zahlen 1 - 10 ausgeben werden.
          System.out.print(spalte + "\t");
        } else if(spalte == 0) {
            // Am Anfang einer Zeile soll die Nr. der Zeile ausgegben werden. Dies ist
            // in diesem Fall ein i.
            System.out.print(zeile + "\t");
        } else {
            int rechnung = zeile * spalte;
          System.out.print(rechnung + "\t");
        }
    }   
  }
  System.out.println("");
}

}


_2_Schleifen() {
}
}