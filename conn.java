package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
        Connection connection;
        Statement statement;


    public conn() {
        try {
            // Corrected syntax for establishing a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "@Sagar735210");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
