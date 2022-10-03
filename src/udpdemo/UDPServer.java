package udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws Exception {

        // Communication channel not oriented by connection (port 9876)
        DatagramSocket serverSocket = new DatagramSocket(9876);

        while (true) {
            // Receive buffer
            byte[] recBuffer = new byte[1024];

            // Create receive datagram
            DatagramPacket recPacket = new DatagramPacket(recBuffer, recBuffer.length);

            // Receive remote host datagram
            System.out.println("Waiting receive...");
            serverSocket.receive(recPacket);    // Blocking

            // Create send buffer
            byte[] sendBuffer = new byte[1024];
            sendBuffer = "server data test".getBytes();

            // Obtaining the IP Address and the port
            InetAddress IPAddress = recPacket.getAddress();
            int port = recPacket.getPort();

            // Create send packet
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, IPAddress, port);

            // Send the packet to the client
            serverSocket.send(sendPacket);
            System.out.println("Message sent!");
        }
        // Close socket
        //serverSocket.close();
    }
}
