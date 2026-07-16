package runners;

import algorithms.MergeSort;
import algorithms.QuickSort;
import algorithms.BubbleSort;
import algorithms.InsertionSort;


import java.io.IOException;
import java.util.*;


public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void display() throws IOException {
        //Defined "shutdown" trigger for menu
        boolean userExit = false;


        Set<Double> alcoholValue = new LinkedHashSet<>(WineReader.loadAlcoholValues());
        Double[] array = alcoholValue.toArray(new Double[0]);


        //Displays menu as text to the user
        displayMenu();

        //Makes sure user can exit menu with 99. Waits for a number input from the user, this number calls an algorithm based on input in /algorithms/
        while (!userExit) {
            System.out.print("Please input number from menu and press enter: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {

                // Bubblesort unoptimized
                case 1 -> {
                    Counter.resetCounter();
                    System.out.println("BubbleSort Unoptimized: ");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(BubbleSort.unoptimizedBubbleSort(array)));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }

                // Bubblesort optimized
                case 2 -> {
                    Counter.resetCounter();
                    System.out.println("BubbleSort Optimized: ");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(BubbleSort.optimizedBubbleSort(array)));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }

                // Bubblesort unoptimized and randomized array
                case 3 -> {
                    Counter.resetCounter();
                    System.out.println("BubbleSort Unoptimized (Randomized): ");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(BubbleSort.unoptimizedBubbleSort(arrayRandomizer(array))));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }
                case 4 -> {
                    // Bubblesort optimized and randomized array
                    Counter.resetCounter();
                    System.out.println("BubbleSort Optimized (Randomized): ");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(BubbleSort.optimizedBubbleSort(arrayRandomizer(array))));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }
                case 5 -> {
                    //Insertion sort
                    Counter.resetCounter();
                    System.out.println("Insertion Sort: ");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(InsertionSort.sort(array)));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }
                case 6 -> {
                    //Insertion sort randomized
                    Counter.resetCounter();
                    System.out.println("Insertion Sort (Randomized): ");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(InsertionSort.sort(arrayRandomizer(array))));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }
                case 7 -> {
                    //Merge sort
                    Counter.resetCounter();
                    System.out.println("Merge Sort: ");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(MergeSort.mergeRun(array)));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }
                case 8 -> {
                    //merge sort randomized
                    Counter.resetCounter();
                    System.out.println("Merge Sort (Randomized): ");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(MergeSort.mergeRun(arrayRandomizer(array))));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }
                case 9 -> {
                    //quick sort - first element
                    Counter.resetCounter();
                    System.out.println("Quick Sort - First element");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(QuickSort.runner(array, 'a')));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }
                case 10 -> {
                    //quick sort - last element
                    Counter.resetCounter();
                    System.out.println("Quick Sort - Last element");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(QuickSort.runner(array, 'b')));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }
                case 11 -> {
                    //quick sort - Random element
                    Counter.resetCounter();
                    System.out.println("Quick Sort - Random element");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(QuickSort.runner(array, 'c')));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }
                case 12 -> {
                    //quick sort - median element
                    Counter.resetCounter();
                    System.out.println("Quick Sort - Median element");
                    Counter.timerStart();
                    System.out.println(Arrays.toString(QuickSort.runner(array, 'd')));
                    Counter.timerStop();
                    Counter.comparisonsSwapsMergers();
                }
                //Displays menu
                case 55 -> displayMenu();
                //Quits/breaks loop
                case 99 -> {
                    System.out.println("Goodbye \uD83D\uDC4B");
                    userExit = true;
                }
                //Standard menu choice
                default -> System.out.println("Your choices are 1-12, 55 for menu or 99 to exit. Please try again.");
            }
        }
    }

    public static Double[] arrayRandomizer(Double[] a) {
        List<Double> temp = new ArrayList<>(Arrays.asList(a));
        Double[] randomized;

        Collections.shuffle(temp);
        randomized = temp.toArray(new Double[0]);
        return randomized;
    }

    static void displayMenu(){
        System.out.println("###########################################");
        System.out.println("#  Please make a choice:                  #");
        System.out.println("#  1. BubbleSort Unoptimized              #");
        System.out.println("#  2. BubbleSort Optimized                #");
        System.out.println("#  3. BubbleSort Unoptimized (Randomized) #");
        System.out.println("#  4. BubbleSort Optimized   (Randomized) #");
        System.out.println("#  5. Insertion Sort                      #");
        System.out.println("#  6. Insertion Sort         (Randomized) #");
        System.out.println("#  7. Merge Sort                          #");
        System.out.println("#  8. Merge Sort             (Randomized) #");
        System.out.println("#  9. Quick Sort     - First element      #");
        System.out.println("#  10. Quick Sort     - Last element      #");
        System.out.println("#  11. Quick Sort     - Random element    #");
        System.out.println("#  12. Quick Sort     - Median element    #");
        System.out.println("#                                         #");
        System.out.println("#  55. Display menu                       #");
        System.out.println("#  99. Exit                               #");
        System.out.println("###########################################");
    }
}