import java.util.ArrayList;
import java.util.List;
public abstract class CycleDetectionAlgorithms {
    static class Node {
        int data;
        Node next;
        List<Node> edges; // Seznam hran

        Node(int data) {
            this.data = data;
            next = null;
            edges = new ArrayList<>(); // Inicializace seznamu hran
        }
    }

    protected static Node head = null;

    // Insert a new value at the start of the linked list
    protected void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Metoda pro vložení hrany mezi uzly
    protected void insertEdge(int from, int to) {
        Node fromNode = findNode(from);
        Node toNode = findNode(to);
        if (fromNode != null && toNode != null) {
            // Vložení hrany z "fromNode" do "toNode"
            fromNode.edges.add(toNode);
        } else {
            System.out.println("Chyba: Jeden nebo oba uzly neexistují.");
        }
    }

    // Metoda pro nalezení uzlu podle hodnoty
    protected Node findNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }
        return null; // Pokud uzel není nalezen
    }
}
