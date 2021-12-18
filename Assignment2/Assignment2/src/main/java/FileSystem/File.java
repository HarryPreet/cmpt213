package FileSystem;

import java.util.List;
import java.util.ArrayList;

public class File extends Node{
    private List<Observer> _observers = new ArrayList<Observer>();

    File(String n, Directory p){
        super(n,p);
    }

    public List<String> find(String s){
        List<String> result =
                new ArrayList<String>();
        if (_name.indexOf(s) != -1){
            result.add(this.getAbsoluteName());
        }
        return result;
    }

    public void attach(Observer o){
        if (!_observers.contains(o)){
            _observers.add(o);
        }
    }
    public void detach(Observer o){
        _observers.remove(o);
    }

    public void notifyObservers(){
        for (Observer obs : _observers){
            obs.update();
        }
    }
    public void write(String s){
        notifyObservers();
    }



}
