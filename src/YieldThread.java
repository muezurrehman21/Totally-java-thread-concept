public class YieldThread extends Thread{

    public YieldThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i=0; i<100; i++){
            try {
                Thread.sleep(100);
                /*yield is giving time to other thread for running*/
                Thread.yield();
                System.out.println(Thread.currentThread().getName() + " is running");
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        YieldThread t1 = new YieldThread("t1");
        YieldThread t2 = new YieldThread("t2");
        t1.start();
        t2.start();

    }
}
