package hospital.management.system;

import java.awt.*;
import java.util.Date;
import javax.swing.*;

import com.mysql.*;

import java.awt.event.*;
import java.sql.ResultSet;

public class NEW_PATIENT extends JFrame implements ActionListener {
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

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select * from room;");
            while(rs.next()){
                c1.add(rs.getString("room_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tohoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

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
        b1.addActionListener(this);

        back= new JButton("Back");
        back.setBounds(260,430,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        panel.add(back);
        back.addActionListener(this);



        setVisible(true);
        setSize(850,550);
        setLocation(300,250);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            conn c = new conn();
            String radio="";
            if(male.isSelected()){
                radio="male";
            }else if(female.isSelected()){
                radio="female";
            }
            String s1=(String)combobox.getSelectedItem();
            String s2= textFieldNumber.getText();
            String s3=textName.getText();
            String s4=radio;
            String s5=textDisease.getText();
            String s6=c1.getSelectedItem();
            String s7=date.getText();
            String s8 =textDeposit.getText();
            try{
                String q= "insert into patient_info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1="update room set availability ='occupied' where room_no="+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new NEW_PATIENT();
    }
}
