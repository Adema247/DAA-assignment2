package main;

import main.PerformanceTracker;

public class KadanesAlgorithm {

    public static class Result {
        public int maxSum;
        public int startIndex;
        public int endIndex;

        public Result(int maxSum, int startIndex, int endIndex) {
            this.maxSum = maxSum;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public String toString() {
            return String.format("Max Sum: %d (from index %d to %d)", maxSum, startIndex, endIndex);
        }
    }

    public static Result findMaxSubarray(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty or null");
        }

        int maxSum = arr[0];
        int currentSum = arr[0];
        int start = 0;
        int tempStart = 0;
        int end = 0;

        tracker.addArrayAccess(2);

        for (int i = 1; i < arr.length; i++) {
            tracker.addComparison();
            tracker.addArrayAccess();
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            tracker.addOperation();

            if (currentSum == arr[i]) {
                tempStart = i;
            }

            tracker.addComparison();
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
                tracker.addOperation();
            }
        }

        return new Result(maxSum, start, end);
    }
}
