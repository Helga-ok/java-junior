package com.acme.edu;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RemoteSaver implements Saver, Closeable {
    private DataOutputStream out;
    private Socket socket;

    public RemoteSaver() {
        try {
            socket = new Socket("localhost", 2345);
            out = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String message) {
        try {
            out.writeUTF(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        out.close();
        socket.close();
    }
}
