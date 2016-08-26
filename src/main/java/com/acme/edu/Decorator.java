package com.acme.edu;

/**
 * Decorator constructs result string.
 */
 public class Decorator {
    private String prefix = "";
    private String postfix = "";

    public Decorator(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    /**
     * Decorate an original message.
     * @param message original message.
     * @return wrapped message.
     */
    String decorate(String message) {
        return prefix + message + postfix + System.lineSeparator();
    }
}
