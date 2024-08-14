public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        /*
        step 1:
        * will print the thread name*/
        //main thread loop
        for (int i=0; i<10000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
        //-------------------------------------------------------------------------------------------------//
        /*
        step: 2
        * creating world class to run multiple threads which is extended with thread class
        * */
        //these two thread will run concurrently without any dependency on each other.
        //if yu want to look deeply to copy and paste following two lines just before the main thread loop.

        World world = new World();

        //to start thread

        world.start();
        //---------------------------------------------------------------------------------------------------//
        /*
        step 3:
        with implementation of runnable interface create World1 class*/
        World1 world1 = new World1();
        Thread thread = new Thread(world1);
        //to start thread
        thread.start();

    }
}
