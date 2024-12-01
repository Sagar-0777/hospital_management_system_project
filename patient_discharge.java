package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class patient_discharge extends JFrame {
    patient_discharge(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);  // Adjusted the panel size for the window
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        // Adding label to page page
        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 160, 20);  // Adjusted the table size for better fit
        label.setBackground(new Color(90, 156, 163));
        label.setFont(new Font("Tahoma", Font.BOLD, 25));
        label.setForeground(Color.green);
        panel.add(label);

        JLabel label2 = new JLabel("Customer ID");
        label2.setBounds(30, 80, 160, 20);  // Adjusted the table size for better fit
        label2.setBackground(new Color(90, 156, 163));
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 22);  // Adjusted position
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                choice.addItem(resultSet.getString("Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        JLabel label3 = new JLabel("Room No");
        label3.setBounds(30, 130, 160, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(200, 130, 160, 20);
        RNo.setFont(new Font("Tahoma", Font.BOLD, 15));
        RNo.setForeground(Color.white);
        panel.add(RNo);

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30, 180, 160, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200, 180, 260, 20);
        INTime.setFont(new Font("Tahoma", Font.BOLD, 15));
        INTime.setForeground(Color.white);
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30, 230, 160, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        label5.setForeground(Color.white);
        panel.add(label5);

        Date date = new Date();
        JLabel OutTime = new JLabel("" + date);
        OutTime.setBounds(200, 230, 260, 20);
        OutTime.setFont(new Font("Tahoma", Font.BOLD, 15));
        OutTime.setForeground(Color.white);
        panel.add(OutTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30, 300, 120, 30);
        discharge.setForeground(Color.white);
        discharge.setBackground(Color.black);
        panel.add(discharge);

        JButton discharge1 = new JButton("Discharge");
        discharge.setBounds(30, 300, 120, 30);
        discharge.setForeground(Color.white);
        discharge.setBackground(Color.black);
        panel.add(discharge);

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    c.statement.executeUpdate("delete from patient_info where Number = '" + choice.getSelectedItem() + "'");
                    c.statement.executeUpdate("update Room set Availability = 'Available' where Room_Number = '" + RNo.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Discharge Successfully");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });









        JButton check = new JButton("Check");
        check.setBounds(160, 300, 120, 30);
        check.setForeground(Color.white);
        check.setBackground(Color.black);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where Number = '" + choice.getSelectedItem() + "'");
                    while (resultSet.next()) {
                        RNo.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });




        JButton back =  new JButton("Back");
        back.setBounds(300,300,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setSize(800, 400);  // Corrected the window size for better view
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

        public static void main(String[] args) {
        new patient_discharge();
    }
}
