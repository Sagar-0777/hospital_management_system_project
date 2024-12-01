package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room extends JFrame {
    JTable table;

    Room() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 540);
        panel.setBackground(new Color(90, 156, 163)); // Corrected green component
        panel.setLayout(null);
        add(panel);

        // Load and scale the image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/room.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600, 200, 200, 200);
        panel.add(label);


        //adding tabel in the page
        table = new JTable();
        table.setBounds(14,44,500,400);
        table.setBackground(new Color(90, 156, 163));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Room No");
        label1.setBounds(10,15,120,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label1);


        JLabel label2 = new JLabel("Availability");
        label2.setBounds(120,15,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(257,15,100,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(385,15,120,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(label4);

        //adding back button
        JButton back = new JButton("Back");
        back.setBounds(220,480,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);




        // Frame properties
        setSize(900, 550);
        setLayout(null);
        setLocation(300, 230);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
