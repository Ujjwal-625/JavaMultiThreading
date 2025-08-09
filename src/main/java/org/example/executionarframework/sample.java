package org.example.executionarframework;

public class sample {
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
        Thread [] threads=new Thread[9];
        for(int i=1;i<10;i++){
            int finalI = i;
            threads[i-1]=new Thread(()->{
               long fact=factorial(finalI);
                System.out.println(fact);
            });
            threads[i-1].start();
        }

        for(Thread i: threads){
            try {
                i.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Total Time : "+(System.currentTimeMillis()-startTime));
    }
}
