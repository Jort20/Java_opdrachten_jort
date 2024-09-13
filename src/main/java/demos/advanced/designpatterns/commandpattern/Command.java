package demos.advanced.designpatterns.commandpattern;

/**
 * This command both has an execute and an undo action.
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public interface Command {
    void execute();

    void undo();

    void redo();
}
