package org.example;

import org.example.locks.BankAccount;
import org.example.locks.LockBankAccount;


public class Main {
    public static void main(String[] args) {
        //1
//        Thread1 t=new Thread1();
//        t.start();
//        for(;;){
//            System.out.println("Hello");
//        }



        //custom name Thread
//        CustomNameThread t=new CustomNameThread("MyCustomThread");
//        t.start();

        //synchronisation
//        Counter counter=new Counter();
//        SynchronisedThread s1=new SynchronisedThread(counter);
//        SynchronisedThread s2=new SynchronisedThread(counter);
//        s1.start();
//        s2.start();
//        try {
//            s1.join();
//            s2.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(counter.getCounter());





        //intrinsic locking using Synchronised Keyword
//        BankAccount account=new BankAccount();
//        Runnable task=new Runnable() {
//            @Override
//            public void run() {
//                account.Withdrawl(50);
//            }
//        };
//        Thread t1=new Thread(task);
//        Thread t2=new Thread(task);
//        //no matter what t2 has to wait for 10 sec to be executed
//        t1.start();
//        t2.start();




//      extrinsic locking by creating Lock Object
        LockBankAccount account=new LockBankAccount();
        Runnable task=new Runnable() {
            @Override
            public void run() {
                account.Withdrawl(50);
            }
        };
        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        t1.start();
        t2.start();





    }
}