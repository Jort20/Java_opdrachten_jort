package demos.advanced.designpatterns.observer_filter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sequencer {
    List<SequencerObserver> observers = new LinkedList<>();
    List<Sequence> dummySeqs;

    public void registerObserver(SequencerObserver observer) {
        this.observers.add(observer);
    }

    public boolean unregisterObserver(SequencerObserver observer) {
        if (this.observers.contains(observer)) {
            this.observers.remove(observer);
            return true;
        }
        return false;
    }

    private void notifyObservers(Sequence seq) {
        for (SequencerObserver obs : this.observers) {
            //System.out.println("obs.getClass().getSimpleName() = " + obs.getClass().getSimpleName());
            obs.newSequenceDetermined(seq);
        }
    }

    public void sequence() {
        //this simulates tha actual sequencing process
        for (Sequence seq : this.dummySeqs) {
            //System.out.println(seq);
            notifyObservers(seq);
        }
    }




    public void createDummySequences(int number, int length) {
        if (null == dummySeqs) {
            dummySeqs = new ArrayList<>();
        }
        final char[] nucs = {'A', 'G', 'C', 'T'};
        final char[] qual = {'!', '$', '0', '1', '5', '9', 'A', 'C', 'E', 'I'};

        for (int i = 0; i < number; i++) {
            StringBuilder sbNucs = new StringBuilder();
            StringBuilder qualNucs = new StringBuilder();
            for (int j = 0; j < length; j++) {
                char n = nucs[(int) (Math.random() * nucs.length)];
                sbNucs.append(n);
                char q = qual[(int) (Math.random() * qual.length)];
                qualNucs.append(q);
            }
            Sequence s = new Sequence(sbNucs.toString(), qualNucs.toString(), (long) i);
            dummySeqs.add(s);
        }
    }

}
