package org.example;


import java.io.Writer;

class SharedObj{
     volatile private  boolean flag=false;// by adding volatile keyword our Threads will work fine



    //this will be runned by Writer Thread
    public  void setFlagTrue(){
        System.out.println("Writer Thread made the flag True");
        flag=true;
    }

    //this will be runned by readerThread
    public void printIfFlagTrue(){
        while(!flag){
            //do nothing
        }
        System.out.println("Flag is True");
    }
}
public class VolatileExample {
    public static void main(String[] args) {
        SharedObj obj =new SharedObj();

        Thread Writer=new Thread(()->{
            try {
                //deleaying this thread so that other thread run first and flag should be false
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            obj.setFlagTrue();
        });
        Thread Reader=new Thread(()->{obj.printIfFlagTrue();});
        Writer.start();
        Reader.start();
    }

}
