package login.screen;

import data.DataRepository;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;


public class Main extends Application {

    Stage window;
    private Scene scene;
    DataRepository dataRepository = DataRepository.getInstance();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws SQLException, FileNotFoundException {
        window = primaryStage;
        window.setTitle("Login Screen");

        FileInputStream inputStream = new FileInputStream("/home/mike/Downloads/justice9.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(new Image(inputStream), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);




        GridPane grid = new GridPane();
        scene = new Scene(grid, 1024, 768);
        grid.setBackground(background);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        Text welcomeTxt = new Text("CASE MANAGEMENT SYSTEM");
        welcomeTxt.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 25));


        grid.add(welcomeTxt, 0, 0);
        Label choiceBox = new Label("Choose User:");
        choiceBox.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 16));
        choiceBox.setTextFill(Color.web("#000000"));
        grid.add(choiceBox, 0, 1);

        ChoiceBox userLabel = new ChoiceBox();
        grid.add(userLabel, 0, 2);
        TextField userTxt = new TextField();
        userLabel.setItems(FXCollections.observableArrayList(
                "Individual", "Police", "Judge","Lawyer","Company"));
        userTxt.setPromptText("User ID");
        grid.add(userTxt, 1, 2);


        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(Font.font("Pixel", FontWeight.BOLD, 16));
        passwordLabel.setTextFill(Color.web("#000000"));

        grid.add(passwordLabel, 0, 3);
        PasswordField passwordBox = new PasswordField();
        passwordBox.setPromptText("Password");
        grid.add(passwordBox, 1, 3);



            Button loginBtn = new Button("Login");
        loginBtn.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 12));
        loginBtn.setTextFill(Color.web("#000000"));

        grid.add(loginBtn, 1, 4);

        loginBtn.setOnAction((ActionEvent e) -> {
            String selectedView = userLabel.getValue().toString().toUpperCase();
            try {
                showView(AppViews.valueOf(selectedView), userTxt.getText(), passwordBox.getText());



            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        });

        window.setResizable(false);

        window.setScene(scene);
        window.show();
    }


    private void showView(AppViews view, String username, String password) throws FileNotFoundException {
        switch (view) {
            case INDIVIDUAL:
                System.out.println(dataRepository.validateIndividual(username, password));
                if(dataRepository.validateIndividual(username, password)) {
                    new IndividualView(username,scene);
                    window.close();

                }
                break;

            case JUDGE:
                System.out.println(dataRepository.validateJudge(username, password));
                if(dataRepository.validateJudge(username, password)) {
                    new JudgeView(username,scene);
                    window.close();

                }

                break;

            case POLICE:
                System.out.println(dataRepository.validatePolice(username, password));
                if(dataRepository.validatePolice(username, password)) {
                    new PoliceView(username,scene);
                 window.close();

                }
                    break;

            case COMPANY:
                System.out.println(dataRepository.validateCompany(username, password));
                if(dataRepository.validateCompany(username, password)) {
                    new CompanyView(username,scene);
                    window.close();

                }
                break;

            case LAWYER:
                System.out.println(dataRepository.validateLawyer(username, password));
                if(dataRepository.validateLawyer(username, password)) {
                    new LawyerView(username,scene);
                    window.close();


                }
                break;
        }

    }
}
