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
    public String getDoctorId() {
        return this.id;
    }
    public boolean setTimeslot(int slotIndex, String patientName) {
        if (slotIndex >= 0 && slotIndex < this.timeslots.length && !this.timeslots[slotIndex]) {
            timeslots[slotIndex] = true;
            patients[slotIndex] = patientName;
            return true;
        }
        return false;
    }
}
