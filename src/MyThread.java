/*
* this class is using to understand the different state of Threads
* moreover , how thread run

* NEW
* RUNNALBE
* BLOCKED,
* WAITING,
* TIMED_WAITING,
* TERMINATED
* */

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        //thread state will be NEW
        System.out.println(t1.getState());
        t1.start();
        //Thread state will be RUNNABLE
        System.out.println(t1.getState());
        // let sleep this thread , the CPU will start thread of MYTHREAD
        t1.sleep(100);
        System.out.println(t1.getState());
        //the join function wait for thread to die
        //t1 is calling by main method , we can say the main method is waiting for to get t1 finish -
        t1.join();
        System.out.println(t1.getState());


    }

}
