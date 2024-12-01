package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1,b2;

    Login() {
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40, 20, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16)); // Corrected font size syntax
        namelabel.setForeground(Color.BLACK); // Corrected the syntax
         add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 73, 100, 30); // Set bounds for Password label
        password.setFont(new Font("Tahoma", Font.BOLD, 16)); // Set the font size
        password.setForeground(Color.BLACK); // Set the text color to black
        add(password); // Add the label to the frame


        //text field
        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30); // Set the position and size
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15)); // Corrected font syntax
        textField.setBackground(new Color(255, 179, 0)); // Set background color
        add(textField);

        //textarea for password
        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30); // Set the position and size
        jPasswordField.setFont(new Font("Tahoma", Font.BOLD, 15)); // Corrected font syntax
        jPasswordField.setBackground(new Color(255, 179, 0)); // Set background color
        add(jPasswordField);

        //image insertion
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png")); // Corrected parameter syntax
        Image i1 = imageIcon.getImage().getScaledInstance(340, 220, Image.SCALE_DEFAULT); // Correct image scaling
        ImageIcon imageIcon1 = new ImageIcon(i1); // Corrected the constructor for ImageIcon
        JLabel label = new JLabel(imageIcon1); // Create the label with the image icon
        label.setBounds(320, 15, 350, 250); // Correct bounds for positioning the image
        add(label); // Add the label to the frame

        //adding button
        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30); // Set position and size of the button
        b1.setFont(new Font("serif", Font.BOLD, 15)); // Set font style and size
        b1.setBackground(Color.BLACK); // Set the background color to black
        b1.setForeground(Color.WHITE); // Set the text color to white
        b1.addActionListener(this);
        add(b1); // Add the button to the frame

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30); // Set position and size of the button
        b2.setFont(new Font("serif", Font.BOLD, 15)); // Set font style and size
        b2.setBackground(Color.BLACK); // Set the background color to black
        b2.setForeground(Color.WHITE); // Set the text color to white
        b2.addActionListener(this);
        add(b2); // Add the button to the frame


        getContentPane().setBackground(new Color(189,164,170));

        setSize(800, 400); // Corrected the setSize syntax
        setLocation(400, 270); // Corrected the setLocation syntax
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {  // Removed the semicolon here
            try {
                conn c = new conn();
                String user = textField.getText();
                String Pass = new String(jPasswordField.getPassword());

                String q = "select * from login where ID = '" + user + "' and PW = '" + Pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new Reception();  // Assuming 'test' is another class
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login credentials");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            System.exit(0);  // Use 0 for a normal exit status
        }
    }
}
