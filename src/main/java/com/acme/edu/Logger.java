package com.acme.edu;

public class Logger {
    private static NumberSequence numberSequence = new NumberSequence();

    public static void log(int message) {
        numberSequence.setMaxValue(Integer.MAX_VALUE);
        numberSequence.add(message);
    }

    public static void log(byte message) {
        numberSequence.setMaxValue(Byte.MAX_VALUE);
        numberSequence.add(message);
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
        System.out.println(numberSequence.getResult());
    }

}
