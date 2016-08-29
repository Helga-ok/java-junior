package com.acme.edu;

/**
 * Saver is an interface for saving message.
 */
public interface Saver {
    /**
     * Save message.
     * @param message the string to save.
     */
    void save(String message) throws SaveException;
}