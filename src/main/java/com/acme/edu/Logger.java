package com.acme.edu;

/**
 * Logger provides a functionality to log a message stream.
 */
public class Logger {
    private NumberSequence numberSequence = new NumberSequence();
    private StringSequence stringSequence = new StringSequence();
    private Type currentType = Type.NUMBER;
    private Decorator decorator;
    private Saver[] savers;

    private enum Type {
        STRING, NUMBER
    }

    public Logger(Decorator decorator, Saver... savers) {
        this.decorator = decorator;
        this.savers = savers;
    }

    /**
     * Log number as integer.
     * @param message message to be logged.
     */
    public void log(int message) {
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
    public void log(byte message) {
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
    public void log(char message) {
        for (Saver saver:savers) {
            saver.save("char: " + message);
        }
    }

    /**
     * Log character.
     * @param message message to be logged.
     */
    public void log(boolean message) {
        for (Saver saver:savers) {
            saver.save(decorator.decorate("primitive: " + message));
        }
    }

    /**
     * Log object.
     * @param message message to be logged.
     */
    public void log(Object message) {
        String result;
        if(message instanceof String) {
            currentType = Type.STRING;
            result = "string: ";
            stringSequence.add(result + message);
        } else {
            result = "reference: ";
            for (Saver saver:savers) {
                saver.save(result + message);
            }
        }
    }

    /**
     * Terminate the sequence of messages.
     */
    public void terminate() {
        String result;
        if(currentType == Type.NUMBER) {
            result = numberSequence.getResult();
        } else {
            result = stringSequence.getResult();
        }
        for (Saver saver:savers) {
            saver.save(result);
        }
    }
}
