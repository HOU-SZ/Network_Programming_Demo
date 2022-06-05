package src.tcp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
    public static void main(String[] args) throws Exception {
        // 1.创建服务
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        serverSocket = new ServerSocket(9980);
        // 2.监听客户端的连接
        socket = serverSocket.accept();// 阻断式连接，会一直等待客户端连接
        // 3.获取输入流
        is = socket.getInputStream();
        // 4.文件输出
        fos = new FileOutputStream(new File("picture1.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
               fos.write(buffer,0,len);
         }
        System.out.println("成功接收...");
        // 5.通知客户端接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("我接受到了，你可以关闭了...".getBytes());
        // 6.关闭资源
         fos.close();
         os.close();
         is.close();
         socket.close();
         serverSocket.close();
    }
}
