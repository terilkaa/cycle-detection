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

        for (int i = 0; i < 16; i++) {
            insert(i);
        }

        head.next.next.next.next.next.next.next.next.next.next.next.next.next = head.next.next;

        int[] result = detectLoop();
        System.out.println("Brent's Cycle Detection Algorithm");
        if (result[0] != -1) {
            System.out.println("Cycle found at node " + result[0] + " with a length of " + result[1]);
        } else {
            System.out.println("No cycle found");
        }
    }
}

