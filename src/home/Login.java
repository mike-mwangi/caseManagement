package home;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login  {
    Stage window2;

    public void start(Stage primaryStage) {
        window2 = primaryStage;
        window2.setTitle("DASHBOARD");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Text welcomeTxt= new Text ("DASHBOARD");
        welcomeTxt.setFont(Font.font("Tahoma", FontWeight.NORMAL,25));
        grid.add (welcomeTxt,0,0);

        Button Profile=new Button("");
        grid.add(Profile, 1, 1);

        Button Cases=new Button("");
        grid.add(Cases, 1, 2);

        Button Payment=new Button("");
        grid.add(Payment, 1, 3);


        Scene scene2= new Scene(grid,800,800);
        window2.setScene(scene2);
        window2.show();


    }

    private static void launch(Object args) {

    }

}







