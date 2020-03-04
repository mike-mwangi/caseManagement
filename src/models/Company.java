package models;

public class Company {
    private String companyID;
    private String CompanyName;
    private String CompanyAddress;
    private String CompanyContact;
    private String password;

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        CompanyAddress = companyAddress;
    }

    public String getCompanyContact() {
        return CompanyContact;
    }

    public void setCompanyContact(String companyContact) {
        CompanyContact = companyContact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
