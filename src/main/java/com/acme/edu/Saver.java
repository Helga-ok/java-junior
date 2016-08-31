package com.acme.edu;

import java.io.Closeable;

/**
 * Saver is an interface for saving message.
 */
public interface Saver extends Closeable {
    /**
     * Save message.
     * @param message the string to save.
     */
    void save(String message) throws SaveException;
}