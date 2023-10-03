public class CharFrequency {
    public static void main(String[] args) {
        char[] str = {'m', 'a', 'l', 'a', 'y', 'a', 'l', 'a', 'm', '\0'};
        char key = 'a';
        int len = 0, count = 0;
        while(str[len] != '\0')	len++;

        for(int i=0; i<len; i++)
            if(str[i] == key)
                count++;

        System.out.println("Frequency is " + count);
    }
}
