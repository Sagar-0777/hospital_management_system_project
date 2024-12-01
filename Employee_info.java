package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {

    Employee_info() {

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1100, 590);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 1000, 450);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Adding labels for the table header
        JLabel label1 = new JLabel("Name");
        label1.setBounds(24, 9, 70, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(154, 9, 70, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label2);

        JLabel label3 = new JLabel("Number");
        label3.setBounds(300, 9, 120, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label3);

        JLabel label4 = new JLabel("Salary");
        label4.setBounds(420, 9, 70, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail");
        label5.setBounds(590, 9, 70, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhar No");
        label6.setBounds(735, 9, 120, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label6);

        JLabel label7 = new JLabel("Address");
        label7.setBounds(860, 9, 100, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label7);


        JButton button = new JButton("BACK");
        button.setBounds(350,500,120,30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(1000, 600);
        setLayout(null);
        setLocation(350, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
