package org.example;

public class Counter {
    private int counter;

    Counter (){
        counter=0;
    }

    synchronized void increament(){
        counter++;
    }

    int getCounter(){
        return counter;
    }
}
