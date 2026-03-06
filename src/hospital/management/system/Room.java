package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class Room extends JFrame implements ActionListener{
    JTable table;
    Room(){
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(600,200,200,200);
        panel.add(label);

        table= new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(90,156,163));
        panel.add(table);

        try{
            conn c = new conn();
            String q= "select * from room";
            ResultSet rs = c.statement.executeQuery(q);
            while(rs.next()){
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        JLabel label1= new JLabel("Room No.");
        label1.setBounds(12,15,80,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2= new JLabel("Availability");
        label2.setBounds(140,15,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3= new JLabel("Price");
        label3.setBounds(290,15,80,15);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4= new JLabel("Bed_Type");
        label4.setBounds(400,15,80,15);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);
        
        JButton back = new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        panel.add(back);
        back.addActionListener(this);
        
        setVisible(true);
        setSize(900,600);
        setLocation(300,230);
    }
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
    public static void main(String[] args){
        new Room();
    }
}
