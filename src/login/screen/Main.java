package login.screen;

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
    Stage windowForCancellation;
    Stage windowForLogin;
    Stage windowForRegistration;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws SQLException, FileNotFoundException {
        window = primaryStage;
        window.setTitle("Login Screen");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://10.20.113.55:3306/120138_cms");

        FileInputStream inputStream = new FileInputStream("/home/mike/Downloads/App background1.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(new Image(inputStream), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);

       /*Image image = new Image ("file: App backgound.jpg");
       ImageView imageView = new ImageView (image);
       imageView.setImage(image);

       Group root = new Group();
       root.getChildren().addAll(imageView);*/
        //Scene scene1 = new Scene (root, 500,500);
        //Image image1= new Image (getClass().getResource("App backgroung.jpg").toString());
        //BackgroundImage backgroundImage = new BackgroundImage (image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //Background background = new Background (backgroundImage);



        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 700, 600);
        grid.setBackground(background);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        // grid.setBackground(background);
        //ImagePattern pattern = new ImagePattern(image);
        //scene.setFill(pattern);
        //grid.getChildren().addAll(imageView);

        Text welcomeTxt = new Text("Welcome");
        welcomeTxt.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 25));


        grid.add(welcomeTxt, 0, 0);
        Label choiceBox = new Label("Choose User:");
        choiceBox.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 16));
        choiceBox.setTextFill(Color.web("#ff0000"));

        grid.add(choiceBox, 0, 1);
        ChoiceBox userLabel = new ChoiceBox();

        grid.add(userLabel, 0, 2);
        TextField userTxt = new TextField();
//        Button individual=new Button();
        userLabel.setItems(FXCollections.observableArrayList(
                "Individual", "Police", "Judge","Lawyer"));
        userTxt.setPromptText("User");


        grid.add(userTxt, 1, 2);


        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Pixel", FontWeight.BOLD, 16));
        passwordLabel.setTextFill(Color.web("#ff0000"));

        grid.add(passwordLabel, 0, 3);
        PasswordField passwordBox = new PasswordField();
        passwordBox.setPromptText("Password");
        grid.add(passwordBox, 1, 3);

        Button loginBtn = new Button("Login");
        loginBtn.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 12));
        loginBtn.setTextFill(Color.web("#ff0000"));

        grid.add(loginBtn, 1, 4);
        loginBtn.setOnAction((ActionEvent e) -> {
            String selectedView = userLabel.getValue().toString().toUpperCase();
            showView(AppViews.valueOf(selectedView), userTxt.getText());


        });
////        Button cancelBtn = new Button("cancel");
////        grid.add(cancelBtn, 1, 5);
////        cancelBtn.setOnAction(e ->{
////            windowForCancellation = primaryStage;
////            windowForCancellation.setTitle(" Cancellation Screen");
////            GridPane gridForCancellation = new GridPane();
////            gridForCancellation.setAlignment(Pos.CENTER);
////            gridForCancellation.setVgap(10);
////            gridForCancellation.setHgap(10);
////            gridForCancellation.setPadding(new Insets(10));
////
////            Label cancelTxt = new Label("Sorry to see you leave"+ "😢");
////            cancelTxt.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 25));
////            gridForCancellation.add(cancelTxt, 0, 0);
//
//            Button back = new Button ("Back");
//            gridForCancellation.add(back, 0, 1);
//            back.setOnAction(ex -> window.setScene(scene));
//
//            Scene cancelScene = new Scene(gridForCancellation, 500, 500);
//            window.setScene(cancelScene);
//            window.show();
//        });

//        Button registerBtn = new Button ("Sign up");
//        grid.add(registerBtn, 1, 5);
//        Label signUp = new Label ("No account? Create one!");
//        grid.add(signUp, 1, 4);
//
//        registerBtn.setOnAction(e -> {
//            windowForRegistration = primaryStage;
//            windowForRegistration.setTitle("Registration Screen");
//
//
//            GridPane gridForRegistration = new GridPane();
//            gridForRegistration.setAlignment(Pos.CENTER);
//            gridForRegistration.setVgap(10);
//            gridForRegistration.setHgap(10);
//            gridForRegistration.setPadding(new Insets(10));
//
//            Label firstNameLabel = new Label("First Name");
//            gridForRegistration.add(firstNameLabel, 0, 1);
//            TextField firstNameTxt = new TextField();
//            firstNameTxt.setPromptText("First name");
//            gridForRegistration.add(firstNameTxt, 1, 1);
//
//            Label lastNameLabel = new Label("Last Name");
//            gridForRegistration.add(lastNameLabel, 0, 2);
//            TextField lastNameTxt = new TextField();
//            lastNameTxt.setPromptText("last name");
//            gridForRegistration.add(lastNameTxt, 1, 2);
//
//            Label userNameLabel = new Label("Username");
//            gridForRegistration.add(userNameLabel, 0, 3);
//            TextField userNameTxt = new TextField();
//            userNameTxt.setPromptText("username");
//            gridForRegistration.add(userNameTxt, 1, 3);
//
//            Label emailLabel = new Label("Email");
//            gridForRegistration.add(emailLabel, 0, 4);
//            TextField emailTxt = new TextField();
//            emailTxt.setPromptText("Email");
//            gridForRegistration.add(emailTxt, 1, 4);
//
//            Label userPasswordLabel = new Label("Password");
//            gridForRegistration.add(userPasswordLabel, 0, 5);
//            PasswordField passwrdBox = new PasswordField();
//            passwrdBox.setPromptText("Password");
//            gridForRegistration.add(passwrdBox, 1, 5);
//
//            Button signUpBtn = new Button ("sign up");
//            gridForRegistration.add(signUpBtn, 1, 7);
//            signUpBtn.setOnAction(E -> window.setScene(scene));
//
//            Scene registerScene = new Scene(gridForRegistration, 700, 600);
//            window.setScene(registerScene);
//            window.show();
//        });



//        String url="jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2322920";
//        String user="sql2322920";
//        String password="rL7%mG3%?";
//        try {
//            Connection myConn = DriverManager.getConnection(url,user,password);
//            Statement myStm = myConn.createStatement();
//            String sql = "select * from cases";
//            ResultSet rs = myStm.executeQuery(sql);
//
//            while (rs.next()) {
//                System.out.println(rs.getString("CaseID"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//



//        ResultSet cases = DataRepository.getInstance().getCases();
//        while(cases.next()) {
//            System.out.println(cases.getString("caseID"));
//        }
//        ResultSet court = DataRepository.getInstance().getCourt();
//        while(court.next()) {
//            System.out.println(court.getString("courtID"));
//        }
//
//
//        ResultSet advocates = DataRepository.getInstance().getAdvocates();
//        while(advocates.next()) {
//            System.out.println(advocates.getString("advocateFName"));
//        }
//
//        ResultSet ID = DataRepository.getInstance().getIndividualById();
//        while(ID.next()) {
//            System.out.println(advocates.getString("individualID"));
//        }





        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }


    private void showView(AppViews view, String extra) {
        switch (view) {
            case INDIVIDUAL:
                new IndividualView();
                break;
            case JUDGE:
                new JudgeView(extra);
                break;
            case POLICE:
                    new PoliceView(extra);
                    break;
            case LAWYER:
                new LawyerView();
                break;
        }

    }
}
