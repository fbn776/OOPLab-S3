import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class IntHandler {
    static String readLine() throws IOException {
        System.out.print("Enter line: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    static int[] getIntArr() throws IOException, NumberFormatException {
        String line = readLine();
        StringTokenizer tk = new StringTokenizer(line, " ");
        int[] arr = new int[tk.countTokens()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        return arr;
    }

}

public class IntLineSum {
    public static void main(String[] args) {
        try {
            int[] arr = IntHandler.getIntArr();
            int sum = 0;

            for(int i=0; i<arr.length; i++) {
                System.out.println(arr[i]);
                sum += arr[i];
            }

            System.out.println("Sum is: " + sum);
        } catch (NumberFormatException e) {
            System.out.println("The input list should only contain integers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
