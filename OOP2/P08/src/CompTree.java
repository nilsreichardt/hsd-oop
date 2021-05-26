import java.util.Objects;

public class CompTree {
    /**
     * A root node is the starting node of tree.
     */
    private Node root;

    public CompTree() {}

    public static void main(String[] args) {
        CompTree tree = new CompTree();

        tree.add("07");
        tree.add("04");
        tree.add("15");
        tree.add("02");
        tree.add("06");
        tree.add("05");
        tree.add("03");
        tree.add("11");
        tree.add("13");
        tree.add("12");

        System.out.println(tree.paint());
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Wird nur fürs Testing gebraucht.
     * @return Gibt die Root-Payload zurück.
     */
    protected Comparable getRoot() {
        return root.payload;
    }

    public boolean contains(String searchingString) {
        if(isEmpty()) return false;
        Node node = new Node(searchingString);
        return root.contains(node);
    }

    /**
     * @return Gibt einen String zurück, wo erst smaller, this, bigger zurückgegeben wird
     */
    protected String inorder() {
        if(isEmpty()) return "";
        return root.inorder();
    }

    /**
     * @return Gibt einen String zurück, wo erst this, smaller, bigger zurückgegeben wird
     */
    protected String preorder() {
        if(isEmpty()) return "";
        return root.preorder();
    }

    /**
     * @return Gibt einen String zurück, wo erst smaller, bigger, this zurückgegeben wird
     */
    protected String postorder() {
        if(isEmpty()) return "";
        return root.postorder();
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

    /**
     * Entfernt einen String aus dem Tree.
     * @param toBeRemovedPayload Der String, der aus dem Tree entfernt wird.
     */
    public void remove(String toBeRemovedPayload) {
        if(isEmpty()) {
            System.out.println(toBeRemovedPayload + " kann nicht enfternt werden, weil die Liste leer ist.");
            return;
        }
        root = root.remove(toBeRemovedPayload);
    }

    /**
     * Returns the smallest payload of the tree.
     * Note: This method is not mentioned in the task. It was added to test Node.getSmallestSubNode().
     * @return Smallest payload. If tree is is empty, null will be returned
     */
    protected Comparable getSmallestPayload() {
        if(isEmpty()) return null;
        return root.getSmallestSubNode().payload;
    }

    /**
     * Returns the biggest payload of the tree.
     * Note: This method is not mentioned in the task. It was added to test Node.getBiggestSubNode().
     * @return Biggest payload. If tree is is empty, null will be returned
     */
    protected Comparable getBiggestPayload() {
        if(isEmpty()) return null;
        return root.getBiggestSubNode().payload;
    }

    public String toString() {
        return inorder();
    }

    class Node {
        Comparable payload;

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

        public String preorder() {
            String string = "";

            string += payload + "_";

            if(hasSmaller()) {
                string += smaller.preorder();
            }

            if(hasBigger()) {
                string += bigger.preorder();
            }

            return string;
        }

        public String postorder() {
            String string = "";

            if(hasSmaller()) {
                string += smaller.postorder();
            }

            if(hasBigger()) {
                string += bigger.postorder();
            }

            string += payload + "_";

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

        private Node getSmallestSubNode() {
            if(!hasSmaller()) return this;
            return smaller.getSmallestSubNode();
        }

        private Node getBiggestSubNode() {
            if(!hasBigger()) return this;
            return bigger.getBiggestSubNode();
        }

        private boolean hasSmaller() {
            return smaller != null;
        }

        private boolean hasBigger() {
            return bigger != null;
        }

        private Comparable getPayload() {
            return payload;
        }

        /** Entfernt einen Knoten aus dem Baum ab diesem Knoten
         *
         * Dazu suchen wir rekursiv im Baum, bis wir den
         * zu entfernenden Knoten (zeK) gefunden haben.
         *
         * Wenn this entfernt wird, wird der Ersatz-Knoten zurückgegeben
         * Wenn this nicht der gesuchte Knoten ist, wird this zurückgegeben
         *
         * @param toBeRemovedPayload die Payload, die aus dem Baum entfernt werden soll
         * @return Knoten, der nach dem Löschen anstelle von this referenziert werden soll
         */
        private Node remove(Comparable toBeRemovedPayload) {
            int compareResult = toBeRemovedPayload.compareTo(this.payload);

            // Prüfe, ob diese Node (this) entfernt werden soll
            if(compareResult == 0) {
                // Da das Entfernen mit Fallunterscheidung etwas länglich ist,
                // rufen wir dafür eine Methode entfernenMitFallunterscheidung() auf
                // Diese gibtden Knoten zurück, der this ersetzen soll
                Node neu = this.removeWithCases();

                // Da this ersetzt werden soll,
                // wird der Ersatz-Knoten an die aufrufende Methode zurückgegeben
                return neu;
            } else {
                // Fall vergleich < 0: this.nutzlast ist kleiner als toBeRemovedPayload
                if(compareResult < 0) {
                    if(hasSmaller()) {
                        // Knoten aus dem kleineren Teilbaum entfernen
                        // -> rekursiver Aufruf von entfernen(s)
                        // Der Rückgabewert ist das (neue) Ziel von kleiner
                        smaller = smaller.remove(toBeRemovedPayload);
                    }
                    // this wurde nicht gelöscht
                } else {
                    // Fall vergleich > 0: this.nutzlast ist größer als toBeRemovedPayload
                    if(hasBigger()) {
                        // Knoten aus dem größeren Teilbaum entfernen
                        // -> rekursiver Aufruf von entfernen(s)
                        // Der Rückgabewert ist das (neue) Zie
                        bigger = bigger.remove(toBeRemovedPayload);
                    }
                    // this wurde nicht entfernt
                }
                return this;
            }
        }

        private Node removeWithCases() {
            // Fall 0: kein Nachfolger
            // ersetze in der aufrufenden Methode die Referenz auf this
            // durch eine Referenz auf null -> gebe null zurück
            if(!hasBigger() && !hasSmaller()) return null;

            // Fall 1a: Nur ein Nachfolger - kleinerer Teilbaum
            // ersetze in der aufrufenden Methode die Referenz auf this
            // durch eine Referenz auf this.kleiner -> gebe this.kleiner zurück
            if(hasBigger() && !hasSmaller()) {
                return bigger;
            }

            // Fall 1b: Nur ein Nachfolger - groesserer Teilbaum
            // ersetze in der aufrufenden Methode die Referenz auf this
            // durch eine Referenz auf this.groesser -> gebe this.groesser zurück
            if(!hasBigger() && hasSmaller()) {
                return smaller;
            }


            //Fall 2: beide Nachfolger existieren
            // Ermittle den kleinsten Knoten des größeren Teilbaums
            // Entferne den gefundenen kleinsten Knoten aus dem größeren Teilbaum
            // mit der bereits definierten Methode
            Node smallestNodeInBiggerSubTree = bigger.getSmallestSubNode();
            this.remove(smallestNodeInBiggerSubTree.getPayload());

            // ersetze nun this durch den kleinsten nachfolger
            // 1) übernehme die Verweise von this in den Ersatz-Knoten kleinster
            smallestNodeInBiggerSubTree.smaller = smaller;
            smallestNodeInBiggerSubTree.bigger = bigger;

            // 2) ersetze in der aufrufenden Methode die Referenz auf this
            // durch eine Referenz auf kleinster -> gebe kleinster zurück
            return smallestNodeInBiggerSubTree;
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
