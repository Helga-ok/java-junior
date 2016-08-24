package com.acme.edu;

public class Logger {
    private static int sum;
    private static boolean meetMaxValue = false;
    public static void log(int message) {
        long longSum = sum + message;
        if(longSum < Integer.MAX_VALUE) {
            sum += message;
        } else {
            if(!meetMaxValue) meetMaxValue = true;
        }
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

    public static void terminateNumSeq() {
        System.out.println("primitive: " + sum);
        if(meetMaxValue) {
            System.out.print(Integer.MAX_VALUE);
        }
        sum = 0;
        meetMaxValue = false;
    }

}
