import java.lang.Comparable;

/**
 * Eine doppelt verkettete Liste, die nur Daten von dem Datentyp "String" speichern kann (nicht generisch).
 */
public class DoLiString {
    /**
     * Die erste Node der Liste. Falls first leer ist, ist die Liste leer.
     */
    private Node first;

    /**
     * Die letzte Node der Liste. Kann leer sein.
     */
    private Node last;

    public DoLiString() {
        this.first = null;
        this.last = null;
    }

    public static void main(String[] args) {
        DoLiString list = new DoLiString();
        list.insertInOrder("München");
        list.insertInOrder("Berlin");
        list.insertInOrder("Düsseldorf");
        list.insertInOrder("Kiel");
        System.out.println(list);
    }

    /**
     * Fügt einen neuen String in die Liste am Anfang ein.
     *
     * @param payload Der String, der zur Liste hinzugefügt werden soll.
     */
    public void insert(String payload) {
        Node node = new Node(payload);

        if (isNotEmpty()) {
            first.insert(node);
        }
        first = node;

        if (last == null) {
            last = node;
        }
    }

    /**
     * Fügt einen String alphabetisch sortiert in die Liste ein. Bedinung dafür ist, dass die Liste bereits sortiert
     * ist.
     */
    public void insertInOrder(String payload) {
        if (isEmpty()) {
            insert(payload);
        } else {
            Node node = new Node(payload);
            first.insertInOrder(node);
            updateLast();
            updateFirst();
        }
    }

    /**
     * Da ein nicht optimales Design der Klasse vorgegeben wird, wird eine Methode benötigt, die first in der Liste
     * aktualisiert und neu setzt. Es passiert zu viel Logik innerhalb der Node-Klasse. Jedoch kann und soll diese nicht
     * die Logik der DoListString-Klasse verwalten, weswegen es den Workaround benötigt, dass von der
     * DoListString-Klasse nochmal mit der überprüft werden muss, ob first aktualisiert werden muss.
     */
    private void updateFirst() {
        if (first.prev != null) {
            first = first.prev;
        }
    }

    /**
     * Da ein nicht optimales Design der Klasse vorgegeben wird, wird eine Methode benötigt, die last in der Liste
     * aktualisiert und neu setzt. Es passiert zu viel Logik innerhalb der Node-Klasse. Jedoch kann und soll diese nicht
     * die Logik der DoListString-Klasse verwalten, weswegen es den Workaround benötigt, dass von der
     * DoListString-Klasse nochmal mit der überprüft werden muss, ob last aktualisiert werden muss.
     */
    private void updateLast() {
        if (last.next != null) {
            last = last.next;
        }
    }

    /**
     * Für einen neuen String in die Liste am Ende ein.
     *
     * @param payload Der String, der zur Liste hinzugegfügt werden soll.
     */
    public void append(String payload) {
        Node node = new Node(payload);

        if (last != null) {
            last.append(node);
        }
        last = node;

        if (isEmpty()) {
            first = node;
        }
    }

    /**
     * Sucht in der Liste nach einer Note, die den suchenden String als Payload gespeichert hat.
     *
     * Aufgabenstellung: Definieren Sie eine private Methode nodeOf(), die einen String sucht und das zugehörigen
     * Node-Objekt zurückgibt Diese Methode können Sie für Ihre Methoden zum Suchen und Löschen verwenden, ohne Code
     * duplizieren zu müssen.
     *
     * @param searchingString Der suchende String
     * @return Falls es in der Liste * eine Node mit diesem String gibt, wird diese Node zurückgegeben. Falls es diese
     * Node nicht gibt, wird null zurück * gegeben.
     */
    private Node nodeOf(String searchingString) {
        return nodeOf(searchingString, first);
    }

