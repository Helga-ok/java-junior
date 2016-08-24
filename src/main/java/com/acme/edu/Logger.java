package com.acme.edu;

public class Logger {
    private static int sum;
    private static int maxValue;
    private static boolean meetMaxValue = false;

    public static void log(int message) {
        maxValue = Integer.MAX_VALUE;
        long longSum = (long)sum + message;
        if(longSum < maxValue) {
            sum += message;
        } else {
            meetMaxValue = true;
        }
    }

    public static void log(byte message) {
        maxValue = Byte.MAX_VALUE;
        long longSum = (long)sum + message;
        if(longSum < maxValue) {
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
            result += " + " + maxValue;
        }
        System.out.println(result);

        sum = 0;
        meetMaxValue = false;
        maxValue = 0;
    }

}
