import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    static int width = 400;
    static int height = 500;
    final static int btnWidth = width / 4;
    final static int btnHeight = (height - 100) / 4;


    public static void main(String[] main) {
        width += 14;
        height += 37;

        JFrame frame = new JFrame("Calculator");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel resultCont = new JLabel("000000");
        resultCont.setHorizontalAlignment(JLabel.RIGHT);
        resultCont.setVisible(true);
        resultCont.setBounds(0, 0, width - 14, 100);
        resultCont.setBackground(Color.LIGHT_GRAY);
        resultCont.setOpaque(true);

        int num = 1;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                frame.add(createButton(String.valueOf(num++), i * btnWidth, 100 + (j * btnHeight), btnWidth, btnHeight));
            }
        }

        frame.add(createButton("0", btnWidth, 100 + (3 * btnHeight), btnWidth, btnHeight));

        String[] operators = {"+", "-", "*", "/"};
        int j = 0;
        for(String i : operators) {
            frame.add(createButton(i, btnWidth * 3, 100 + (j * btnHeight), btnWidth, btnHeight));
            j++;
        }

        frame.add(createButton("=", btnWidth * 2, 100 + (3 * btnHeight), btnWidth, btnHeight));


        frame.add(resultCont);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    public static JButton createButton(String text, int x, int y, int width, int height) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, width, height);
        btn.setFont(new Font("monospace", Font.PLAIN, 20));
        return btn;
    }
}
