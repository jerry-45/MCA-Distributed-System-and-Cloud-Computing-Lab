// Write a server program to add 2 numbers which is passed by client program using datagram

import java.io.IOException;
import java.net.*;
public class UDPServer
{
    public static void main(String[] args)
    {
        DatagramSocket socket = null;
        try
        {
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            while(true)
            {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String receivedData = new String(receivePacket, getData(), 0, receivePacket.getLength());
                System.out.println(receiveData);
                String[] numbers = receivedData.split(",");
                if(numbers.length == 2)
                {
                    int num1 = Integer.parseInt(numbers[0]);
                    int num2 = Integer.parseInt(numbers[1]);
                    int res = num1 + num2;
                    InetAddress clInetAddress = receivePacket.getPort();
                    String resp = res;
                    byte[] sendData = res.getBytes();
                    DatagramPacket sendPacket(sendData, sendData.length);
                    socket.send(receiveData);
                    System.out.println(res);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(socket l = null && !socket.isClosed())
            {
                socket.close();
            }
        }
    }
}