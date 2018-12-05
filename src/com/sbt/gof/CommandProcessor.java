package com.sbt.gof;

import com.sbt.gof.commands.BaseCommand;
import com.sbt.gof.commands.Command;
import com.sbt.gof.commands.SendToUserCommand;

public class CommandProcessor {

    private MainChat chat;

    private Command startHandler;

    public CommandProcessor(MainChat chat) {
        this.chat = chat;
    }

    void execute(ClientTask clientTask, String message) {
        startHandler.
    }

    private void initCommandHandlers() {
        Command baseHandler = new BaseCommand()
        startHandler = new SendToUserCommand();
    }
}
