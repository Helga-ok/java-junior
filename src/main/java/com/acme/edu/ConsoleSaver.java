package com.acme.edu;

/**
 * ConsoleSaver displays message on the screen.
 */
public class ConsoleSaver implements Saver {
    /**
     * Display message on the screen.
     * @param message the string to save.
     */
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}