package iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence();

        System.out.println("First 10 Fibonacci numbers:");
        Iterator<Integer> iterator = new FibonacciIterator(11);

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
    }
}

