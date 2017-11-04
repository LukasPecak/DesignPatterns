package org.lukas.javach.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 29.10.2017.
 *
 * @author Lukas Pecak
 */
public class CommandMacro implements Command {

    private static Logger log = LoggerFactory.getLogger(CommandMacro.class);
    private Command[] commands;

    CommandMacro(Command ... commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        log.info("Run macro commands");
        for (Command command : commands) {
            command.execute();
        }

    }

    @Override
    public void undo() {
        log.info("Undo macro commands");
        for (Command command : commands) {
            command.undo();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringDescription = new StringBuilder("|");
        for (Command command : commands) {
            stringDescription.append(command.getClass().getSimpleName()).append("|");
        }
        return stringDescription.toString();
    }
}
