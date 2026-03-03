package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField passField;
    JButton login,cancel;
    Login(){
        setLayout(null);
        JLabel text = new JLabel("Username");
        text.setBounds(40,20,100,35);
        text.setFont(new Font("Tahoma",Font.BOLD,16));
        add(text);

        textField = new JTextField();
        textField.setBounds(150,25,200,25);
        textField.setFont(new Font("Tahoma",Font.BOLD,16));
        textField.setBackground(new Color(255,179,0));
        add(textField);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,35);
        pass.setFont(new Font("Tahoma",Font.BOLD,16));
        add(pass);

        passField = new JPasswordField();
        passField.setBounds(150,70,200,25);
        passField.setFont(new Font("Tahoma",Font.BOLD,16));
        passField.setBackground(new Color(255,179,0));
        add(passField);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2= i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(300,-30,400,300);
        add(label);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setFont(new Font("serif",Font.BOLD,15));
        login.setForeground(Color.white);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,140,120,30);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(new Color(109,164,170));
        setSize(750,300);
        setLocation(300,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new Login();
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==login){
            try{
                conn c= new conn();
                String user=textField.getText();
                String pass=passField.getText();
                String q="select * from login where ID ='"+user+"'and pass='"+pass+"'";
                ResultSet rs = c.statement.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Reception().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                }


            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.exit(10);
        }
    }
}
