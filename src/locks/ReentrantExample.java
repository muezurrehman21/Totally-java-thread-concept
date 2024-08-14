package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();

    /*
    * ReentrantLock : Reentrant lock is checking the total count of lock acquire within the following code
    * when we acquire lock two time
    * we need to unlock it two times
    * it is also checking where the lock acquire and where the lock release*/
    public void outerMethod(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is here ");
            System.out.println("outer Method");
            innerMethod();
        }  finally {
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " is here ");
            System.out.println("inner Methood");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample reentrantExample = new ReentrantExample();
        reentrantExample.outerMethod();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                reentrantExample.outerMethod();
//            }
//        };
//        Thread t1 = new Thread(runnable,"t1");
//        Thread t2 = new Thread(runnable,"t2");
//        t1.start();
//        t2.start();
    }
}
