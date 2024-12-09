import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    // Recursive binary search for integers
    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        if (left > right) {
            return -1; // Base case: range is empty
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearchRecursive(array, target, left, mid - 1);
        } else {
            return binarySearchRecursive(array, target, mid + 1, right);
        }
    }

    // Recursive binary search for strings
    public static int binarySearchRecursive(String[] array, String target, int left, int right) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        if (left > right) {
            return -1; // Base case: range is empty
        }

        int mid = left + (right - left) / 2;

        int comparison = array[mid].compareTo(target);

        if (comparison == 0) {
            return mid;
        } else if (comparison > 0) {
            return binarySearchRecursive(array, target, left, mid - 1);
        } else {
            return binarySearchRecursive(array, target, mid + 1, right);
        }
    }

    // Recursive binary search for all indices
    public static List<Integer> binarySearchAllIndices(int[] array, int target, int left, int right) {
        List<Integer> indices = new ArrayList<>();

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        if (left > right) {
            return indices; // Base case: range is empty
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            indices.add(mid);
            indices.addAll(binarySearchAllIndices(array, target, left, mid - 1));
            indices.addAll(binarySearchAllIndices(array, target, mid + 1, right));
        } else if (array[mid] > target) {
            indices.addAll(binarySearchAllIndices(array, target, left, mid - 1));
        } else {
            indices.addAll(binarySearchAllIndices(array, target, mid + 1, right));
        }

        return indices;
    }

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 3, 4, 5, 6};
        String[] stringArray = {"apple", "banana", "cherry", "date"};

        System.out.println("Integer Binary Search:");
        System.out.println(binarySearchRecursive(intArray, 3, 0, intArray.length - 1)); // Example: Index of 3

        System.out.println("String Binary Search:");
        System.out.println(binarySearchRecursive(stringArray, "cherry", 0, stringArray.length - 1)); // Example: Index of "cherry"

        System.out.println("All Indices Binary Search:");
        System.out.println(binarySearchAllIndices(intArray, 3, 0, intArray.length - 1)); // Example: Indices of 3
    }
}
