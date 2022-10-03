package tcpdemo;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception {

        // Try to create a connection with 127.0.0.1:9000
        // The s port will be defined by the OS (from 1024 to 65535)
        Socket s = new Socket("127.0.0.1",9000);

        // Create an output stream to the socket (writer)
        OutputStream os = s.getOutputStream();
        DataOutputStream writer = new DataOutputStream(os);

        // Create an input stream to the socket (reader)
        InputStreamReader is = new InputStreamReader(s.getInputStream());
        BufferedReader reader = new BufferedReader(is);

        // Create a keyboard buffer
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        String text = inFromUser.readLine();   // Blocking

        // Write to the socket
        writer.writeBytes(text + "\n");

        // Read from the socket
        String response = reader.readLine();   // Blocking
        System.out.println("From server: " + response);

        // Close the socket
        s.close();
    }
}
