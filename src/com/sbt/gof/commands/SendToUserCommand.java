package com.sbt.gof.commands;

public class SendToUserCommand implements Command {

    private Command next;

    public SendToUserCommand(Command next) {
        this.next = next;
    }

    @Override
    public void execute(String userName, String message) {

    }

    @Override
    public boolean isApplicable(String message) {
        return false;
    }

    @Override
    public void setNext(Command command) {
        next = command;
    }

    @Override
    public Command getNext() {
        return next;
    }
}
