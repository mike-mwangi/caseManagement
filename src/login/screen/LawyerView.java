package login.screen;

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

public class LawyerView extends Stage {




    public LawyerView() {

        this.setTitle("LAWYER DASHBOARD");


        GridPane gridLawyer = new GridPane();
        Scene scene = new Scene(gridLawyer, 700, 600);

        gridLawyer.setAlignment(Pos.CENTER);
        gridLawyer.setVgap(10);
        gridLawyer.setHgap(10);
        gridLawyer.setPadding(new Insets(10));
        // grid.setBackground(background);
        //ImagePattern pattern = new ImagePattern(image);
        //scene.setFill(pattern);
        //grid.getChildren().addAll(imageView);

        Text welcomeTxt = new Text("Welcome");
        welcomeTxt.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 25));
        gridLawyer.add(welcomeTxt, 0, 0);

        Button Profile = new Button("Profile");
        gridLawyer.add(Profile, 0, 1);
        Profile.setOnAction(e ->{
            this.setTitle("My Profile");
            GridPane gridForProfile = new GridPane();
            gridForProfile.setAlignment(Pos.CENTER);
            gridForProfile.setVgap(10);
            gridForProfile.setHgap(10);
            gridForProfile.setPadding(new Insets(10));


            Label firstNameLabel = new Label("First Name");
            gridForProfile.add(firstNameLabel, 0, 1);
            TextField firstNameTxt = new TextField();
            firstNameTxt.setPromptText("First name");
            gridForProfile.add(firstNameTxt, 1, 1);

            Label lastNameLabel = new Label("Last Name");
            gridForProfile.add(lastNameLabel, 0, 2);
            TextField lastNameTxt = new TextField();
            lastNameTxt.setPromptText("last name");
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
        });


        Button Cases = new Button("Cases");
        gridLawyer.add(Cases, 0, 2);
        Cases.setOnAction(e ->{
            this.setTitle("My Profile");
            GridPane gridForCases = new GridPane();
            gridForCases.setAlignment(Pos.CENTER);
            gridForCases.setVgap(10);
            gridForCases.setHgap(10);
            gridForCases.setPadding(new Insets(10));


            Label firstNameLabel = new Label("Case ID:");
            gridForCases.add(firstNameLabel, 0, 1);
            TextField CaseField = new TextField();
            CaseField.setPromptText("Case ID");
            gridForCases.add(CaseField, 1, 1);


            Button back = new Button("Back");
            gridForCases.add(back, 0, 4);
            back.setOnAction(ex -> this.setScene(scene));


            Scene CaseScene = new Scene(gridForCases, 700, 600);
            this.setScene(CaseScene);
            this.show();
        });

        this.setScene(scene);
        //gridForCancellation.getChildren().addAll(cancelTxt);
        this.show();
        // System.out.println("Canceled");
    }

    }

