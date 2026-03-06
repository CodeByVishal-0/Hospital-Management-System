package hospital.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
public class Department extends JFrame implements ActionListener {
    Department(){
        setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table =new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            conn c= new conn();
            String q= "select * from department";
            ResultSet rs = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.getStackTrace();
        }
        
        JLabel label1 = new JLabel("Department");
        label1.setBounds(145,11,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(431,11,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JButton back = new JButton("Back");
        back.setBounds(400,410,130,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });


        setVisible(true);
        setLocation(350,250);
        setSize(700,500);

    }
    public static void main(String[] args){
        new Department();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
