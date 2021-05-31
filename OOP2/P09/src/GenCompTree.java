import java.util.Iterator;
import java.util.Objects;

public class GenCompTree<T extends Comparable<T>> implements Iterable<T> {
    /**
     * A root node is the starting node of tree.
     */
    private Node<T> root;

    public GenCompTree() {}

    public static void main(String[] args) {
        GenCompTree<String> tree = new GenCompTree<>();
        tree.add("07");
        tree.add("04");
        tree.add("15");
        tree.add("02");
        tree.add("06");
        tree.add("05");
        tree.add("03");

        System.out.println("Finds '5' (While-Loop): " + tree.findStringInTreeWhile(tree, "5"));
        System.out.println("Finds '5' (ForEach-Loop):" + tree.findStringInTreeFor(tree, "5"));

        System.out.println();
        System.out.println("---");
        System.out.println();

        GenCompTree<Integer> treeInt = new GenCompTree<>();
        GenCompTree<Studi> treeStudi = new GenCompTree<>();

        treeInt.add(7);
        treeInt.add(4);
        treeInt.add(15);
        treeInt.add(2);
        treeInt.add(6);
        treeInt.add(5);
        treeInt.add(3);

        treeStudi.add(new Studi("07", 7));
        treeStudi.add(new Studi("04", 4));
        treeStudi.add(new Studi("15", 15));
        treeStudi.add(new Studi("02", 2));
        treeStudi.add(new Studi("06", 6));
        treeStudi.add(new Studi("05", 5));
        treeStudi.add(new Studi("03", 3));

        System.out.println("Iterating 'treeInt (While)'");
        treeInt.iterateWithWhile();
        System.out.println("Iterating 'treeInt (ForEach)'");
        treeInt.iterateWithFor();

        System.out.println("Iterating 'treeStudi (While)'");
        treeStudi.iterateWithWhile();
        System.out.println("Iterating 'treeStudi (ForEach)'");
        treeStudi.iterateWithFor();


        // Task 3 d) Es funktioniert gar keine Kobination
        // treeInt.add(new Studi("20", 20));
        // treeStudi.add(20);
    }

    public void iterateWithWhile() {
        Iterator<T> it = this.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void iterateWithFor() {
        for (T t: this) {
            System.out.println(t);
        }
    }

    public boolean findStringInTreeWhile(GenCompTree<String> tree, String searchingString) {
        Iterator<String> it = tree.iterator();
        while (it.hasNext()) {
            final String next = it.next();
            if(next.contains(searchingString)) {
                return true;
            }
        }
        return false;
    }

    public boolean findStringInTreeFor(GenCompTree<String> tree, String searchingString) {
        for (String next : tree) {
            if (next.contains(searchingString)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Wird nur fürs Testing gebraucht.
     * @return Gibt die Root-Payload zurück.
     */
    protected T getRoot() {
        return root.payload;
    }

    public boolean contains(T searchingString) {
        if(isEmpty()) return false;
        Node<T> node = new Node<>(searchingString);
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

    public void add(T addingString) {
        Node<T> node = new Node<>(addingString);

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
    public void remove(T toBeRemovedPayload) {
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
    protected T getSmallestPayload() {
        if(isEmpty()) return null;
        return root.getSmallestSubNode().payload;
    }

    /**
     * Returns the biggest payload of the tree.
     * Note: This method is not mentioned in the task. It was added to test Node.getBiggestSubNode().
     * @return Biggest payload. If tree is is empty, null will be returned
     */
    protected T getBiggestPayload() {
        if(isEmpty()) return null;
        return root.getBiggestSubNode().payload;
    }

    public String toString() {
        return inorder();
    }

    @Override
    public Iterator<T> iterator() {
        return new CompIterator<T>(root);
    }

    static class Node<T extends Comparable<T>> {
        T payload;
        Node<T> smaller;
        Node<T> bigger;

        public Node(T payload) {
            this.payload = payload;
        }

        public Node<T> getSmaller() {
            return smaller;
        }

        public Node<T> getBigger() {
            return bigger;
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

        public void add(Node<T> addingNode) {
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

        public boolean contains(Node<T> searchingNode) {
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

        private Node<T> getSmallestSubNode() {
            if(!hasSmaller()) return this;
            return smaller.getSmallestSubNode();
        }

        private Node<T> getBiggestSubNode() {
            if(!hasBigger()) return this;
            return bigger.getBiggestSubNode();
        }

        private boolean hasSmaller() {
            return smaller != null;
        }

        private boolean hasBigger() {
            return bigger != null;
        }

        private T getPayload() {
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
        private Node<T> remove(T toBeRemovedPayload) {
            int compareResult = toBeRemovedPayload.compareTo(this.payload);

            // Prüfe, ob diese Node (this) entfernt werden soll
            if(compareResult == 0) {
                // Da das Entfernen mit Fallunterscheidung etwas länglich ist,
                // rufen wir dafür eine Methode entfernenMitFallunterscheidung() auf
                // Diese gibtden Knoten zurück, der this ersetzen soll
                Node<T> neu = this.removeWithCases();

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

        private Node<T> removeWithCases() {
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
            if(!hasBigger()) {
                return smaller;
            }


            //Fall 2: beide Nachfolger existieren
            // Ermittle den kleinsten Knoten des größeren Teilbaums
            // Entferne den gefundenen kleinsten Knoten aus dem größeren Teilbaum
            // mit der bereits definierten Methode
            Node<T> smallestNodeInBiggerSubTree = bigger.getSmallestSubNode();
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
        public int hashCode() {
            return Objects.hash(payload, smaller, bigger);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<T> node = (Node<T>) o;
            return Objects.equals(payload, node.payload) && Objects.equals(smaller, node.smaller) && Objects.equals(bigger, node.bigger);
        }
    }

    public static class CompIterator<T extends Comparable<T>> implements Iterator<T> {
        Node<T> next;

        public CompIterator(Node<T> start) {
            this.next = start;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            if(hasNext()) {
                T temp = next.getPayload();
                next = next.getBigger();
                return temp;
            }
            return null;
        }
    }
}
