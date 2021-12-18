package finalexam.infection;

/**
 * Represent a health care worker at a hospital
 */
public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void treat(Patient patient, String description) {
        patient.treatedBy(this, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                '}';
    }
}
