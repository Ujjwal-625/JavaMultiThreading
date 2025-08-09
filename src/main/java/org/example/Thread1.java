package org.example;

public class Thread1 extends  Thread{
    @Override
    public void run() {
        for(;;){
            System.out.println("World !");
        }
    }
}
