package com.acme.edu;

/**
 * Logger provides a functionality to log a message stream.
 */
public class Logger {
    private static NumberSequence numberSequence = new NumberSequence();
    private static StringSequence stringSequence = new StringSequence();
    private static Type currentType = Type.NUMBER;
    private static Decorator decorator = new Decorator();
    private Saver[] savers;

    private enum Type {
        STRING, NUMBER
    }

    public Logger(Saver... savers) {
        this.savers = savers;
    }

    /**
     * Log number as integer.
     * @param message message to be logged.
     */
    public static void log(int message) {
        if(currentType == Type.STRING){
            terminate();
        }
        currentType = Type.NUMBER;
        numberSequence.setMaxValue(Integer.MAX_VALUE);
        numberSequence.add(message);
    }

    /**
     * Log number as byte.
     * @param message message to be logged.
     */
    public static void log(byte message) {
        if(currentType == Type.STRING){
            terminate();
        }
        currentType = Type.NUMBER;
        numberSequence.setMaxValue(Byte.MAX_VALUE);
        numberSequence.add(message);
    }

    /**
     * Log a logic expression.
     * @param message message to be logged.
     */
    public static void log(char message) {
        saver.save("char: " + message);
    }

    /**
     * Log character.
     * @param message message to be logged.
     */
    public static void log(boolean message) {
        saver.save(decorator.decorate("primitive: " + message));
    }

    /**
     * Log object.
     * @param message message to be logged.
     */
    public static void log(Object message) {
        String result;
        if(message instanceof String) {
            currentType = Type.STRING;
            result = "string: ";
            stringSequence.add(result + message);
        } else {
            result = "reference: ";
            saver.save(result + message);
        }
    }

    /**
     * Terminate the sequence of messages.
     */
    public static void terminate() {
        String result;
        if(currentType == Type.NUMBER) {
            result = numberSequence.getResult();
        } else {
            result = stringSequence.getResult();
        }
        saver.save(result);
    }

    /**
     * Set prefix in decorator.
     * @param prefix prefix to append at the beginning.
     */
    public static void setPrefix(String prefix) {
        decorator.setPrefix(prefix);
    }

    /**
     * Set postfix in decorator.
     * @param postfix postfix to append at the end.
     */
    public static void setPostfix(String postfix) {
        decorator.setPostfix(postfix);
    }
}
