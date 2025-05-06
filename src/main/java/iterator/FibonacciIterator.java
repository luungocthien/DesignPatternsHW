package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {
    private int count = 0; // To track number of elements returned
    private int maxCount = Integer.MAX_VALUE; // Allows infinite by default

    private int prev = 0;
    private int curr = 1;

    // Optional: allow limiting how many numbers are produced
    public FibonacciIterator() {
        // infinite by default
    }

    public FibonacciIterator(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public boolean hasNext() {
        return count < maxCount;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more Fibonacci numbers.");
        }

        int nextValue = curr;
        int temp = curr;
        curr = curr + prev;
        prev = temp;
        count++;

        return nextValue;
    }
}

