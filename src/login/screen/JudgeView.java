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

public class JudgeView extends Stage {


    private String judgeId;


    public JudgeView (String judgeId){

        this.judgeId = judgeId;


        this.setTitle("JUDGE DASHBOARD");


        GridPane gridJudge = new GridPane();
        Scene scene = new Scene(gridJudge, 700, 600);
        gridJudge.setAlignment(Pos.CENTER);
        gridJudge.setVgap(10);
        gridJudge.setHgap(10);
        gridJudge.setPadding(new Insets(10));
        // grid.setBackground(background);
        //ImagePattern pattern = new ImagePattern(image);
        //scene.setFill(pattern);
        //grid.getChildren().addAll(imageView);

        Text welcomeTxt = new Text("Welcome");
        welcomeTxt.setFont(Font.font("Pixel", FontWeight.LIGHT.BOLD, 25));
        gridJudge.add(welcomeTxt, 0, 0);

        Button Profile = new Button("Profile");
        gridJudge.add(Profile, 0, 1);
        Profile.setOnAction(e ->{

            ResultSet profile;
            try {
                profile = DataRepository.getInstance().getJudgeProfile(judgeId);
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
//                    firstNameTxt.setPromptText("First name");
                    firstNameTxt.setText(profile.getString("judgeFName"));
                    gridForProfile.add(firstNameTxt, 1, 1);

                    Label lastNameLabel = new Label("Last Name:");
                    gridForProfile.add(lastNameLabel, 0, 2);
                    Label lastNameTxt = new Label();
//                    lastNameTxt.setPromptText("last name");
                    lastNameTxt.setText(profile.getString("judgeLName"));
                    gridForProfile.add(lastNameTxt, 1, 2);

                    Label caseTypeLabel = new Label("Case Type:");
                    gridForProfile.add(caseTypeLabel, 0, 3);
                    Label caseTypeTxt = new Label();
//                    caseTypeTxt.setPromptText("last name");
                    caseTypeTxt.setText(profile.getString("caseTypeName"));
                    gridForProfile.add(caseTypeTxt, 1, 3);
//
//
//                    Label userGender = new Label("Gender");
//                    gridForProfile.add(userGender, 0, 3);
//                    TextField userGenderTxt = new TextField();
//                    userGenderTxt.setPromptText("username");
//                    gridForProfile.add(userGenderTxt, 1, 3);


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


        Button Cases = new Button("Cases");
        gridJudge.add(Cases, 0, 2);
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
