package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {

    Ambulance(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,690);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,480);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(table);

        try{
            conn c =new conn();
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JLabel label = new JLabel("Driver Name");
        label.setBounds(12,7,190,21);
        label.setFont(new Font("Tahoma",Font.BOLD,23));
        panel.add(label);

        JLabel label1 = new JLabel("Vehicle No");
        label1.setBounds(300,7,150,21);
        label1.setFont(new Font("Tahoma",Font.BOLD,23));
        panel.add(label1);

        JLabel label3 = new JLabel("Vehicle Model");
        label3.setBounds(570,7,190,21);
        label3.setFont(new Font("Tahoma",Font.BOLD,23));
        panel.add(label3);

        JButton back = new JButton("Back");
        back.setBounds(365, 550, 85, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(450,195);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Ambulance();
    }
}
