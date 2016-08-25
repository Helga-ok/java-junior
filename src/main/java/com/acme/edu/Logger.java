package com.acme.edu;

public class Logger {
    private static NumberSequence numberSequence = new NumberSequence();
    private static StringSequence stringSequence = new StringSequence();
    private static Type currentType = Type.NUMBER;
    private static Saver saver = new ConsoleSaver();
    private static Decorator decorator = new Decorator();

    private enum Type {
        STRING, NUMBER
    }

    public static void log(int message) {
        if(currentType == Type.STRING){
            terminate();
        }
        currentType = Type.NUMBER;
        numberSequence.setMaxValue(Integer.MAX_VALUE);
        numberSequence.add(message);
    }

    public static void log(byte message) {
        if(currentType == Type.STRING){
            terminate();
        }
        currentType = Type.NUMBER;
        numberSequence.setMaxValue(Byte.MAX_VALUE);
        numberSequence.add(message);
    }

    public static void log(char message) {
        saver.save("char: " + message);
    }

    public static void log(boolean message) {
        saver.save(decorator.decorate("primitive: " + message));
    }

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

    public static void terminate() {
        String result;
        if(currentType == Type.NUMBER) {
            result = numberSequence.getResult();
        } else {
            result = stringSequence.getResult();
        }
        saver.save(result);
    }

    public static void setPrefix(String prefix) {
        decorator.setPrefix(prefix);
    }

    public static void setPostfix(String postfix) {
        decorator.setPostfix(postfix);
    }
}
