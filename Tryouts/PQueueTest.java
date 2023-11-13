import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PQueueTest {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        System.out.print("Number of elements: ");
        int n = scn.nextInt();

        System.out.print("Enter numbers: ");
        for (int i = 0; i < n; i++) {
            pq.add(scn.nextInt());
        }

        System.out.println("Number with most priority: " + pq.remove());
    }
}
