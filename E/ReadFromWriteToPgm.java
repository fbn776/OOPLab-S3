import java.io.*;

public class ReadFromWriteToPgm {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String readFileName = null;
        try {
            System.out.print("Enter file to read from: ");
            readFileName = br.readLine();
            /// Reading section
            FileReader fr = new FileReader(readFileName);
            System.out.println("Reading from file: " + readFileName);

            String readText = "";
            int unit;
            while ((unit = fr.read()) != -1) {
                readText += (char) unit;
            }

            System.out.println("Read: \n" + readText);
            fr.close();

            /// Writing section;
            System.out.print("Enter file to write to: ");
            String writeFileName = br.readLine();

            FileWriter fw = new FileWriter(writeFileName);
            System.out.println("Writing to file: " + writeFileName);
            fw.write(readText);
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + readFileName + " is not found");
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
