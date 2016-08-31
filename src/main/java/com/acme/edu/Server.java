package com.acme.edu;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The class listens to socket and processes the data.
 */
public class Server {
    /**
     * Launch server.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        int maxClientNumber = 3;
        int curClientNumber = 0;
        try (ServerSocket serverSocket = new ServerSocket(2345)) {
            while (curClientNumber < maxClientNumber) {
                Socket client = serverSocket.accept();
                curClientNumber++;
                try (
                        DataInputStream in = new DataInputStream(
                                new BufferedInputStream(
                                        client.getInputStream()
                                )
                        )
                ) {
                    while (true) {
                        try {
                            System.out.println(in.readUTF());
                        } catch (IOException e) {
                            System.out.println("Close connection");
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}