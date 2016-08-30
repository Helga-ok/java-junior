package com.acme.edu;
import java.io.*;

/**
 * Saves log into file.
 */
public class FileSaver implements Saver {
    private String fileName;
    private String filePath = "." + File.separator + "logs" + File.separator + fileName;

    public FileSaver(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Saves message into the file.
     * @param message the string to save.
     * @throws SaveException
     */
    @Override
    public void save(String message) throws SaveException {
        File file = new File(filePath);

        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(file)), "UTF-8"))) {
            bw.write(message);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new SaveException(e);
        }
    }
}
