package data;

import java.sql.*;
import java.util.Properties;

public class DataRepository {
    private Connection dbConnection = null;
    private static DataRepository dataRepository;
    Statement statement;

    private DataRepository() {
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
            String url = "jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2322920";
            Properties info = new Properties();
            info.put("user", "sql2322920");
            info.put("password", "rL7%mG3%");

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

    public ResultSet getCases() throws SQLException {
        return statement.executeQuery("SELECT * FROM cases");
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

//    public ResultSet getJudgeProfile(String judgeId) throws SQLException {
//        return statement.executeQuery("SELECT * FROM judge WHERE judgeId ='" + judgeId + "'");
//    }

    public ResultSet getJudgeProfile(String judgeId) throws  SQLException {
        return statement.executeQuery("SELECT  judge.judgeID,judge.judgeFName,judge.judgeLName,casetype.caseTypeID,casetype.caseTypeName FROM judge INNER JOIN casetype WHERE judge.caseTypeID = casetype.caseTypeID && judgeId ='" +judgeId + "'");
    }



    public ResultSet getPoliceProfile(String officerId) throws SQLException {
        return statement.executeQuery("SELECT * FROM officer WHERE officerID ='" + officerId + "'");

    }
}
