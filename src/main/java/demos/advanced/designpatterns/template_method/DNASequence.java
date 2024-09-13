package demos.advanced.designpatterns.template_method;

import java.util.HashMap;
import java.util.Map;

class DNASequence extends NucleicAcidSequence{
    static Map<Character, Character> complements = new HashMap<>();
    static {
        complements.put('A', 'T');
        complements.put('T', 'A');
        complements.put('C', 'G');
        complements.put('G', 'C');
    }
    public DNASequence(String sequence, String name) {
        super(sequence, name);
    }

    @Override
    public char getComplementCharacter(char c) {
        return complements.get(c);
    }
}