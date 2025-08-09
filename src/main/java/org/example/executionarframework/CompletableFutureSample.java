package org.example.executionarframework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSample {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
                System.out.println("completed Waiting");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Ok";
        });

        try {
            completableFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main Running");
    }
}
