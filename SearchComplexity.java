// SearchComplexity.java
// Starter code for final programming assignment in CIT-63 Java Programming Spring 2024


import java.util.Arrays;
import java.util.Scanner;

public class SearchComplexity {

    // Linear Search Method
public static int linearSearch(int[] array, int target) {
    int iterations = 0; // Initialize iteration count
    for (int i = 0; i < array.length; i++) {
        iterations++; // Increment iteration count
        if (array[i] == target) {
            System.out.println("Target found at index " + i + " in " + iterations + " iterations.");
            return i;  // Returns index of found element
        }
    }
    System.out.println("Target not found in " + iterations + " iterations.");
    return -1;  // Target not found
}

   // Recursive Binary Search Method
public static int recursiveBinarySearch(int[] array, int target, int left, int right, int iterations) {
    iterations++; // Increment iteration count

    if (left > right) {
        System.out.println("Binary search iterations: " + iterations);
        return -1;  // Target not found
    }

    int mid = left + (right - left) / 2;

    if (array[mid] == target) {
        System.out.println("Binary search iterations: " + iterations);
        return mid;
    }

    if (array[mid] < target) {
        return recursiveBinarySearch(array, target, mid + 1, right, iterations);
    } else {
        return recursiveBinarySearch(array, target, left, mid - 1, iterations);
    }
}

// Wrapper method to call the recursive binary search
public static int binarySearch(int[] array, int target) {
    return recursiveBinarySearch(array, target, 0, array.length - 1, 0);
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number of elements in array:");
    if (scanner.hasNextInt()) {
        int n = scanner.nextInt();
        if (n > 0) {
            int[] array = new int[n];

            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                if (scanner.hasNextInt()) {
                    array[i] = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.close();
                    return;
                }
            }

            System.out.println("Enter target number to search:");
            if (scanner.hasNextInt()) {
                int target = scanner.nextInt();

                // Linear Search
                int linearResult = linearSearch(array, target);
                System.out.println((linearResult == -1) ? "Target not found by linear search." :
                        "Target found by linear search at index: " + linearResult);

                // Binary Search (Array must be sorted)
                Arrays.sort(array);
                int binaryResult = binarySearch(array, target);
                System.out.println((binaryResult == -1) ? "Target not found by binary search." :
                        "Target found by binary search at index: " + binaryResult);
            } else {
                System.out.println("Invalid input. Please enter an integer.");
            }
        } else {
            System.out.println("Invalid input. Array size must be greater than zero.");
        }
    } else {
        System.out.println("Invalid input. Please enter an integer.");
    }

    scanner.close();
}
}

