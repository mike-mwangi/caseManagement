package models;

public class Judge {
    private String judgeID;
    private String judgeFName;
    private String judgeLName;
    private String caseType;
    private String password;

    public String getJudgeID() {
        return judgeID;
    }

    public void setJudgeID(String judgeID) {
        this.judgeID = judgeID;
    }

    public String getJudgeFName() {
        return judgeFName;
    }

    public void setJudgeFName(String judgeFName) {
        this.judgeFName = judgeFName;
    }

    public String getJudgeLName() {
        return judgeLName;
    }

    public void setJudgeLName(String judgeLName) {
        this.judgeLName = judgeLName;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
