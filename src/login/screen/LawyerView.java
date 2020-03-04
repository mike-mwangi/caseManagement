package login.screen;

import data.DataRepository;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Advocate;
import models.Judge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LawyerView extends Stage {

    Stage windowForCases;
    private String lawyerId;
    GridPane gridLawyer = new GridPane();

    public LawyerView(String lawyerId,Scene myScene) throws FileNotFoundException {

        this.lawyerId=lawyerId;

        this.setTitle("LAWYER DASHBOARD");



        Scene scene = new Scene(gridLawyer, 1024, 768);

        gridLawyer.setAlignment(Pos.CENTER);
        gridLawyer.setVgap(10);
        gridLawyer.setHgap(10);
        gridLawyer.setPadding(new Insets(10));

        FileInputStream inputStream = new FileInputStream("/home/mike/Downloads/justice9.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(new Image(inputStream), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        gridLawyer.setBackground(background);


        Text welcomeTxt = new Text("Welcome");
        welcomeTxt.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 25));
        gridLawyer.add(welcomeTxt, 0, 0);

        Button Profile = new Button("Profile");
        gridLawyer.add(Profile, 0, 1);
        Profile.setOnAction(e ->{
            ResultSet profile;
            try {
                profile = DataRepository.getInstance().getLawyerProfile(lawyerId);
                while(profile.next()) {
                    System.out.println();
                    this.setTitle("My Profile");
                    GridPane gridForProfile = new GridPane();
                    gridForProfile.setAlignment(Pos.CENTER);
                    gridForProfile.setVgap(10);
                    gridForProfile.setHgap(10);
                    gridForProfile.setPadding(new Insets(10));
                    gridForProfile.setBackground(background);



                    Label firstNameLabel = new Label("First Name:");
                    gridForProfile.add(firstNameLabel, 0, 1);
                    Label firstNameTxt = new Label();
                    firstNameTxt.setText(profile.getString("advocateFName"));
                    gridForProfile.add(firstNameTxt, 1, 1);


                    Label lastNameLabel = new Label("Last Name:");
                    gridForProfile.add(lastNameLabel, 0, 2);
                    Label lastNameTxt = new Label();
                    lastNameTxt.setText(profile.getString("advocateLName"));
                    gridForProfile.add(lastNameTxt, 1, 2);


                    Button back = new Button("Back");
                    gridForProfile.add(back, 0, 4);
                    back.setOnAction(ex -> this.setScene(scene));


                    Scene ProfileScene = new Scene(gridForProfile, 1024, 768);
                    this.setScene(ProfileScene);
                    this.show();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


        Button Cases = new Button("Cases");
        gridLawyer.add(Cases, 0, 2);

        Cases.setOnAction(e -> {

            ResultSet cases;
            try {
                cases = DataRepository.getInstance().getAdvocateCases(lawyerId);
                while (cases.next()) {
                    System.out.println();

                    windowForCases = this;
                    windowForCases.setTitle("My Cases");
                    GridPane gridForCases = new GridPane();
                    gridForCases.setAlignment(Pos.CENTER);
                    gridForCases.setVgap(10);
                    gridForCases.setHgap(10);
                    gridForCases.setPadding(new Insets(10));
                    gridForCases.setBackground(background);


                    Label caseNameLabel = new Label("Case Name:");
                    gridForCases.add(caseNameLabel, 0, 1);
                    Label caseNameTxt = new Label();
                    caseNameTxt.setText(cases.getString("caseName"));
                    gridForCases.add(caseNameTxt, 1, 1);

                    Label caseStatementLabel = new Label("Case Statement:");
                    gridForCases.add(caseStatementLabel, 0, 2);
                    Label caseStatementTxt = new Label();
                    caseStatementTxt.setText(cases.getString("statementID"));
                    gridForCases.add(caseStatementTxt, 1, 2);


                    Label courtLabel = new Label("Court:");
                    gridForCases.add(courtLabel, 0, 3);
                    Label courtTxt = new Label();
                    courtTxt.setText(cases.getString("courtID"));
                    gridForCases.add(courtTxt, 1, 3);

                    Label sentenceLabel = new Label("Sentence:");
                    gridForCases.add(sentenceLabel, 0, 4);
                    Label sentenceTxt = new Label();
                    sentenceTxt.setText(cases.getString("sentence"));
                    gridForCases.add(sentenceTxt, 1, 4);


                    Label advocateLabel = new Label("Judge:");
                    gridForCases.add(advocateLabel, 0, 5);
                    Label advocateTxt = new Label();
                    advocateTxt.setText(cases.getString("judgeID"));
                    gridForCases.add(advocateTxt, 1, 5);


                    Label caseStageLabel = new Label("Case Stage:");
                    gridForCases.add(caseStageLabel, 0, 6);
                    Label caseStageTxt = new Label();
                    caseStageTxt.setText(cases.getString("caseStageID"));
                    gridForCases.add(caseStageTxt, 1, 6);

                    Label NHDateLabel = new Label("Next Hearing Date:");
                    gridForCases.add(NHDateLabel, 0, 7);
                    Label NHDateTxt = new Label();
                    NHDateTxt.setText(cases.getString("nextHearingDate"));
                    gridForCases.add(NHDateTxt, 1, 7);


                    Label NHTimeLabel = new Label("Next Hearing Time:");
                    gridForCases.add(NHTimeLabel, 0, 8);
                    Label NHTimeTxt = new Label();
                    NHTimeTxt.setText(cases.getString("nextHearingTime"));
                    gridForCases.add(NHTimeTxt, 1, 8);






                    Button back = new Button("Back");
                    gridForCases.add(back, 0, 9);
                    back.setOnAction(ex -> this.setScene(scene));
                    Scene CaseScene = new Scene(gridForCases, 1024, 768);

                    this.setScene(CaseScene);
                    this.show();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        });


        Button changePassword = new Button("Change Password");
        gridLawyer.add(changePassword, 0, 3);
        changePassword.setOnAction(e -> {

            this.setTitle("Registration Screen");
            GridPane gridForPassword = new GridPane();
            gridForPassword.setAlignment(Pos.CENTER);
            gridForPassword.setVgap(10);
            gridForPassword.setHgap(10);
            gridForPassword.setPadding(new Insets(10));
            gridForPassword.setBackground(background);


            Label advocateIdLabel = new Label("Lawyer ID:");
            gridForPassword.add(advocateIdLabel, 0, 1);
            TextField advocateIdTxt = new TextField();
            gridForPassword.add(advocateIdTxt, 1, 1);


            Label advocateFNameLabel = new Label("Advocate First Name:");
            gridForPassword.add(advocateFNameLabel, 0, 2);
            TextField advocateFNameTxt = new TextField();
            gridForPassword.add(advocateFNameTxt, 1, 2);


            Label advocateLNameLabel = new Label("Advocate Last Name:");
            gridForPassword.add(advocateLNameLabel, 0, 3);
            TextField advocateLNameTxt = new TextField();
            gridForPassword.add(advocateLNameTxt, 1, 3);


            Label newPasswordLabel = new Label("New Password:");
            gridForPassword.add(newPasswordLabel, 0, 5);
            TextField newPasswordTxt = new TextField();
            gridForPassword.add(newPasswordTxt, 1, 5);


            Button Back = new Button("Back");
            gridForPassword.add(Back, 0, 6);
            Back.setOnAction(c -> this.setScene(scene));


            Button Save = new Button("Save");
            gridForPassword.add(Save, 3, 6);
            Save.setOnAction(b -> {

                try {
                    DataRepository.getInstance().advocateChangePassword();
                    Connection connection = DataRepository.getInstance().dbConnection;

                    String advocateID = advocateIdTxt.getText();
                    String advocateFName = advocateFNameTxt.getText();
                    String advocateLName = advocateLNameTxt.getText();
                    String password = newPasswordTxt.getText();


                    Advocate passwordChange = new Advocate();
                    passwordChange.setAdvocateID(advocateID);
                    passwordChange.setAdvocateFName(advocateFName);
                    passwordChange.setAdvocateLName(advocateLName);
                    passwordChange.setPassword(password);


                    String sql = ("INSERT INTO advocate (advocateID,advocateFName,advocateLName,password) VALUES ('"+ advocateID+"','" +advocateFName+"','"+advocateLName  +"','"+password + "')");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);


                } catch (SQLException exc) {
                    exc.printStackTrace();
                }


            });



            Scene InsertScene = new Scene(gridForPassword, 1024, 768);
            this.setScene(InsertScene);
            this.show();

        });

        this.setScene(scene);
        this.show();
        logout(myScene);

    }
    public void logout(Scene scene)
    {

        Button logOut= new Button("Log out");
        gridLawyer.add(logOut, 0, 4);
        logOut.setOnAction(ex -> this.setScene(scene));

    }

}
