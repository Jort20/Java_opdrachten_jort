package demos.advanced.refactoring;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class Stack {
    private int topOfStack = 0;
    private List<Integer> elements = new LinkedList<Integer>();

    public List<Integer> getStackAsList() {
        return Collections.unmodifiableList(elements);
    }

    public int size() {
        return topOfStack;
    }

    public void push(int element) {
        topOfStack++;
        elements.add(element);
    }

    public int pop() throws EmptyStackException {
        if (topOfStack == 0) throw new EmptyStackException();
        int element = elements.get(--topOfStack);
        elements.remove(topOfStack);
        return element;
    }
}
