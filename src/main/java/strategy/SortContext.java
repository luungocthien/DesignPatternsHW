package strategy;

public class SortContext {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSort(int[] arr) {
        if (strategy != null) {
            strategy.sort(arr);
        } else {
            throw new IllegalStateException("Sorting strategy not set.");
        }
    }
}

