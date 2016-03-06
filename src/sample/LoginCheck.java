package sample;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.xml.transform.Result;
import java.sql.*;


/**
 * Created by coolm_000 on 2/13/2016.
 */
public class LoginCheck {
    private TextField nameInput = null;
    private PasswordField passInput = null;
    private static int ssid = 0;
    private Connection conn = null;
    private String url = "jdbc:mysql://localhost/appft";
    private String dbUsername = "root";
    private String dbPassword = "";
    private final String sql = "SELECT UserName,Password FROM enduser";
    private Statement databaseCheck;

    public LoginCheck(TextField nameInput, PasswordField passInput) {
        this.nameInput = nameInput;
        this.passInput = passInput;
    }

    public void verify(TextField nameInput, PasswordField passInput) {
        // check fake database for login
        String username = nameInput.getText();
        String password = passInput.getText();

        AlertBox alert = new AlertBox();
        try {
            if ( credentialsCheck(username, password)) {

                alert.display("Successful", "You are logged in");
            } else {
                alert.display("Wrong Information", "Incorrect Username or Password!");
            }

        } catch (NumberFormatException e) {
            alert.display("Error", "Username and Password Don/'t Match");
        }
    }

    private boolean credentialsCheck(String username, String password) {
        boolean login = false;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println("Error:Unable to load driver class!");
            System.exit(1);
        }

        try {
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            System.out.println("Connected successfully");

            databaseCheck = conn.createStatement();
            ResultSet rs = databaseCheck.executeQuery(sql);

            if(rs.next()) {

                if (rs.getString("UserName").equals(username) && rs.getString("Password").equals(password)) {
                    login = true;

                } else {
                    login = false;
                }
            }

        } catch (SQLException e) {
            System.out.println("SqlExceptions:" + e.getMessage());
            System.out.println("SQLState:" + e.getSQLState());
            System.out.println("VendorError:" + e.getErrorCode());
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();


        }

        return login;
    }
}
