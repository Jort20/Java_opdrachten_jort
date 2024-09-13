package demos.advanced.designpatterns.factory;

import java.util.Properties;

/**
 * Creation date: Jul 08, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public abstract class Sequence {
    public static Sequence fromString(String sequence, Properties properties) {
        sequence.toUpperCase();
        Sequence newSeq;
        //determine what type the string represents
        //create the correct subtype (DNA, RNA, ...)
        if (sequence.contains("T"))
            newSeq = new DNA();
        else if (sequence.contains("U"))
            newSeq = new RNA();
        else
            newSeq = new Protein();
        //process the properties and return the created object
        return newSeq;
    }
}
