import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Calc extends JFrame implements MouseListener {
    int width = 400;
    int height = 500;
    int btnHeight = (height - 100) / 4;
    int btnWidth = width / 4;

    String[] symbols = {"+", "-", "*", "/"};
    JLabel result;
    float finalResult = 0;
   // int lastNum = -1;

    public Calc() {
        setSize(width + 14, height + 30);
        setLayout(null);
        result = new JLabel("0000");
        result.setBounds(0, 0, width, 100);
        result.setFont(new Font("monospace", 0, 30));
        add(result);

        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = createBtn(String.valueOf(num++), i * btnWidth, 100 + j * btnHeight, btnWidth, btnHeight);
                add(btn);
            }
        }
        int dy = 0;
        for (String i : symbols) {
            add(createBtn(i, 3 * btnWidth, 100 + (dy++) * btnHeight, btnWidth, btnHeight));
        }


        add(createBtn("0", btnWidth, 100 + 3 * btnHeight, btnWidth, btnHeight));
        add(createBtn("=", 2 * btnWidth, 100 + 3 * btnHeight, btnWidth, btnHeight));


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    JButton createBtn(String name, int x, int y, int w, int h) {
        JButton btn = new JButton(name);
        btn.setBounds(x, y, w, h);
        btn.setFont(new Font("monospace", 0, 20));
        btn.addMouseListener(this);

        return btn;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton btn = (JButton) e.getSource();
            String txt = btn.getText();

//            System.out.println("Pressed: " + txt + "\nFinal: " + finalResult + "\nLast: " + lastNum);

            if (txt == "=") {
                result.setText(String.valueOf(finalResult));

                finalResult = 0;
                return;
            }

            if (isOpr(txt)) {
                float lastNum = Float.parseFloat(result.getText());
                System.out.println("Last num: " + lastNum);
                switch (txt) {
                    case "+":
                        finalResult += lastNum;
                        break;
                    case "-":
                        finalResult -= lastNum;
                        break;
                    case "*":
                        finalResult *= lastNum;
                        break;
                    case "/":
                        finalResult /= lastNum;
                        break;

                }
            } else {
                result.setText(txt);
//                int num = Integer.parseInt(txt);
            }
        }
    }


    boolean isOpr(String opr) {
        return (opr == "+" || opr == "-" || opr == "*" || opr == "/");
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}


public class CalcTest {
    public static void main(String[] args) {
        new Calc();
    }
}
