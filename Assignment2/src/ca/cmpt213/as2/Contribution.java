package ca.cmpt213.as2;

//Extension of group class to store comment and score
public class Contribution {
    private Float score;
    private String comment;

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getComment() {
        return "\""+ comment.replace("\n","")+"\"";
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ca.cmpt213.as2.Contribution{" +
                "score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }
}
