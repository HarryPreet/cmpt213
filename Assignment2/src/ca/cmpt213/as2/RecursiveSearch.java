package ca.cmpt213.as2;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

//Program to Recursively Search the directory

public class RecursiveSearch {
    public static void search(File currentFolder, List<File> jsonFiles) {
        FileFilter j = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".json") || file.isDirectory();
            }
        };

        try {
            for (File subFile : currentFolder.listFiles(j)) {
                if (subFile.isDirectory()) {
                    search(subFile, jsonFiles);
                } else {
                    jsonFiles.add(subFile);
                }
            }
        }
        catch( Exception e){
            System.out.println("Error!No files!");
        }
    }
}
