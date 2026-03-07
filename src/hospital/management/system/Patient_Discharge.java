package hospital.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;
public class Patient_Discharge extends JFrame implements ActionListener {
    Patient_Discharge(){
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label1 = new JLabel("Customer ID");
        label1.setBounds(30,80,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.white);
        panel.add(label1);

        Choice c1= new Choice();
        c1.setBounds(200,80,150,25);
        panel.add(c1);

        try{
            conn c = new conn();
            String q = "select * from patient_info";
            ResultSet rs = c.statement.executeQuery(q);
            while(rs.next()){
                c1.add(rs.getString("number"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(30,130,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        JLabel rno = new JLabel();
        rno.setBounds(200,130,150,20);
        rno.setFont(new Font("Tahoma",Font.BOLD,14));
        rno.setForeground(Color.white);
        panel.add(rno );

        JLabel label3 = new JLabel("In Time");
        label3.setBounds(30,180,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel intime = new JLabel();
        intime.setBounds(200,180,250,20);
        intime.setFont(new Font("Tahoma",Font.BOLD,14));
        intime.setForeground(Color.white);
        panel.add(intime);

        JLabel label4 = new JLabel("Out Time");
        label4.setBounds(30,230,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        Date date= new Date();
        JLabel outtime = new JLabel(""+date);
        outtime.setBounds(200,230,250,20);
        outtime.setFont(new Font("Tahoma",Font.BOLD,14));
        outtime.setForeground(Color.white);
        panel.add(outtime);

        JButton discharge= new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    conn c = new conn();
                    c.statement.executeUpdate("delete from patient_info where number='"+c1.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set availability='Available' where room_no='"+rno.getText()+"'");
                    JOptionPane.showMessageDialog(null, "Patient Discharged Successfully.");
                    setVisible(false);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    conn c = new conn();
                    ResultSet rs = c.statement.executeQuery("select * from patient_info where number='"+c1.getSelectedItem()+"'");
                    while(rs.next()){
                        rno.setText(rs.getString("room_number"));
                        intime.setText(rs.getString("time"));
                    }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(300,300,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });


        setVisible(true);
        setSize(800,400);
        setLocation(400,250);

    }
    public static void main(String[] args){
        new Patient_Discharge();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
