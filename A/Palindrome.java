class Palindrome {
	public static void main(String[] args) {
		char[] str = {'m', 'a', 'l', 'a', 'y', 'a', 'l', 'a', 'm', '\0'};
		int len = 0, left = 0, right, isPalindrome = 1;
		while(str[len] != '\0')	len++;
		right = len - 1;

		while(left < right) {
			if (str[left] != str[right]) {
				isPalindrome = 0;
				break;
			}
			++left;
			--right;
		}

		if(isPalindrome == 1)
			System.out.println("The string is a palindrome");
		else
			System.out.println("The string is not a palindrome");
	}
}
