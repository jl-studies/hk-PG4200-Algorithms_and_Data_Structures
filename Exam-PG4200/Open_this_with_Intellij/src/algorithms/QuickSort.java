package algorithms;

import java.util.Arrays;
import java.util.Random;
import runners.Counter;

public class QuickSort {

    // Method to choose which element to use as pivot
    static int pivot(Double[] a, int first, int last, char sortOrder) {
        switch (sortOrder) {

            // Use first element as pivot
            case 'a' -> {
                return first;
            }

            // Use last element as pivot
            case 'b' -> {
                return last;
            }

            // Use a random element as pivot
            case 'c' -> {
                int random = new Random().nextInt(last - first + 1) + first;
                return random;
            }

            // Use median of three (first, middle, last) as pivot
            case 'd' -> {
                int middle = ((first + last) / 2);
                int empty = 0;

                // Check which value is in the middle (median)
                if ((a[middle] <= a[last] && a[middle] >= a[first])) {
                    return middle;
                }
                if (a[middle] >= a[last] && a[middle] <= a[first]) {
                    return middle;
                }
                if (a[first] <= a[last] && a[first] >= a[middle]) {
                    return first;
                }
                if (a[first] >= a[last] && a[first] <= a[middle]) {
                    return first;
                }
                if (a[last] <= a[first] && a[last] >= a[middle]){
                    return last;
                }
                if (a[last] >= a[first] && a[last] <= a[middle]) {
                    return last;
                }

                // Default return (should not normally happen)
                return empty;
            }
        }
        return first;
    }


    // the Quick sorting after the pivot have been chosen
    static void sorting(Double[] a, int first, int last, char sortOrder) {

        // Only sort if it is minimum two elements
        if (first < last) {

            // Will locat the pivot and move elements around it
            int pi = partition(a, first, last, sortOrder);

            // starts moving all values that are lower than pivot
            sorting(a, first, pi - 1, sortOrder);

            // it then moves all the values that are higher tha pivot to the right
            sorting(a, pi + 1, last, sortOrder);
        }
    }

    // Places pivot in correct position
    static int partition(Double[] a, int first, int last, char sortOrder) {

        // Get pivot index based on chosen strategy
        int indexPivot = pivot(a, first, last, sortOrder);

        // Move pivot to the end of the array (if not already there)
        if (indexPivot != last) {
            swap(a, indexPivot, last);
            Counter.numberOfSwaps++;
        }

        // Pivot value (now at last position)
        double pivot = a[last];

        // n marks the boundary for elements smaller than pivot
        int n = first - 1;

        // Loop through elements
        for (int i = first; i < last; i++) {

            Counter.numberOfComparisons++;

            // If element is smaller than pivot
            if (a[i] < pivot) {
                n++;

                // Swap to move smaller element to the left side
                if (i != n) {
                    swap(a, i, n);
                    Counter.numberOfSwaps++;
                }
            }
        }

        // Place pivot in correct sorted position
        int k = n + 1;
        if (k != last) {
            swap(a, k, last);
            Counter.numberOfSwaps++;
        }

        // Return pivot index
        return n + 1;
    }

    // Swap two elements in the array
    private static void swap(Double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Main method to run quicksort
    public static Double[] runner(Double[] x, char sortOrder) {

        // Create a copy so original array is not modified
        Double[] a = Arrays.copyOf(x, x.length);

        int n = a.length;

        // Start sorting
        sorting(a, 0, n - 1, sortOrder);

        // Return sorted array
        return a;
    }
}