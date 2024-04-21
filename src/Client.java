import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static final int MAKE_APPOINTMENT_PORT = 6666;
    public static final int CANCEL_APPOINTMENT_PORT = 6667;
    public static void main(String[] args) throws IOException {
        System.out.print("Please enter your name: ");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String patientName = consoleReader.readLine();
        Socket makeSocket = null, cancelSocket = null;
        PrintWriter out1 = null, out2 = null;
        try {
            // Open two sockets for make and cancel
            makeSocket = new Socket("localhost", MAKE_APPOINTMENT_PORT);
            cancelSocket = new Socket("localhost", CANCEL_APPOINTMENT_PORT);
            // Send patient's name to both sockets
            out1 = new PrintWriter(makeSocket.getOutputStream(), true);
            out2 = new PrintWriter(cancelSocket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader socketReader_make = new BufferedReader(new InputStreamReader(makeSocket.getInputStream()));
        BufferedReader socketReader_cancel = new BufferedReader(new InputStreamReader(cancelSocket.getInputStream()));
        while (true) {
            System.out.println("Enter\n 1 to make a new appointment\n 2 to cancel an appointment");
            int inpt = Integer.parseInt(consoleReader.readLine());
            System.out.print("Enter Doctor ID: \n");
            String docID = consoleReader.readLine();
            System.out.println("Enter Timeslot: ");
            int timeSlot = Integer.parseInt(consoleReader.readLine());
            String response = null;
            if(inpt == 1) {
                // make appointment
                out1.println(docID + ' ' + patientName + ' ' + timeSlot);
                response = socketReader_make.readLine();
            } else {
                // cancel appointment
                out2.println(docID + ' ' + patientName + ' ' + timeSlot);
                response = socketReader_cancel.readLine();
            }
            System.out.println("Result: " + response);
            System.out.println("Press 2 to Exit!");
            String toExit = consoleReader.readLine();
            if(toExit.equals("2")) break;
        }
        consoleReader.close();
        socketReader_cancel.close();
        socketReader_make.close();
    }
}
