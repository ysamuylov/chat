package com.sbt.gof;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTask implements Runnable {

    public ClientTask(MainChat chat, Socket socket) {
        this.chat = chat;
        try {
            scanner = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Enter your username");
            this.userName = scanner.nextLine();
        } catch (IOException e) {
            System.out.printf("Some errors happened: " + e);
        }

    }

    private MainChat chat;

    private CommandProcessor commandProcessor;

    private PrintWriter out;

    private Scanner scanner;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void run() {
        out.println("Welcome " + userName);
        System.out.println("Waiting for messages");
        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            if (inputLine.equalsIgnoreCase("exit")) break;
            out.println(userName + " ::: " + inputLine);
            System.out.println(inputLine);
            chat.notifyClients(userName, inputLine);
        }
        scanner.close();
        out.close();
        chat.unsubscribe(userName);
    }

    public void printOut(String message) {
        out.println(message);
    }
}
