import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class rules extends JFrame implements ActionListener {

    String Name;
    JButton back, start;

    rules(String Name) {
        this.Name = Name;

         getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setSize(800, 650);
        setLocation(350, 100);

        JLabel h1 = new JLabel("Welcome " + Name + " to Finger tips ");

        h1.setBounds(80, 20, 800, 45);
        h1.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        h1.setForeground(Color.magenta);

        JLabel text = new JLabel();
        text.setBounds(20, 30, 750, 400);
        text.setFont(new Font("Tahoma", Font.PLAIN, 15));
        text.setForeground(Color.DARK_GRAY);
        text.setText(

                "<html>" +
                        "1. Login Required: Participants must log in using valid credentials." + "<br><br>" +
                        "2. Time Limit: Each quiz has a fixed duration; the timer starts once the quiz begins."
                        + "<br><br>" +
                        "3. No Navigation Back: Once a question is answered or skipped, going back may not be allowed."
                        + "<br><br>" +
                        "4. Auto-Submission: The quiz will auto-submit when the timer ends." + "<br><br>" +
                        "5. No External Help: Use of books, mobile phones, or internet search is prohibited."
                        + "<br><br>" +
                        "6. Scoring: Each correct answer carries marks; there may or may not be negative marking."
                        + "<br><br>" +
                        "<html>"

        );

        back = new JButton("Back");
        back.setBounds(20, 500, 100, 25);
        back.setBackground(Color.cyan);
        back.setFont(new Font("Times New Roman", Font.BOLD, 15));
        back.addActionListener(this);

        start = new JButton("Start");
        start.setBounds(650, 500, 100, 25);
        start.setBackground(Color.cyan);
        start.setFont(new Font("Times New Roman", Font.BOLD, 15));
        start.addActionListener(this);

        add(h1);
        add(text);
        add(back);
        add(start);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {

            setVisible(false);
            new login();

        } else if (ae.getSource() == start) {

            setVisible(false);
            new mcq(Name);
        }
    }

    public static void main(String[] args) {

        new rules("user");

    }

}
