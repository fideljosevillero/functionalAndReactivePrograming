package com.fideljose.trainingStreamJava.functional;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        // Create Thread 1
//        Thread thread = new Thread(
//            () -> System.out.println(" Implemented! ")
//        );
//        thread.start();

        // Create Thread 2
        MyFunctionalInterface myFunctionalInterface =
                () -> System.out.println("Execute method myFunction from MyFunctionalInterface interface");
        myFunctionalInterface.myFunction();

        // Chaining Functions
        Function<Integer, Integer> f1 = (n) -> n*7;
        Function<Integer, Integer> f2 = (r) -> r-17;
        Function<Integer, Integer> f3 = f1.andThen(f2);
        System.out.println(f3.apply(10));

        // Compose Functions - inverter chaining order
        Function<Integer, Integer> f1a = (n) -> n*7;
        Function<Integer, Integer> f2a = (r) -> r-17;
        Function<Integer, Integer> f3a = f1a.compose(f2a);
        System.out.println(f3a.apply(10));
    }



}
