package org.example;

public class SynchronisedThread  extends Thread{

    Counter counter;
    SynchronisedThread(Counter counter){
        this.counter=counter;
    }
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            counter.increament();
        }
    }
}
