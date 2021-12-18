package ca.cmpt213.as2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Class to implement Student class as a list
public class StudentManager implements Iterable<Student> {
    private List<Student> students = new ArrayList<>();
    private int size;

    @Override
    public String toString() {
        return "StudentManager{" +
                "students=" + students +
                ", size=" + size +
                '}';
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(Student s){
        students.add(s);
        size++;
    }
    public void remove(Student s){
        students.remove(s);
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}
