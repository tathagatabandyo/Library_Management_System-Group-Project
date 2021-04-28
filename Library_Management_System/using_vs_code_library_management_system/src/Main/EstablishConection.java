package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EstablishConection {
    public static Connection getEstblishConnection() {
        Connection con = null;
        try {
            // load the jdbc Driver Class
            Class.forName("com.mysql.jdbc.Driver");

            // Establish Conection
            String url = "jdbc:mysql://127.0.0.1:3306/library_management_system";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(url, user, password);

            return con;

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return con;
        }
    }
}
