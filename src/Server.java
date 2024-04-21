public class Server {
    public static final int MAKE_APPOINTMENT_PORT = 6666;
    public static final int CANCEL_APPOINTMENT_PORT = 6667;
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Input.txt");
        // TODO: The server should take requests from clients IN PARALLEL
        // TODO: on both ports for many make and cancel appointments

    }
}
