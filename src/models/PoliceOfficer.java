package models;

public class PoliceOfficer {
    private String officerID;
    private String officerFName;
    private String officerLName;
    private String password;

    public String getOfficerID() {
        return officerID;
    }

    public void setOfficerID(String officerID) {
        this.officerID = officerID;
    }

    public String getOfficerFName() {
        return officerFName;
    }

    public void setOfficerFName(String officerFName) {
        this.officerFName = officerFName;
    }

    public String getOfficerLName() {
        return officerLName;
    }

    public void setOfficerLName(String officerLName) {
        this.officerLName = officerLName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
