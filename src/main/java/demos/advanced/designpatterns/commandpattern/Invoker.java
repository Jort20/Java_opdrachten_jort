package demos.advanced.designpatterns.commandpattern;

import java.util.Stack;

/**
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class Invoker {
    private Stack<Command> commands = new Stack<>();
    private Stack<Command> undoneCommands = new Stack<>();

    public void addCommand(Command command) {
        command.execute();
        this.commands.push(command);
        this.undoneCommands.clear();
    }

    public void undoCommand() {
        Command undo = this.commands.pop();
        undo.undo();
        this.undoneCommands.push(undo);
    }

    public void redoCommand() {
        Command redo = this.undoneCommands.pop();
        redo.execute();
        this.commands.push(redo);
    }
}
