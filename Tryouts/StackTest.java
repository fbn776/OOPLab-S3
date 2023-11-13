import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        String str = "Hello There";

        for(int i=0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);
        }

        System.out.print("Reversed string is: ");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
