package src.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            // 1.要知道服务器的地址,端口
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            // 2.创建一个Socket连接
            socket = new Socket(serverIp,port);
            // 3.发送消息，相当于往外写
            os = socket.getOutputStream();
            String string = "我在学习网络编程...";
            os.write(string.getBytes()); // 将字符串打散为字节数组
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
