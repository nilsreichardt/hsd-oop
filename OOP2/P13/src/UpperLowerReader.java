import java.io.*;

public class UpperLowerReader extends FilterReader {

    /**
     * Constructor der Klasse UpperLowerWriter
     *
     * @param in - Writer-Object, dem der Stream übergeben wird
     */
    protected UpperLowerReader(Reader in) {
        super(in);
    }

    /**
     * Wandelt den übergegeben Character in einen Kleinbuchstaben um
     *
     * @return Gibt den den ausgelesenen Input zurück.
     */
    @Override
    public int read() throws IOException {
        try {
            int i = in.read();
            if (i != -1) {
                if (Character.isLowerCase(i)) {
                    return Character.toUpperCase(i);
                } else {
                    return Character.toLowerCase(i);
                }
            } else {
                return -1;
            }
        } catch (IOException e) {
            System.err.println("Systemfehler beim Modifizieren in UpperLowerWriter: " + e);
            throw e;
        }
    }

    /**
     * Wandelt den übergegeben Character in einen Kleinbuchstaben um
     *
     * @param buf - Zu modifizierendes Character-Array
     * @param off - eEin eventueller Offset
     * @param len - Länge des modifizierten Arrays
     */
    @Override
    public int read(char[] buf, int off, int len) throws IOException {
        try {
            int anzahl = in.read(buf, off, len);
            if (anzahl == 1) {
                return -1;
            }

            for (int i = off; i < (off + anzahl); i++) {
                buf[i] = Character.isLowerCase(buf[i]) ? Character.toUpperCase(buf[i]) : Character.toLowerCase(buf[i]);
            }

            return anzahl;
        }  catch (IOException e) {
            System.err.println("Systemfehler beim Modifizieren in UpperLowerWriter." + e);
            throw e;
        }
    }
}