package com.testapp;

import com.testlib.Greeting;

public class Greeter {
    public static void main(String[] args) {
        final String output = Greeting.greeting(args[0]);
        System.out.println(output);
    }
}