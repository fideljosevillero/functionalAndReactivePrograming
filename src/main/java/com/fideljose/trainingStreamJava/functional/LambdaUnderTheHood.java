package com.fideljose.trainingStreamJava.functional;

public class LambdaUnderTheHood {

    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface1  = () -> System.out.println("Implemented 1");
        MyFunctionalInterface myFunctionalInterface2  = () -> System.out.println("Implemented 2");

        myFunctionalInterface1.myFunction();
        myFunctionalInterface2.myFunction();
    }




}
