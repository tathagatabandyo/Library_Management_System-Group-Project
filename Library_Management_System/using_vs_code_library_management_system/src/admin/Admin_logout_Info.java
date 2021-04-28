package admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class Admin_logout_Info {
    public static void save_Logout_Info(Connection con, String name, String user) {
        String q = "INSERT INTO admin_logout_information(name,username) VALUES(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, name);
            ps.setString(2, user);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
