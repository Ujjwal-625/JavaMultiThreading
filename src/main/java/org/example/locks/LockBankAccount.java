package org.example.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBankAccount {
    int balance=100;

    private Lock lock=new ReentrantLock();

    public void Withdrawl(int amt) {
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amt) {
                    balance -= amt;
                    System.out.println(Thread.currentThread().getName() + " Your transaction is in process....");
                    try {
                        Thread.sleep(4000);
                        System.out.println("Your balance is " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("Insufficient balance");
                }
            }
            else{
                System.out.println(Thread.currentThread().getName()+" could not aquire the lock");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
