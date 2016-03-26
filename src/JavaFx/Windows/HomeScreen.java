package JavaFx.Windows;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by coolm_000 on 3/25/2016.
 */
public class HomeScreen{

 public HomeScreen(){}
    public static void screen(){

      ////////////////////////////////////////////////////////////////
             /* Local Variables */
      Stage window;

      /////////////////////////////////////////////////////////
      window = new Stage();
      window.setTitle("Weight4Me");

      //Setting up GridPane
      GridPane grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(8);
      grid.setHgap(10);


      Scene scene = new Scene(grid, 700, 550);
      window.initStyle(StageStyle.DECORATED);
      window.setScene(scene);
      window.show();
  }
}
