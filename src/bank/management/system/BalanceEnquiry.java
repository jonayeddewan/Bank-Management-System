package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 900);
        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(185, 300, 400, 35);
        l3.add(l1);

        b1.setBounds(370, 516, 150, 35);
        l3.add(b1);
        int balance = 0;
        try{
            Connector c1 = new Connector();
            ResultSet bdt = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (bdt.next()) {
                if (bdt.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(bdt.getString("amount"));
                } else {
                    balance -= Integer.parseInt(bdt.getString("amount"));
                }
            }
        }catch(Exception e){}

        l1.setText("Your Current Account Balance is BDT "+balance);

        b1.addActionListener(this);

        setSize(900, 800);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
