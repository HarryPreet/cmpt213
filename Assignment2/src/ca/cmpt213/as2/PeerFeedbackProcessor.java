package ca.cmpt213.as2;

import com.google.gson.*;

import java.io.*;
import java.util.*;



public class PeerFeedbackProcessor {

    public static void main(String[] args) {

        //Strings from terminal
        if(args.length>=0 && args.length<2){
            System.out.println("Error! Wrong number of arguments than expected!");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        File input = new File(inputFile);
        List<File> jsonFiles = new ArrayList<File>();

        //Puttling all json files in one Array list object
        RecursiveSearch.search(input, jsonFiles);
        FeedbackElementManager ungroupedFeedback = new FeedbackElementManager();
        StudentManager studentBase = new StudentManager();

        //Mapping all group members
        HashMap<String, String> groupChecker = new HashMap<String, String>();

        List<String> found = new ArrayList<String>();

        try {
            for (File subFiles : jsonFiles) {

                //Process all feedback
                JsonElement fileElement = JsonParser.parseReader(new FileReader(subFiles));
                JsonObject fileObject = fileElement.getAsJsonObject();
                Gson g = new Gson();
                Feedback feedback = g.fromJson(fileObject, Feedback.class);

                String SrcStudentEmail = feedback.getGroup().get(0).getSfu_email();
                Student s = new Student(SrcStudentEmail);
                float checkScore = 0;
                int n = 0;

                for (FeedbackElement iteratingElement : feedback.getGroup()) {
                    n = n + 1;
                    checkScore = checkScore + iteratingElement.getContribution().getScore();
                    FeedbackElement feedbackElement = new FeedbackElement(iteratingElement.getSfu_email(), iteratingElement.getContribution(), iteratingElement.getSourceStudent(), feedback.getConfidential_comments());
                    feedbackElement.setSourceStudent(SrcStudentEmail);
                    ungroupedFeedback.add(feedbackElement);
                    groupChecker.put(SrcStudentEmail, iteratingElement.getSfu_email());
                    s.getGroup().add(iteratingElement.getSfu_email());
                }
                if( Math.abs(checkScore-(20 * n)) > 0.1){
                    System.out.println("Error! Sum of scores not validating criteria(20*number of members in group! ");
                }

                studentBase.add(s);
            }
            //Only one File
            if (studentBase.getSize() == 1) {
                System.out.println("Error!Only one input file!");
                return;
            }

            //Grouping
            int j = 1;
            for (FeedbackElement iterator : ungroupedFeedback) {
                for (int i = 0; i < studentBase.getSize(); ++i) {
                    if (studentBase.getStudents().get(i).getGroup().contains(iterator.getSourceStudent()) && !found.contains(iterator.getSourceStudent())) {
                        found.addAll(studentBase.getStudents().get(i).getGroup());
                        iterator.setTeam(j);
                        j++;
                        break;
                    } else if (!studentBase.getStudents().get(i).getGroup().contains(iterator.getSourceStudent()) && found.contains(iterator.getSourceStudent())) {
                        iterator.setTeam(j);
                    }
                }

            }

            Collections.sort(ungroupedFeedback.getRowFeedback(), new Comparator<FeedbackElement>() {
                @Override
                public int compare(FeedbackElement f1, FeedbackElement f2) {
                    boolean flag;
                    int c = 0;
                    if (f1.getTeam() < f2.getTeam()) {
                        return -1;
                    } else if (f1.getTeam() > f2.getTeam()) {
                        return 1;
                    } else if (f1.getTeam() == f2.getTeam()) {
                        c = f1.getSourceStudent().compareTo(f2.getSourceStudent());
                        return c;
                    }
                    return 0;

                }
            });
        } catch (FileNotFoundException e) {
                System.out.println("Error! ");
            }
        catch(Exception e){
            System.out.println("Error opening input file");
        }
        try{
                FileWriter csvWriter = new FileWriter(outputFile);
                csvWriter.append("Group#,Source Student,Target Student,Score,Comment,,Private\n");
                for (FeedbackElement iterator : ungroupedFeedback) {
                    if(iterator.getSfu_email()==iterator.getSourceStudent()){
                        csvWriter.append("-->"+"Group" + iterator.getTeam() + "," +iterator.getSfu_email() + "," + iterator.getContribution().getScore() + "," +iterator.getContribution().getComment()+","+iterator.getConfidential()+"\n");
                    }
                    csvWriter.append("Group" + iterator.getTeam() + "," + iterator.getSourceStudent() + "," + iterator.getSfu_email() + "," + iterator.getContribution().getScore() + ",," +iterator.getContribution().getComment()+"\n");
                }
                csvWriter.flush();
                csvWriter.close();

        }
        catch (IOException f){
            System.out.println("Error Opening File!");

        }


    }
}
