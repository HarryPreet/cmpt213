package FileSystem;
import java.util.List;
import java.util.ArrayList;

public class Directory extends Node {
    private String name;

    Directory(String n) {
        this(n, null);
    }

    Directory(String n, Directory p) {
        super(n,p);
        _children = new ArrayList<Node>();
    }

    public String getAbsoluteName() {
        return super.getAbsoluteName() + "/";
    }

    public void add(Node n) {
        _children.add(n);
    }

    public List<String> find(String s) {
        List<String> result =
                new ArrayList<String>();
        if (_name.indexOf(s) != -1) {
            result.add(getAbsoluteName());
        }
        for (Node child : _children) {
            result.addAll(child.find(s));
        }
        return result;
    }

    private List<Node> _children;
}


