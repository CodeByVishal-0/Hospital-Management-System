package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Reception extends JFrame {
    Reception(){
        setLayout(null);

        JPanel panel= new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1527,670);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JPanel panel1= new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(1300,0,250,250);
        panel1.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image i22=i11.getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel label1= new JLabel(i33);
        label1.setBounds(1000,50,300,100);
        panel1.add(label1);

        JButton addPatient = new JButton("Add New Patient");
        addPatient.setBounds(30,15,200,30);
        addPatient.setBackground(new Color(246,215,118));
        panel1.add(addPatient);
        addPatient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();

            }
        });

        JButton room = new JButton("Room");
        room.setBounds(30,58,200,30);
        room.setBackground(new Color(246,215,118));
        panel1.add(room);
        room.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton department = new JButton("Department");
        department.setBounds(30,100,200,30);
        department.setBackground(new Color(246,215,118));
        panel1.add(department);
        department.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    new Department();
            }
        });

        JButton allEmp = new JButton("All Employee Info.");
        allEmp.setBounds(270,15,200,30);
        allEmp.setBackground(new Color(246,215,118));
        panel1.add(allEmp);
        allEmp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                

            }
        });

        JButton patientInfo = new JButton("Patient Info.");
        patientInfo.setBounds(270,58,200,30);
        patientInfo.setBackground(new Color(246,215,118));
        panel1.add(patientInfo);
        patientInfo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                

            }
        });

        JButton dis= new JButton("Patient Discharge");
        dis.setBounds(270,100,200,30);
        dis.setBackground(new Color(246,215,118));
        panel1.add(dis);
        dis.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                

            }
        });

        JButton updateDetails= new JButton("Update Patient Details.");
        updateDetails.setBounds(510,15,200,30);
        updateDetails.setBackground(new Color(246,215,118));
        panel1.add(updateDetails);
        updateDetails.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                

            }
        });

        JButton ambulance= new JButton("Hospital Ambulance");
        ambulance.setBounds(510,58,200,30);
        ambulance.setBackground(new Color(246,215,118));
        panel1.add(ambulance);
        ambulance.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                

            }
        });

        JButton searchRoom= new JButton("Search Room");
        searchRoom.setBounds(510,100,200,30);
        searchRoom.setBackground(new Color(246,215,118));
        panel1.add(searchRoom);
        searchRoom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                

            }
        });

        JButton logout= new JButton("Logout");
        logout.setBounds(750,15,200,30);
        logout.setBackground(new Color(246,215,118));
        panel1.add(logout);
        logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login().setVisible(true);;

            }
        });
        
        
        
        getContentPane().setBackground(Color.white);
        setSize(1950,1000);
        setVisible(true);

    }
    public static void main(String[] args){
        new Reception();
    }
}
