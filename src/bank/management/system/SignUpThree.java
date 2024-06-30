package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignUpThree extends JFrame implements ActionListener{

    JLabel l1,type,card,number,pin,pnumebr,cvv, cvvNum,services;
    JComboBox c1;

    JCheckBox ch1,ch2,ch3,ch4,ch5;

    JButton submit,cancel;

    String formno;
    SignUpThree(String formno)
    {
        this.formno = formno;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);

        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);

        type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(100,140,400,30);
        add(type);

        String type[] = {"Select Account Type","Savings Account","Fixed Deposit","Current Account","Recurring Deposit Account"};
        c1 = new JComboBox(type);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 18));
        c1.setBounds(300,140,400,30);
        add(c1);

        card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100,190,400,30);
        add(card);

        number = new JLabel("XXXX-XXXX-XXXX-4128");
        number.setFont(new Font("Raleway", Font.BOLD, 18));
        number.setBounds(300,190,400,30);
        add(number);

        pin = new JLabel("PIN Number:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,240,400,30);
        add(pin);

        pnumebr = new JLabel("XXXX");
        pnumebr.setFont(new Font("Raleway", Font.BOLD, 18));
        pnumebr.setBounds(300,240,400,30);
        add(pnumebr);

        cvv = new JLabel("CVV Number:");
        cvv.setFont(new Font("Raleway", Font.BOLD, 20));
        cvv.setBounds(100,290,400,30);
        add(cvv);

        cvvNum = new JLabel("XXX");
        cvvNum.setFont(new Font("Raleway", Font.BOLD, 18));
        cvvNum.setBounds(300,290,400,30);
        add(cvvNum);

        services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100,400,400,30);
        add(services);

        ch1 = new JCheckBox("ATM Card");
        ch1.setBackground(Color.WHITE);
        ch1.setFont(new Font("Raleway",Font.BOLD, 16));
        ch1.setBounds(100,450,200,30);
        add(ch1);

        ch2 = new JCheckBox("Internet Banking");
        ch2.setBackground(Color.WHITE);
        ch2.setFont(new Font("Raleway",Font.BOLD, 16));
        ch2.setBounds(300,450,200,30);
        add(ch2);

        ch3 = new JCheckBox("Email & SMS Alerts");
        ch3.setBackground(Color.WHITE);
        ch3.setFont(new Font("Raleway",Font.BOLD, 16));
        ch3.setBounds(100,500,200,30);
        add(ch3);

        ch4 = new JCheckBox("Cheque Book");
        ch4.setBackground(Color.WHITE);
        ch4.setFont(new Font("Raleway",Font.BOLD, 16));
        ch4.setBounds(300,500,200,30);
        add(ch4);

        ch5 = new JCheckBox("I thereby declare that the above details are correct to the best of my knowledge.");
        ch5.setBackground(Color.WHITE);
        ch5.setBounds(100, 600, 630, 20);
        ch5.setFont(new Font("Raleway",Font.BOLD,15));
        add(ch5);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(250,650,100,30);
        add(cancel);
        cancel.addActionListener(this);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(450,650,100,30);
        add(submit);
        submit.addActionListener(this);

        setSize(850,820);
        setLocation(350,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String AccountType = (String)c1.getSelectedItem();

            Random random = new Random();
            String cardNumber = ""+Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = ""+Math.abs((random.nextLong() % 9000L) + 1000L);
            String cvvNumber = ""+Math.abs((random.nextLong() % 900L) + 100);

            String facilities = "";

            if(ch1.isSelected())
            {
                facilities = facilities + "ATM Card";
            }
            else if(ch2.isSelected())
            {
                facilities = facilities + "Internet Banking";
            }
            else if(ch3.isSelected())
            {
                facilities = facilities + "Emails & SMS Alerts";
            }
            else if(ch4.isSelected())
            {
                facilities = facilities + "Cheque Book";
            }
            try
            {
                if(AccountType.equals(null))
                {
                    JOptionPane.showMessageDialog(null, "Account Type Is Required");
                }
                else
                {
                    Connector con = new Connector();
                    String query1 = "insert into signupthree values('"+formno+"','"+AccountType+"','"+cardNumber+"','"+pinNumber+"','"+cvvNumber+"','"+facilities+"')";
                    con.s.executeUpdate(query1);
                    String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    con.s.executeUpdate(query2);


                    JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber + "\n PIN Number: "+pinNumber + "\n CVV Number: "+cvvNumber);


                    setVisible(false);
                    new Deposit(pinNumber).setVisible(false);
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new SignUpThree("");
    }
}
