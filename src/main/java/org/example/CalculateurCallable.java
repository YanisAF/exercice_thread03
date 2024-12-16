package org.example;

import java.util.concurrent.Callable;

public class CalculateurCallable implements Callable<Integer> {
    private final int number;

    public CalculateurCallable(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        return number*number*number;
    }


}
