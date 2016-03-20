package JavaFx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;


public class Main extends Application  {

    public void start(Stage primaryStage) throws Exception{

        ////////////////////////////////////////////////////////////////
             /* Local Variables */
             Stage window;
             Button loginButton;
             PasswordField passInput;
             TextField nameInput;
             LoginCheck loginCheck;
        /////////////////////////////////////////////////////////
            window = primaryStage;
            window.setTitle("Weight4Me");

            //Setting up GridPane
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setVgap(8);
            grid.setHgap(10);

            //Name Label
            Label nameLabel = new Label("Username:");
            GridPane.setConstraints(nameLabel, 1, 1);

            // Name input
            nameInput = new TextField();
            nameInput.setPromptText("Username or Email");
            GridPane.setConstraints(nameInput, 1, 2);

            //Pass Label
            Label passLabel = new Label("Password:");
            GridPane.setConstraints(passLabel, 1, 3);

            // Pass input
            passInput = new PasswordField();
            passInput.setPromptText("Password");
            GridPane.setConstraints(passInput, 1, 4);

            // login button & login check
            loginCheck= new LoginCheck(nameInput, passInput);
            loginButton = new Button();
            loginButton.setText("Login");
            loginButton.setOnAction(e -> {
                if (nameInput.getText().isEmpty() == false && passInput.getText().isEmpty() == false) {
                    loginCheck.verify(nameInput, passInput);
                } else {
                    AlertBox.display("Empty Values", "Please Input Username & Password");
                }
            }  );
            GridPane.setConstraints(loginButton, 1, 5);

            // Setting the Scene
            grid.getChildren().addAll(nameInput, nameLabel, passLabel, passInput, loginButton);
            Scene scene = new Scene(grid, 700, 550);
            scene.getStylesheets().add("CSS/LoginPage.css");
            window.initStyle(StageStyle.DECORATED);
            window.setScene(scene);
            window.show();
            }




    public  static void main (String [] args){
        launch(args);
    }




}
