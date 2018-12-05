package com.sbt.gof.commands;

import com.sbt.gof.ClientTask;
import com.sbt.gof.MainChat;

public class BaseCommand implements Command {

    private ClientTask clientTask;

    private MainChat chat;

    public BaseCommand(ClientTask clientTask, MainChat chat) {
        this.clientTask = clientTask;
        this.chat = chat;
    }

    @Override
    public void execute(ClientTask clientTask, String message) {
        System.out.println(message);
        chat.notifyClients(clientTask.getUserName() + " ::: " + message);
    }

    @Override
    public boolean isApplicable(String message) {
        return true;
    }

    @Override
    public void setNext(Command command) {

    }

    @Override
    public Command getNext() {
        return null;
    }
}
