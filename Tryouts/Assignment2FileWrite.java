import java.io.*;
import java.util.StringTokenizer;

public class Assignment2FileWrite {
    public static void main(String[] args) {
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("MyFile.txt"));
            String text = "This is the University Exam for OODP. This a program to illustrate the use of files.";

            StringTokenizer tk = new StringTokenizer(text, ".");
            while(tk.hasMoreTokens()) {
                fw.write(tk.nextToken());
                fw.newLine();
            }
            fw.close();
        } catch (IOException e) {
        }
    }
}
