import java.io.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        try {
            // Task: 2
            UpperLowerReader ulw = new UpperLowerReader(new StringReader("ADs12!aA"));
            StringBuilder content = new StringBuilder();
            // ulw.close(); // throws java.io.IOException: Stream closed
            int nextChar;
            while ((nextChar = ulw.read()) != -1) {
                content.append((char) nextChar);
            }
            // System.out.println(String.valueOf(content));

            char[] input2 = new char[4];
            UpperLowerReader ulw2 = new UpperLowerReader(new StringReader(("UiA12!as")));

            int off = 0;
            int len = 3;
            int anz = 0;
            String ausgabe;

            while(anz != -1) {
                anz = ulw2.read(input2, off, len);
                if(anz != -1 ) {
                    ausgabe = new String(input2, off, anz);
                    System.out.println("bufread:" + ausgabe);
                } else {
                    System.out.println("EOS");
                }
            }

            // Task 3
            UpperLowerReader ulw3 = new UpperLowerReader(new FileReader("//Users//nils//Desktop//buffer.txt"));
            StringBuilder content2 = new StringBuilder();
            int nextChar2;
            while ((nextChar2 = ulw3.read()) != -1) {
                content2.append((char) nextChar2);
            }
            System.out.println(String.valueOf(content2));

            try {
                UpperLowerReader ulw4 = new UpperLowerReader(new FileReader("öalkj321"));
                StringBuilder content3 = new StringBuilder();
                int nextChar3;
                while ((nextChar3 = ulw3.read()) != -1) {
                    content3.append((char) nextChar3);
                }
                System.out.println(String.valueOf(content3));
            } catch (IOException e) {
                System.out.println("Fehler!!" + e);
            }

            System.out.println();
            System.out.println("----------");
            System.out.println();

            // Task 4
            BufferedReader bufferReader = new BufferedReader(new UpperLowerReader(new FileReader("//Users//nils//Desktop//buffer.txt")));
            String line;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
            }

            // Wofür BufferReader verwenden? Ähnlich Grund wie bei BufferWrite.
            // Ein BufferReader modifiziert keine Daten.
            // BufferReader versucht möglichst viele Zeile in seinen interen Buffer zu lesen.

        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Datei: " + e);
            e.printStackTrace();
        }
    }
}