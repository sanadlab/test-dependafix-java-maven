package com.test;

import lombok.SneakyThrows;
import lombok.Getter;
import lombok.Setter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Message Server demonstrating Lombok usage with JDK 21
 * This class uses @SneakyThrows which requires Lombok to process bytecode
 * Lombok 1.18.26 fails with JDK 21 (class file major version 65)
 * Lombok 1.18.30+ supports JDK 21
 */
@Getter
@Setter
public class MessageServer {
    private int port;
    private boolean running;

    public MessageServer(int port) {
        this.port = port;
        this.running = false;
    }

    @SneakyThrows(IOException.class)
    public void start() {
        ServerSocket serverSocket = new ServerSocket(port);
        running = true;
        
        while (running) {
            Socket clientSocket = serverSocket.accept();
            ClientHandler handler = new ClientHandler(clientSocket);
            handler.handle();
        }
    }

    @Getter
    @Setter
    public static class ClientHandler {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @SneakyThrows(IOException.class)
        public void handle() {
            // This method uses @SneakyThrows which triggers the Lombok bytecode transformation
            // that fails with Lombok 1.18.26 on JDK 21
            socket.getInputStream().read();
        }
    }
}

