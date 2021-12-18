package ca.courseplanner.model;

import ca.courseplanner.model.WrapperClasses.ApiWatcherWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Courses class contains only the course name,
 * department and the list of all the courses offered.
 */
public class Courses {
    private String courseCatalogNumber;
    private String courseName;
    private String department;
    private int departmentId;
    private long courseId;
    private static long courseOfferingId  = 1;
    private List<CourseOffering> courseOfferings = new ArrayList<>();

    public List<ApiWatcherWrapper> getObservers() {
        return observers;
    }

    public void setObservers(List<ApiWatcherWrapper> observers) {
        this.observers = observers;
    }

    private List<ApiWatcherWrapper> observers = new ArrayList<>();

    // Constructor
    public Courses(CourseData cd) {
        this.courseCatalogNumber = cd.getCatalogNumber();
        this.courseName = cd.getCourseName();
        courseOfferings.add(new CourseOffering(cd));
        this.department = cd.getSubject();
    }

    // Accessor and mutator

    public String getCourseCatalogNumber() {
        return courseCatalogNumber;
    }

    public void setCourseCatalogNumber(String courseCatalogNumber) {
        this.courseCatalogNumber = courseCatalogNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public List<CourseOffering> getCourseOfferings() {
        return courseOfferings;
    }

    public void setCourseOfferings(List<CourseOffering> courseOfferings) {
        this.courseOfferings = courseOfferings;
    }
    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public void notifyObservers(String message){
        for(ApiWatcherWrapper ad : this.observers){
            ad.getEvents().add(message);
        }
    }


    public void addToGroup(CourseData cd){
        if(courseOfferings.isEmpty()){
            CourseOffering co = new CourseOffering(cd);
            co.setCourseOfferingId(courseOfferingId);
            courseOfferingId++;
            courseOfferings.add(co);
        }
        for(CourseOffering co : courseOfferings){
            if(co.getSemester()==cd.getSemester() && co.getLocation().equals(cd.getLocation())){
                co.addToSection(cd);
                return;
            }
        }
        CourseOffering co = new CourseOffering(cd);
        co.setCourseOfferingId(courseOfferingId);
        courseOfferingId++;
        courseOfferings.add(co);
    }

    @Override
    public String toString() {
        String prettyPrint = courseName + courseOfferings;
        prettyPrint = prettyPrint.replace("[", "");
        prettyPrint = prettyPrint.replace("]", "");
        prettyPrint = prettyPrint.replace(",\n", "\n");
        prettyPrint = prettyPrint.replace(", ", " ");
        return prettyPrint;
    }
}