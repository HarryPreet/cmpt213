package ca.cmpt213.as2;

//Feedback Element Stores a group of feedback from the JSON file
public class FeedbackElement {
    private String sfu_email;
    private Contribution contribution;
    private String sourceStudent;
    private int team;

    public String getConfidential() {
        return "\""+confidential.replace("\n","")+"\"";
    }

    public void setConfidential(String confidential) {
        this.confidential = confidential;
    }

    private String confidential;

    public FeedbackElement(String sfu_email, Contribution contribution, String sourceStudent, String confidentialComment) {
        this.sfu_email = sfu_email;

        this.contribution = contribution;
        this.sourceStudent = sourceStudent;
        this. confidential = confidentialComment;
        this.team=1;
    }

    public String getSfu_email() {
        return sfu_email;
    }

    public void setSfu_email(String sfu_email) {
        this.sfu_email = sfu_email;
    }

    public Contribution getContribution() {
        return contribution;
    }

    public void setContribution(Contribution contribution) {
        this.contribution = contribution;
    }

    public String getSourceStudent() {
        return sourceStudent;
    }

    public void setSourceStudent(String sourceStudent) {
        this.sourceStudent = sourceStudent;
    }


    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "FeedbackElement{" +
                "sfu_email='" + sfu_email + '\'' +
                ", contribution=" + contribution +
                ", sourceStudent='" + sourceStudent + '\'' +
                ", team=" + team +
                '}';
    }
}
