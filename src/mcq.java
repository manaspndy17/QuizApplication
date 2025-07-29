import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mcq extends JFrame implements ActionListener {

    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];

    JLabel qn, quo;
    JRadioButton op1, op2, op3, op4;

    JButton next, L, Submit;

    public static int timer = 15;
    public static int count = 0;
    public static int score = 0;
    public static int flag = 0;

    String userAns[][] = new String[10][2];
    ButtonGroup groupOp;

    String Name;

    mcq(String Name) {

        this.Name = Name;

        setBounds(50, 0, 1440, 850);
         getContentPane().setBackground(Color.white);
        

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banner.jpg"));
        Image image = i1.getImage().getScaledInstance(1440, 300, Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(image);
        JLabel banner = new JLabel(img);
        banner.setBounds(0, 0, 1440, 350);
        add(banner);

        qn = new JLabel();
        qn.setBounds(30, 200, 50, 500);
        qn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(qn);

        quo = new JLabel();
        quo.setBounds(80, 200, 900, 500);
        quo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(quo);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        op1 = new JRadioButton();
        op1.setBounds(100, 520, 900, 20);
        op1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        op1.setBackground(Color.white);
        add(op1);

        op2 = new JRadioButton();
        op2.setBounds(100, 560, 900, 20);
        op2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        op2.setBackground(Color.white);
        add(op2);

        op3 = new JRadioButton();
        op3.setBounds(100, 600, 900, 20);
        op3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        op3.setBackground(Color.white);
        add(op3);

        op4 = new JRadioButton();
        op4.setBounds(100, 640, 900, 20);
        op4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        op4.setBackground(Color.white);
        add(op4);

        groupOp = new ButtonGroup();
        groupOp.add(op1);
        groupOp.add(op2);
        groupOp.add(op3);
        groupOp.add(op4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Times New Roman", Font.BOLD, 30));
        next.addActionListener(this);
        add(next);

        L = new JButton("50-50");
        L.setBounds(1100, 610, 200, 40);
        L.setBackground(Color.BLACK);
        L.setForeground(Color.WHITE);
        L.setFont(new Font("Times New Roman", Font.BOLD, 30));
        L.addActionListener(this);
        add(L);

        Submit = new JButton("Submit");
        Submit.setBounds(1100, 670, 200, 40);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Submit.addActionListener(this);
        add(Submit);
        Submit.setEnabled(false);

        start(count);

        setVisible(true);
    }

    public void paint(Graphics g) {

        super.paint(g);

        String time = "Time Left - " + timer + " seconds";

        g.setColor(Color.red);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {

            g.drawString(time, 1100, 500);

        }

        else {
            g.drawString("Times up!!", 1100, 500);

        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (flag == 1) {

            flag = 0;
            timer = 15;

        } else if (timer < 0) {
            timer = 15;

            op1.setEnabled(true);
            op4.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);

            if (count == 8) {
                Submit.setEnabled(true);
                next.setEnabled(false);

            }
            if (count == 9) {

                if (groupOp.getSelection() == null) {

                    userAns[count][0] = "";

                } else {
                    userAns[count][0] = groupOp.getSelection().getActionCommand();
                }

                for (int i = 0; i < userAns.length; i++) {

                    if (userAns[i][0].equals(answers[i][1])) {

                        score += 1;

                    }

                }

                setVisible(false);
                new score(Name, score);

            } else {

                if (groupOp.getSelection() == null) {

                    userAns[count][0] = "";

                } else {
                    userAns[count][0] = groupOp.getSelection().getActionCommand();
                }
                count++;
                start(count);
                groupOp.clearSelection();

            }
        }

    }

    public void start(int count) {
        qn.setText(" " + (count + 1) + ". ");
        quo.setText(questions[count][0]);

        op1.setText(questions[count][1]);
        op1.setActionCommand(questions[count][1]);

        op2.setText(questions[count][2]);
        op2.setActionCommand(questions[count][2]);

        op3.setText(questions[count][3]);
        op3.setActionCommand(questions[count][3]);

        op4.setText(questions[count][4]);
        op4.setActionCommand(questions[count][4]);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == next) {

            repaint();

            flag = 1;
            op1.setEnabled(true);
            op4.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);

            if (groupOp.getSelection() == null) {

                userAns[count][0] = "";

            } else {
                userAns[count][0] = groupOp.getSelection().getActionCommand();
            }

            if (count == 8) {
                Submit.setEnabled(true);
                next.setEnabled(false);

            }
            count++;
            start(count);
            groupOp.clearSelection();

        } else if (ae.getSource() == L) {

            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {

                op1.setEnabled(false);
                op4.setEnabled(false);

            } else {
                op2.setEnabled(false);
                op3.setEnabled(false);
            }

            L.setEnabled(false);

        } else if(ae.getSource()== Submit){

            flag = 1;

            if (groupOp.getSelection() == null) {

                userAns[count][0] = "";

            } else {
                userAns[count][0] = groupOp.getSelection().getActionCommand();
            }

            for (int i = 0; i < userAns.length; i++) {

                if (userAns[i][0].equals(answers[i][1])) {

                    score += 1;

                }

            }

            setVisible(false);
            new score(Name, score);

        }

    }

    public static void main(String[] args) {

        new mcq("user");
    }

}
