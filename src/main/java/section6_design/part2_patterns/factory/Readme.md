# Factory with Strategy

In part `section4_oop.part3_consensus_creator` you were tasked to create a consensus sequence from a set of sequences.
There were two variations: the first was with the IUPAC ambiguitiy codes, the second was with the bracket notation.
As a reminder, this is the class:

```java
public class ConsensusSequenceCreator {
    private String[] sequences;
    private boolean iupac;
    private String[] ambiguities;
    private String consensus = "";

    /**
     * testing main.
     * @param args  the CL args
     */
    public static void main(String[] args) {
        String[] sequences = new String[4];
        sequences[0] = "GAAT";
        sequences[1] = "GAAA";
        sequences[2] = "GATT";
        sequences[3] = "GAAC";
        
        ConsensusSequenceCreator csc = new ConsensusSequenceCreator();
        String consensus;
        consensus = csc.createConsensus(sequences, true);
        System.out.println("consensus = " + consensus);
        //consensus should equal "GAWH"
        consensus = csc.createConsensus(sequences, false);
        //consensus should equal "GA[A/T][A/T/C]"
        System.out.println("consensus = " + consensus);
    }

    /**
     * creates a consensus sequence from the given array of sequences.
     * @param sequences the sequences to scan for consensus
     * @param iupac flag to indicate IUPAC (true) or bracket notation (false)
     * @return consensus the consensus sequence
     */
    public String createConsensus(String[] sequences, boolean iupac) {
        this.sequences = sequences;
        this.iupac = iupac;
        this.ambiguities = new String[sequences[0].length()];
        //in this first step, all possibilities for each position are collected
        buildAmbiguities();
        //in this step, variants for each position are translated into either bracket 
        //[x/y] notation or IUPAC notation
        buildConsensus();
        return this.consensus;
    }

    private void buildConsensus() {
        //YOUR CODE
    }

    private void buildAmbiguities() {
        //YOUR CODE
    }

}
```

You should refactor this class to use the Factory pattern. This involves several steps:

1. Get the `main()` method to a separate class called `ConsensusSequenceCreatorApp` in the same package.
2. Make `ConsensusSequenceCreator` and interface or an abstract class. your choice.
3. Create a `ConsensusSequenceCreatorFactory` class that has a method `createConsensusSequenceCreator()`. 
   This method should take a String or an enum (to be created by you) as argument specifying the type of factory 
   to create, and return a concrete `ConsensusSequenceCreator` instance (`ConsensusSequenceCreatorIupac` or
   `ConsensusSequenceCreatorBracket` - subclasses you will create).
4. Create the two subclasses `ConsensusSequenceCreatorIupac` and `ConsensusSequenceCreatorBracket` that 
   extend/implement `ConsensusSequenceCreator`. Try to extract as much common code as possible to the superclass/interface.
5. Can you adapt your design to include the Strategy pattern? This Strategy should be used to build either bracket 
   or IUPAC consencus position representations. 