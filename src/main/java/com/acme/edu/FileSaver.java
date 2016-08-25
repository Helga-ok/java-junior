package com.acme.edu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Filesaver writes message into file.
 */
public class FileSaver implements Saver {
    /**
     * Write message into file.
     * @param message the string to save.
     */
    @Override
    public void save(String message) {
        System.out.println("IN FILE: " + message);
    }
}