package data;

import models.*;

import javax.swing.*;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataRepository {
    public Connection dbConnection = null;
    private static DataRepository dataRepository;
    Statement statement;

    public DataRepository() {
        initializeConnection();
    }

    public static DataRepository getInstance() {
        if (dataRepository == null) {
            dataRepository = new DataRepository();
        }
        return dataRepository;
    }

    private void initializeConnection() {
        try {
            String url = "jdbc:mysql://remotemysql.com:3306/utNwEmfi1A";
            Properties info = new Properties();
            info.put("user", "utNwEmfi1A");
            info.put("password", "0SQLl7fKZP");

            dbConnection = DriverManager.getConnection(url, info);

            if (dbConnection != null) {
                System.out.println("Successfully connected to MySQL database");
                statement = dbConnection.createStatement();
            }

        } catch (
                Exception ex) {
            System.out.println("An error occurred while connecting MySQL database");
            ex.printStackTrace();
        }
    }



    int count = 0;

    public  List<Case> insertCases() throws SQLException {
        List<Case> cases = new ArrayList<>();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM cases");
        while(resultSet.next()) {
            Case courtCase = new Case();
            courtCase.setCaseID(resultSet.getString("caseID"));
            courtCase.setCaseName(resultSet.getString("caseName"));
            courtCase.setStatementID(resultSet.getString("statementID"));
            courtCase.setJudgeID(resultSet.getString("judgeID"));
            courtCase.setCourtID(resultSet.getString("courtID"));
            courtCase.setAdvocateID(resultSet.getString("AdvocateID"));
            courtCase.setPaymentID(resultSet.getString("paymentID"));
            courtCase.setCaseTypeID(resultSet.getString("caseTypeID"));
            courtCase.setSentence(resultSet.getString("sentence"));
            courtCase.setCaseStage(resultSet.getString("caseStageID"));
            courtCase.setNextHearingDate(resultSet.getString("nextHearingDate"));
            courtCase.setNextHearingTime(resultSet.getString("nextHearingTime"));
            cases.add(courtCase);
        }
        JOptionPane.showMessageDialog(null, "Case Created Successfully");

        return cases;
    }



    public  List<Company> insertCompanyDetails() throws SQLException {
        List<Company> cases = new ArrayList<>();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM company");
        while(resultSet.next()) {
            Company companyCase = new Company();
            companyCase.setCompanyID(resultSet.getString("companyID"));
            companyCase.setCompanyName(resultSet.getString("companyName"));
            companyCase.setCompanyAddress(resultSet.getString("companyAddress"));
            companyCase.setCompanyContact(resultSet.getString("companyContact"));
            companyCase.setPassword(resultSet.getString("password"));


            cases.add(companyCase);
        }
        JOptionPane.showMessageDialog(null, "Case Created Successfully");

        return cases;
    }



    public  List<Individual> insertIndividualDetails() throws SQLException {
        List<Individual> cases = new ArrayList<>();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM individual");
        while(resultSet.next()) {
            Individual indDetails = new Individual();
            indDetails.setIndividualID(resultSet.getString("individualID"));
            indDetails.setIndividualFName(resultSet.getString("individualFName"));
            indDetails.setIndividualLName(resultSet.getString("individualLName"));
            indDetails.setIndividualAge(resultSet.getString("individualAge"));
            indDetails.setIndividualGender(resultSet.getString("individualGender"));
            indDetails.setPassword(resultSet.getString("password"));
            cases.add(indDetails);
        }
        JOptionPane.showMessageDialog(null, "Case Created Successfully");

        return cases;
    }


    public  List<IndividualCase> insertIndividualCaseDetails() throws SQLException {
        List<IndividualCase> cases = new ArrayList<>();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM individualCase");
        while(resultSet.next()) {
            IndividualCase indCaseDetails = new IndividualCase();
            indCaseDetails.setIndividualID(resultSet.getString("individualID"));
            indCaseDetails.setCaseID(resultSet.getString("caseID"));


            cases.add(indCaseDetails);
        }
        JOptionPane.showMessageDialog(null, "Case Created Successfully");

        return cases;
    }



    public  List<CompanyCase> insertCompanyCaseDetails() throws SQLException {
        List<CompanyCase> cases = new ArrayList<>();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM companyCase");
        while(resultSet.next()) {
            CompanyCase companyCaseDetails = new CompanyCase();
            companyCaseDetails.setCompanyID(resultSet.getString("companyID"));
            companyCaseDetails.setCaseID(resultSet.getString("caseID"));


            cases.add(companyCaseDetails);
        }
        JOptionPane.showMessageDialog(null, "Case Created Successfully");

        return cases;
    }



    public  List<Case> judgeAlterCases() throws SQLException {
        List<Case> cases = new ArrayList<>();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM cases");
        while(resultSet.next()) {
            Case alterCase = new Case();
            alterCase.setCaseID(resultSet.getString("caseID"));
            alterCase.setCaseName(resultSet.getString("caseName"));
            alterCase.setStatementID(resultSet.getString("statementID"));
            alterCase.setJudgeID(resultSet.getString("judgeID"));
            alterCase.setCourtID(resultSet.getString("courtID"));
            alterCase.setAdvocateID(resultSet.getString("AdvocateID"));
            alterCase.setPaymentID(resultSet.getString("paymentID"));
            alterCase.setCaseTypeID(resultSet.getString("caseTypeID"));
            alterCase.setSentence(resultSet.getString("sentence"));
            alterCase.setCaseStage(resultSet.getString("caseStageID"));
            alterCase.setNextHearingDate(resultSet.getString("nextHearingDate"));
            alterCase.setNextHearingTime(resultSet.getString("nextHearingTime"));
            cases.add(alterCase);
        }
        JOptionPane.showMessageDialog(null, "Case Changed Successfully");

        return cases;
    }


    public  List<Judge> judgeChangePassword() throws SQLException {
        List<Judge> details = new ArrayList<>();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM judge");
        while(resultSet.next()) {
            Judge changePassword = new Judge();
            changePassword.setPassword(resultSet.getString("password"));
            details.add(changePassword);
        }
        JOptionPane.showMessageDialog(null, "Password Changed Successfully");

        return details;
    }


    public  List<Advocate> advocateChangePassword() throws SQLException {
        List<Advocate> details = new ArrayList<>();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM advocate");
        while(resultSet.next()) {
            Advocate changePassword = new Advocate();
            changePassword.setPassword(resultSet.getString("password"));
            details.add(changePassword);
        }
        JOptionPane.showMessageDialog(null, "Password Changed Successfully");

        return details;
    }


    public  List<Individual> individualChangePassword() throws SQLException {
        List<Individual> details = new ArrayList<>();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM individual");
        while(resultSet.next()) {
            Individual changePassword = new Individual();
            changePassword.setPassword(resultSet.getString("password"));
            details.add(changePassword);
        }
        JOptionPane.showMessageDialog(null, "Password Changed Successfully");

        return details;
    }



    public  List<PoliceOfficer> policeChangePassword() throws SQLException {
        List<PoliceOfficer> details = new ArrayList<>();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM officer");
        while(resultSet.next()) {
            PoliceOfficer changePassword = new PoliceOfficer();
            changePassword.setPassword(resultSet.getString("password"));
            details.add(changePassword);
        }
        JOptionPane.showMessageDialog(null, "Password Changed Successfully");

        return details;
    }






    public ResultSet getCourt() throws SQLException {
        return statement.executeQuery("SELECT * FROM court");
    }

    public ResultSet getAdvocates() throws SQLException {
        return statement.executeQuery("SELECT * FROM advocate");
    }

    public ResultSet getIndividualById(String individualId) throws SQLException {
        return statement.executeQuery("SELECT * FROM individual WHERE individualID =" + individualId);
    }

    public ResultSet getJudgeProfile(String judgeId) throws  SQLException {
        return statement.executeQuery(" SELECT * FROM judge WHERE judgeID ='" + judgeId + "'");
    }

    public ResultSet getPoliceProfile(String officerId) throws SQLException {
        return statement.executeQuery("SELECT * FROM officer WHERE officerID ='" + officerId + "'");

    }


    public ResultSet getLawyerProfile(String lawyerId) throws SQLException {
        return statement.executeQuery("SELECT * FROM advocate WHERE advocateID ='" + lawyerId + "'");

    }

    public ResultSet getCompanyProfile(String companyId) throws SQLException {
        return statement.executeQuery("SELECT * FROM company WHERE companyID ='" + companyId + "'");

    }
    public ResultSet getIndividualProfile(String individualId) throws SQLException {
        return statement.executeQuery("SELECT * FROM individual WHERE individualID ='" + individualId + "'");

    }


    public ResultSet getIndividualCases(String individualId) throws SQLException {
        return statement.executeQuery("SELECT cases.*,individualCase.* FROM cases JOIN individualCase WHERE individualID ='" + individualId + "'");

    }


    public ResultSet getCompanyCases(String companyId) throws SQLException {
        return statement.executeQuery("SELECT cases.*,companyCase.* FROM cases JOIN companyCase WHERE companyID ='" + companyId + "'");

    }


    public ResultSet getJudgeCases(String judgeId) throws SQLException {
        return statement.executeQuery("SELECT * FROM cases WHERE judgeID ='" + judgeId + "'");

    }


    public ResultSet getAdvocateCases(String advocateId) throws SQLException {
        return statement.executeQuery("SELECT * FROM cases WHERE advocateID ='" + advocateId + "'");

    }


    public boolean validateJudge(String username, String password) {
        ResultSet resultSet = null;
        try {
            // SELECT from judge where id=username
            resultSet = statement.executeQuery("SELECT * FROM judge WHERE judgeId='" + username + "'");

            // Assert 1 row returned
            if(resultSet.last()){
                count = resultSet.getRow();
            }
            if (count < 1) {
                return false;
            }

            // Assert password in result = password
            if (! resultSet.getString("password").equals(password)) {
                JOptionPane.showMessageDialog(null, "Wrong Password");
                return false;
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        if (resultSet == null) {

            return false;
        }

        return true;
    }


    public boolean validateLawyer(String username, String password) {
        ResultSet resultSet = null;
        try {
            // SELECT from judge where id=username
            resultSet = statement.executeQuery("SELECT * FROM advocate WHERE advocateID='" + username + "'");

            // Assert 1 row returned
            if(resultSet.last()){
                count = resultSet.getRow();
            }
            if (count < 1) {
                return false;
            }

            // Assert password in result = password
            if (! resultSet.getString("password").equals(password)) {
                JOptionPane.showMessageDialog(null, "Wrong Password");

                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (resultSet == null) {
            return false;
        }

        return true;
    }




    public boolean validateIndividual(String username, String password) {
        ResultSet resultSet = null;
        try {
            // SELECT from judge where id=username
            resultSet = statement.executeQuery("SELECT * FROM individual WHERE individualID='" + username + "'");

            // Assert 1 row returned
            int count = 0;
            if(resultSet.last()){
                count = resultSet.getRow();
            }
            if (count < 1) {
                return false;
            }

            // Assert password in result = password
            if (! resultSet.getString("password").equals(password)) {
                JOptionPane.showMessageDialog(null, "Wrong Password");

                return false;

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        if (resultSet == null) {
            return false;
        }

        return true;
    }

    public boolean validatePolice(String username, String password) {
        ResultSet resultSet = null;
        try {
            // SELECT from judge where id=username
            resultSet = statement.executeQuery("SELECT * FROM officer WHERE officerID='" + username + "'");

            // Assert 1 row returned
            int count;
            count = 0;
            if(resultSet.last()){
                count = resultSet.getRow();
            }
            if (count < 1) {
                return false;
            }

            // Assert password in result = password
            if (! resultSet.getString("password").equals(password)) {
                JOptionPane.showMessageDialog(null, "Wrong Password");

                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (resultSet == null) {
            return false;
        }

        return true;
    }

    public boolean validateCompany(String username, String password) {
        ResultSet resultSet = null;
        try {
            // SELECT from judge where id=username
            resultSet = statement.executeQuery("SELECT * FROM company WHERE companyID='" + username + "'");

            // Assert 1 row returned
            count = 0;
            if(resultSet.last()){
                count = resultSet.getRow();
            }
            if (count < 1) {
                return false;
            }

            // Assert password in result = password
            if (! resultSet.getString("password").equals(password)) {
                JOptionPane.showMessageDialog(null, "Wrong Password");

                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (resultSet == null) {
            return false;
        }

        return true;
    }


}
