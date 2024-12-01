package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ALL_Patient_Info extends JFrame {
    ALL_Patient_Info() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1500, 640);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        // Adding table
        JTable table = new JTable();
        table.setBounds(0, 50, 1500, 300);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from Patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Adding labels for column headers
        JLabel label1 = new JLabel("ID");
        label1.setBounds(30, 10, 50, 22);
        label1.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setBounds(200, 10, 80, 22);
        label2.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(370, 10, 80, 22);
        label3.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(555, 10, 80, 22);
        label4.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(721, 10, 100, 22);
        label5.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label5);

        JLabel label6 = new JLabel("Room");
        label6.setBounds(935, 10, 80, 22);
        label6.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(1180, 10, 80, 22);
        label7.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label7);

        JLabel label8 = new JLabel("Deposit");
        label8.setBounds(1290, 10, 80, 22);
        label8.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label8);

        JButton button = new JButton("BACK");
        button.setBounds(700, 500, 100, 30); // Adjusted to fit within the panel's height
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });







        // Set window properties
        setUndecorated(true);
        setSize(1500, 650);  // Corrected the window size for better view
        setLayout(null);
        setLocation(20, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ALL_Patient_Info();
    }
}
