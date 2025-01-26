public class Main {
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String GREEN = "\033[0;32m";  // GREEN
    public static final String YELLOW = "\033[0;33m"; // YELLOW

    public static void main(String[] args) {

        int[] capacities = {100, 1000, 10_000, 100_000, 500_000, 1_000_000};

        for (int capacity : capacities) {
            System.out.println("---------------------------------------");
            System.out.println("Array capacity: " + capacity);

            Integer[] arr = SortingAlgorithms.generateRandomArray(capacity);

            measureSortingTime("Insertion sort", arr);
            measureSortingTime("Selection sort", arr);
            measureSortingTime("Heap sort", arr);
        }
    }

    private static void measureSortingTime(
            String algorithmName,
            Integer[] originalArray
    ) {
        Integer[] arrayCopy = originalArray.clone();
        System.out.println(YELLOW + "Starting sorting with " + algorithmName + "..." + RESET);
        long startTime = System.nanoTime();
        switch (algorithmName) {
            case "Insertion sort":
                SortingAlgorithms.insertionSort(arrayCopy);
                break;
            case "Selection sort":
                SortingAlgorithms.selectionSort(arrayCopy);
                break;
            case "Heap sort":
                SortingAlgorithms.heapSort(arrayCopy);
                break;
            default:
                System.out.println("Error.z");
        }
        long endTime = System.nanoTime();
        System.out.println(GREEN + algorithmName + " took " + (endTime - startTime) + " nanoseconds" + RESET);
    }
}
