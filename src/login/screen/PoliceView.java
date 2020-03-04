package login.screen;

import data.DataRepository;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PoliceView extends Stage {

private  Scene scene;
private GridPane gridPolice;

    public PoliceView(String officerId,Scene myScene)throws FileNotFoundException {

        this.setTitle("POLICE DASHBOARD");



     gridPolice = new GridPane();
        scene = new Scene(gridPolice, 1024, 768);
        gridPolice.setAlignment(Pos.CENTER);
        gridPolice.setVgap(10);
        gridPolice.setHgap(10);
        gridPolice.setPadding(new Insets(10));

        FileInputStream inputStream = new FileInputStream("/home/mike/Downloads/justice9.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(new Image(inputStream), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        gridPolice.setBackground(background);


        Text welcomeTxt = new Text("Welcome");
        welcomeTxt.setFont(Font.font("Pixel", FontWeight.BOLD, 25));
        gridPolice.add(welcomeTxt, 0, 0);

        Button Profile = new Button("Profile");
        gridPolice.add(Profile, 0, 1);
        Profile.setOnAction(e ->{
            ResultSet profile;
            try {
                profile = DataRepository.getInstance().getPoliceProfile(officerId);
                while(profile.next()) {
                    System.out.println();


                    this.setTitle("My insertCases");
                    GridPane gridForProfile = new GridPane();
                    gridForProfile.setAlignment(Pos.CENTER);
                    gridForProfile.setVgap(10);
                    gridForProfile.setHgap(10);
                    gridForProfile.setPadding(new Insets(10));
                    gridForProfile.setBackground(background);




                    Label firstNameLabel = new Label("First Name:");
                    gridForProfile.add(firstNameLabel, 0, 2);
                    Label firstNameTxt = new Label();
                    firstNameTxt.setText(profile.getString("officerFName"));
                    gridForProfile.add(firstNameTxt, 1, 2);



                    Label lastNameLabel = new Label("Last Name:");
                    gridForProfile.add(lastNameLabel, 0, 3);
                    Label lastNameTxt = new Label();
                    lastNameTxt.setText(profile.getString("officerLName"));
                    gridForProfile.add(lastNameTxt, 1, 3);


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




        Button individualButton = new Button("Individual");
        gridPolice.add(individualButton, 0, 2);
        individualButton.setOnAction(e ->{
            this.setTitle("Registration Screen");

            GridPane gridForIndividual = new GridPane();
            gridForIndividual.setAlignment(Pos.CENTER);
            gridForIndividual.setVgap(10);
            gridForIndividual.setHgap(10);
            gridForIndividual.setPadding(new Insets(10));
            gridForIndividual.setBackground(background);


            Label indIdLabel = new Label("Individual ID:");
            gridForIndividual.add(indIdLabel, 0, 1);
            TextField indIdTxt = new TextField();
            gridForIndividual.add(indIdTxt, 1, 1);


            Label indFNameLabel = new Label("Individual First Name:");
            gridForIndividual.add(indFNameLabel, 0, 2);
            TextField indFNameTxt = new TextField();
            gridForIndividual.add(indFNameTxt, 1, 2);


            Label indLNameLabel = new Label("Individual Last Name:");
            gridForIndividual.add(indLNameLabel, 0, 3);
            TextField indLNameTxt = new TextField();
            gridForIndividual.add(indLNameTxt, 1, 3);


            Label ageLabel = new Label("Age:");
            gridForIndividual.add(ageLabel, 0, 4);
            TextField indAgeTxt = new TextField();
            gridForIndividual.add(indAgeTxt, 1, 4);


            Label indGenderLabel = new Label("Gender:");
            gridForIndividual.add(indGenderLabel, 0, 5);
            TextField indGenderTxt = new TextField();
            gridForIndividual.add(indGenderTxt, 1, 5);



            Label passwordLabel = new Label("Password:");
            gridForIndividual.add(passwordLabel, 0, 6);
            TextField indPasswordTxt = new TextField();
            gridForIndividual.add(indPasswordTxt, 1, 6);



            Button back = new Button("Back");
            gridForIndividual.add(back, 0, 7);
            back.setOnAction(ex -> this.setScene(scene));


            Button save = new Button("Save");
            gridForIndividual.add(save, 3, 7);
            save.setOnAction(ex -> {

                try {
                    DataRepository.getInstance().insertIndividualDetails();
                    Connection connection = DataRepository.getInstance().dbConnection;

                    String indID=indIdTxt.getText();
                    String indFName = indFNameTxt.getText();
                    String indLName = indLNameTxt.getText();
                    String indAge = indAgeTxt.getText();
                    String indGender = indGenderTxt.getText();
                    String indPassword = indPasswordTxt.getText();



                    Individual indDetails = new Individual();
                    indDetails.setIndividualID(indID);
                    indDetails.setIndividualFName(indFName);
                    indDetails.setIndividualLName(indLName);
                    indDetails.setIndividualAge(indAge);
                    indDetails.setIndividualGender(indGender);
                    indDetails.setPassword(indPassword);


                    String sql =("INSERT INTO individual (individualID,individualFName,individualLName,individualAge,individualGender,password) VALUES ('" + indID
                            + "','" + indFName + "','" + indLName + "','" + indAge + "','" +indGender+ "','" +indPassword+ "')");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);

                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            });

            Scene InsertScene = new Scene(gridForIndividual, 1024, 768);
            this.setScene(InsertScene);
            this.show();


        });






        Button individualCaseButton = new Button("Individual Case");
        gridPolice.add(individualCaseButton, 0, 3);
        individualCaseButton.setOnAction(e ->{
            this.setTitle("Registration Screen");


            GridPane gridForIndCase = new GridPane();
            gridForIndCase.setAlignment(Pos.CENTER);
            gridForIndCase.setVgap(10);
            gridForIndCase.setHgap(10);
            gridForIndCase.setPadding(new Insets(10));
            gridForIndCase.setBackground(background);





            Label indIdLabel = new Label("Individual ID:");
            gridForIndCase.add(indIdLabel, 0, 1);
            TextField indIdTxt = new TextField();
            gridForIndCase.add(indIdTxt, 1, 1);


            Label indCaseLabel = new Label("Individual Case ID:");
            gridForIndCase.add(indCaseLabel, 0, 2);
            TextField indCaseTxt = new TextField();
            gridForIndCase.add(indCaseTxt, 1, 2);


            Button back = new Button("Back");
            gridForIndCase.add(back, 0, 3);
            back.setOnAction(ex -> this.setScene(scene));

            Button save = new Button("Save");
            gridForIndCase.add(save, 3, 3);
            save.setOnAction(ex -> {

                try {
                    DataRepository.getInstance().insertIndividualCaseDetails();
                    Connection connection = DataRepository.getInstance().dbConnection;

                    String indID=indIdTxt.getText();
                    String indCaseID = indCaseTxt.getText();




                    IndividualCase indCaseDetails = new IndividualCase();
                    indCaseDetails.setIndividualID(indID);
                    indCaseDetails.setCaseID(indCaseID);



                    String sql =("INSERT INTO individualCase (individualID,caseID) VALUES ('" + indID
                            + "','" + indCaseID +  "')");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);




                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            });


            Scene InsertScene = new Scene(gridForIndCase, 1024, 768);
            this.setScene(InsertScene);
            this.show();


        });




        Button companyButton = new Button("Company");
        gridPolice.add(companyButton, 0, 4);
        companyButton.setOnAction(e ->{
            this.setTitle("Registration Screen");


            GridPane gridForCompany = new GridPane();
            gridForCompany.setAlignment(Pos.CENTER);
            gridForCompany.setVgap(10);
            gridForCompany.setHgap(10);
            gridForCompany.setPadding(new Insets(10));
            gridForCompany.setBackground(background);



            Label companyIdLabel = new Label("Company ID:");
            gridForCompany.add(companyIdLabel, 0, 1);
            TextField companyIdTxt = new TextField();
            gridForCompany.add(companyIdTxt, 1, 1);


            Label companyNameLabel = new Label("Company Name:");
            gridForCompany.add(companyNameLabel, 0, 2);
            TextField companyNameTxt = new TextField();
            gridForCompany.add(companyNameTxt, 1, 2);


            Label companyAddressLabel = new Label("Company Address:");
            gridForCompany.add(companyAddressLabel, 0, 3);
            TextField companyAddressTxt = new TextField();
            gridForCompany.add(companyAddressTxt, 1, 3);


            Label companyContactLabel = new Label("Company Contact:");
            gridForCompany.add(companyContactLabel, 0, 4);
            TextField companyContactTxt = new TextField();
            gridForCompany.add(companyContactTxt, 1, 4);


            Label passwordLabel = new Label("Password:");
            gridForCompany.add(passwordLabel, 0, 5);
            TextField passwordTxt = new TextField();
            gridForCompany.add(passwordTxt, 1, 5);


            Button back = new Button("Back");
            gridForCompany.add(back, 0, 6);
            back.setOnAction(ex -> this.setScene(scene));

            Button save = new Button("Save");
            gridForCompany.add(save, 3, 6);
            save.setOnAction(ex -> {

                try {
                    DataRepository.getInstance().insertCompanyDetails();
                    Connection connection = DataRepository.getInstance().dbConnection;

                    String companyID=companyIdTxt.getText();
                    String companyName = companyNameTxt.getText();
                    String companyAddress = companyAddressTxt.getText();
                    String companyContact = companyContactTxt.getText();
                    String companyPassword=passwordTxt.getText();


                    Company companyCase = new Company();
                    companyCase.setCompanyID(companyID);
                    companyCase.setCompanyName(companyName);
                    companyCase.setCompanyAddress(companyAddress);
                    companyCase.setCompanyContact(companyContact);
                    companyCase.setPassword(companyPassword);

                    String sql =("INSERT INTO company (companyID,CompanyName,CompanyAddress,CompanyContact,password)" +
                            " VALUES ('" + companyID
                            + "','" + companyName + "','" + companyAddress + "','" + companyContact+ "','"+
                            companyPassword + "')");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);


                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            });

            Scene InsertScene = new Scene(gridForCompany, 1024, 768);
            this.setScene(InsertScene);
            this.show();
        });




        Button companyCaseButton = new Button("Company Case");
        gridPolice.add(companyCaseButton, 0, 5);
        companyCaseButton.setOnAction(e ->{
            this.setTitle("Registration Screen");


            GridPane gridForCompanyCase = new GridPane();
            gridForCompanyCase.setAlignment(Pos.CENTER);
            gridForCompanyCase.setVgap(10);
            gridForCompanyCase.setHgap(10);
            gridForCompanyCase.setPadding(new Insets(10));
            gridForCompanyCase.setBackground(background);



            Label companyIdLabel = new Label("Company ID:");
            gridForCompanyCase.add(companyIdLabel, 0, 1);
            TextField companyIdTxt = new TextField();
            gridForCompanyCase.add(companyIdTxt, 1, 1);


            Label caseIdLabel = new Label("Company Case ID:");
            gridForCompanyCase.add(caseIdLabel, 0, 2);
            TextField caseIdTxt = new TextField();
            gridForCompanyCase.add(caseIdTxt, 1, 2);


            Button back = new Button("Back");
            gridForCompanyCase.add(back, 0, 3);
            back.setOnAction(ex -> this.setScene(scene));

            Button save = new Button("Save");
            gridForCompanyCase.add(save, 3, 3);
            save.setOnAction(ex -> {

                try {
                    DataRepository.getInstance().insertCompanyCaseDetails();
                    Connection connection = DataRepository.getInstance().dbConnection;

                    String companyID=companyIdTxt.getText();
                    String companyCaseID = caseIdTxt.getText();




                    IndividualCase indCaseDetails = new IndividualCase();
                    indCaseDetails.setIndividualID(companyID);
                    indCaseDetails.setCaseID(companyCaseID);



                    String sql =("INSERT INTO companyCase (companyID,caseID) VALUES ('" + companyID
                            + "','" + companyCaseID +  "')");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);



                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            });


            Scene InsertScene = new Scene(gridForCompanyCase, 1024, 768);
            this.setScene(InsertScene);
            this.show();

        });



        Button Cases = new Button("Insert Cases");
        gridPolice.add(Cases, 0, 6);
        Cases.setOnAction(e -> {

            this.setTitle("Registration Screen");
            GridPane gridForRegistration = new GridPane();
            gridForRegistration.setAlignment(Pos.CENTER);
            gridForRegistration.setVgap(10);
            gridForRegistration.setHgap(10);
            gridForRegistration.setPadding(new Insets(10));
            gridForRegistration.setBackground(background);


            Label caseIdLabel = new Label("Case ID:");
            gridForRegistration.add(caseIdLabel, 0, 1);
            TextField caseIdText = new TextField();
            gridForRegistration.add(caseIdText, 1, 1);



            Label caseNameLabel = new Label("Case Name:");
            gridForRegistration.add(caseNameLabel, 0, 2);
            TextField caseNameTxt = new TextField();
            gridForRegistration.add(caseNameTxt, 1, 2);

            Label statementIdLabel = new Label("Statement:");
            gridForRegistration.add(statementIdLabel, 0, 3);
            TextField statementIdTxt = new TextField();
            gridForRegistration.add(statementIdTxt, 1, 3);

            Label judgeIdLabel = new Label("Judge:");
            gridForRegistration.add(judgeIdLabel, 0, 4);
            TextField judgeIdTxt = new TextField();
            gridForRegistration.add(judgeIdTxt, 1, 4);


            Label courtLabel = new Label("Court:");
            gridForRegistration.add(courtLabel, 0, 5);
            TextField courtTxt = new TextField();
            gridForRegistration.add(courtTxt, 1, 5);

            Label advocateLabel = new Label("Advocate:");
            gridForRegistration.add(advocateLabel, 0, 6);
            TextField advocateTxt = new TextField();
            gridForRegistration.add(advocateTxt, 1, 6);

            Label paymentLabel = new Label("Payment:");
            gridForRegistration.add(paymentLabel, 0, 7);
            TextField paymentTxt = new TextField();
            gridForRegistration.add(paymentTxt, 1, 7);

            Label caseTypeLabel = new Label("Case Type:");
            gridForRegistration.add(caseTypeLabel, 0, 8);
            TextField caseTypeTxt = new TextField();
            gridForRegistration.add(caseTypeTxt, 1, 8);

            Label sentenceLabel = new Label("Sentence:");
            gridForRegistration.add(sentenceLabel, 0, 9);
            TextField sentenceTxt = new TextField();
            gridForRegistration.add(sentenceTxt, 1, 9);

            Label caseStageLabel = new Label("Case Stage:");
            gridForRegistration.add(caseStageLabel, 0, 10);
            TextField caseStageTxt = new TextField();
            gridForRegistration.add(caseStageTxt, 1, 10);

            Label nextHearingDateLabel = new Label("Next Hearing Date:");
            gridForRegistration.add(nextHearingDateLabel, 0, 11);
            TextField nextHearingDateTxt = new TextField();
            gridForRegistration.add(nextHearingDateTxt, 1, 11);

            Label nextHearingTimeLabel = new Label("Next Hearing Time:");
            gridForRegistration.add(nextHearingTimeLabel, 0, 12);
            TextField nextHearingTimeTxt = new TextField();
            gridForRegistration.add(nextHearingTimeTxt, 1, 12);




            Button back = new Button("Back");
            gridForRegistration.add(back, 0, 13);
            back.setOnAction(ex -> this.setScene(scene));


            Button save = new Button("Save");
            gridForRegistration.add(save, 3, 13);
            save.setOnAction(ex -> {

                this.setScene(scene);
                try {

                    DataRepository.getInstance().insertCases();
                    Connection connection = DataRepository.getInstance().dbConnection;



                    String caseId=caseIdText.getText();
                    String caseName = caseNameTxt.getText();
                    String statementId = statementIdTxt.getText();
                    String judgeId = judgeIdTxt.getText();
                    String courtId = courtTxt.getText();
                    String advocateId = advocateTxt.getText();
                    String payment = paymentTxt.getText();
                    String caseType = caseTypeTxt.getText();
                    String sentence = sentenceTxt.getText();
                    String caseStage = caseStageTxt.getText();
                    String nextHearingDate=nextHearingDateTxt.getText();
                    String nextHearingTime=nextHearingDateTxt.getText();



                    Case courtCase = new Case();
                    courtCase.setCaseID(caseId);
                    courtCase.setCaseName(caseName);
                    courtCase.setStatementID(statementId);
                    courtCase.setJudgeID(judgeId);
                    courtCase.setCourtID(courtId);
                    courtCase.setAdvocateID(advocateId);
                    courtCase.setPaymentID(payment);
                    courtCase.setCaseTypeID(caseType);
                    courtCase.setSentence(sentence);
                    courtCase.setCaseStage(caseStage);
                    courtCase.setNextHearingDate(nextHearingDate);
                    courtCase.setNextHearingTime(nextHearingTime);


                    String sql =("INSERT INTO cases (caseID, caseName, statementID, judgeID, courtID,advocateID," +
                            "paymentID, caseTypeID, sentence, caseStageID,nextHearingDate,nextHearingTime) VALUES ('" + caseId
                            + "','" + caseName + "','" + statementId + "','" + judgeId + "','" + courtId + "','" + advocateId
                            + "','" + payment + "','" + caseType + "','" + sentence + "','" + caseStage +"','" +nextHearingDate+"','" +nextHearingTime + "')");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);

                } catch (SQLException exc) {
                    exc.printStackTrace();
                }


            });





            Scene InsertScene = new Scene(gridForRegistration, 1024, 768);
            this.setScene(InsertScene);
            this.show();
        });



        Button changePassword = new Button("Change Password");
        gridPolice.add(changePassword, 0, 7);
        changePassword.setOnAction(e -> {

            this.setTitle("Registration Screen");
            GridPane gridForPassword = new GridPane();
            gridForPassword.setAlignment(Pos.CENTER);
            gridForPassword.setVgap(10);
            gridForPassword.setHgap(10);
            gridForPassword.setPadding(new Insets(10));
            gridForPassword.setBackground(background);


            Label officerIdLabel = new Label("Officer ID:");
            gridForPassword.add(officerIdLabel, 0, 1);
            TextField officerIdTxt = new TextField();
            gridForPassword.add(officerIdTxt, 1, 1);


            Label officerFNameLabel = new Label("Officer First Name:");
            gridForPassword.add(officerFNameLabel, 0, 2);
            TextField officerFNameTxt = new TextField();
            gridForPassword.add(officerFNameTxt, 1, 2);


            Label officerLNameLabel = new Label("Officer Last Name:");
            gridForPassword.add(officerLNameLabel, 0, 3);
            TextField officerLNameTxt = new TextField();
            gridForPassword.add(officerLNameTxt, 1, 3);


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
                    DataRepository.getInstance().policeChangePassword();
                    Connection connection = DataRepository.getInstance().dbConnection;

                    String myOfficerID = officerIdTxt.getText();
                    String officerFName = officerFNameTxt.getText();
                    String officerLName = officerLNameTxt.getText();
                    String password = newPasswordTxt.getText();


                    Judge passwordChange = new Judge();
                    passwordChange.setJudgeID(myOfficerID);
                    passwordChange.setJudgeFName(officerFName);
                    passwordChange.setJudgeLName(officerLName);
                    passwordChange.setPassword(password);


                    String sql = ("INSERT INTO officer (officerID,officerFName,officerLName,password) VALUES ('"
                            + myOfficerID + "','" + officerFName + "','" + officerLName + "','" + password + "')");
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
        gridPolice.add(logOut, 0, 8);
        logOut.setOnAction(ex -> this.setScene(scene));

    }



}

