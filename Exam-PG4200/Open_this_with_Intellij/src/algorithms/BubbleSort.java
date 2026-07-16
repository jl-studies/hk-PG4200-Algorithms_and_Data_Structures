package algorithms;

import java.util.Arrays;
import runners.Counter;


public class BubbleSort {

    public static Double[] optimizedBubbleSort(Double[] x) {
        //Creates copy of array
        Double[] a = Arrays.copyOf(x, x.length);
        //Finds length of array
        int n = a.length;

        //Runs n - 1 passes through the array
        for (int i = 0; i < n - 1; ++i) {
            boolean swapped = false;
            //For loop that compares each adjacent value pair
            for (int j = 0; j < n - i - 1; ++j) {
                Counter.numberOfComparisons++;
                //Swaps adjacent value pairs, if left element is greater than right
                if (a[j] > a[j + 1]) {
                    //Sets temporary variable to value at a[index] position
                    double temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    //Sets swapped to be true if swapped
                    swapped = true;
                    //Increments number of swaps
                    Counter.numberOfSwaps++;
                }
            }
            //Breaks if swapped is not true
            if (!swapped) {
                break;
            }
        }
        //Returns sorted array
        return a;
    }


    public static Double[] unoptimizedBubbleSort(Double[] x) {
        //Creates copy of array
        Double[] a = Arrays.copyOf(x, x.length);
        //Finds length of array
        int n = a.length;
        //Runs n - 1 passes through the array
        for (int i = 0; i < n - 1; ++i) {
            //For loop that compares each adjacent value pair
            for (int j = 0; j < n - i - 1; ++j) {
                //Increments comparisons
                Counter.numberOfComparisons++;
                //Swaps adjacent value pairs, if left element is greater than right
                if (a[j] > a[j + 1]) {
                    //Sets temporary variable to value at a[index] position
                    double temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    //Increments number of swaps
                    Counter.numberOfSwaps++;
                }
            }

        }
        //Returns sorted array
        return a;
    }

}
