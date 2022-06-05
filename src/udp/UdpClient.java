package src.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        // 1.建立Socket
        DatagramSocket socket = new DatagramSocket();
        // 2.建包
        String msg = "Hello, server...";
        InetAddress localhost = InetAddress.getByName("127.0.0.1");
        int port = 2280;
        // 数据
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
        // 3.发送
        socket.send(packet);
        // 4.关闭
        socket.close();
    }
}
