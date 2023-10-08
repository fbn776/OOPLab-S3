
class Characters {
    private char[] chars;
    public Characters(char[] c) {
        this.chars = c;
    }
    public int getFreq(char key) {
        int count = 0, i = 0;
        while(this.chars[i] != '\0') {
            if(this.chars[i] == key) {
                count++;
            }
            i++;
        }
        return count;
    }
}

public class CharFreqWithClass {
    public static void main(String[] args) {
        char[] str = {'m', 'a', 'l', 'a', 'y', 'a', 'l', 'a', 'm', '\0'};
        char key = 'a';
        Characters chr = new Characters(str);

        System.out.println("Frequency is " + chr.getFreq(key));
    }
}
