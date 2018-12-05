package com.sbt.gof;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainChat {

    private Map<String, ClientTask> clients = new HashMap<>();

    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public void subscribe(Socket clientSocket) {
        try {
            ClientTask clientTask = new ClientTask(this, clientSocket);
            threadPool.execute(clientTask);
            notifyClients("User " + clientTask.getUserName() + " enter into chat");
            clients.put(clientTask.getUserName(), clientTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unsubscribe(String userName) {
        clients.remove(userName);
    }

    public void notifyClients(String initiatorUserName, String message) {
        clients.keySet().stream()
                .filter(c -> !c.equalsIgnoreCase(initiatorUserName))
                .forEach(c -> clients.get(c).printOut(message));
    }

    public void notifyClients(String message) {
        clients.values().stream()
                .forEach(client -> client.printOut(message));
    }
}
