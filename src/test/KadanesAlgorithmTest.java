package test;

import main.KadanesAlgorithm;
import main.PerformanceTracker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KadanesAlgorithmTest {

    @Test
    public void testBasicCase() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        PerformanceTracker tracker = new PerformanceTracker();
        KadanesAlgorithm.Result result = KadanesAlgorithm.findMaxSubarray(arr, tracker);

        Assertions.assertEquals(6, result.maxSum);
        Assertions.assertEquals(3, result.startIndex);
        Assertions.assertEquals(6, result.endIndex);
    }

    @Test
    public void testAllNegative() {
        int[] arr = {-8, -3, -6, -2, -5, -4};
        PerformanceTracker tracker = new PerformanceTracker();
        KadanesAlgorithm.Result result = KadanesAlgorithm.findMaxSubarray(arr, tracker);

        Assertions.assertEquals(-2, result.maxSum);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {10};
        PerformanceTracker tracker = new PerformanceTracker();
        KadanesAlgorithm.Result result = KadanesAlgorithm.findMaxSubarray(arr, tracker);

        Assertions.assertEquals(10, result.maxSum);
        Assertions.assertEquals(0, result.startIndex);
        Assertions.assertEquals(0, result.endIndex);
    }
}