    /**
     * Sucht in der Liste nach einer Note, die den suchenden String als Payload gespeichert hat.
     *
     * Aufgabenstellung: Definieren Sie eine private Methode nodeOf(), die einen String sucht und das zugehörigen
     * Node-Objekt zurückgibt Diese Methode können Sie für Ihre Methoden zum Suchen und Löschen verwenden, ohne Code
     * duplizieren zu müssen.
     *
     * Visualisierung: Node1 --> Node2 --> Node3 --> Node4 --> null Die Methode geht rekursiv von Node1 zu Node 2 zu
     * Node3, usw. bis null erreicht ist und somit das Ende der Liste erreicht wurde.
     *
     * Abbruchbedingungen sind folgende: 1. currentNode ist null: Dies bedeutet, dass die Methode am Ende der Liste
     * angelangt und somit der gesuchte String nicht gefunden wurde. 2. payload von currentNode ist gleich
     * searchingString: Für den gesuchten String wurde die gesuchte Node gefunden.
     *
     * @param searchingString Der suchende String
     * @param currentNode     Die jeweilige Node, die gerade angeschaut wird.
     * @return Falls es in der Liste * eine Node mit diesem String gibt, wird diese Node zurückgegeben. Falls es diese *
     * Node nicht gibt, wird null zurück * gegeben.
     */
    private Node nodeOf(String searchingString, Node currentNode) {
        if (currentNode == null) return null;
        if (currentNode.payload.equals(searchingString)) return currentNode;
        return nodeOf(searchingString, currentNode.next);
    }

    /**
     * Entfernt den angegebenen String aus der List.
     *
     * @param searchingString Der String, der entfernt werden soll
     * @return Gibt true ist zurück, falls die Node entfernt wurde. Falls zu dem String keine Node gefunden wurde, wird
     * false zurückgegeben.
     */
    public boolean remove(String searchingString) {
        Node node = nodeOf(searchingString);

        // Es wurde keine Node mit "searchingString" gefunden. Dieser String ist nicht in der Liste vorhanden.
        if (node == null) return false;

        if (first == node) {
            first = node.next;
        } else if (last == node) {
            last = node.prev;
        }

        node.remove();
        return false;
    }

    /**
     * Gibt an, ob der zu suchende String in der Liste vorhanden ist.
     *
     * @param searchingString Der suchende String
     * @return Falls der String vorhanden ist, wird true zurückgegeben, anderenfalls false.
     */
    public boolean has(String searchingString) {
        return nodeOf(searchingString) != null;
    }

    /**
     * Überprüft, ob die Liste leer ist.
     *
     * @return Gibt true zurück, falls die Liste leer ist. False, falls die Liste gefüllt ist.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Überprüft, ob die Liste nicht leer ist.
     *
     * @return Gibt true zurück, falls die Liste gefüllt ist. False, falls die Liste leer ist.
     */
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public String toString() {
        if (first == null) return "DoLiString:";
        return "DoLiString:" + first.generateToStringWithAllNodes(first);
    }

    /**
     * Der Knoten, der die Payload, also den String speichert.
     */
    private class Node implements Comparable<Node> {
        /**
         * Die nächste Node. Falls null ist, ist die Node am Ende.
         */
        private Node next;

        /**
         * Die vorherige Node. Falls null ist, die Node am Anfang.
         */
        private Node prev;

        /**
         * Der String, der in der Node gespeichert wird.
         */
        String payload;

        public Node(String item) {
            this.payload = item;
            this.next = null;
            this.prev = null;
        }

        /**
         * Fügt eine neue Node vor dieser Node ein.
         *
         * Falls "newNode" null ist, wird ein Error geworfen.
         *
         * @param newNode Die neue Node, die eingefügt werden soll. Darf nicht null sein, ansonsten wird ein Fehler
         *                geworfen.
         */
        public void insert(Node newNode) {
            if (newNode == null) {
                throw new Error("Neue Node darf nicht null sein");
            }

            if (!this.isFirst()) {
                this.prev.next = newNode;
            }

            newNode.prev = this.prev;
            newNode.next = this;
            this.prev = newNode;
        }

        /**
         * Fügt eine neue Node alphabetisch sortiert in die Liste ein.
         *
         * @param newNode Die neue Node, die sortiert eingefügt werden soll.
         */
        public void insertInOrder(Node newNode) {
            int compareToResult = compareTo(newNode);

            if (compareToResult == 0) {
                // If payload is equal nothing should happen.
                return;
            }

            // If is payload is bigger than the new one, we should insert the payload before the current payload.
            if (compareToResult > 0) {
                insert(newNode);
            } else {
                // New payload is bigger than the current payload. If we are at the end of the list, we can append the
                // new payload.
                if (isLast()) {
                    append(newNode);
                } else {
                    // We have to go to the next node.
                    next.insertInOrder(newNode);
                }
            }
        }

