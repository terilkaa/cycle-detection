public class FloydCycleDetection extends CycleDetectionAlgorithms {
    // initialize a new head for the linked list

    // detect if there is a loop
    // in the linked list
    static int[] detectLoop() {
        Node slowPointer = head,
                fastPointer = head;

        while (slowPointer != null
                && fastPointer != null
                && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                int mu = 0;
                slowPointer = head;
                while (slowPointer != fastPointer) {
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                    mu++;
                }
                int lambda = 1;
                fastPointer = fastPointer.next;
                while (slowPointer != fastPointer) {
                    fastPointer = fastPointer.next;
                    lambda++;
                }
                return new int[]{mu, lambda};
            }

        }
        return new int[]{-1};
    }
}
