package org.lukas.javach.command;

/**
 * Created by Lukas on 28.10.2017.
 *
 * @author Lukas Pecak
 */
public interface Command {

    void execute();

    void undo();
}
