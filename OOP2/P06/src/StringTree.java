public class StringTree {
    /**
     * A root node is the starting node of tree.
     */
    private Node root;

    public StringTree() {}

    public boolean isEmpty() {
        return root == null;
    }

    class Node {
        Node smaller;
        Node bigger;

        public Node(Node smaller, Node bigger) {
            this.smaller = smaller;
            this.bigger = bigger;
        }
    }
}
