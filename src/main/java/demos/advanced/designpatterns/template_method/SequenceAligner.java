package demos.advanced.designpatterns.template_method;

public class SequenceAligner {
    private char[] charArrayOne;
    private char[] charArrayTwo;

    public static void main(String[] args) {
        SequenceAligner aligner = new SequenceAligner();

    }

    private int[] calculateScores(AlignmentAlgorithm algorithm) {
        int minimumAlignmentLength = 20;
        int[] best = new int[3];
        int bestX = 0;            //x-index for best score in current sequence
        int bestY = 0;            //y-index for best score in current sequence
        int windowBestScore = 0;    //best score in current analysis window

        /*two-sequence alignments*/
        for (int x = 1; x < charArrayOne.length - minimumAlignmentLength; x++) {        //looping sequence one
            for (int y = 1; y < charArrayTwo.length; y++) {    //looping sequence two

                //first determine move value in cell left and top
                int move = getMove(x, y);
                int currentBestScore = getScore(move);


                /*decide on global/local alignments*/
                if (currentBestScore < 0 && (algorithm == AlignmentAlgorithm.LOCAL)) {    //check for scores below 0 and correct if necessary
                    currentBestScore = 0;
                }

                writeScore(x, y, currentBestScore);

                //obtain highest score for window
                if (currentBestScore > windowBestScore) {
                    windowBestScore = currentBestScore;
                    bestX = x;
                    bestY = y;
                }
            }//end reverse strand
        }//end forward strand

        //return main values
        best[0] = windowBestScore;
        best[1] = bestX;
        best[2] = bestY;
        return best;
    }

    private void writeScore(int x, int y, int currentBestScore) {
        //LOGIC OMITTED
    }

    private int getScore(int move) {
        //LOGIC OMITTED
        return 0;
    }

    private int getMove(int x, int y) {
        //LOGIC OMITTED
        return 0;
    }

}
