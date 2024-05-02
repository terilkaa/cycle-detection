public class FloydCycleDetection extends CycleDetectionAlgorithms {

    static int[] detectLoop() {
        Node tortoise = head,
                hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                int start = 1;
                int mu = 0;
                tortoise = head;
                while (tortoise != hare) {
                    tortoise = tortoise.next;
                    hare = hare.next;
                    mu++;
                }
                start = hare.data;
                return new int[]{mu, start};
            }

        }
        return new int[]{-1};
    }

    public static void main(String[] args) {

        head = new Node(0);
        Node current = head;
        for (int i = 1; i < 16; i++) {
            current.next = new Node(i);
            current = current.next;
        }

        // Creating a cycle starting from the second node with a length of 14 nodes
        Node cycleStart = head.next;
        for (int i = 0; i < 13; i++) {
            cycleStart = cycleStart.next;
        }
        current.next = cycleStart;

        int[] result = detectLoop();
        System.out.println("Floyd's Cycle Detection Algorithm");
        if (result[0] != -1) {
            System.out.println("Cycle found at node " + result[1] + " with a length of " + result[0]);
        } else {
            System.out.println("No cycle found");
        }
    }
}
