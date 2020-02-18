package login.screen;

import data.DataRepository;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PoliceView extends Stage {

private String officerId;


    public PoliceView(String officerId) {

        this.setTitle("POLICE DASHBOARD");



        GridPane gridPolice = new GridPane();
        Scene scene = new Scene(gridPolice, 700, 600);
        gridPolice.setAlignment(Pos.CENTER);
        gridPolice.setVgap(10);
        gridPolice.setHgap(10);
        gridPolice.setPadding(new Insets(10));
        // grid.setBackground(background);
        //ImagePattern pattern = new ImagePattern(image);
        //scene.setFill(pattern);
        //grid.getChildren().addAll(imageView);

        Text welcomeTxt = new Text("Welcome");
        welcomeTxt.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 25));
        gridPolice.add(welcomeTxt, 0, 0);

        Button Profile = new Button("Profile");
        gridPolice.add(Profile, 0, 1);
        Profile.setOnAction(e ->{
            ResultSet profile;
            try {
                profile = DataRepository.getInstance().getPoliceProfile(officerId);
                while(profile.next()) {
                    System.out.println();


                    this.setTitle("My Profile");
                    GridPane gridForProfile = new GridPane();
                    gridForProfile.setAlignment(Pos.CENTER);
                    gridForProfile.setVgap(10);
                    gridForProfile.setHgap(10);
                    gridForProfile.setPadding(new Insets(10));


                    Label firstNameLabel = new Label("First Name:");
                    gridForProfile.add(firstNameLabel, 0, 1);
                    Label firstNameTxt = new Label();
                    firstNameTxt.setText(profile.getString("officerFName"));
                    gridForProfile.add(firstNameTxt, 1, 1);


//                    Label firstNameLabel = new Label("First Name:");
//                    gridForProfile.add(firstNameLabel, 0, 1);
//                    Label firstNameTxt = new Label();
////                    firstNameTxt.setPromptText("First name");
//                    firstNameTxt.setText(profile.getString("judgeFName"));
//                    gridForProfile.add(firstNameTxt, 1, 1);

                    Label lastNameLabel = new Label("Last Name:");
                    gridForProfile.add(lastNameLabel, 0, 2);
                    Label lastNameTxt = new Label();
                    lastNameTxt.setText(profile.getString("officerLName"));
                    gridForProfile.add(lastNameTxt, 1, 2);

                    Label userGender = new Label("Gender");
                    gridForProfile.add(userGender, 0, 3);
                    TextField userGenderTxt = new TextField();
                    userGenderTxt.setPromptText("username");
                    gridForProfile.add(userGenderTxt, 1, 3);


                    Button back = new Button("Back");
                    gridForProfile.add(back, 0, 4);
                    back.setOnAction(ex -> this.setScene(scene));


                    Scene ProfileScene = new Scene(gridForProfile, 700, 600);
                    this.setScene(ProfileScene);
                    this.show();
                }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        });


        Button InsertCases = new Button("InsertCases");
        gridPolice.add(InsertCases, 0, 2);
        InsertCases.setOnAction(e -> {
            this.setTitle("Registration Screen");


            GridPane gridForRegistration = new GridPane();
            // Scene sceneForRegistration = new Scene(gridForRegistration, 500, 500);
            gridForRegistration.setAlignment(Pos.CENTER);
            gridForRegistration.setVgap(10);
            gridForRegistration.setHgap(10);
            gridForRegistration.setPadding(new Insets(10));

            Label firstNameLabel = new Label("First Name:");
            gridForRegistration.add(firstNameLabel, 0, 1);
            TextField firstNameTxt = new TextField();
            firstNameTxt.setPromptText("First name");
            gridForRegistration.add(firstNameTxt, 1, 1);



            Label lastNameLabel = new Label("Last Name");
            gridForRegistration.add(lastNameLabel, 0, 2);
            TextField lastNameTxt = new TextField();
            lastNameTxt.setPromptText("last name");
            gridForRegistration.add(lastNameTxt, 1, 2);

            Label userNameLabel = new Label("Username");
            gridForRegistration.add(userNameLabel, 0, 3);
            TextField userNameTxt = new TextField();
            userNameTxt.setPromptText("username");
            gridForRegistration.add(userNameTxt, 1, 3);


            Button back = new Button("Back");
            gridForRegistration.add(back, 0, 4);
            back.setOnAction(ex -> this.setScene(scene));




            Scene InsertScene = new Scene(gridForRegistration, 700, 600);
            this.setScene(InsertScene);
            this.show();
        });



        this.setScene(scene);
        //gridForCancellation.getChildren().addAll(cancelTxt);
        this.show();
        // System.out.println("Canceled");
    }

    }

