package main;

public class PerformanceTracker {
    private long comparisons = 0;
    private long arrayAccesses = 0;
    private long operations = 0;

    public void addComparison() { comparisons++; }
    public void addArrayAccess() { arrayAccesses++; }
    public void addArrayAccess(int n) { arrayAccesses += n; }
    public void addOperation() { operations++; }

    public long getComparisons() { return comparisons; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getOperations() { return operations; }

    public void reset() {
        comparisons = 0;
        arrayAccesses = 0;
        operations = 0;
    }

    @Override
    public String toString() {
        return String.format("Comparisons: %d | Array Accesses: %d | Operations: %d",
                comparisons, arrayAccesses, operations);
    }
}