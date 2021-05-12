import java.util.Objects;

public class StringTree {
    /**
     * A root node is the starting node of tree.
     */
    private Node root;

    public StringTree() {}

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Wird nur fürs Testing gebraucht.
     * @return Gibt die Root-Payload zurück.
     */
    protected String getRoot() {
        return root.payload;
    }

    public boolean contains(String searchingString) {
        if(isEmpty()) return false;
        Node node = new Node(searchingString);
        return root.contains(node);
    }

    private String inorder() {
        if(isEmpty()) return "";
        return root.inorder();
    }

    public void add(String addingString) {
        Node node = new Node(addingString);

        if(isEmpty()) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public String paint() {
        if(isEmpty()) return "";
        return root.paint("");
    }

    public String toString() {
        return inorder();
    }

    class Node {
        String payload;

        Node smaller;
        Node bigger;

        public Node(String payload) {
            this.payload = payload;
        }

        public String inorder() {
            String string = "";

            if(hasSmaller()) {
                string += smaller.inorder();
            }

            string += payload + "_";

            if(hasBigger()) {
                string += bigger.inorder();
            }

            return string;
        }

        public String paint(String currentString) {
            String string = "";
            if(hasBigger()) {
                string += bigger.paint(currentString + "\t");
            }

            string += currentString + payload + "\n";

            if(hasSmaller()) {
                string += smaller.paint(currentString + "\t");
            }

            return string;
        }

        public void add(Node addingNode) {
            final int compareResult = addingNode.payload.compareTo(payload);
            if(compareResult == 0) {
                // The case if two payloads are equal will not be treated.
                return;
            }

            if(compareResult > 0) {
                if(hasBigger()) {
                    bigger.add(addingNode);
                } else {
                    bigger = addingNode;
                }
            } else {
                if(hasSmaller()) {
                    smaller.add(addingNode);
                } else {
                    smaller = addingNode;
                }
            }
        }

        public boolean contains(Node searchingNode) {
            final int compareResult = payload.compareTo(searchingNode.payload);
            if(compareResult == 0) {
                return true;
            }

            if(compareResult > 0) {
                if(hasSmaller()) {
                    return smaller.contains(searchingNode);
                }
            } else {
                if(hasBigger()) {
                    return bigger.contains(searchingNode);
                }
            }

            return false;
        }

        private boolean hasSmaller() {
            return smaller != null;
        }

        private boolean hasBigger() {
            return bigger != null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(payload, node.payload) && Objects.equals(smaller, node.smaller) && Objects.equals(bigger, node.bigger);
        }

        @Override
        public int hashCode() {
            return Objects.hash(payload, smaller, bigger);
        }
    }
}
