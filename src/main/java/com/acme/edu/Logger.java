package com.acme.edu;

public class Logger {
    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        String type;
        if(message instanceof String) {
            type = "string: ";
        }
        else {
            type = "reference: ";
        }
        System.out.println(type + message);
    }
}
