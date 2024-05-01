public class BrentCycleDetection extends CycleDetectionAlgorithms {

    /* This function detects loop in the list
    If loop was there in the list then it returns,
    the first node of loop otherwise returns null */
    static int[] detectLoop() {
        // Initialize variables
        int power = 1;
        int lam = 1;
        Node tortoise = head;
        Node hare = head.next; // Adjusted from f(head)

        // Main loop to detect cycle
        while (tortoise != hare) {
            if (power == lam) {
                tortoise = hare;
                power *= 2;
                lam = 0;
            }
            hare = hare.next; // Adjusted from f(hare)
            lam++;
        }

        // Find the position of the first repetition of length λ
        tortoise = hare = head;
        for (int i = 0; i < lam; i++) {
            hare = hare.next; // Adjusted from f(hare)
        }

        // The distance between the hare and tortoise is now λ.

        // Next, the hare and tortoise move at the same speed until they agree
        int mu = 0;
        while (tortoise != hare) {
            tortoise = tortoise.next; // Adjusted from f(tortoise)
            hare = hare.next; // Adjusted from f(hare)
            mu++;
        }

        return new int[]{mu, lam};
    }
}