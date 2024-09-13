package demos.advanced.designpatterns.commandpattern;

import java.util.Random;

/**
 * Concrete command.
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class AddNucleotideCommand implements Command {
    private static char[] nucleotides = new char[]{'A', 'C', 'G', 'T'};
    private final NucleotideSequenceReceiver receiver;
    private char lastChar;

    public AddNucleotideCommand(NucleotideSequenceReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        Random r = new Random();
        int index = r.nextInt(4);
        this.receiver.append(nucleotides[index]);
    }

    @Override
    public void undo() {
        this.lastChar = receiver.deleteLast();
    }

    @Override
    public void redo() {
        //TODO what happens if this is called multiple times?
        this.receiver.append(lastChar);
    }
}
