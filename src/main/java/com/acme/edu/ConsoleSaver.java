package com.acme.edu;

import java.io.IOException;

/**
 * ConsoleSaver displays message on the screen.
 */
public class ConsoleSaver implements Saver {
    /**
     * Display message on the screen.
     * @param message the string to save.
     */
    @Override
    public void save(String message) throws SaveException{
        try {
            System.out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SaveException(e);
        }
    }

    @Override
    public void close() throws IOException {

    }
}