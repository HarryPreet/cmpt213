package finalexam.infection;

/**
 * Represent a patient at a hospital
 */
public class Patient {
    private String name;
    private int age;
    private boolean isSick;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isSick() {
        return isSick;
    }
    public void setSick(boolean isSick) {
        this.isSick = isSick;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                '}';
    }

    public void treatedBy(Worker worker, String description) {
        System.out.println(this + " treated by " + worker + " for " + description);
    }
}
