package locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    /*
    * scenerio : if we are not using explicit lock and we use synchronized , the t2 will wait 10 second to completed the process of t1
    * then it will go for execution .suppose sleep is our database queries,operations and all that
    *
    *
    * */
//    public synchronized void withdrawBalance(int amount)  {
//        System.out.println(Thread.currentThread().getName() + " atempting to withdraw " + amount );
//        if (amount < balance){
//            System.out.println(Thread.currentThread().getName() + " processing with witdraw " + amount );
//
//            try{
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//
//            }
//            balance -= amount;
//        }
//        else {
//            System.out.println(Thread.currentThread().getName() + " insufficient balance" );
//        }
//    }

    /*
     * now we are going to apply lock instead of synchronized
     * this do like if any thread is accessing lock it will lock the critical part for other threads.
     * */
    private final Lock lock = new ReentrantLock();


    /*we are implementing three method
    * tryLock
    * tryLock with time
    * unlock
    * */
    public void withdrawBalance(int amount)  {
        System.out.println(Thread.currentThread().getName() + " atempting to withdraw " + amount );
        try {
            /*thread acquire the lock if it is free within the given waiting time and the current thread has not
            * been intrupted
            * if the lock is available this methd return immediately with the value true*/
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (amount < balance){
                    System.out.println(Thread.currentThread().getName() + " processing with witdraw " + amount );
                    try{
                        /* if we are increasing the sleep time ,
                        * for example: we have two thread t1 and t2.
                        * when t1 hold a lock first . it will hold it for 3 second and
                        * t2 will try to access the lock in the mean time and the lock will not available because we are
                        * giving t2 just 1000ms to wait in tryLock(1000, TimeUnit.MILLISECONDS)*/
                        Thread.sleep(500);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Completed withdrawal, remain balance " + balance );
                    } catch (InterruptedException e) {
                        /*we are storing the state of interupted thread*/
                        Thread.currentThread().interrupt();

                    } finally {
                        lock.unlock();
                    }

                }
                else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance" );
                }
            }else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later" );
            }
        } catch (InterruptedException e) {
            /*we are storing the state of interupted thread*/
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted()){
            //we can do anything for the thread which has benn interupted
        }
    }




}
