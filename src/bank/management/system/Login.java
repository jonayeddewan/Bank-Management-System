
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login()
    {
        setTitle("RUET e-Banking");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/my2.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to RUET e-Banking System");
        text.setFont(new Font("Osward", Font.BOLD, 25));
        text.setBounds(200, 40, 1000, 40);
        add(text);
        
        JLabel CardNo = new JLabel("Card No:");
        CardNo.setFont(new Font("Raleway", Font.BOLD, 25));
        CardNo.setBounds(120, 150, 400, 40);
        add(CardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(250, 160, 250, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD, 20));
        add(cardTextField);
        
        login = new JButton("Sign In");
        login.setBounds(250, 280, 100, 30);
        //login.setBackground(Color.BLACK);
        //login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        signup = new JButton("Sign Up");
        signup.setBounds(400, 280, 100, 30);
        //login.setBackground(Color.BLACK);
        //login.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        clear = new JButton("Clear");
        clear.setBounds(250, 325, 250, 30);
        //login.setBackground(Color.BLACK);
        //login.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("Raleway", Font.BOLD, 25));
        Pin.setBounds(120, 220, 400, 40);
        add(Pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(250, 225, 250, 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD, 20));
        add(pinTextField);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == login)
        {
            Connector con = new Connector();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where CardNumber = '"+cardNumber+"' and PinNumber = '"+pinNumber+"'";

            try
            {
                ResultSet rs = con.s.executeQuery(query);

                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN Number!");
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
        else if(ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
    }
    public static void main(String args[])
    {
        new Login();
    }


}
