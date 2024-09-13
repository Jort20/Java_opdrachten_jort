package demos.advanced.designpatterns.commandpattern;

/**
 * This models the GUI that hase buttons that can be clicked
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class NucleotideGuiClient {
    private final Invoker invoker = new Invoker();

    public void addButtonClicked() {
        invoker.addCommand(new AddNucleotideCommand(NucleotideSequenceReceiver.getInstance()));
    }

    public void toggleCaseButtonClicked() {
        invoker.addCommand(new ToggleCaseCommand(NucleotideSequenceReceiver.getInstance()));
    }

    public void undoButtonClicked() {
        invoker.undoCommand();
    }

    public void redoButtonClicked() {
        invoker.redoCommand();
    }
}
