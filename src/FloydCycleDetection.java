public class FloydCycleDetection extends CycleDetectionAlgorithms {
    static int[] detectLoop() {
        Node tortoise = head,
                hare = head;

        while (tortoise != null && hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                int start = 0;
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

        for (int i = 0; i < 16; i++) {
            insert(i);
        }

        head.next.next.next.next.next.next.next.next.next.next.next.next.next = head.next.next;

        int[] result = detectLoop();
        System.out.println("Floyd's Cycle Detection Algorithm");
        if (result[0] != -1) {
            System.out.println("Cycle found at node " + result[0] + " with a length of " + result[1]);
        } else {
            System.out.println("No cycle found");
        }
    }
}
