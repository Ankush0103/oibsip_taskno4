import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import java.util.TimerTask;

class OnlineExam extends JFrame implements ActionListener {
    JLabel jLabel1, jLabel2;
    JRadioButton[] jb = new JRadioButton[6];
    JButton jButton1, jButton2;
    ButtonGroup buttonGroup;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    Timer timer;
    ImageIcon ch = new ImageIcon("checked.png");
    OnlineExam(String s) {
        super(s);
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        add(jLabel1);
        add(jLabel2);
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            buttonGroup.add(jb[i]);
        }
        jButton1 = new JButton("Save and Next");
        jButton2 = new JButton("Result");
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        add(jButton1);
        add(jButton2);
        jButton2.setEnabled(false);
        set();
        jLabel1.setBounds(30, 40, 450, 20);
        jLabel2.setBounds(20, 20, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        jButton1.setBounds(100, 240, 140, 30);
        jButton2.setBounds(300, 240, 150, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);

        final int[] timeLeft = {60};
        TimerTask task = new TimerTask() {
            public void run() {

                timeLeft[0]--;
                if(timeLeft[0] >= 1)
                {
                    jLabel2.setText("Time left: " + timeLeft[0] + " sec.");
                } else {
                    jLabel2.setText("Time Out");
                    jButton1.setEnabled(false);
                    jButton2.setEnabled(true);
                }
            }
        };

        java.util.Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButton1) {
            if (check()) {
                count++;
            }
            current++;
            set();
            if (current == 9) {
                jButton1.setEnabled(false);
                jButton2.setEnabled(true);
            }
        }
        if (e.getActionCommand().equals("Result")) {
            set();
            if (current == 9) {
                jButton2.setEnabled(true);
            }
            if(check()) {
                count += 1;
            }
            int c;
            current++;
            if(count==9)
                c = count + 1;
            else
                c=count;
            JOptionPane.showMessageDialog(this,"Score = "+c,   "Marks", JOptionPane.INFORMATION_MESSAGE, ch);
            System.exit(0);

        }

    }

    String[] questions = {
            "Q1. Which component is used to compile, debug and execute the java programs?",
            "Q2. Which of the following is not a primitive data type in Java?",
            "Q3. Arrays in JAVA are-:",
            "Q4. Which of the following is not a valid Java identifier?",
            "Q5. Which exception is thrown when Divide by Zero statement executes?",
            "Q6. Which keyword is used to prevent a variable from being modified in Java?",
            "Q7. Which one of the following is not a Java feature?",
            "Q8. In JAVA byte, short, int and long all of these are?",
            "Q9. Which keyword is used to declare an interface in java?",
            "Q10. In JAVA how a thread is created?"
    };
    String[][] choices = {
            {"JRE","JIT", "JDK", "JVM"},
            {"int", "float", "String", "boolean"},
            {"Objects", "Object References", "Primitive data type", "None of the above"},
            {"myVar", "my_Var", "_Var", "2Var"},
            {"NumberFormatException", "ArithmeticException", "NullPointerException", "None of These"},
            {"const", "final", "static", "None of these"},
            {"Object-Oriented", "Use of Pointers", "Portable", "Dynamic and Extensible"},
            {"signed", "unsigned", "Both of above", "None of these"},
            {"class", "interface", "implements", "abstract"},
            {"Extending the thread class", "Implementing runnable interface", "Both of above", "None of the above"},
    };
    int[] answers = {2, 2, 0, 3, 1, 1,  1, 0, 1, 2};

    void set() {
        jb[4].setSelected(true);
        jLabel1.setText(questions[current]);
        for (int i = 0; i < 4; i++) {
            jb[i].setText(choices[current][i]);
        }
        jLabel1.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) {
            jb[j].setBounds(50, 80 + i, 200, 20);
        }
    }

    boolean check() {
        return jb[answers[current]].isSelected();
    }


}

//Icon Author Atrributes
//<a href="https://www.flaticon.com/free-icons/tick" title="tick icons">Tick icons created by Roundicons - Flaticon</a>
