package org.example.locks;

public class BankAccount {
    int balance=100;

    synchronized public void Withdrawl(int amt) {
        if(balance>=amt){
            balance-=amt;
            System.out.println(Thread.currentThread().getName()+" Your transaction is in process....");
            try {
                Thread.sleep(4000);
                System.out.println("Your balance is "+balance);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println("Insufficient balance");
        }
    }


}
