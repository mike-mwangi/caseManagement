package models;

public class Advocate {
    private String advocateID;
    private String advocateFName;
    private String advocateLName;
    private String password;

    public String getAdvocateID() {
        return advocateID;
    }

    public void setAdvocateID(String advocateID) {
        this.advocateID = advocateID;
    }

    public String getAdvocateFName() {
        return advocateFName;
    }

    public void setAdvocateFName(String advocateFName) {
        this.advocateFName = advocateFName;
    }

    public String getAdvocateLName() {
        return advocateLName;
    }

    public void setAdvocateLName(String advocateLName) {
        this.advocateLName = advocateLName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
