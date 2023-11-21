class Search {
    static int ERROR = -99999;
    static void binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == key) {
                System.out.println("Found element at: " + mid);
                return;
            }

            if(arr[mid] > key) {
                right = mid - 1;
            } else if(arr[mid] < key) {
                left = mid + 1;
            }
        }
        System.out.println("Element not found");
    }
}

public class BinarySearchPgm {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 10, 14, 15};
        Search.binarySearch(arr, -10);
    }
}
