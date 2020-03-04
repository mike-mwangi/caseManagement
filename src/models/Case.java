package models;

public class Case {
    private String caseID;
    private String caseName;
    private String statementID;
    private String judgeID;
    private String courtID;
    private String advocateID;
    private String paymentID;
    private String caseTypeID;
    private String sentence;
    private String caseStage;
    private String nextHearingDate;
    private String nextHearingTime;




    public String getCaseStage() {
        return caseStage;
    }

    public String getCaseID() {
        return caseID;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseStage(String caseStage) {
        this.caseStage = caseStage;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }



    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getStatementID() {
        return statementID;
    }

    public void setStatementID(String statementID) {
        this.statementID = statementID;
    }

    public String getJudgeID() {
        return judgeID;
    }

    public void setJudgeID(String judgeID) {
        this.judgeID = judgeID;
    }

    public String getCourtID() {
        return courtID;
    }

    public void setCourtID(String courtID) {
        this.courtID = courtID;
    }

    public String getAdvocateID() {
        return advocateID;
    }

    public void setAdvocateID(String advocateID) {
        this.advocateID = advocateID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getCaseTypeID() {
        return caseTypeID;
    }

    public void setCaseTypeID(String caseTypeID) {
        this.caseTypeID = caseTypeID;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getNextHearingDate() {
        return nextHearingDate;
    }

    public void setNextHearingDate(String nextHearingDate) {
        this.nextHearingDate = nextHearingDate;
    }

    public String getNextHearingTime() {
        return nextHearingTime;
    }

    public void setNextHearingTime(String nextHearingTime) {
        this.nextHearingTime = nextHearingTime;
    }
}
