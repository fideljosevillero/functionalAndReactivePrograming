package com.fideljose.functionalAndReactivePrograming.functional;

import java.util.Locale;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        // Create Thread 1
//        Thread thread = new Thread(
//            () -> System.out.println(" Implemented! ")
//        );
//        thread.start();

        // Create Thread 2
//        MyFunctionalInterface myFunctionalInterface =
//                () -> System.out.println("Execute method myFunction from MyFunctionalInterface interface");
//        myFunctionalInterface.myFunction();

        // Chaining Functions
//        Function<Integer, Integer> f1 = (n) -> n*7;
//        Function<Integer, Integer> f2 = (r) -> r-17;
//        Function<Integer, Integer> f3 = f1.andThen(f2);
//        System.out.println(f3.apply(10));
//
//        // Compose Functions - inverter chaining order
//        Function<Integer, Integer> f1a = (n) -> n*7;
//        Function<Integer, Integer> f2a = (r) -> r-17;
//        Function<Integer, Integer> f3a = f1a.compose(f2a);
//        System.out.println(f3a.apply(10));

//        // Currying
//        Function<Integer, Function<Integer, Function<Integer, Integer>>> fun1= f1 -> f2 -> f3 -> f1 + f2 - f3;
//        Function<Integer, Function<Integer, Integer>> fun2 = fun1.apply(2);
//        Function<Integer, Integer> fuct3 = fun2.apply(3);
//        Integer res = fuct3.apply(0);
//        System.out.println(res);
//
//        // Currying example 2
//        Function<String, Function<String, Function<String, String>>> fun = string1 -> string2 -> string3 -> string1.toString().concat("-Fidel")
//                                                                                                                + string2.toUpperCase()
//                                                                                                                + string3.isEmpty() ;
//        Function<String, Function<String, String>> f2 = fun.apply("valor inicial");
//        Function<String, String> f3 = f2.apply(" - valor 2 - ");
//        String result = f3.apply("Valor 3");
//        System.out.println(result);

//        Tail Call - Recursion
        System.out.println(reFactory(4));
        int accumulator = 1;
        System.out.println(tailReFactoryOptimiced(4, accumulator));
    }

    public static long reFactory(int n){
        if(n <= 1) return 1;

        return n * reFactory(n-1);
    }

    public static long tailReFactoryOptimiced(int n, int accumulator){
        if(n <= 1) return accumulator;
//        System.out.println(accumulator);
//        System.out.println(n);
        return tailReFactoryOptimiced(n-1, n*accumulator);
    }



}
