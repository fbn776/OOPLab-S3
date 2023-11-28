import javax.swing.*;
import java.awt.event.*;

public class Assignment4SwingUserInput {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Form");
        frame.setLayout(null);

        JLabel label;

        label = new JLabel("User name: ");
        label.setBounds(10, 10, 100, 40);
        frame.add(label);

        JTextField username = new JTextField();
        username.setBounds(10 + 100 + 2, 10, 300, 40);

        label = new JLabel("Password: ");
        label.setBounds(10, 60, 100, 40);
        frame.add(label);

        JTextField password = new JPasswordField();
        password.setBounds(10 + 100 + 2, 60, 300, 40);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(100, 200, 100, 50);
        JButton submit = new JButton("Submit");
        submit.setBounds(250, 200, 100, 50);

        cancel.addActionListener(e -> {
            if(e.getActionCommand() == "Cancel") {
                System.out.println("Canceling");
                System.exit(0);
            };
        });

        submit.addActionListener(e -> {
            if(e.getActionCommand() == "Submit") {
                JDialog d = new JDialog();
                JLabel l = new JLabel("Hello " + username.getText());
                d.add(l);
                l.setBounds(20, 10, 100, 50);
                d.setBounds(100, 100,200, 100);
                d.setVisible(true);
            };
        });

        frame.add(username);
        frame.add(password);
        frame.add(cancel);
        frame.add(submit);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
