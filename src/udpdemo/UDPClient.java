package udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        // Remote host IP address (server)
        InetAddress IPAddress = InetAddress.getByName("127.0.0.1");

        // Create a buffer to send
        byte[] sendData = new byte[1024];
        sendData = "client data test".getBytes();

        // Communication channel not oriented by connection
        // "clientSocket" will get a port by the OS
        DatagramSocket clientSocket = new DatagramSocket();

        // Creating the datagram
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

        // Send the packet to the server
        clientSocket.send(sendPacket);

        // Receive buffer
        byte[] recBuffer = new byte[1024];

        // Received datagram
        DatagramPacket recPacket = new DatagramPacket(recBuffer, recBuffer.length);
        clientSocket.receive(recPacket);    // Blocking

        // Obtaining the info
        String info = new String(recPacket.getData(), recPacket.getOffset(), recPacket.getLength());
        System.out.println(info);

        // Close the socket
        clientSocket.close();
    }
}
