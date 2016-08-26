package com.acme.edu;

/**
 * Decorator constructs result string.
 */
 public class Decorator {
    private String prefix = "";
    private String postfix = "";

    Decorator(String prefix, String postfix) {

    }
    /**
     * Decorate an original message.
     * @param message original message.
     * @return wrapped message.
     */
    String decorate(String message) {
        return prefix + message + postfix + System.lineSeparator();
    }

    /**
     * Set prefix in Decorator.
     * @param prefix prefix to append at the beginning.
     */
    void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Set postfix in Decorator.
     * @param postfix postfix to append at the end.
     */
    void setPostfix(String postfix) {
        this.postfix = postfix;
    }
}
