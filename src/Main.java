import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FloydCycleDetection floydDetection = new FloydCycleDetection();
        floydDetection.insert(1);
        floydDetection.insert(2);
        floydDetection.insert(3);
        floydDetection.insert(4);

        // add a loop
        FloydCycleDetection.head.next.next = FloydCycleDetection.head;

        // Detecting cycle using Floyd's Tortoise and Hare algorithm
        int[] result = FloydCycleDetection.detectLoop();
        if (result[0] != -1) {
            System.out.println("Cycle found at node " + result[0] + " with a length of " + result[1]);
        } else {
            System.out.println("No cycle found");
        }

        BrentCycleDetection brentDetection = new BrentCycleDetection();
        brentDetection.insert(1);
        brentDetection.insert(2);
        brentDetection.insert(3);
        brentDetection.insert(4);

        // add a loop
        BrentCycleDetection.head.next.next.next = BrentCycleDetection.head;

        // Detecting cycle using Brent's algorithm
        int[] result2 = BrentCycleDetection.detectLoop();
        if (result2[0] != -1) {
            System.out.println("Cycle found at node " + result2[0] + " with a length of " + result2[1]);
        } else {
            System.out.println("No cycle found");
        }
    }
}