package ca.cmpt213.as2;

import java.util.ArrayList;
import java.util.List;

//Class to store email of source student and their group members
public class Student {
    private String email;
    private List<String> group = new ArrayList<>();
    private float averageScore;

    public Student(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getGroup() {
        return group;
    }

    public void setGroup(List<String> group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", group=" + group +
                '}' +'\n';
    }
}
