package Multithreading.src;

class A extends Thread{
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println("This is class A");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class B extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("This is class B");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Multithreading {
    public static void main(String[] args) {
        A obj1= new A();
        B obj2= new B();

        obj1.start();
        obj2.start();
    }
}
