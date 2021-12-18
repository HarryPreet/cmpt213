package finalexam.infection;

/**
 * Simple class to test creating a scenario with patients and a health care worker
 */
public class Hospital {
    public static void main(String[] args) {
        Patient p1 = new Patient("I.R. Healthy", 18);
        Patient p2 = new Patient("Mr. Hammer", 50);
        p2.setSick(true);

        Worker w1 = new Worker("Dr. Fix");
        w1.treat(p1, "Headache");
        w1.treat(p2, "Cough");

        // No change to health:
        p1.setSick(false);

        // Change to health:
        p1.setSick(true);
        p2.setSick(false);
    }
}
