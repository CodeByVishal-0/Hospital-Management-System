package hospital.management.system;

import java.awt.*;
import java.util.Date;

import javax.swing.*;

public class NEW_PATIENT extends JFrame {
    JComboBox combobox;
    JTextField textFieldNumber,textName,textDisease,textDeposit;
    JRadioButton male,female;
    Choice c1;
    JLabel date;
    JButton b1,back;
    NEW_PATIENT(){
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image i2= i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel name=new JLabel("NEW PATIENT FORM");
        name.setBounds(118,11,260,53);
        name.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(name); 

        JLabel id=new JLabel("ID :");
        id.setBounds(35,76,200,14);
        id.setForeground(Color.white);
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(id); 

        combobox = new JComboBox<>(new String[]{"Aadhar Card","Voter ID","Driving License","Other"});
        combobox.setBounds(271,73,150,20);
        combobox.setBackground(new Color(3,45,48));
        combobox.setForeground(Color.white);
        combobox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(combobox);

        JLabel idnumber=new JLabel("ID Number :");
        idnumber.setBounds(35,111,200,14);
        idnumber.setForeground(Color.white);
        idnumber.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(idnumber); 

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);
        
        JLabel pname=new JLabel("Patient Name :");
        pname.setBounds(35,151,200,14);
        pname.setForeground(Color.white);
        pname.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(pname); 

        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);

        JLabel gender=new JLabel("Gender :");
        gender.setBounds(35,191,200,14);
        gender.setForeground(Color.white);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender); 

        male = new JRadioButton("Male");
        male.setFont(new Font("Tahoma",Font.BOLD,14));
        male.setForeground(Color.white);
        male.setBackground(new Color(109,164,170));
        male.setBounds(271,191,80,15);
        panel.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Tahoma",Font.BOLD,14));
        female.setForeground(Color.white);
        female.setBackground(new Color(109,164,170));
        female.setBounds(350,191,80,15);
        panel.add(female);

        JLabel disease=new JLabel("Disease :");
        disease.setBounds(35,231,200,14);
        disease.setForeground(Color.white);
        disease.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(disease);

        textDisease= new JTextField();
         textDisease.setBounds(271,231,150,20);
        panel.add(textDisease);

        JLabel room=new JLabel("Room :");
        room.setBounds(35,274,200,14);
        room.setForeground(Color.white);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);

        ///room choice

        JLabel labelDate=new JLabel("Time :");
        labelDate.setBounds(35,316,200,14);
        labelDate.setForeground(Color.white);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelDate);

        Date date1= new Date();
        date= new JLabel(""+date1);
        date.setBounds(271,316,250,14);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        JLabel labelDeposite=new JLabel("Deposite :");
        labelDeposite.setBounds(35,359,200,17);
        labelDeposite.setForeground(Color.white);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelDeposite);

        textDeposit= new JTextField();
         textDeposit.setBounds(271,359,150,20);
        panel.add(textDeposit);
        
        b1= new JButton("Add");
        b1.setBounds(100,430,120,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        panel.add(b1);

        back= new JButton("Back");
        back.setBounds(260,430,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        panel.add(back);



        setVisible(true);
        setSize(850,550);
        setLocation(300,250);


    }
    public static void main(String[] args){
        new NEW_PATIENT();
    }
}
