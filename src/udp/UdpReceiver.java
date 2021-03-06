package src.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);
        // 准备接收包裹
        while (true){
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet); // 阻塞式接收包裹
            // 断开连接
            byte[] data = packet.getData();
            String receiveData = new String(data, 0, packet.getLength());
            System.out.println(receiveData);
            if (receiveData.equals("bye")){
                break;
            }
        }
        socket.close();
    }
}
