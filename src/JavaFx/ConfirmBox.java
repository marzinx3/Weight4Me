package JavaFx;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by coolm_000 on 2/7/2016.
 */
public class ConfirmBox {

    static boolean answer;
    static Button yesButton,noButton;

    public static Boolean display(String title, String message){
        Stage window= new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        // create two buttons

        yesButton= new Button("Yes");
        noButton = new Button("No");

        yesButton.setOnAction(e -> {
                answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });


        VBox layout= new VBox(10);
        layout.getChildren().addAll(label,noButton,yesButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout,200,400);
        window.setScene(scene1);
        window.showAndWait();

        return  answer;

    }

}
