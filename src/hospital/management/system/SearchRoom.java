package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame {
    Choice choice;
    JTable table;

    SearchRoom(){
        setLayout(null);

         JPanel panel = new JPanel();
        panel.setBounds(5,5,690,690);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel search = new JLabel("Search for Room");
        search.setBounds(250,11,186,31);
        search.setForeground(Color.white);
        search.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(search);

        JLabel status = new JLabel("Status");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.white);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);

        choice  = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.white);
        panel.add(table);
        try{
            conn c =new conn();
            ResultSet rs = c.statement.executeQuery("select  * from room;");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(23,162,150,20);
        roomno.setForeground(Color.white);
        roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(roomno);
        
        JLabel available = new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setForeground(Color.white);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);
        
        JLabel price = new JLabel("Price");
        price.setBounds(458,162,150,20);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel bed = new JLabel("Bed-Type");
        bed.setBounds(580,162,150,20);
        bed.setForeground(Color.white);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bed);

        JButton searchbt = new JButton("Search");
        searchbt.setBounds(200,420,120,25);
        searchbt.setBackground(Color.black);
        searchbt.setForeground(Color.white);
        panel.add(searchbt);

        searchbt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                try{
                    String q = "select * from room where availability='"+choice.getSelectedItem()+"'";
                    conn c = new conn();
                    ResultSet rs= c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    });

        JButton back = new JButton("Back");
        back.setBounds(380,420,120,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
        }
    });

        setVisible(true);
        setSize(700,500);
        setLocation(450,250);

    }
    public static void main(String[] args){
        new SearchRoom();
    }
}
