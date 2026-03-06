package hospital.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
public class Employee_Info extends JFrame implements ActionListener {
    Employee_Info(){
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);
        try{
            conn c = new conn();
            String q = "select * from emp_info";
            ResultSet rs = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.setStackTrace(null);
        }
        JLabel label1= new JLabel("Name");
        label1.setBounds(41,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);
        JLabel label2= new JLabel("Age");
        label2.setBounds(180,9,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);
        JLabel label3= new JLabel("Phone Number");
        label3.setBounds(350,9,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);
        JLabel label4= new JLabel("Salary");
        label4.setBounds(550,9,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);
        JLabel label5= new JLabel("Gmail");
        label5.setBounds(700,9,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);
        JLabel label6= new JLabel("Aadhar Number");
        label6.setBounds(830,9,150,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JButton back  = new JButton("Back");
        back.setBounds(350,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(this);

        setVisible(true);
        setSize(1000,600);
        setLocation(350,230);
    }
    public static void main(String[] args){
        new Employee_Info();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
