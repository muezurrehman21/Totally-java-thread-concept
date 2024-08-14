import java.awt.*;

public class InteruptedThread extends Thread {
    /*
* ref :
* public Thread(String name) {
    this((ThreadGroup)null, (Runnable)null, name, 0L);
}
* */
    public InteruptedThread(String name){
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
//            Thread.interrupted();
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println(Thread.currentThread().getState());


    }

    public static void main(String[] args) {
        InteruptedThread t1 = new InteruptedThread("t1");
        t1.start();
//        t1.interrupt();



    }
}
