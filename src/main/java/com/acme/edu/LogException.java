package com.acme.edu;

/**
 * If any exception passed in Logger methods, then a
 * LogException will be thrown.
 */
public class LogException extends Exception {
    LogException(Exception e) {
    }
}
