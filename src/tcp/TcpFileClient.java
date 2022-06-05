package src.tcp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpFileClient {
    public static void main(String[] args) throws Exception{
        InetAddress serverIp = InetAddress.getByName("127.0.0.1");
        int port = 9980;
        Socket socket = new Socket(serverIp,port);
        // 2.创建一个输出流
        OutputStream os = socket.getOutputStream();
        // 3.文件流  读取文件
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\Shizheng\\Desktop\\dog-puppy-on-garden-royalty-free-image-1586966191.jpg"));
        // 4.写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

        // 5.通知服务器，文件写出结束了
        socket.shutdownOutput();

        // 6.服务器确定接收后断开服务
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=is.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos.toString());

        baos.close();
        fis.close();
        os.close();
        is.close();
        socket.close();
    }
}
