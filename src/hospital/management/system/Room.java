package hospital.management.system;

import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;
public class Room extends JFrame{
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
                // table.setModel(DbUtils);
            }
        }catch(Exception e){
            e.getStackTrace();
        }



        setVisible(true);
        setSize(900,600);
        setLocation(300,230);
    }
    public static void main(String[] args){
        new Room();
    }
}
