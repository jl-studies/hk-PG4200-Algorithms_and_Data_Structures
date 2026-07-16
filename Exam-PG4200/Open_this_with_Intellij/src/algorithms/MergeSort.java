package algorithms;

import java.util.Arrays;
import runners.Counter;

public class MergeSort {
    static void mergeSort(Double[] a, int indexLeft, int indexRight) {

        //Checks if leftindex is smaller than rightindex
        if (indexLeft < indexRight) {

            //Calculations for finding right minus left index and middle index
            int rightMinusLeft = indexRight - indexLeft;
            int indexMiddle = indexLeft + rightMinusLeft / 2;

            //Calls mergesort method with left and middle index
            mergeSort(a, indexLeft, indexMiddle);
            //Calls mergesort method with right and middle index
            mergeSort(a, indexMiddle+1, indexRight);
            //Calls merge method to merge arrays
            merge(a, indexLeft, indexMiddle, indexRight);
        }
    }

    static void merge(Double[] a, int indexLeft, int indexMiddle, int indexRight) {
        //Increments number of mergers
        Counter.numberOfMergers++;
        //Creates two variables to calculate how many elements are in each half of the arrays/subarrays
        int p1 = indexMiddle - indexLeft + 1;
        int p2 = indexRight - indexMiddle;

        //Creates two temporary arrays to help merge
        double[] arrayLeft = new double[p1];
        double[] arrayRight = new double[p2];

        //Copying data to the temporary arrays, for runs until i or j has reached
        //the index value of p1 (left array) or p2 (right array)
        for (int i = 0; i < p1; ++i)
            arrayLeft[i] = a[indexLeft + i];
        for (int j = 0; j < p2; ++j)
            arrayRight[j] = a[indexMiddle + 1 + j];

        //Merge and sorting of the arrays
        int i = 0;
        int j = 0;
        int k = indexLeft;
        //Runs while i is smaller than p1 (left index) and j is smaller than p2 (right index)
        while (i < p1 && j < p2) {
            //Increases number of comparisons
            Counter.numberOfComparisons++;
            //If runs as long as arrayleft index is not higher or equal to indexright value
            if (arrayLeft[i] <= arrayRight[j]) {
                a[k] = arrayLeft[i];
                i++;
            }
            else {
                a[k] = arrayRight[j];
                j++;
            }
            k++;
        }

        //Handles remaining elements
        //while loop runs as long as value I is smaller than p1 (left subarrays index)
        while (i < p1) {
            a[k] = arrayLeft[i];
            i++;
            k++;
        }
        //while loop runs as long as value j is smaller than p2 (right subarrays index)
        while (j < p2) {
            a[k] = arrayRight[j];
            j++;
            k++;
        }
    }
    //Runner
    public static Double[] mergeRun(Double[] x) {
        //Creates copy of array with variable x and finds x's length
        Double[] a = Arrays.copyOf(x, x.length);
        //sets n to be a (temp array) length
        int n = a.length;
        //Runs mergesort with temp array a, start of indexleft 0 (first index) and indexright (last index)
        mergeSort(a, 0, n-1);
        //Returns sorted a array to menu for printing
        return a;

    }
}
