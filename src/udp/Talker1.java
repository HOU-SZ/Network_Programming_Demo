package src.udp;

public class Talker1 {
    public static void main(String[] args) {
        // 开启两个线程
        new Thread(new TalkSend(7777, "127.0.0.1", 9999)).start();
        new Thread(new TalkReceive(8888, "Talker2")).start();
    }
}
