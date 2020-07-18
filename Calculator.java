import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator {
    static JTextField textField;
    JFrame frame;
    JPanel panel;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton button0;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonDivide;
    JButton buttonMultiply;
    JButton buttonEqual;
    JButton buttonReset;
    JButton buttonDot;
    double number1;
    double number2;
    double result;
    String textNumber1;


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setGui();

    }

    public void setGui() {
        this.frame = new JFrame("Calculator");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.panel = new JPanel();

        this.panel.setBackground(Color.GRAY);

        textField = new JTextField();

        this.buttonPlus = new JButton("+");
        buttonPlus.addActionListener(new MyButtonPlusListener());
        this.buttonMinus = new JButton("-");
        buttonMinus.addActionListener(new MyButtonMinusListener());
        this.buttonMultiply = new JButton("*");
        buttonMultiply.addActionListener(new MyButtonMultiplyListener());
        this.buttonDivide = new JButton("/ ");
        buttonDivide.addActionListener(new MyButtonDivideListener());
        this.button1 = new JButton("1");
        button1.addActionListener(new MyButton1Listener());
        this.button2 = new JButton("2");
        button2.addActionListener(new MyButton2Listener());
        this.button3 = new JButton("3");
        button3.addActionListener(new MyButton3Listener());
        this.button4 = new JButton("4");
        button4.addActionListener(new MyButton4Listener());
        this.button5 = new JButton("5");
        button5.addActionListener(new MyButton5Listener());
        this.button6 = new JButton("6");
        button6.addActionListener(new MyButton6Listener());
        this.button7 = new JButton("7");
        button7.addActionListener(new MyButton7Listener());
        this.button8 = new JButton("8");
        button8.addActionListener(new MyButton8Listener());
        this.button9 = new JButton("9");
        button9.addActionListener(new MyButton9Listener());
        this.buttonReset = new JButton("C");
        buttonReset.addActionListener(new MyButtonResetListener());
        this.buttonEqual = new JButton("=");
        buttonEqual.addActionListener(new MyButtonEqualListener());
        this.button0 = new JButton("0");
        button0.addActionListener(new MyButton0Listener());
        this.buttonDot = new JButton(".");
        buttonDot.addActionListener(new MyButtonDotListener());

        this.number1 = 0;
        this.number2 = 0;
        this.result = 0;
        this.textNumber1 = " ";

        this.textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Calculator.textField.getText().contains("+") && !Calculator.textField.getText().contains("-") &&
                        !Calculator.textField.getText().contains("*") && !Calculator.textField.getText().contains("/")) {
                    char c = e.getKeyChar();
                    if (((c < '0') || (c > '9'))) { //разрешаю вводить только цифры. все знаки воодить толко кнопками
                        e.consume();
                    }
                } else {
                    Calculator.this.textNumber1 = Calculator.textField.getText();
                    Calculator.textField.setText("");
                }
            }
        });

        frame.add(textField, BorderLayout.NORTH);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonPlus);
        panel.add(button0);
        panel.add(buttonMinus);
        panel.add(buttonMultiply);
        panel.add(buttonDivide);
        panel.add(buttonEqual);
        panel.add(buttonReset);
        panel.add(buttonDot);

        frame.add(panel);

        this.frame.setBounds(200, 100, 180, 280);
        this.frame.setVisible(true);

    }


    public class MyButtonEqualListener implements ActionListener {
        public MyButtonEqualListener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") && !Calculator.textField.getText().contains("-") &&
                    !Calculator.textField.getText().contains("*") && !Calculator.textField.getText().contains("/")) {

                String textNumber = Calculator.textField.getText();
                Calculator.this.number2 = Double.parseDouble(textNumber);
                if (Calculator.this.textNumber1.contains("+")) {
                    Calculator.this.result = Calculator.this.number1 + Calculator.this.number2;
                    Calculator.textField.setText(result + "");
                } else if (Calculator.this.textNumber1.contains("-")) {
                    Calculator.this.result = Calculator.this.number1 - Calculator.this.number2;
                    Calculator.textField.setText(result + "");
                } else if (Calculator.this.textNumber1.contains("*")) {
                    Calculator.this.result = Calculator.this.number1 * Calculator.this.number2;
                    Calculator.textField.setText(result + "");
                } else if (Calculator.this.textNumber1.contains("/")) {
                    if (Calculator.this.number2 != 0) {
                        Calculator.this.result = Calculator.this.number1 / Calculator.this.number2;
                        Calculator.textField.setText(result + "");
                    } else {
                        Calculator.textField.setText("divide by zero");
                    }
                }
            } else {
                Calculator.textField.setText(Calculator.textField.getText());
            }
        }
    }

    public class MyButtonPlusListener implements ActionListener {
        public MyButtonPlusListener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") && !Calculator.textField.getText().contains("-") &&
                    !Calculator.textField.getText().contains("*") && !Calculator.textField.getText().contains("/")) {
                String textNumber = Calculator.textField.getText();
                Calculator.textField.setText(Calculator.textField.getText() + "+");
                Calculator.this.textNumber1 = Calculator.textField.getText();
                Calculator.this.number1 = Double.parseDouble(textNumber);
                Calculator.textField.requestFocus();
            }
        }

    }

    public class MyButtonMinusListener implements ActionListener {
        public MyButtonMinusListener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") && !Calculator.textField.getText().contains("-") &&
                    !Calculator.textField.getText().contains("*") && !Calculator.textField.getText().contains("/")) {
                String textNumber = Calculator.textField.getText();
                Calculator.textField.setText(Calculator.textField.getText() + "-");
                Calculator.this.textNumber1 = Calculator.textField.getText();
                Calculator.this.number1 = Double.parseDouble(textNumber);
            } else if (Calculator.textField.getText().isEmpty()) {
                Calculator.this.number1 = 0;
                Calculator.this.textNumber1 = "-";
                Calculator.textField.setText("-");
            }
            Calculator.textField.requestFocus();
        }

    }

    public class MyButtonMultiplyListener implements ActionListener {
        public MyButtonMultiplyListener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") && !Calculator.textField.getText().contains("-") &&
                    !Calculator.textField.getText().contains("*") && !Calculator.textField.getText().contains("/")) {
                String textNumber = Calculator.textField.getText();
                Calculator.textField.setText(Calculator.textField.getText() + "*");
                Calculator.this.textNumber1 = Calculator.textField.getText();
                Calculator.this.number1 = Double.parseDouble(textNumber);
                Calculator.textField.requestFocus();
            }
        }

    }

    public class MyButtonDivideListener implements ActionListener {
        public MyButtonDivideListener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") && !Calculator.textField.getText().contains("-") &&
                    !Calculator.textField.getText().contains("*") && !Calculator.textField.getText().contains("/")) {
                String textNumber = Calculator.textField.getText();
                Calculator.textField.setText(Calculator.textField.getText() + "/");
                Calculator.this.textNumber1 = Calculator.textField.getText();
                Calculator.this.number1 = Double.parseDouble(textNumber);
                Calculator.textField.requestFocus();
            }
        }

    }

    public class MyButton1Listener implements ActionListener {
        public MyButton1Listener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") &&
                    !Calculator.textField.getText().contains("-") && !Calculator.textField.getText().contains("*") &&
                    !Calculator.textField.getText().contains("/")) {
                Calculator.textField.setText(Calculator.textField.getText() + "1");
            } else {
                Calculator.textField.setText("");
                Calculator.textField.setText("1");
            }
        }
    }

    public class MyButton2Listener implements ActionListener {
        public MyButton2Listener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") &&
                    !Calculator.textField.getText().contains("-") && !Calculator.textField.getText().contains("*") &&
                    !Calculator.textField.getText().contains("/")) {
                Calculator.textField.setText(Calculator.textField.getText() + "2");
            } else {
                Calculator.textField.setText("");
                Calculator.textField.setText("2");
            }
        }
    }

    public class MyButton3Listener implements ActionListener {
        public MyButton3Listener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") &&
                    !Calculator.textField.getText().contains("-") && !Calculator.textField.getText().contains("*") &&
                    !Calculator.textField.getText().contains("/")) {
                Calculator.textField.setText(Calculator.textField.getText() + "3");
            } else {
                Calculator.textField.setText("");
                Calculator.textField.setText("3");
            }
        }
    }

    public class MyButton4Listener implements ActionListener {
        public MyButton4Listener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") &&
                    !Calculator.textField.getText().contains("-") && !Calculator.textField.getText().contains("*") &&
                    !Calculator.textField.getText().contains("/")) {
                Calculator.textField.setText(Calculator.textField.getText() + "4");
            } else {
                Calculator.textField.setText("");
                Calculator.textField.setText("4");
            }
        }
    }

    public class MyButton5Listener implements ActionListener {
        public MyButton5Listener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") &&
                    !Calculator.textField.getText().contains("-") && !Calculator.textField.getText().contains("*") &&
                    !Calculator.textField.getText().contains("/")) {
                Calculator.textField.setText(Calculator.textField.getText() + "5");
            } else {
                Calculator.textField.setText("");
                Calculator.textField.setText("5");
            }
        }
    }

    public class MyButton6Listener implements ActionListener {
        public MyButton6Listener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") &&
                    !Calculator.textField.getText().contains("-") && !Calculator.textField.getText().contains("*") &&
                    !Calculator.textField.getText().contains("/")) {
                Calculator.textField.setText(Calculator.textField.getText() + "6");
            } else {
                Calculator.textField.setText("");
                Calculator.textField.setText("6");
            }
        }
    }

    public class MyButton7Listener implements ActionListener {
        public MyButton7Listener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") &&
                    !Calculator.textField.getText().contains("-") && !Calculator.textField.getText().contains("*") &&
                    !Calculator.textField.getText().contains("/")) {
                Calculator.textField.setText(Calculator.textField.getText() + "7");
            } else {
                Calculator.textField.setText("");
                Calculator.textField.setText("7");
            }
        }
    }

    public class MyButton8Listener implements ActionListener {
        public MyButton8Listener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") &&
                    !Calculator.textField.getText().contains("-") && !Calculator.textField.getText().contains("*") &&
                    !Calculator.textField.getText().contains("/")) {
                Calculator.textField.setText(Calculator.textField.getText() + "8");
            } else {
                Calculator.textField.setText("");
                Calculator.textField.setText("8");
            }
        }
    }

    public class MyButton9Listener implements ActionListener {
        public MyButton9Listener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") &&
                    !Calculator.textField.getText().contains("-") && !Calculator.textField.getText().contains("*") &&
                    !Calculator.textField.getText().contains("/")) {
                Calculator.textField.setText(Calculator.textField.getText() + "9");
            } else {
                Calculator.textField.setText("");
                Calculator.textField.setText("9");
            }
        }
    }

    public class MyButton0Listener implements ActionListener {
        public MyButton0Listener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") &&
                    !Calculator.textField.getText().contains("-") && !Calculator.textField.getText().contains("*") &&
                    !Calculator.textField.getText().contains("/")) {
                Calculator.textField.setText(Calculator.textField.getText() + "0");
            } else {
                Calculator.textField.setText("");
                Calculator.textField.setText("0");
            }
        }
    }

    public class MyButtonResetListener implements ActionListener {
        public MyButtonResetListener() {
        }

        public void actionPerformed(ActionEvent a) {
            Calculator.textField.setText("");
            Calculator.this.number1 = 0;
            Calculator.textField.requestFocus();
        }
    }

    public class MyButtonDotListener implements ActionListener {
        public MyButtonDotListener() {
        }

        public void actionPerformed(ActionEvent a) {
            if (!Calculator.textField.getText().isEmpty() && !Calculator.textField.getText().contains("+") &&
                    !Calculator.textField.getText().contains("-") && !Calculator.textField.getText().contains("*") &&
                    !Calculator.textField.getText().contains("/") && !Calculator.textField.getText().contains(".")) {
                Calculator.textField.setText(Calculator.textField.getText() + ".");

            } else if (Calculator.textField.getText().isEmpty()) {
                Calculator.textField.setText("0.");
            }
            Calculator.textField.requestFocus();
        }
    }
}
