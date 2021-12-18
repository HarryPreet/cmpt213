package FileSystem;

public class FileSystemMain {
    public static void main(String[] args){
        Directory root = new Directory("");
        Directory usr = new Directory("usr", root);
        new File("core", root);
        new File("adm", usr);
        new Directory("foo", usr);
        new File("bar1", usr);
        new File("xbar2", usr);
        Directory bar1 = new Directory("bar1", usr);
        new File("bar4", bar1);
        new Directory("yybarzz3", usr);
        System.out.println(root.find("bar"));
        System.out.println(root.find("core"));
        System.out.println(root.find("foo"));


      /*  File core = new File("core", root);
//        core.attach(new Observer() {
//            @Override
//            public void update(){
//                System.out.println("file " +
//                        core.getAbsoluteName() + " has changed.");
//            }
//            private File _subject = core;
//        });
         //Observer fobj = ()->System.out.println("file " + core.getAbsoluteName() + " has changed.");
         //core.attach(fobj);
         FileObserver f = new FileObserver(core);
         core.attach(f);
         core.write("hello");
         core.write("world");*/
    }

}
