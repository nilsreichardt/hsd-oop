import java.io.*;

public class UpperLowerWriter extends FilterWriter {

    /**
     * Constructor der Klasse UpperLowerWriter
     * @param out - Writer-Object, dem der Stream übergeben wird
     */
    protected UpperLowerWriter(Writer out) {
        super(out);
    }

    /**
     * Wandelt den übergegeben Character in einen Kleinbuchstaben um
     * @param c - der zu modifizierende Character
     */
    @Override
    public void write(int c) throws IOException{
        try {
            char output = (char) c;
            if (Character.isLetter(output)) {
                if (Character.isLowerCase(output)) {
                    output = Character.toUpperCase(output);
                }
                else {
                    output = Character.toLowerCase(output);
                }
            }
            this.out.write(output);
        }
        catch (IOException e) {
            System.err.println("Systemfehler beim Modifizieren in UpperLowerWriter: " + e);
            throw e;
        }
    }

    /**
     * Wandelt den übergegeben Character in einen Kleinbuchstaben um
     * @param buf - Zu modifizierendes Character-Array
     * @param off - eEin eventueller Offset
     * @param len - Länge des modifizierten Arrays
     */
    @Override
    public void write(char[] buf, int off, int len) throws IOException{
        try {
            char[] output = new char[len];
            for(int i=0; i<len; i++) {
                char currentCharacter = buf[off+i];
                if (Character.isUpperCase(currentCharacter))
                    currentCharacter = Character.toLowerCase(currentCharacter);
                else
                    currentCharacter = Character.toUpperCase(currentCharacter);
                output[i] = currentCharacter;
            }
            this.out.write(output,0,len);
        }
        catch (IOException e) {
            System.err.println("Systemfehler beim Modifizieren in UpperLowerWriter." + e);
            throw e;
        }
    }
}