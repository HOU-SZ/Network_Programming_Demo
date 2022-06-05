package src.url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlDownload {
    public static void main(String[] args) throws IOException {
        // 1.下载地址（示例为将Tomcat服务器上的资源下载到本地）
        URL url = new URL("http://127.0.0.1:8080/MrHou/Security.txt");
        // 2.连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("SecurityFile.txt");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer))!= -1){
            fos.write(buffer,0,len);
        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();  // 断开连接
    }
}
