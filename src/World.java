public class World extends Thread{
   /*for code block a new thread we need to override run() */

    @Override
    public void run() {
        for (int i=0; i<10000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}