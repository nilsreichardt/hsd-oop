public class DoLiString {
    private Node first;
    private Node last;

    public DoLiString() {
        first = null;
        last = null;
    }

    private class Node {
        private Node next;
        private Node prev;

        String item;

        public Node(String item) {
            this.item = item;
            next = null;
            prev = null;
        }
    }
}