package src.ip_port;

import java.net.InetAddress;

public class IPAddress {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);
            InetAddress inetAddress2 = InetAddress.getByName("localhost");
            System.out.println(inetAddress2);
            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3);

            InetAddress inetAddress4 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress4);

            System.out.println(inetAddress4.getCanonicalHostName());
            System.out.println(inetAddress4.getHostAddress());
            System.out.println(inetAddress4.getHostName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
