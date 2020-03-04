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
import models.Case;
import models.Judge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JudgeView extends Stage {

    Stage windowForCases;


    private String judgeId;

    GridPane gridJudge = new GridPane();



    public JudgeView (String judgeId,Scene myScene) throws FileNotFoundException {

        this.judgeId = judgeId;


        this.setTitle("JUDGE DASHBOARD");


        Scene scene = new Scene(gridJudge, 1024, 768);
        gridJudge.setAlignment(Pos.CENTER);
        gridJudge.setVgap(10);
        gridJudge.setHgap(10);
        gridJudge.setPadding(new Insets(10));
        FileInputStream inputStream = new FileInputStream("/home/mike/Downloads/justice9.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(new Image(inputStream), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        gridJudge.setBackground(background);


        Text welcomeTxt = new Text("Welcome");
        welcomeTxt.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 25));
        gridJudge.add(welcomeTxt, 0, 0);

        Button Profile = new Button("Profile");
        gridJudge.add(Profile, 0, 1);
        Profile.setOnAction(e -> {

            ResultSet profile;
            try {
                profile = DataRepository.getInstance().getJudgeProfile(judgeId);
                while (profile.next()) {
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
                    firstNameTxt.setText(profile.getString("judgeFName"));
                    gridForProfile.add(firstNameTxt, 1, 1);

                    Label lastNameLabel = new Label("Last Name:");
                    gridForProfile.add(lastNameLabel, 0, 2);
                    Label lastNameTxt = new Label();
                    lastNameTxt.setText(profile.getString("judgeLName"));
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
        gridJudge.add(Cases, 0, 2);

        Cases.setOnAction(e -> {

            ResultSet cases;
            try {
                cases = DataRepository.getInstance().getJudgeCases(judgeId);
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


                    Label advocateLabel = new Label("Advocate:");
                    gridForCases.add(advocateLabel, 0, 5);
                    Label advocateTxt = new Label();
                    advocateTxt.setText(cases.getString("advocateID"));
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


        Button alterCases = new Button("Alter Cases");
        gridJudge.add(alterCases, 0, 3);
        alterCases.setOnAction(e -> {

            this.setTitle("Registration Screen");
            GridPane gridForAlter = new GridPane();
            gridForAlter.setAlignment(Pos.CENTER);
            gridForAlter.setVgap(10);
            gridForAlter.setHgap(10);
            gridForAlter.setPadding(new Insets(10));
            gridForAlter.setBackground(background);


            Label caseIdLabel = new Label("Case ID:");
            gridForAlter.add(caseIdLabel, 0, 1);
            TextField caseIdText = new TextField();
            gridForAlter.add(caseIdText, 1, 1);


            Label caseNameLabel = new Label("Case Name:");
            gridForAlter.add(caseNameLabel, 0, 2);
            TextField caseNameTxt = new TextField();
            gridForAlter.add(caseNameTxt, 1, 2);

            Label statementIdLabel = new Label("Statement:");
            gridForAlter.add(statementIdLabel, 0, 3);
            TextField statementIdTxt = new TextField();
            gridForAlter.add(statementIdTxt, 1, 3);

            Label judgeIdLabel = new Label("Judge:");
            gridForAlter.add(judgeIdLabel, 0, 4);
            TextField judgeIdTxt = new TextField();
            gridForAlter.add(judgeIdTxt, 1, 4);


            Label courtLabel = new Label("Court:");
            gridForAlter.add(courtLabel, 0, 5);
            TextField courtTxt = new TextField();
            gridForAlter.add(courtTxt, 1, 5);

            Label advocateLabel = new Label("Advocate:");
            gridForAlter.add(advocateLabel, 0, 6);
            TextField advocateTxt = new TextField();
            gridForAlter.add(advocateTxt, 1, 6);

            Label paymentLabel = new Label("Payment:");
            gridForAlter.add(paymentLabel, 0, 7);
            TextField paymentTxt = new TextField();
            gridForAlter.add(paymentTxt, 1, 7);

            Label caseTypeLabel = new Label("Case Type:");
            gridForAlter.add(caseTypeLabel, 0, 8);
            TextField caseTypeTxt = new TextField();
            gridForAlter.add(caseTypeTxt, 1, 8);

            Label sentenceLabel = new Label("Sentence:");
            gridForAlter.add(sentenceLabel, 0, 9);
            TextField sentenceTxt = new TextField();
            gridForAlter.add(sentenceTxt, 1, 9);

            Label caseStageLabel = new Label("Case Stage:");
            gridForAlter.add(caseStageLabel, 0, 10);
            TextField caseStageTxt = new TextField();
            gridForAlter.add(caseStageTxt, 1, 10);

            Label nextHearingDateLabel = new Label("Next Hearing Date:");
            gridForAlter.add(nextHearingDateLabel, 0, 11);
            TextField nextHearingDateTxt = new TextField();
            gridForAlter.add(nextHearingDateTxt, 1, 11);

            Label nextHearingTimeLabel = new Label("Next Hearing Time:");
            gridForAlter.add(nextHearingTimeLabel, 0, 12);
            TextField nextHearingTimeTxt = new TextField();
            gridForAlter.add(nextHearingTimeTxt, 1, 12);


            Button back = new Button("Back");
            gridForAlter.add(back, 0, 13);
            back.setOnAction(ex -> this.setScene(scene));


            Button save = new Button("Save");
            gridForAlter.add(save, 3, 13);
            save.setOnAction(ex -> {

                try {
                    DataRepository.getInstance().judgeAlterCases();
                    Connection connection = DataRepository.getInstance().dbConnection;


                    String caseId = caseIdText.getText();
                    String caseName = caseNameTxt.getText();
                    String statementId = statementIdTxt.getText();
                    String judgeID = judgeIdTxt.getText();
                    String courtId = courtTxt.getText();
                    String advocateId = advocateTxt.getText();
                    String payment = paymentTxt.getText();
                    String caseType = caseTypeTxt.getText();
                    String sentence = sentenceTxt.getText();
                    String caseStage = caseStageTxt.getText();
                    String nextHearingDate = nextHearingDateTxt.getText();
                    String nextHearingTime = nextHearingDateTxt.getText();


                    Case courtCase = new Case();
                    courtCase.getCaseID();
                    courtCase.getCaseName();
                    courtCase.setStatementID(statementId);
                    courtCase.getJudgeID();
                    courtCase.getCourtID();
                    courtCase.getAdvocateID();
                    courtCase.setPaymentID(payment);
                    courtCase.getCaseTypeID();
                    courtCase.setSentence(sentence);
                    courtCase.setCaseStage(caseStage);
                    courtCase.setNextHearingDate(nextHearingDate);
                    courtCase.setNextHearingTime(nextHearingTime);


                    String sql = ("INSERT INTO cases (caseID, caseName, statementID, judgeID, courtID,advocateID," +
                            "paymentID, caseTypeID, sentence, caseStageID,nextHearingDate,nextHearingTime) VALUES ('" + caseId
                            + "','" + caseName + "','" + statementId + "','" + judgeID + "','" + courtId + "','" + advocateId
                            + "','" + payment + "','" + caseType + "','" + sentence + "','" + caseStage + "','" + nextHearingDate + "','" + nextHearingTime + "')");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);


                } catch (SQLException exc) {
                    exc.printStackTrace();
                }

            });

            Scene alterCasesScene = new Scene(gridForAlter, 1024, 768);
            this.setScene(alterCasesScene);
            this.show();

        });


        Button changePassword = new Button("Change Password");
        gridJudge.add(changePassword, 0, 4);
        changePassword.setOnAction(e -> {

            this.setTitle("Registration Screen");
            GridPane gridForPassword = new GridPane();
            gridForPassword.setAlignment(Pos.CENTER);
            gridForPassword.setVgap(10);
            gridForPassword.setHgap(10);
            gridForPassword.setPadding(new Insets(10));
            gridForPassword.setBackground(background);


            Label judgeIdLabel = new Label("Judge ID:");
            gridForPassword.add(judgeIdLabel, 0, 1);
            TextField judgeIdTxt = new TextField();
            gridForPassword.add(judgeIdTxt, 1, 1);


            Label judgeFNameLabel = new Label("Judge First Name:");
            gridForPassword.add(judgeFNameLabel, 0, 2);
            TextField judgeFNameTxt = new TextField();
            gridForPassword.add(judgeFNameTxt, 1, 2);


            Label judgeLNameLabel = new Label("Judge Last Name:");
            gridForPassword.add(judgeLNameLabel, 0, 3);
            TextField judgeLNameTxt = new TextField();
            gridForPassword.add(judgeLNameTxt, 1, 3);

            Label caseTypeLabel = new Label("Judge Case Type:");
            gridForPassword.add(caseTypeLabel, 0, 4);
            TextField caseTypeTxt = new TextField();
            gridForPassword.add(caseTypeTxt, 1, 4);

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
                    DataRepository.getInstance().judgeChangePassword();
                    Connection connection = DataRepository.getInstance().dbConnection;

                    String myJudgeID = judgeIdTxt.getText();
                    String judgeFName = judgeFNameTxt.getText();
                    String judgeLName = judgeLNameTxt.getText();
                    String caseType = caseTypeTxt.getText();
                    String password = newPasswordTxt.getText();


                    Judge passwordChange = new Judge();
                    passwordChange.setJudgeID(myJudgeID);
                    passwordChange.setJudgeFName(judgeFName);
                    passwordChange.setJudgeLName(judgeLName);
                    passwordChange.setCaseType(caseType);
                    passwordChange.setPassword(password);


                    String sql = ("INSERT INTO judge (judgeID,judgeFName,judgeLName,caseTypeID,password) VALUES ('" + myJudgeID + "','" + judgeFName + "','" + judgeLName + "','" + caseType + "','" + password + "')");
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
            gridJudge.add(logOut, 0, 7);
            logOut.setOnAction(ex -> this.setScene(scene));

        }

    }












