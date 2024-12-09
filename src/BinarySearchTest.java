import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @Test
    public void testIntegerBinarySearch() {
        int[] array = {1, 2, 3, 3, 4, 5, 6};
        assertEquals(2, BinarySearch.binarySearchRecursive(array, 3, 0, array.length - 1));
    }

    @Test
    public void testStringBinarySearch() {
        String[] array = {"apple", "banana", "cherry", "date"};
        assertEquals(2, BinarySearch.binarySearchRecursive(array, "cherry", 0, array.length - 1));
    }

    @Test
    public void testAllIndicesBinarySearch() {
        int[] array = {1, 2, 3, 3, 4, 5, 6};
        assertEquals(List.of(2, 3), BinarySearch.binarySearchAllIndices(array, 3, 0, array.length - 1));
    }
}
