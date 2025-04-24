package strategy;

// Main.java
import java.util.Random;
import java.util.Arrays;

public class Main {
    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(10_000);
        return arr;
    }

    private static void testPerformance(String name, SortingStrategy strategy, int[] smallArray, int[] largeArray) {
        SortContext context = new SortContext();
        context.setStrategy(strategy);

        int[] smallCopy = Arrays.copyOf(smallArray, smallArray.length);
        int[] largeCopy = Arrays.copyOf(largeArray, largeArray.length);

        long startSmall = System.nanoTime();
        context.executeSort(smallCopy);
        long endSmall = System.nanoTime();

        long startLarge = System.nanoTime();
        context.executeSort(largeCopy);
        long endLarge = System.nanoTime();

        System.out.printf("%s:\n", name);
        System.out.printf("  Small array time: %.2f ms\n", (endSmall - startSmall) / 1e6);
        System.out.printf("  Large array time: %.2f ms\n\n", (endLarge - startLarge) / 1e6);
    }

    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(30);
        int[] largeArray = generateRandomArray(100_000);

        testPerformance("Selection Sort", new SelectionSortStrategy(), smallArray, largeArray);
        testPerformance("Bubble Sort", new BubbleSortStrategy(), smallArray, largeArray);
        testPerformance("Insertion Sort", new InsertionSortStrategy(), smallArray, largeArray);
    }
}

