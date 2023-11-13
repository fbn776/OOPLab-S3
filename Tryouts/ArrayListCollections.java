import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListCollections {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.print("Enter n: ");
        int n = scn.nextInt();

        System.out.print("Enter numbers: ");
        for(int i = 0; i < n; i++) {
            arr.add(scn.nextInt());
        }

        System.out.print("Array list is: ");
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}
