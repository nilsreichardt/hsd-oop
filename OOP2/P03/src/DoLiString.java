import java.util.Iterator;
import java.lang.Iterable;
import java.util.NoSuchElementException;

/**
 * Eine doppelt verkettete Liste, die nur Daten von dem Datentyp "String" speichern kann (nicht generisch).
 */
public class DoLiString implements Iterable<String> {
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
        // Task 3 a)
//        DoLiString list = new DoLiString();
//        Iterator iterator = list.iterator();
//        for (int i = 0; i < 5; i++) {
//            iterator.next();
//        }

        // Task 3 b)
        DoLiString list = new DoLiString();
        list.append("Düsseldorf");
        list.append("Berlin");
        list.append("Siegen");
        list.append("München");
        list.append("Köln");
        list.append("Duisburg");
        list.append("Dortmund");
        list.append("Kiel");
        Iterator iterator = list.iterator();

//        for (Object payload : list) {
//            System.out.println(payload);
//        }
//
//        System.out.println("");
//
//        iterator = list.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        iterator.next();
//        iterator.next();

        DoLiString list2 = new DoLiString();
        list2.append("Peter");
        list2.append("Günter");
        list2.append("Herbert");

        Iterator iterator2 = list2.iterator();

        while(iterator.hasNext() || iterator2.hasNext()) {
            if(iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }

            if(iterator2.hasNext()) {
                System.out.println(iterator2.next().toString());
            }
        }
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
     * 1. currentNode ist null: Dies bedeutet, dass die Methode am Ende der Liste
     * angelangt und somit der gesuchte String nicht gefunden wurde.
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
     * Entfernt den angegebenen String aus der List.
     *
     * @param searchingString
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

        // while-Schleife
//        Iterator iterator = iterator();
//        String string = iterator.next().toString();
//        while (iterator.hasNext()) {
//            string += "," + iterator.next().toString();
//        }

        // forEach-Schleife
        Iterator iterator = iterator();
        String string = "";
        for (String payload: this) {
            string += "," + payload.toString();
        }

        return "DoLiString:" + string;
    }

    @Override
    public Iterator<String> iterator() {
        return new DoLiIterator(first);
    }

    /**
     * Der Knoten, der die Payload, also den String speichert.
     */
    class Node {
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
         * @return Gibt die nächste Node zurück, kann auch null sein.
         */
        public Node next() {
            return next;
        }

        /**
         * @return Gibt die Payload der Node an, kann auch null sein.
         */
        public String getPayload() {
            return payload;
        }

        @Override
        public String toString() {
            // Prev & Next darf nicht gemeinsam ausgegeben werden, da ansonsten beim Ausgeben der gesamten Liste zu
            // einer Endlosschleife kommt, weil die 1. Node die 2. Node ausgibt, die wiederum die 1. Node wieder ausgibt.
            return "Node{" + payload + "}";
        }
    }

    private class DoLiIterator implements Iterator<String> {
        /**
         * Die nächste Node der DoLiString Klasse.
         */
        Node current;

        /**
         * Construktor der DoLiIterator Klasse.
         * @param current Gibt den nächsten Knoten der Liste an. Sollte bei der Übergabe der erste Knoten der Liste sein.
         */
        public DoLiIterator(Node current) {
            this.current = current;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #current} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != null && current.next() != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public String next() {
            if(hasNext()) {
                String payload = current.getPayload();
                current = current.next();
                return payload;
            }
            return null;
        }
    }
}