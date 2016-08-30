package com.acme.edu;

/**
 * If any exception is passed in Saver methods, then a
 * SaveException will be thrown.
 */
public class SaveException extends Exception {
    public SaveException(Exception e) {
    }
}
