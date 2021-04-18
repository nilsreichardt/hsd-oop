public class DoLiString {
    private Node first;
    private Node last;

    public DoLiString() {
        first = null;
        last = null;
    }

    public static void main(String[] args) {
//        DoLiString list = new DoLiString();
//
//        System.out.println("Die Liste, wenn noch kein Element vorhanden ist:");
//        System.out.println(list);
//
//        list.insert("Berlin");
//        System.out.println("Die Liste, nachdem das 1. Element hinzugefügt wurde:");
//        System.out.println(list);
//
//        list.insert("München");
//        System.out.println("Die Liste, nachdem das 2. Element hinzugefügt wurde:");
//        System.out.println(list);
//
//        list.insert("Düsseldorf");
//        System.out.println("Die Liste, nachdem das 3. Element hinzugefügt wurde:");
//        System.out.println(list);

        DoLiString list = new DoLiString();

        System.out.println("Die Liste, wenn noch kein Element vorhanden ist:");
        System.out.println(list);

        list.append("Berlin");
        System.out.println("Die Liste, nachdem das 1. Element hinzugefügt wurde:");
        System.out.println(list);

        list.append("München");
        System.out.println("Die Liste, nachdem das 2. Element hinzugefügt wurde:");
        System.out.println(list);

        list.append("Düsseldorf");
        System.out.println("Die Liste, nachdem das 3. Element hinzugefügt wurde:");
        System.out.println(list);
    }

    /**
     * Fügt einen neuen String in die Liste am Anfang ein.
     *
     * @param payload Der String, der zu Liste hinzugefügt werden soll.
     */
    public void insert(String payload) {
        Node node = new Node(payload);

        if (first != null) {
            first.insert(node);
        }
        first = node;

        if (last == null) {
            last = node;
        }
    }

    public void append(String payload) {
        Node node = new Node(payload);

        if (last != null) {
            last.append(node);
        }
        last = node;

        if (first == null) {
            first = node;
        }
    }

    @Override
    public String toString() {
        if(first == null) return "DoLiString:";
        return "DoLiString:" + first.generateToStringWithAllNodes(first);
    }

    private class Node {
        private Node next;
        private Node prev;

        String payload;

        public Node(String item) {
            this.payload = item;
            next = null;
            prev = null;
        }

        /**
         * Fügt eine neue Node vor dieser Node ein.
         *
         * @param newNode Die neue Node, die eingefügt werden soll. Darf nicht null sein, ansonsten wird ein Fehler
         *                geworfen.
         */
        public void insert(Node newNode) {
            if (newNode == null) {
                throw new Error("Neue Node darf nicht null sein");
            }

            newNode.prev = this.prev;

            if (newNode.prev != null) {
                newNode.prev.next = newNode;
            }

            newNode.next = this;
            this.prev = newNode;
        }

        /**
         * Fügt eine neue Node nach dieser Node ein.
         *
         * @param newNode
         */
        public void append(Node newNode) {
            if (newNode == null) {
                throw new Error("Neue Node darf nicht null sein");
            }

            this.next = newNode;
            newNode.prev = this;
        }

        public String generateToStringWithAllNodes(Node newNode) {
            if(newNode == null) return "";
            return newNode.toString() + ", " + generateToStringWithAllNodes(newNode.next);
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