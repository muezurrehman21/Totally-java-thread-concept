public class PeriorityThread extends Thread {


    /*
    * ref :
    * public Thread(String name) {
        this((ThreadGroup)null, (Runnable)null, name, 0L);
    }
    * */
    public PeriorityThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            for (int j=0; j<1000; j++){
                System.out.println(Thread.currentThread().getName() + " - Periority - " + Thread.currentThread().getPriority() );
            }
        }
    }

    public static void main(String[] args) {
        PeriorityThread t1 = new PeriorityThread("Low Perioty");
        PeriorityThread t2 = new PeriorityThread("Medium Perioty");
        PeriorityThread t3 = new PeriorityThread("High Perioty");
        t1.setPriority(MIN_PRIORITY);
        t2.setPriority(NORM_PRIORITY);
        t3.setPriority(MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();


    }
}
