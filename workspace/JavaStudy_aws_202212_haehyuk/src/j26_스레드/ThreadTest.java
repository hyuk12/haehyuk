package j26_스레드;

public class ThreadTest {

    public static void main(String[] args) {
        LoopThread loopThread1 = new LoopThread("홍길동");
        LoopThread loopThread2 = new LoopThread("김유신");
        LoopThread loopThread3 = new LoopThread("이순신");
        LoopThread loopThread4 = new LoopThread("강감찬");

        loopThread1.setPriority(10);
        System.out.println(loopThread1.getPriority());
        System.out.println(loopThread2.getPriority());
        System.out.println(loopThread3.getPriority());
        System.out.println(loopThread4.getPriority());

        loopThread1.start();
        loopThread2.start();
        loopThread3.start();
        loopThread4.start();


    }
}
