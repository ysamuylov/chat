package com.sbt.gof.commands;

import com.sbt.gof.ClientTask;

public interface Command {

    void execute(ClientTask clientTask, String message);

    boolean isApplicable(String message);

    void setNext(Command command);

    Command getNext();

    default void process(ClientTask clientTask, String message) {
        if (isApplicable(message)) {
            execute(clientTask, message);
        }
        getNext().execute(clientTask, message);
    }
}
