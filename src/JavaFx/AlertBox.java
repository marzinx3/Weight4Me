package JavaFx;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by coolm_000 on 2/6/2016.
 */
public class AlertBox {


    public static void display(String title, String message){
       Stage window= new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);
        Button closeButton = new Button("This will close window");
        closeButton.setOnAction(e -> window.close());

        VBox layout= new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout,200,400);
        window.setScene(scene1);
        window.showAndWait();

    }

}
