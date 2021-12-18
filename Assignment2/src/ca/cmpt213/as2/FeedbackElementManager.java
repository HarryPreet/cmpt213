package ca.cmpt213.as2;

import java.util.*;

//Class to implement Feedback Element as a list

public class FeedbackElementManager implements Iterable<FeedbackElement> {

    private List<FeedbackElement> rowFeedback= new ArrayList<>();
    private int size;

    public void add(FeedbackElement f){
        rowFeedback.add(f);
        size++;
    }
    public void remove(FeedbackElement f){
        rowFeedback.remove(f);
    }

    public List<FeedbackElement> getRowFeedback() {
        return rowFeedback;
    }

    public void setRowFeedback(List<FeedbackElement> rowFeedback) {
        this.rowFeedback = rowFeedback;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public Iterator<FeedbackElement> iterator() {
        return rowFeedback.iterator();
    }
}
