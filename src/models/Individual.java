package models;

public class Individual {
    private String individualID;
    private String individualFName;
    private String individualLName;
    private String individualAge;
    private String individualGender;
    private String password;

    public String getIndividualID() {
        return individualID;
    }

    public void setIndividualID(String individualID) {
        this.individualID = individualID;
    }

    public String getIndividualFName() {
        return individualFName;
    }

    public void setIndividualFName(String individualFName) {
        this.individualFName = individualFName;
    }

    public String getIndividualLName() {
        return individualLName;
    }

    public void setIndividualLName(String individualLName) {
        this.individualLName = individualLName;
    }

    public String getIndividualAge() {
        return individualAge;
    }

    public void setIndividualAge(String individualAge) {
        this.individualAge = individualAge;
    }

    public String getIndividualGender() {
        return individualGender;
    }

    public void setIndividualGender(String individualGender) {
        this.individualGender = individualGender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
