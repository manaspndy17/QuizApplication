import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class score extends JFrame implements ActionListener {

    String Name;
    int score;
    JButton play;

    score(String Name, int score) {

        this.Name = Name;
        this.score = score;

        setSize(800, 800);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLocation(400, 0);

        JLabel h1 = new JLabel("Thanks for playing " + Name);
        h1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        h1.setBounds(50, 10, 450, 30);
        h1.setForeground(Color.black);
        add(h1);

        JLabel name = new JLabel("Score");
        name.setFont(new Font("Viner Hand ITC", Font.BOLD, 150));
        name.setBounds(200, 200, 450, 150);
        name.setForeground(Color.magenta);
        add(name);

        JLabel Uscore = new JLabel("" + score);
        Uscore.setFont(new Font("Viner Hand ITC", Font.BOLD, 100));
        Uscore.setBounds(350, 375, 450, 100);
        Uscore.setForeground(Color.green);
        add(Uscore);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hhh.gif"));
        // Image image = i1.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH);
        // ImageIcon img = new ImageIcon(image);
        // JLabel img1 = new JLabel(img);

        JLabel img1 = new JLabel(i1);

        img1.setBounds(0, 300, 450, 500);
        add(img1);

        setVisible(true);


        play = new JButton("Play again");
        play.setBounds(550, 700 ,200, 25);
        play.setBackground(Color.cyan);
        play.setFont(new Font("Times New Roman", Font.BOLD, 15));
        play.addActionListener(this);
        add(play);
    }




    public void actionPerformed(ActionEvent ae) {

        if ( ae.getSource() == play ) {

            setVisible(false);
            
            new login();
        }

    }

    public static void main(String[] args) {

        new score("user", 0);

    }

}
