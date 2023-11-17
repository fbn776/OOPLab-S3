import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlingPgm {
    public static void main(String[] args) {
        String fileName = "test.txt";
        String writeText = "Hello there, how are you?";

        try {
            FileWriter fw = new FileWriter(fileName);
            FileReader fr = new FileReader(fileName);

            System.out.println("Writing to file: " + fileName);
            fw.write(writeText);
            fw.close();

            System.out.println("Reading from file: " + fileName);
            int unit;
            while((unit = fr.read()) != -1) {
                System.out.print((char) unit);
            }
            System.out.println("\nFile read");
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
