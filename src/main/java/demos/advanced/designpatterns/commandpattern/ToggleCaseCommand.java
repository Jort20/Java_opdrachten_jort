package demos.advanced.designpatterns.commandpattern;

/**
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class ToggleCaseCommand implements Command {
    private final NucleotideSequenceReceiver receiver;

    public ToggleCaseCommand(NucleotideSequenceReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.toggleCase();
    }

    @Override
    public void undo() {
        this.receiver.toggleCase();
    }

    @Override
    public void redo() {
        this.receiver.toggleCase();
    }
}
