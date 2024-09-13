package demos.advanced.designpatterns.commandpattern;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class AddNucleotideClientTest {
    private NucleotideGuiClient client;

    @BeforeEach
    public void setup() {
        NucleotideSequenceReceiver.getInstance().clearAll();
        client = new NucleotideGuiClient();
    }

    @Test
    public void addButtonClicked() throws Exception {
        client.addButtonClicked();
        System.out.println("after add button clicked: " + NucleotideSequenceReceiver.getInstance().toString());
        assertEquals(1, NucleotideSequenceReceiver.getInstance().length());

        client.addButtonClicked();
        System.out.println("after add button clicked: " + NucleotideSequenceReceiver.getInstance().toString());
        assertEquals(2, NucleotideSequenceReceiver.getInstance().length());
    }

    @Test
    public void addAndUndoButtonClicked() throws Exception {
        client.addButtonClicked();
        client.addButtonClicked();
        System.out.println("after add button clicked twice : " + NucleotideSequenceReceiver.getInstance().toString());
        assertEquals(2, NucleotideSequenceReceiver.getInstance().length());

        client.undoButtonClicked();
        System.out.println("after undo button clicked : " + NucleotideSequenceReceiver.getInstance().toString());
        assertEquals(1, NucleotideSequenceReceiver.getInstance().length());

        client.undoButtonClicked();
        System.out.println("after undo button clicked : " + NucleotideSequenceReceiver.getInstance().toString());
        assertEquals(0, NucleotideSequenceReceiver.getInstance().length());
    }

}