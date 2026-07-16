package algorithms;

import java.util.Arrays;
import runners.Counter;

public class InsertionSort {

    // Method that sorts an array of Double values using insertion sort
    public static Double[] sort(Double[] x) {

        // Create a copy of the input array so the original is not modified
        Double[] a = Arrays.copyOf(x, x.length);

        int n = a.length; // Length of the array

        // Start from the second element (index 1), since the first is already "sorted"
        for (int i = 1; i < n; i++) {

            double temp = a[i]; // The value we want to insert in the correct position
            int index = i - 1;  // Start comparing with the element to the left

            // the loop wil run true alle the elements left of the index
            while (index >= 0) {
                Counter.numberOfComparisons++; // Count comparisons

                if (a[index] > temp) {
                    a[index + 1] = a[index]; // Move element one step to the right
                    index--; // Move left
                    Counter.numberOfSwaps++; // Count shifts (treated as swaps)
                } else {
                    break; // Stop when the correct position is found
                }
            }

            // Place temp in its correct position
            a[index + 1] = temp;
        }

        // Return the sorted array
        return a;
    }
}