
class PalinCharacters {
    private char[] chars;
    public PalinCharacters(char[] c) {
        this.chars = c;
    }
    private int getLen() {
        int i = 0;
        while(this.chars[i] != '\0') {
            i++;
        }
        return i;
    }

    public int isPalindrome() {
        int left = 0, right = this.getLen() - 1;

        while(left < right) {
            if (this.chars[left] != this.chars[right]) {
                return 0;
            }
            ++left;
            --right;
        }

        return 1;
    }
}


public class PalindromeWithClass {
    public static void main(String[] args) {
        char[] str = {'m', 'a', 'l', 'a', 'y', 'a', 'l', 'a', 'm', '\0'};

        PalinCharacters pln = new PalinCharacters(str);

        if(pln.isPalindrome() == 1)
            System.out.println("The string is a palindrome");
        else
            System.out.println("The string is not a palindrome");
    }
}
