package com.sbt.gof;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    private static final MainChat MAIN_CHAT = new MainChat();

    public static void main(String[] args) {
        System.out.println("Welcome to Server side");

        ServerSocket servers = null;
        // create server socket
        try {
            servers = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println("Couldn't listen to port 4444");
            System.exit(-1);
        }

        while (true) {
            try {
                MAIN_CHAT.subscribe(servers.accept());
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
        }
    }
}
