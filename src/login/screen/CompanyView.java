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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Individual;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyView extends Stage {

    Stage windowForProfile;
    Stage windowForCases;
    GridPane gridCompany = new GridPane();
    private String companyId;


    public CompanyView(String companyId,Scene myScene) throws FileNotFoundException{
        this.companyId = companyId;
        this.setTitle("COMPANY DASHBOARD");



        Scene scene = new Scene(gridCompany, 1024, 768);


        gridCompany.setAlignment(Pos.CENTER);
        gridCompany.setVgap(10);
        gridCompany.setHgap(10);
        gridCompany.setPadding(new Insets(10));


        Text welcomeTxt = new Text("Welcome");
        welcomeTxt.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 25));
        gridCompany.add(welcomeTxt, 0, 0);
        FileInputStream inputStream = new FileInputStream("/home/mike/Downloads/justice9.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(new Image(inputStream), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        gridCompany.setBackground(background);

        Button Profile = new Button("Profile");
        gridCompany.add(Profile, 0, 1);
        Profile.setOnAction(e ->{
            ResultSet profile;
            try {
                profile = DataRepository.getInstance().getCompanyProfile(companyId);
                while(profile.next()) {
                    System.out.println();
                    this.setTitle("My Profile");
                    GridPane gridForProfile = new GridPane();
                    gridForProfile.setAlignment(Pos.CENTER);
                    gridForProfile.setVgap(10);
                    gridForProfile.setHgap(10);
                    gridForProfile.setPadding(new Insets(10));
                    gridForProfile.setBackground(background);

                    windowForProfile = this;
                    windowForProfile.setTitle("My Profile");


                    Label companyNameLabel = new Label("Company Name:");
                    gridForProfile.add(companyNameLabel, 0, 1);
                    Label companyNameTxt = new Label();
                    companyNameTxt.setText(profile.getString("companyName"));
                    gridForProfile.add(companyNameTxt, 1, 1);

                    Label addressLabel = new Label("Company Address:");
                    gridForProfile.add(addressLabel, 0, 2);
                    Label addressTxt = new Label();
                    addressTxt.setText(profile.getString("companyAddress"));
                    gridForProfile.add(addressTxt, 1, 2);


                    Label companyContactLabel = new Label("Company Contact:");
                    gridForProfile.add(companyContactLabel, 0, 3);
                    Label companyContactTxt = new Label();
                    companyContactTxt.setText(profile.getString("companyContact"));
                    gridForProfile.add(companyContactTxt, 1, 3);


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
        gridCompany.add(Cases, 0, 2);

        Cases.setOnAction( e -> {

            ResultSet cases;
            try {
                cases = DataRepository.getInstance().getCompanyCases(companyId);
                while (cases.next()) {
                    System.out.println();

                    windowForCases= this;
                    windowForCases.setTitle("My Cases");
                    GridPane gridForCases = new GridPane();
                    gridForCases.setAlignment(Pos.CENTER);
                    gridForCases.setVgap(10);
                    gridForCases.setHgap(10);
                    gridForCases.setPadding(new Insets(10));
                    gridForCases.setBackground(background);




                    Label caseIDLabel = new Label("Case ID:");
                    gridForCases.add(caseIDLabel, 0, 1);
                    Label caseIDTxt = new Label();
                    caseIDTxt.setText(cases.getString("caseID"));
                    gridForCases.add(caseIDTxt, 1, 1);



                    Label caseNameLabel = new Label("Case Name:");
                    gridForCases.add(caseNameLabel, 0, 2);
                    Label caseNameTxt = new Label();
                    caseNameTxt.setText(cases.getString("caseName"));
                    gridForCases.add(caseNameTxt, 1, 2);

                    Label caseStatementLabel = new Label("Case Statement:");
                    gridForCases.add(caseStatementLabel, 0, 3);
                    Label caseStatementTxt = new Label();
                    caseStatementTxt.setText(cases.getString("statementID"));
                    gridForCases.add(caseStatementTxt, 1, 3);


                    Label judgeIdLabel = new Label("Judge Name:");
                    gridForCases.add(judgeIdLabel, 0, 4);
                    Label judgeIdTxt = new Label();
                    judgeIdTxt.setText(cases.getString("judgeID"));
                    gridForCases.add(judgeIdTxt, 1, 4);



                    Label courtLabel = new Label("Court:");
                    gridForCases.add(courtLabel, 0, 5);
                    Label courtTxt = new Label();
                    courtTxt.setText(cases.getString("courtID"));
                    gridForCases.add(courtTxt, 1, 5);


                    Label AdvocateIdLabel = new Label("Advocate Name:");
                    gridForCases.add(AdvocateIdLabel, 0, 6);
                    Label AdvocateIdTxt = new Label();
                    AdvocateIdTxt.setText(cases.getString("advocateID"));
                    gridForCases.add(AdvocateIdTxt, 1, 6);



                    Label paymentIdLabel = new Label("Payment:");
                    gridForCases.add(paymentIdLabel, 0, 7);
                    Label paymentIdTxt = new Label();
                    paymentIdTxt.setText(cases.getString("paymentID"));
                    gridForCases.add(paymentIdTxt, 1, 7);



                    Label caseTypeIdLabel = new Label("Case Type:");
                    gridForCases.add(caseTypeIdLabel, 0, 8);
                    Label caseTypeIdTxt = new Label();
                    caseTypeIdTxt.setText(cases.getString("caseTypeID"));
                    gridForCases.add(caseTypeIdTxt, 1, 8);



                    Label sentenceLabel = new Label("Sentence:");
                    gridForCases.add(sentenceLabel, 0, 9);
                    Label sentenceTxt = new Label();
                    sentenceTxt.setText(cases.getString("sentence"));
                    gridForCases.add(sentenceTxt, 1, 9);



                    Label caseStageLabel = new Label("Case Stage:");
                    gridForCases.add(caseStageLabel, 0, 10);
                    Label caseStageTxt = new Label();
                    caseStageTxt.setText(cases.getString("caseStageID"));
                    gridForCases.add(caseStageTxt, 1, 10);




                    Label NHDateLabel = new Label("Next Hearing Date:");
                    gridForCases.add(NHDateLabel, 0, 11);
                    Label NHDateTxt = new Label();
                    NHDateTxt.setText(cases.getString("nextHearingDate"));
                    gridForCases.add(NHDateTxt, 1, 11);



                    Label NHTimeLabel = new Label("Next Hearing Time:");
                    gridForCases.add(NHTimeLabel, 0, 12);
                    Label NHTimeTxt = new Label();
                    NHTimeTxt.setText(cases.getString("nextHearingTime"));
                    gridForCases.add(NHTimeTxt, 1, 12);


                    Button back = new Button("Back");
                    gridForCases.add(back, 0, 13);
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
        gridCompany.add(changePassword, 0, 3);
        changePassword.setOnAction(e -> {

            this.setTitle("Change Password");
            GridPane gridForPassword = new GridPane();
            gridForPassword.setAlignment(Pos.CENTER);
            gridForPassword.setVgap(10);
            gridForPassword.setHgap(10);
            gridForPassword.setPadding(new Insets(10));
            gridForPassword.setBackground(background);


            Label companyIdLabel = new Label("Company ID:");
            gridForPassword.add(companyIdLabel, 0, 1);
            TextField companyIdTxt = new TextField();
            gridForPassword.add(companyIdTxt, 1, 1);


            Label companyNameLabel = new Label("Company Name:");
            gridForPassword.add(companyNameLabel, 0, 2);
            TextField companyNameTxt = new TextField();
            gridForPassword.add(companyNameTxt, 1, 2);


            Label addressLabel = new Label("Company Address:");
            gridForPassword.add(addressLabel, 0, 4);
            TextField addressTxt = new TextField();
            gridForPassword.add(addressTxt, 1, 4);



            Label contactsLabel = new Label("Company Contacts:");
            gridForPassword.add(contactsLabel, 0, 5);
            TextField contactsTxt = new TextField();
            gridForPassword.add(contactsTxt, 1, 5);

            Label newPasswordLabel = new Label("New Password:");
            gridForPassword.add(newPasswordLabel, 0, 6);
            TextField newPasswordTxt = new TextField();
            gridForPassword.add(newPasswordTxt, 1, 6);


            Button Back = new Button("Back");
            gridForPassword.add(Back, 0, 7);
            Back.setOnAction(c -> this.setScene(scene));


            Button Save = new Button("Save");
            gridForPassword.add(Save, 3, 7);
            Save.setOnAction(b -> {

                try {
                    DataRepository.getInstance().individualChangePassword();
                    Connection connection = DataRepository.getInstance().dbConnection;

                    String myCompanyID = companyIdTxt.getText();
                    String companyName = companyNameTxt.getText();
                    String address = addressTxt.getText();
                    String contacts = contactsTxt.getText();
                    String password = newPasswordTxt.getText();


                    Individual passwordChange = new Individual();
                    passwordChange.setIndividualID(myCompanyID);
                    passwordChange.setIndividualFName(companyName);
                    passwordChange.setIndividualAge(address);
                    passwordChange.setIndividualGender(contacts);
                    passwordChange.setPassword(password);


                    String sql = ("INSERT INTO individual (individualID,individualFName,individualLName,individualAge," +
                            "individualGender,password) VALUES ('"+ myCompanyID+"','" +companyName+"','"+ address +"','"+ contacts+"','"+password + "')");
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
        gridCompany.add(logOut, 0, 5);
        logOut.setOnAction(ex -> this.setScene(scene));

    }

}
