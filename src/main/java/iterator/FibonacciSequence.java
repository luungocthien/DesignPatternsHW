package iterator;

import java.util.Iterator;

public class FibonacciSequence implements Sequence {

    // Returns a new FibonacciIterator starting from the beginning
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }
}

