public class BrentCycleDetection extends CycleDetectionAlgorithms {

    static int[] detectLoop() {
        Node tortoise = head;
        Node hare = head.next;
        int power = 1;
        int lam = 1;
        while (hare != null && hare.next != null) {
            while (tortoise != hare) {
                if (power == lam) {
                    tortoise = hare;
                    power *= 2;
                    lam = 0;
                }
                hare = hare.next;
                lam++;
            }
            tortoise = hare = head;
            for (int i = 0; i < lam; i++) {
                hare = hare.next;
            }
            int mu = 0;
            while (tortoise != hare) {
                tortoise = tortoise.next;
                hare = hare.next;
                mu++;
            }
            return new int[]{mu, lam};
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

