import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static final int MAKE_APPOINTMENT_PORT = 6666;
    public static final int CANCEL_APPOINTMENT_PORT = 6667;
    public static void main(String[] args) {
        System.out.print("Please enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String patientName = scanner.nextLine();
        Socket makeSocket = null, cancelSocket = null;
        try {
            // Open two sockets for make and cancel
            makeSocket = new Socket("localhost", MAKE_APPOINTMENT_PORT);
            cancelSocket = new Socket("localhost", CANCEL_APPOINTMENT_PORT);
            // Send patient's name to both sockets
            PrintWriter out = new PrintWriter(makeSocket.getOutputStream());
            out.println(patientName);
            out = new PrintWriter(cancelSocket.getOutputStream());
            out.println(patientName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
