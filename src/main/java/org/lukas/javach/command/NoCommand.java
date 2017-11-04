package org.lukas.javach.command;

/**
 * Created by Lukas on 29.10.2017.
 *
 * @author Lukas Pecak
 */
public class NoCommand implements Command {

    @Override
    public void execute() {
        throw new UnsupportedOperationException("No command setup");
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("No command setup");
    }
}
