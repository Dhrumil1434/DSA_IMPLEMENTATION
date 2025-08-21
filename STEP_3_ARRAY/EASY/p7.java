package STEP_3_ARRAY.EASY;

/*
 * Problem: Move All Zeros to End of Array
 * 
 * Given an integer array, move all 0's to the end while maintaining the relative order 
 * of the non-zero elements.
 * 
 * Key Requirements:
 * - Move all zeros to the end
 * - Maintain relative order of non-zero elements
 * - Do this in-place if possible
 * 
 * Example: [1, 0, 2, 0, 0, 3] → [1, 2, 3, 0, 0, 0]
 * 
 * Approaches:
 * 1. Brute Force: Use extra array to collect non-zeros, then copy back
 * 2. Better Solution: Two-pointer technique to swap non-zeros with first zero
 */

class BruteForce {
    /*
     * BRUTE FORCE APPROACH: Extra Array Method
     * 
     * Intuition: 
     * - Collect all non-zero elements in a temporary array
     * - Copy them back to the original array starting from index 0
     * - Fill remaining positions with zeros
     * 
     * Steps:
     * 1. Create temp array of same size
     * 2. Copy non-zero elements to temp array
     * 3. Copy temp elements back to original array
     * 4. Fill remaining positions with zeros
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - extra array needed
     */
    public static void moveZerosToEnd(int arr[]) {
        int n = arr.length;
        if (n < 1) {
            return;
        }
        
        // Step 1: Create temporary array and collect non-zero elements
        int temp[] = new int[n];
        int k = 0; // Index for temp array
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[k++] = arr[i]; // Copy non-zero to temp, increment k
            }
        }
        
        // Step 2: Copy non-zero elements back to original array
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
        
        // Step 3: Fill remaining positions with zeros
        for (int i = k; i < n; i++) {
            arr[i] = 0;
        }
        
        // Print result
        for (int x : arr) {
            System.out.println(x);
        }
    }
}

class BetterSolution {
    /*
     * BETTER SOLUTION: Two-Pointer Technique (In-Place)
     * 
     * Intuition:
     * - Use two pointers: one to find zeros, one to find non-zeros
     * - When we find a non-zero after a zero, swap them
     * - This moves non-zeros to the left and zeros to the right
     * 
     * Algorithm:
     * 1. Find the first zero (j pointer)
     * 2. For each non-zero element after j, swap it with arr[j]
     * 3. Increment j to point to the next zero
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) - in-place operation
     * 
     * Example: [1, 0, 2, 0, 0, 3]
     * Step 1: j = 1 (first zero at index 1)
     * Step 2: i = 2, arr[2] = 2 ≠ 0, swap(arr[2], arr[1]) → [1, 2, 0, 0, 0, 3], j = 2
     * Step 3: i = 5, arr[5] = 3 ≠ 0, swap(arr[5], arr[2]) → [1, 2, 3, 0, 0, 0], j = 3
     * Result: [1, 2, 3, 0, 0, 0]
     */
    public static void moveZerosToEnd(int arr[]) {
        if (arr.length < 1) {
            return;
        }
        
        // Step 1: Find the first zero (j pointer)
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        
        // If no zeros found, array is already correct
        if (j == -1) {
            return;
        }
        
        // Step 2: For each non-zero element after j, swap with arr[j]
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                ArrayUtils.swap(arr, i, j); // Swap non-zero with zero
                j++; // Move j to next position (which now contains a zero)
            }
        }
        
        // Print result
        for (int x : arr) {
            System.out.println(x);
        }
    }
}

public class p7 {
    public static void main(String[] args) {
        // Test case: Array with zeros scattered throughout
        int arr[] = { 1, 0, 2, 0, 0, 3 };
        System.out.println("Original array: [1, 0, 2, 0, 0, 3]");
        System.out.println("Brute Force Approach (Extra Array):");
        BruteForce.moveZerosToEnd(arr);
        
        System.out.println("\nBetter Solution (Two-Pointer, In-Place):");
        int arr1[] = { 1, 0, 2, 0, 0, 3 };
        BetterSolution.moveZerosToEnd(arr1);
        
        // Additional test cases
        System.out.println("\nTest Case 2: [0, 0, 0, 1, 2, 3]");
        int arr2[] = { 0, 0, 0, 1, 2, 3 };
        BetterSolution.moveZerosToEnd(arr2);
        
        System.out.println("\nTest Case 3: [1, 2, 3, 0, 0, 0]");
        int arr3[] = { 1, 2, 3, 0, 0, 0 };
        BetterSolution.moveZerosToEnd(arr3);
        
        System.out.println("\nTest Case 4: [0, 0, 0, 0, 0, 0]");
        int arr4[] = { 0, 0, 0, 0, 0, 0 };
        BetterSolution.moveZerosToEnd(arr4);
    }
}
