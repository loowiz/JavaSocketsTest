package tcpdemo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

public class ThreadAttend extends Thread {

    private Socket node;

    public ThreadAttend (Socket node) {
        this.node = node;
    }

    public void run() {

        try {
            // Create an input stream to the socket (reader)
            InputStreamReader is = new InputStreamReader(node.getInputStream());
            BufferedReader reader = new BufferedReader(is);

            // Create an output stream to the socket (writer)
            OutputStream os = node.getOutputStream();
            DataOutputStream writer = new DataOutputStream(os);

            // Socket read
            String text = reader.readLine();    // Blocking

            // Socket write
            writer.writeBytes(text.toUpperCase() + "\n");

            // Close the socket
            node.close();

        } catch (Exception e) { }
    }
}

