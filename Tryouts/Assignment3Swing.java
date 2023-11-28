import javax.swing.*;
import java.awt.event.*;

public class Assignment3Swing {
    public static void main(String[] main) {
        JFrame frame = new JFrame("Sample window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing window");
                System.exit(0);
            }
        });

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
