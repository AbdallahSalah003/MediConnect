import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int MAKE_APPOINTMENT_PORT = 6666;
    public static final int CANCEL_APPOINTMENT_PORT = 6667;
    private static Hospital hospital;
    public static void main(String[] args) {
        hospital = new Hospital("Input.txt");
        // TODO: The server should take requests from clients IN PARALLEL
        // TODO: on both ports for many make and cancel appointments
        new Thread(() -> {
            try {
                ServerSocket ss = new ServerSocket(MAKE_APPOINTMENT_PORT);
                while(true) {
                    new Appointment(ss.accept()).start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();

        new Thread(() -> {
            try {
                ServerSocket ss = new ServerSocket(CANCEL_APPOINTMENT_PORT);
                while(true) {
                    new Appointment(ss.accept()).start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();

    }
    private static class Appointment extends Thread {
        Socket socket;
        public Appointment(Socket s) {
            this.socket = s;
        }
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
                String[] inputs;
                String input;
                while((input = br.readLine()) != null) {
                    inputs = input.split(" ");
                    boolean check;
                    if(this.socket.getLocalPort() == MAKE_APPOINTMENT_PORT) {
                        check = hospital.makeAppointment(inputs);
                        if(check) {
                            out.println("Appointment is reserved successfully!");
                        } else {
                            out.println("Can not reserve the appointment");
                        }
                    } else {
                        check = hospital.cancelAppointment(inputs);
                        if(check) {
                            out.println("Appointment is canceled successfully!");
                        } else {
                            out.println("Can not cancel the appointment");
                        }
                    }

                }
                br.close();
                out.close();
                this.socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
