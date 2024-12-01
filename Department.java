package hospital.management.system;

import com.mysql.cj.xdevapi.Table;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        //adding table
        JTable table = new JTable();
        table.setBounds(33,45,700,350);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e){
            e.printStackTrace();

        }

        //adding department label okay bhai
        JLabel label1 = new JLabel("Department");
        label1.setBounds(40,11,150,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,19));
        panel.add(label1);
        //adding phono no lable or text in the page theek hai na
        JLabel label2 = new JLabel("Phone No");
        label2.setBounds(380,11,170,25);
        label2.setFont(new Font("Tahoma",Font.BOLD,19));
        panel.add(label2);


    JButton b1 = new JButton("BACK");
    b1.setBounds(220,430,130,30);
    b1.setBackground(Color.black);
    b1.setForeground(Color.white);
    panel.add(b1);

    b1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    });







        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);

    }


    public static void main(String[] args) {
        new Department();

    }
}
