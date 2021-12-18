package FileSystem;
import java.util.List;

public abstract class Node {
    Node(String name, Directory parent) {
        this._name = name;
        this._parent = parent;
        if(this._parent != null) {
            _parent.add(this);
        }
    }
    public String getAbsoluteName() {
        if (this._parent != null) {
            return this._parent.getAbsoluteName() + this._name;
        }
        return this._name;
    }

    public String toString() {
        return getAbsoluteName();
    }
    public abstract List<String> find(String s);
    protected String _name;
    protected Directory _parent;
}