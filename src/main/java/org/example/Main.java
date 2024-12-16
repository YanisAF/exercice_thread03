package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer>[] futures = new Future[5];

        for (int i = 1; i <= 5;  i++) {
            futures[i-1] = executorService.submit(new CalculateurCallable(i));
        }

        for (int i = 0; i < futures.length; i++) {
            try {
                System.out.println("Le cube de "+(i+1)+ " est "+futures[i].get());
            }catch (InterruptedException | ExecutionException e){
                System.out.println("Erreur lors de la récuperation pour "+i);
            }

        }

        executorService.shutdown();
    }
}