import java.util.Random;


public class Main {
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String GREEN = "\033[0;32m";  // GREEN
    public static final String YELLOW = "\033[0;33m"; // YELLOW

    public static void main(String[] args) {

//        int[] capacities = {100, 1000, 10_000, 100_000, 500_000, 1_000_000};
//
//        for (int capacity : capacities) {
//            System.out.println("---------------------------------------");
//            System.out.println("Array capacity: " + capacity);
//
//            Integer[] arr = generateRandomArray(capacity);
//
//            measureSortingTime("Selection sort", arr, SortingAlgorithms::selectionSort);
//            measureSortingTime("Insertion sort", arr, SortingAlgorithms::insertionSort);
//            measureSortingTime("Heap sort", arr, SortingAlgorithms::heapSort);
//        }


        Integer[] arr = generateRandomArray(500_000);
        measureSortingTime("Heap sort", arr, SortingAlgorithms::heapSort);
        measureSortingTime("Selection sort", arr, SortingAlgorithms::selectionSort);
    }

    private static void measureSortingTime(
            String algorithmName,
            Integer[] originalArray,
            SortingFunction<Integer> sortingFunction
    ) {
        Integer[] arrayCopy = originalArray.clone();
        System.out.println(YELLOW + "Starting sorting with " + algorithmName + "..." + RESET);
        long startTime = System.nanoTime();
        sortingFunction.sort(arrayCopy);
        long endTime = System.nanoTime();
        System.out.println(GREEN + algorithmName + " took " + (endTime - startTime) + " nanoseconds" + RESET);
    }

    public static Integer[] generateRandomArray(int capacity) {
        Random random = new Random();
        Integer[] array = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = random.nextInt(capacity);
        }
        return array;
    }

    @FunctionalInterface
    interface SortingFunction<T> {
        T[] sort(T[] array);
    }
}
