package ca.cmpt213.as2;

import java.util.List;

//Class to store entire JSON file
public class Feedback {
    private List<FeedbackElement> group = null;
    private String confidential_comments;
    public List<FeedbackElement> getGroup() {
        return group;
    }
    public void setGroup(List<FeedbackElement> group) {
        this.group = group;
    }
    public String getConfidential_comments() {
        return confidential_comments;
    }
    public void setConfidential_comments(String confidential_comments) {
        this.confidential_comments = confidential_comments;
    }

    @Override
    public String toString() {
        return "ca.cmpt213.as2.Example{" +
                "group=" + group +
                ", confidentialComments='" + confidential_comments + '\'' +
                '}';
    }
}
