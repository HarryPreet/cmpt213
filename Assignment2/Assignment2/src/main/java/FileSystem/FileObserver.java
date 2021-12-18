package FileSystem;


public class FileObserver implements Observer{
    FileObserver(File f){
        _subject = f;
    }
    @Override
    public void update(){
        System.out.println("file " +
                _subject.getAbsoluteName() + " has changed.");
    }
    private File _subject;
}
