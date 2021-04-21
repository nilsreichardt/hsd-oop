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
        DoLiString listInsert = new DoLiString();

        System.out.println("Die listInsert, wenn noch kein Element vorhanden ist:");
        System.out.println(listInsert);

        listInsert.insert("Berlin");
        System.out.println("Die listInsert, nachdem das 1. Element hinzugefügt wurde:");
        System.out.println(listInsert);

        listInsert.insert("München");
        System.out.println("Die listInsert, nachdem das 2. Element hinzugefügt wurde:");
        System.out.println(listInsert);

        listInsert.insert("Düsseldorf");
        System.out.println("Die listInsert, nachdem das 3. Element hinzugefügt wurde:");
        System.out.println(listInsert);

        DoLiString listAppend = new DoLiString();

        System.out.println("Die listAppend, wenn noch kein Element vorhanden ist:");
        System.out.println(listAppend);

        listAppend.append("Berlin");
        System.out.println("Die listAppend, nachdem das 1. Element hinzugefügt wurde:");
        System.out.println(listAppend);

        listAppend.append("München");
        System.out.println("Die listAppend, nachdem das 2. Element hinzugefügt wurde:");
        System.out.println(listAppend);

        listAppend.append("Düsseldorf");
        System.out.println("Die listAppend, nachdem das 3. Element hinzugefügt wurde:");
        System.out.println(listAppend);

        System.out.println("Gesucht: " + listAppend.nodeOf("Düsseldorf", listAppend.first).payload);
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
     * Abbruchbedingungen sind folgende:
     * 1. currentNode ist null: Dies bedeutet, dass die Methode am Ende der Liste angelangt und somit der gesuchte
     *    String nicht gefunden wurde.
     * 2. payload von currentNode ist gleich searchingString: Für den gesuchten String wurde die gesuchte Node gefunden.
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
    private class Node {
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
         * <p>
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
         * Überprüft, ob diese Node die erste Node in der Liste ist. Dies ist der Fall, wenn "prev" null ist.
         *
         * @return Gibt true zurück, falls prev null ist und somit die erste Node in der Liste sein muss. Andernfalls
         * wird false zurückgegeben.
         */
        private boolean isFirst() {
            return prev == null;
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
         * Erstellt ab dieser Node und den nächsten Nodes einen String, in dem von jeder Node die .toString-Methode
         * aufgerufen wurde.
         * <p>
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
            return "Node{" +
                    "next=" + next +
                    ", payload='" + payload + '\'' +
                    '}';
        }
    }
}