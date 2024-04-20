public class Doctor {
    private String id;
    private String name;
    private boolean[] timeslots;
    private String[] patients;

    public Doctor(String id, String name, int numberOfSlots) {
        this.id = id;
        this.name = name;
        this.timeslots = new boolean[numberOfSlots];
        this.patients = new String[numberOfSlots];
    }
}
