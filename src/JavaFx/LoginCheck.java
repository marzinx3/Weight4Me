package JavaFx;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;


/**
 * Created by coolm_000 on 2/13/2016.
 */
public class LoginCheck {
    private TextField nameInput = null;
    private PasswordField passInput = null;
    private static int ssid = 0;

    private Statement databaseCheck;

    public LoginCheck(TextField nameInput, PasswordField passInput) {
        this.nameInput = nameInput;
        this.passInput = passInput;
    }

    public void verify(TextField nameInput, PasswordField passInput) {
        // check fake database for
        String username = nameInput.getText();
        String password = passInput.getText();
        AlertBox alert = new AlertBox();
        try {
            if (credentialsCheck(username, password)) {
                alert.display("Successful", "You are logged in");
            } else {
                alert.display("Wrong Information", "Incorrect Username or Password!");
            }
        } catch (NumberFormatException e) {
            alert.display("Error", "Username and Password Don/'t Match");
        }
    }

    private boolean credentialsCheck(String username, String password) {
        Boolean login=false;
        SQLUtil util=null;
        try{
            util=new SQLUtil();
            String sql = "SELECT UserName,Password FROM endusers";
            util.setSQL(sql);
            ResultSet rset=util.executeQuery();
            if(rset.next()) {

                if (rset.getString("UserName").equals(username) && rset.getString("Password").equals(password)) {
                    login = true;

                } else {
                    login = false;
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(util !=null){
                util.close();
            }
        }
        return login;
    }

}
