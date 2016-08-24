package com.acme.edu;

class NumberSequence {
    private static int sum;
    private static int maxValue;
    private static boolean meetMaxValue = false;

    void setMaxValue(int maxValue) {
        NumberSequence.maxValue = maxValue;
    }

    void add(int message) {
        long longSum = (long)sum + message;
        if(longSum < maxValue) {
            sum += message;
        } else {
            meetMaxValue = true;
        }
    }

    String getResult() {
        String result = "primitive: " + sum;
        if(meetMaxValue) {
            result += " + " + maxValue;
        }
        reset();
        return result;
    }

    private static void reset() {
        sum = 0;
        meetMaxValue = false;
    }
}
