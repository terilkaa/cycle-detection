public class FloydCycleDetection extends CycleDetectionAlgorithms {
    // initialize a new head for the linked list

    // detect if there is a loop
    // in the linked list
    static int[] detectLoop() {
        Node tortoise = head,
                hare = head;

        while (tortoise != null
                && hare != null
                && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                int mu = 0;
                tortoise = head;
                while (tortoise != hare) {
                    tortoise = tortoise.next;
                    hare = hare.next;
                    mu++;
                }
                int lambda = 1;
                hare = hare.next;
                while (tortoise != hare) {
                    hare = hare.next;
                    lambda++;
                }
                return new int[]{mu, lambda};
            }

        }
        return new int[]{-1};
    }
}
