package com.fideljose.trainingStreamJava.functional;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(
            () -> System.out.println(" Implemented! ")
        );
        thread.start();
    }

}
