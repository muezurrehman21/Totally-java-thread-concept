package sunchonized;

public class SynchrozedThread extends Thread {

    private Counter counter;

    public SynchrozedThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i=0; i<1000; i++){
            counter.incrementCount();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        SynchrozedThread t1 = new SynchrozedThread(counter1);
        SynchrozedThread t2 = new SynchrozedThread(counter1);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter1.getCount());



    }
}
