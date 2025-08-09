package org.example.executionarframework;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class sample1 {
    static long factorial(int n){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long fact=1;
        for(int i=1;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        ExecutorService executorService= Executors.newFixedThreadPool(9);
        for(int i=1;i<10;i++){
            int finalI = i;
            executorService.submit(()->{
                long fact=factorial(finalI);
                System.out.println(fact);
            });
        }
        executorService.shutdown();

        //finite waiting
//        try {
//            executorService.awaitTermination(300, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


//        inifinite waiting for threads to complete the execution
        while(true){
            try {
                if (executorService.awaitTermination(1,TimeUnit.MILLISECONDS)) break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("Total Time : "+(System.currentTimeMillis()-startTime));
    }
}

