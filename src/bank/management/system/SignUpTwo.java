package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class SignUpTwo extends JFrame implements ActionListener{
    JLabel addDetails,religion,category,income,educational,occupation,nidNumber,mobileNumber,sCitizen,ExAccount,qualification,fNo,l13;
    JButton bNext;
    JRadioButton r1,r2,r3,r4;
    JTextField t1,t2,t3;
    JComboBox c1,c2,c3,c4,c5;
    String formno;

    SignUpTwo(String formno){

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/my2.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);


        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        addDetails = new JLabel("Page 2: Additional Details");
        addDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        addDetails.setBounds(280,30,600,40);
        add(addDetails);

        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(100,120,100,30);
        add(religion);

        String religion[] = {"Muslim","Hindu","Sikh","Christian","Other"};
        c1 = new JComboBox(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        c1.setBounds(350,120,320,30);
        add(c1);

        category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(100,170,100,30);
        add(category);

        String category[] = {"General","OBC","SC","ST","Other"};
        c2 = new JComboBox(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        c2.setBounds(350,170,320,30);
        add(c2);

        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(100,220,100,30);
        add(income);

        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        c3 = new JComboBox(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        c3.setBounds(350,220,320,30);
        add(c3);

        educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 18));
        educational.setBounds(100,270,150,30);
        add(educational);

        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
        c4 = new JComboBox(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        c4.setBounds(350,290,320,30);
        add(c4);

        qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 18));
        qualification.setBounds(100,290,150,30);
        add(qualification);

        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(100,340,150,30);
        add(occupation);

        String occupation[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
        c5 = new JComboBox(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        c5.setBounds(350,340,320,30);
        add(c5);

        nidNumber = new JLabel("NID Number:");
        nidNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        nidNumber.setBounds(100,390,150,30);
        add(nidNumber);

        mobileNumber = new JLabel("Mobile Number:");
        mobileNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        mobileNumber.setBounds(100,440,180,30);
        add(mobileNumber);

        sCitizen = new JLabel("Senior Citizen:");
        sCitizen.setFont(new Font("Raleway", Font.BOLD, 18));
        sCitizen.setBounds(100,490,150,30);
        add(sCitizen);

        ExAccount = new JLabel("Existing Account:");
        ExAccount.setFont(new Font("Raleway", Font.BOLD, 18));
        ExAccount.setBounds(100,540,180,30);
        add(ExAccount);

        fNo = new JLabel("Form No:");
        fNo.setFont(new Font("Raleway", Font.BOLD, 13));
        fNo.setBounds(620,10,60,30);
        add(fNo);

        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));
        l13.setBounds(760,10,60,30);
        add(l13);

        bNext = new JButton("Next");
        bNext.setFont(new Font("Raleway", Font.BOLD, 14));
        bNext.setBackground(Color.BLACK);
        bNext.setForeground(Color.WHITE);
        bNext.setBounds(570,640,100,30);
        add(bNext);
        bNext.addActionListener(this);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t1.setBounds(350,390,320,30);
        add(t1);

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setBounds(350,440,320,30);
        add(t2);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(350,490,100,30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(460,490,100,30);
        add(r2);


        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(350,540,100,30);
        add(r3);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(460,540,100,30);
        add(r4);


        getContentPane().setBackground(Color.WHITE);

        setSize(800,750);
        setLocation(400,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String religion = (String)c1.getSelectedItem();
        String category = (String)c2.getSelectedItem();
        String income = (String)c3.getSelectedItem();
        String education = (String)c4.getSelectedItem();
        String occupation = (String)c5.getSelectedItem();

        String nid = t1.getText();
        String mobile = t2.getText();

        String scitizen = "";
        if(r1.isSelected()){
            scitizen = "Yes";
        }
        else if(r2.isSelected()){
            scitizen = "No";
        }

        String eaccount = "";
        if(r3.isSelected()){
            eaccount = "Yes";
        }else if(r4.isSelected()){
            eaccount = "No";
        }

        try{
            if(t2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }
            else
            {
                Connector con = new Connector();
                String q1 = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+nid+"','"+mobile+"','"+scitizen+"','"+eaccount+"')";
                con.s.executeUpdate(q1);

                new SignUpThree(formno).setVisible(true);
               setVisible(false);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        new SignUpTwo("").setVisible(true);
    }

}
