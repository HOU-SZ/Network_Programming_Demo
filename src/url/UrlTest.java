package src.url;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:8080/MrHou/Security.txt");
        System.out.println(url.getProtocol());  // 协议
        System.out.println(url.getHost());  // 主机
        System.out.println(url.getPort());  // 端口
        System.out.println(url.getPath());   // 文件
        System.out.println(url.getFile());  // 全路径
        System.out.println(url.getQuery());  // 参数

    }
}
