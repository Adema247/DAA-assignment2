package main;

import main.KadanesAlgorithm;
import main.KadanesAlgorithm.Result;
import main.PerformanceTracker;

import java.util.Random;
import java.util.Scanner;

public class BenchmarkRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Kadane's Algorithm Benchmark ===");
        System.out.print("Enter array size (e.g. 10, 1000, 10000): ");
        int n = scanner.nextInt();

        int[] arr = generateRandomArray(n);
        PerformanceTracker tracker = new PerformanceTracker();

        long startTime = System.nanoTime();
        Result result = KadanesAlgorithm.findMaxSubarray(arr, tracker);
        long endTime = System.nanoTime();

        System.out.println(result);
        System.out.printf("Execution Time: %.4f ms%n", (endTime - startTime) / 1_000_000.0);
        System.out.println(tracker);
    }

    private static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(2001) - 1000;
        }
        return arr;
    }
}