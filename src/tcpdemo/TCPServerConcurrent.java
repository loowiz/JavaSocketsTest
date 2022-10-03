package tcpdemo;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerConcurrent {
    public static void main(String[] args) throws Exception {

        // Create socket to listen to the port 9000
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            // Create a new socket with the node (blocking)
            // The port is defined by the OS
            System.out.println("Waiting connection...");
            Socket node = serverSocket.accept();
            System.out.println("Connection established!");

            // Thread to attend the new node
            ThreadAttend thread = new ThreadAttend(node);
            thread.start();
        }
    }
}
