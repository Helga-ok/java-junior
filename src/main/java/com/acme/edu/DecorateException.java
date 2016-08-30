package com.acme.edu;

/**
 * If null parameter is passed to method decorate in Decorator Class, then a
 * DecorateException will be thrown.
 */
public class DecorateException extends Exception {
    public DecorateException() {
        super();
    }

    public DecorateException(NullPointerException e) {
    }
}
