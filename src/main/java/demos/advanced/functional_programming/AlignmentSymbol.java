package demos.advanced.functional_programming;

import java.util.HashMap;
import java.util.Map;

enum AlignmentSymbol {
    ALIGNED(' '),
    MISMATCHED('!') {
        public int getScore() {
            return -2;
        }
    },
    GAP('-') {
        public int getScore() {
            return -5;
        }
    };

    static Map<Character, AlignmentSymbol> characterSymbols = new HashMap<>();

    static {
        characterSymbols.put(' ', ALIGNED);
        characterSymbols.put('!', MISMATCHED);
        characterSymbols.put('-', GAP);
    }

    private final char symbol;

    AlignmentSymbol(char alignmentSymbol) {
        this.symbol = alignmentSymbol;
    }

    public int getScore() {
        return 2;
    }

    public static AlignmentSymbol of(char alignmentSymbol) {
        if (characterSymbols.containsKey(alignmentSymbol)) {
            return characterSymbols.get(alignmentSymbol);
        } else {
            throw new IllegalArgumentException(alignmentSymbol + " is not a legal alignment symbol");
        }
    }
}
