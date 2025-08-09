package org.example;

public class CustomNameThread extends Thread{
    CustomNameThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i=0;i<6;i++){
            System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getPriority());
        }
    }
}
