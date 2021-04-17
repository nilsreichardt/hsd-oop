public class DoLiString {
    private Node first;
    private Node last;

    public DoLiString() {
        first = null;
        last = null;
    }

    public static void main(String[] args) {
        DoLiString list = new DoLiString();
        System.out.println(list);
    }

    private String generateToStringWithAllNodes() {
        Node currentNode = first;

        StringBuilder s = new StringBuilder();

        while(currentNode != null) {
            // Tennung zwischen den Node, jedoch nicht für das erste Objekt, damit so ein String entsteht: ", Node(...)"
            if(!s.isEmpty()) {
                s.append(", ");
            }

            s.append(currentNode);
            currentNode = currentNode.next;
        }

        return s.toString();
    }

    @Override
    public String toString() {
        return generateToStringWithAllNodes();
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

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", prev=" + prev +
                    ", payload='" + payload + '\'' +
                    '}';
        }
    }
}