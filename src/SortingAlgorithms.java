import java.util.Random;

/*
 Vladyslav Kovtun, 19899
*/
public class SortingAlgorithms {

    public static Integer[] insertionSort(Integer[] array) {
        SortedPQ<Integer, Integer> pq = new SortedPQ<>();

        return sortWithPQ(array, pq);
    }

    public static Integer[] selectionSort(Integer[] array) {
        UnsortedPQ<Integer, Integer> pq = new UnsortedPQ<>();

        return sortWithPQ(array, pq);
    }

    private static Integer[] sortWithPQ(Integer[] array, AbstractPriorityQueue<Integer, Integer> pq) {
        for (int element : array) {
            pq.insert(element, element);
        }

        Integer[] sorted = new Integer[array.length];
        int i = 0;

        while (!pq.isEmpty()) {
            sorted[i] = pq.removeMin().getKey();
            i++;
        }

        return sorted;
    }

    public static Integer[] heapSort(Integer[] array) {
        HeapPQ<Integer, Integer> heap = new HeapPQ<>();
        for (int num : array) {
            heap.insert(num, num);
        }
        Integer[] sorted = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            sorted[i] = heap.removeMin().getKey();
        }
        return sorted;
    }

    public static Integer[] generateRandomArray(int capacity) {
        Random random = new Random();
        Integer[] array = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = random.nextInt(capacity);
        }
        return array;
    }
}
