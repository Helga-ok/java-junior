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
    public void log(int message) throws LogException {
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
    public void log(byte message) throws LogException {
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
    public void log(char message) throws LogException {
        for (Saver saver:savers) {
            try {
                saver.save("char: " + message);
            } catch (SaveException e) {
                e.printStackTrace();
                throw new LogException(e);
            }
        }
    }

    /**
     * Log character.
     * @param message message to be logged.
     */
    public void log(boolean message) throws LogException {
        for (Saver saver:savers) {
            try {
                String result = decorator.decorate("primitive: " + message);
                saver.save(result);
            } catch (SaveException | DecorateException e) {
                e.printStackTrace();
                throw new LogException(e);
            }
        }
    }

    /**
     * Log object.
     * @param message message to be logged.
     */
    public void log(Object message) throws LogException {
        String result;
        result = "reference: ";
        for (Saver saver:savers) {
          try {
            saver.save(result + message);
          } catch (SaveException e) {
            e.printStackTrace();
            throw new LogException(e);
          }
        }
    }

    /**
     * Log String.
     * @param message string to be logged.
     */
    public void log(String message) {
        currentType = Type.STRING;
        stringSequence.add("string: " + message);
    }

    /**
     * Terminate the sequence of messages.
     */
    public void terminate() throws LogException {
        String result;
        if(currentType == Type.NUMBER) {
            result = numberSequence.getResult();
        } else {
            result = stringSequence.getResult();
        }
        for (Saver saver:savers) {
            try {
                saver.save(result);
            } catch (SaveException e) {
                e.printStackTrace();
                throw new LogException(e);
            }
        }
    }
}
