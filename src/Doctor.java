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
    public String setTimeslot(int slotIndex, boolean setValue, String patientName) {
        if (slotIndex >= 0 && slotIndex < this.timeslots.length) {
            if (this.timeslots[slotIndex] && setValue) return "The doctor is already busy at this timeslot";
            if (!this.timeslots[slotIndex] && !setValue) return "The doctor doesn't has an appointment at this timeslot!";
            if (!setValue && !patientName.equals(this.patients[slotIndex])) return "This timeslot belongs to other patient!";
            this.timeslots[slotIndex] = setValue;
            if (setValue) {
                this.patients[slotIndex] = patientName;
                return "Making the appointment is done successfully";
            } else {
                this.patients[slotIndex] = null;
                return "Cancel the appointment is done successfully";
            }
        }
        return "The timeslot is out of boundary";
    }
    public void printDoctorInfo() {
        System.out.println("Doctor Info: ");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Timeslots:");
        for (int i = 0; i < timeslots.length; i++) {
            System.out.println("Slot " + i + ": " + (timeslots[i] ? "Patient: " + patients[i]: "Not Booked "));
        }
    }
}
