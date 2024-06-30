package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{

    JButton b1, b2;
    JLabel l1;
    MiniStatement(String pin){
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(500,50);

        l1 = new JLabel();
        add(l1);

        JLabel l2 = new JLabel("RUET e-Banking System");
        l2.setBounds(130, 20, 400, 20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        try{
            Connector c = new Connector();
            ResultSet rs = c.s.executeQuery("select * from login where PinNumber = '"+pin+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("CardNumber").substring(0, 5) + "XXXXXXXX" + rs.getString("CardNumber").substring(12));
            }
        }catch(Exception e){}

        try{
            int balance = 0;
            Connector c1  = new Connector();
            ResultSet bdt = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(bdt.next()){
                l1.setText(l1.getText() + "<html>"+bdt.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + bdt.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + bdt.getString("amount") + "<br><br><html>");
                if(bdt.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(bdt.getString("amount"));
                }else{
                    balance -= Integer.parseInt(bdt.getString("amount"));
                }
            }
            l4.setText("Your Total Balance is BDT "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }

        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);

        b1.addActionListener(this);

        l1.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }

    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }

}
