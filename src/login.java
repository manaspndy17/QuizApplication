import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class login extends JFrame implements ActionListener{
    
    JButton rule , back ;
    JTextField fname;

    login(){
        
         getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img1s.jpeg"));
        JLabel image = new JLabel(i1);

        image.setBounds(0,0,600, 500);

        
        
        JLabel h1 = new JLabel("Finger Tips");

        h1.setBounds(650, 20, 300, 45);
        h1.setFont(new Font("Viner Hand ITC",Font.BOLD, 40));
        h1.setForeground(Color.BLUE);
        

        JLabel name = new JLabel("Enter your name ");
        name.setBounds(675, 100 , 300, 20);
        name.setFont(new Font("Times new Roman", Font.BOLD , 20));
        name.setForeground(new Color(151, 158, 33));
        

         fname = new JTextField();
        fname.setBounds(650,150, 250, 25);
        fname.setFont(new Font("Times New Roman", Font.BOLD , 20));

        rule = new JButton("Rule");
        rule.setBounds(650,200, 100, 25);
        rule.setBackground(Color.cyan);
        rule.setFont(new Font("Times New Roman", Font.BOLD , 15));
        rule.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(800,200, 100, 25);
        back.setBackground(Color.cyan);
        back.setFont(new Font("Times New Roman", Font.BOLD , 15));
        back.addActionListener(this);

        add(rule);
        add(back);
        add(name);
        add(image);
        add(h1);
        add(fname);
        

        setSize(1000,525);
        setLocation(300,100);
         setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
           if ( ae.getSource() == rule) {


            setVisible(false);

           String Name = fname.getText();
            new rules(Name);
            
           }
           else if (ae.getSource() == back) {
            
            setVisible(false);
           }
    }
    
                
    public static void main(String[] args){

        new login();
    }
}