package Multithreading.src;

class C implements Runnable {
    public void method1() {
        for (int i = 0; i < 5; i++) {
            System.out.println("This is method 1 of class C");
        }
    }

    public void method2() {
        for (int i = 0; i < 5; i++) {
            System.out.println("This is method 2 of class C");
        }
    }

    public void run() {
        // Create and start a thread for method1
        Thread t1 = new Thread(() -> method1());
        t1.start();

        // Create and start a thread for method2
        Thread t2 = new Thread(() -> method2());
        t2.start();

//         Optionally, wait for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class D implements Runnable {
    public void method1() {
        for (int i = 0; i < 5; i++) {
            System.out.println("This is method 1 of class D");
        }
    }

    public void method2() {
        for (int i = 0; i < 5; i++) {
            System.out.println("This is method 2 of class D");
        }
    }

    public void run() {
        // Create and start a thread for method1
        Thread t3 = new Thread(() -> method1());
        t3.start();

        // Create and start a thread for method2
        Thread t4 = new Thread(() -> method2());
        t4.start();

        // Optionally, wait for both threads to finish
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class UsingRunnable {
    public static void main(String[] args) {
        // Create a Runnable object of class C
        C obj1 = new C();
        D obj2 = new D();
        // Create a thread to run the obj's run() method
        Thread mainThread1 = new Thread(obj1);
        mainThread1.start();
        Thread mainThread2 = new Thread(obj2);
        mainThread2.start();
    }
}
