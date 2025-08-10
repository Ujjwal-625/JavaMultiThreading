package org.example;


import java.util.concurrent.atomic.AtomicInteger;

//Achiving atomicity without using Sychronisation or Locks
public class Atomicity {
    AtomicInteger counter =new AtomicInteger(0);

    void increament(){
        counter.incrementAndGet();
    }
    int getCount(){
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Atomicity a=new Atomicity();

        Thread t1=new Thread(()->{
            for(int i=0;i<1000;i++){
                a.increament();
            }
        });
        Thread t2=new Thread(()->{
            for(int i=0;i<1000;i++){
                a.increament();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(a.getCount());
    }
}
