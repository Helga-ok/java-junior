package com.acme.edu;

public class Logger {
    private static int sum;
    private static boolean meetMaxValue = false;

    public static void log(int message) {
        long longSum = (long)sum + message;
        if(longSum < Integer.MAX_VALUE) {
            sum += message;
        } else {
            meetMaxValue = true;
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
        String result = "primitive: " + sum;
        if(meetMaxValue) {
            result += " + " + Integer.MAX_VALUE;
        }
        System.out.println(result);

        sum = 0;
        meetMaxValue = false;
    }

}
