package demos.advanced.designpatterns.commandpattern;

import demos.advanced.designpatterns.commandpattern.NucleotideGuiClient;
import demos.advanced.designpatterns.commandpattern.NucleotideSequenceReceiver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class CommandPatternIntegrationTest {
    private NucleotideGuiClient nucleotideGuiClient;

    @BeforeEach
    public void setup() {
        NucleotideSequenceReceiver.getInstance().clearAll();
        nucleotideGuiClient = new NucleotideGuiClient();
    }

    @Test
    public void integrations() throws Exception {
        nucleotideGuiClient.addButtonClicked();
        nucleotideGuiClient.addButtonClicked();
        nucleotideGuiClient.addButtonClicked();
        nucleotideGuiClient.addButtonClicked();
        nucleotideGuiClient.addButtonClicked();
        System.out.println("after add button clicked five times : " + NucleotideSequenceReceiver.getInstance());
        nucleotideGuiClient.toggleCaseButtonClicked();
        System.out.println("toggled case: " + NucleotideSequenceReceiver.getInstance());
        nucleotideGuiClient.addButtonClicked();
        System.out.println("added again: " + NucleotideSequenceReceiver.getInstance());
        nucleotideGuiClient.undoButtonClicked();
        System.out.println("after undo button clicked : " + NucleotideSequenceReceiver.getInstance());
        nucleotideGuiClient.undoButtonClicked();
        System.out.println("after undo button clicked : " + NucleotideSequenceReceiver.getInstance());
        nucleotideGuiClient.redoButtonClicked();
        System.out.println("after redo button clicked : " + NucleotideSequenceReceiver.getInstance());
        nucleotideGuiClient.redoButtonClicked();
        System.out.println("after redo button clicked : " + NucleotideSequenceReceiver.getInstance());
//        nucleotideGuiClient.toggleCaseButtonClicked();
//        System.out.println("toggled case: " + NucleotideSequenceReceiver.getInstance().toString());
//        nucleotideGuiClient.undoButtonClicked();
//        System.out.println("after undo button clicked : " + NucleotideSequenceReceiver.getInstance().toString());
//        nucleotideGuiClient.undoButtonClicked();
//        System.out.println("after undo button clicked : " + NucleotideSequenceReceiver.getInstance().toString());
//        nucleotideGuiClient.undoButtonClicked();
//        System.out.println("after undo button clicked : " + NucleotideSequenceReceiver.getInstance().toString());
//        assertEquals(3, NucleotideSequenceReceiver.getInstance().length());

    }

}