package hospital.management.system;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;;

public class Update_Patient_Details extends JFrame {
    Update_Patient_Details(){
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image i2 =i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1= new JLabel("Update Patient Details.");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2= new JLabel("Name");
        label2.setBounds(25,88,100,25);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,140,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select * from patient_info");
            while(rs.next()){
                choice.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        JLabel label3= new JLabel("Room Number :");
        label3.setBounds(25,129,150,25);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField room = new JTextField();
        room.setBounds(248,129,140,20);
        panel.add(room);

        JLabel label4= new JLabel("In-Time :");
        label4.setBounds(25,174,100,25);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField intime = new JTextField();
        intime.setBounds(248,174,140,20);
        panel.add(intime);

        JLabel label5= new JLabel("Amount Paid :");
        label5.setBounds(25,216,100,25);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField amount = new JTextField();
        amount.setBounds(248,216,140,20);
        panel.add(amount);

        JLabel label6= new JLabel("Pending :");
        label6.setBounds(25,261,100,25);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField pending = new JTextField();
        pending.setBounds(248,261,140,20);
        panel.add(pending);

        JButton check = new JButton("Check");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String id = choice.getSelectedItem();
                    String q = "select * from patient_info where name='"+id+"'";
                    conn c = new conn();
                    ResultSet rs = c.statement.executeQuery(q);
                    while(rs.next()){
                        room.setText(rs.getString("room_number"));
                        intime.setText(rs.getString("time"));
                        amount.setText(rs.getString("deposite"));
                        
                    }
                    ResultSet rs1 =c.statement.executeQuery("select * from room where room_no='"+room.getText()+"'");
                    while(rs1.next()){
                        String price=rs1.getString("price");
                        int amountPaid=Integer.parseInt(price)-Integer.parseInt(amount.getText());
                        pending.setText(""+amountPaid);

                    }

                }catch(Exception r){
                    r.printStackTrace();
                }
            }
        });
        JButton update = new JButton("Update");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room1=room.getText();
                    String time=intime.getText();
                    String amount1=amount.getText();
                    c.statement.executeUpdate("Update patient_info set room_number='"+room1+"',time='"+time+"',deposite='"+amount1+"' where name='"+q+"'");
                    JOptionPane.showMessageDialog(null, "Update Successfully");
                    setVisible(false);
                }catch(Exception r){
                    r.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(168,378,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
            }
        });


        setVisible(true);
        setSize(950,500);
        setLocation(400,250);

    }
    public static void main(String[] args){
        new Update_Patient_Details();
    }   
}
