package ca.courseplanner;

import ca.courseplanner.model.CourseSummary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        CourseSummary.createModel();
        SpringApplication.run(Application.class, args);
    }
}