        /**
         * Überprüft, ob diese Node die erste Node in der Liste ist. Dies ist der Fall, wenn "prev" null ist.
         *
         * @return Gibt true zurück, falls prev null ist und somit die erste Node in der Liste sein muss. Andernfalls
         * wird false zurückgegeben.
         */
        private boolean isFirst() {
            return prev == null;
        }

        /**
         * Überprüft, ob diese Node die letzte node in der Liste ist. Dies ist der Fall, wenn "next" null ist.
         *
         * @return Gibt true zurück, falls next null ist und somit die letzte Node in der Liste sein muss. Andernfalls
         * wird false zurückgegeben.
         */
        private boolean isLast() {
            return next == null;
        }

        /**
         * Fügt eine neue Node nach dieser Node ein.
         * <p>
         * Falls "newNode" null ist, wird ein Error geworfen.
         *
         * @param newNode Die neue Node, die eingefügt werden. Die neue Node, die eingefügt werden soll. Darf nicht null
         *                sein, ansonsten wird ein Fehler geworfen.
         */
        public void append(Node newNode) {
            if (newNode == null) {
                throw new Error("Neue Node darf nicht null sein");
            }

            this.next = newNode;
            newNode.prev = this;
        }

        /**
         * Entfernt diese Node aus der Liste, indem alle Referenzen (prev & next) aufgehoben werden.
         */
        public void remove() {
            if (!this.isFirst()) {
                this.prev.next = this.next;
            }

            if (!this.isLast()) {
                this.next.prev = this.prev;
            }
        }

        /**
         * Erstellt ab dieser Node und den nächsten Nodes einen String, in dem von jeder Node die .toString-Methode
         * aufgerufen wurde.
         *
         * Aufgabenstellung: Dann definieren Sie eine weitere Methode, die entweder iterativ (d.h. mittels einer
         * Schleife) oder rekursiv die String-Beschreibungen aller Node -Objekte ab dem Ziel-Node-Objekt, zusammenbaut,
         * d.h. sie konkateniert diese Strings, jeweils mit Komma und Leerzeichen voneinander getrennt.
         *
         * @param startNode Die Node, mit der gestartet wird, von allen nächsten Nodes die .toString Methode zusammen zu
         *                  fügen.
         * @return Gibt einen zusammengesetzten String aus allen Node ab der "startNode" zurück.
         */
        public String generateToStringWithAllNodes(Node startNode) {
            return startNode == null ? "" : startNode + "; " + generateToStringWithAllNodes(startNode.next);
        }

        @Override
        public String toString() {
            // Prev & Next darf nicht gemeinsam ausgegeben werden, da ansonsten beim Ausgeben der gesamten Liste zu
            // einer Endlosschleife kommt, weil die 1. Node die 2. Node ausgibt, die wiederum die 1. Node wieder ausgibt.
            return "Node{" + payload + "}";
        }

        /**
         * Compares the payload of two nodes. Copied Documentation from String.compareTo:
         *
         * Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the
         * strings. The character sequence represented by this String object is compared lexicographically to the
         * character sequence represented by the argument string. The result is a negative integer if this String object
         * lexicographically precedes the argument string. The result is a positive integer if this String object
         * lexicographically follows the argument string. The result is zero if the strings are equal; compareTo returns
         * 0 exactly when the equals(Object) method would return true. This is the definition of lexicographic ordering.
         * If two strings are different, then either they have different characters at some index that is a valid index
         * for both strings, or their lengths are different, or both. If they have different characters at one or more
         * index positions, let k be the smallest such index; then the string whose character at position k has the
         * smaller value, as determined by using the < operator, lexicographically precedes the other string. In this
         * case, compareTo returns the difference of the two character values at position k in the two string -- that
         * is, the value: this.charAt(k)-anotherString.charAt(k)
         *
         * If there is no index position at which they differ, then the shorter string lexicographically precedes the
         * longer string. In this case, compareTo returns the difference of the lengths of the strings -- that is, the
         * value: this.length()-anotherString.length()
         *
         * For finer-grained String comparison, refer to java.text.Collator.
         *
         * @param o Node which should be compared
         * @return the value 0 if the argument string is equal to this string; a value less than 0 if this string is
         * lexicographically less than the string argument; and a value greater than 0 if this string is
         * lexicographically greater than the string argument.
         */
        @Override
        public int compareTo(Node o) {
            return payload.compareTo(o.payload);
        }
    }
}