import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test {
    public static void main(String[] args) {
        try {
            UpperLowerWriter ulw = new UpperLowerWriter(new BufferedWriter(new FileWriter("//Users//nils//Desktop//test.txt")));
            ulw.write('U');
            ulw.write('a');
            ulw.write('O');
            ulw.write('n');
            ulw.write('!');
            ulw.flush();
            ulw.close();

            UpperLowerWriter ulw2 = new UpperLowerWriter(new BufferedWriter(new FileWriter("//Users//nils//Desktop//buffer.txt")));
            char[] input = {'A','B','c','d','!','2','C'};
            ulw2.write(input, 0, 7);
            ulw2.close();

            // b1) Das modifizierte Array nach dem Buffered Writer zu erzeugen, würde die Performance-Vorteile des
            //     BufferedWriter vernichten
            //
            // b2) Der FileWriter muss immer als letztes aufgerufen werden, da er die Daten des Streams direkt in die
            //     Datei schreibt. Danach kann kein Buffer mehr erzeugt werden.
            System.out.println("Aufgabe 3");
            UpperLowerWriter consoleWriterOne = new UpperLowerWriter(new OutputStreamWriter(System.out));
            consoleWriterOne.write('C');
            consoleWriterOne.write('c');
            consoleWriterOne.write('A');
            consoleWriterOne.write('i');
            consoleWriterOne.write('?');
            consoleWriterOne.flush();
            System.out.println();

            UpperLowerWriter consoleWriter = new UpperLowerWriter(new OutputStreamWriter(System.out));
            consoleWriter.write(input, 0, 7);
            consoleWriter.close();
            consoleWriterOne.close();
            System.out.println("\nTest");
            System.err.println("\nError Test");
        }
        catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Datei: " + e);
            e.printStackTrace();
        }
    }
}