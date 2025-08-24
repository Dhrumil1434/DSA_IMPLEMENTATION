package STEP_3_ARRAY.EASY;

/*
 * Problem: Linear Search in Array
 * 
 * Given an integer array and a target value, find the first occurrence of the target
 * and return its index. If the target is not found, return -1.
 * 
 * Key Requirements:
 * - Return the index of the first occurrence of target
 * - Return -1 if target not found
 * - Handle edge cases (empty array, single element)
 * 
 * Example: [1, 2, 3, 4, 5, 6, 7, 8], target = 8 → return 7
 * Example: [1, 2, 3, 4, 5, 6, 7, 8], target = 10 → return -1
 * 
 * Approaches:
 * 1. Linear Search: O(n) time, O(1) space - scan array sequentially
 * 2. Binary Search: O(log n) time, O(1) space - requires sorted array
 * 
 * Note: Linear search works on any array (sorted or unsorted)
 *       Binary search only works on sorted arrays but is much faster
 */

public class p8 {
    
    /*
     * LINEAR SEARCH IMPLEMENTATION
     * 
     * Intuition: 
     * - Scan the array from left to right
     * - Compare each element with the target
     * - Return index when match is found
     * - Return -1 if no match after scanning entire array
     * 
     * Algorithm:
     * 1. Check if array is empty (edge case)
     * 2. Iterate through array from index 0 to n-1
     * 3. For each element, check if it equals target
     * 4. If found, return current index immediately
     * 5. If not found after entire scan, return -1
     * 
     * Time Complexity: O(n) - worst case scans entire array
     * Space Complexity: O(1) - only constant extra space
     * 
     * Best Case: O(1) - target found at first position
     * Average Case: O(n/2) - target found in middle on average
     * Worst Case: O(n) - target not found or at last position
     */
    public static int linearSearch(int arr[], int k) {
        // Edge case: empty array
        if (arr.length < 1) {
            return -1;
        }
        
        // Scan array sequentially from left to right
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return i; // Found target, return index immediately
            }
        }
        
        return -1; // Target not found after scanning entire array
    }
    
    /*
     * OPTIMIZED LINEAR SEARCH (Early Termination)
     * 
     * If we know the array is sorted in ascending order, we can optimize:
     * - Stop searching when we encounter an element > target
     * - This works because all subsequent elements will be larger
     * - Provides O(1) best case and O(n) worst case
     */
    public static int optimizedLinearSearch(int arr[], int k) {
        if (arr.length < 1) {
            return -1;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return i; // Found target
            }
            // Optimization for sorted arrays: early termination
            if (arr[i] > k) {
                break; // No need to search further
            }
        }
        
        return -1; // Target not found
    }
    
    /*
     * LINEAR SEARCH WITH COUNT (Find all occurrences)
     * 
     * Extension: Count how many times target appears in array
     * Useful for frequency analysis or duplicate detection
     */
    public static int[] linearSearchWithCount(int arr[], int k) {
        if (arr.length < 1) {
            return new int[]{-1, 0}; // {index, count}
        }
        
        int firstIndex = -1;
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                if (firstIndex == -1) {
                    firstIndex = i; // Record first occurrence
                }
                count++; // Increment count
            }
        }
        
        return new int[]{firstIndex, count}; // Return {first_index, total_count}
    }
    
    public static void main(String[] args) {
        // Test case 1: Basic linear search
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println("Array: [1, 2, 3, 4, 5, 6, 7, 8]");
        System.out.println("Searching for 8:");
        System.out.println("Index: " + linearSearch(arr, 8)); // Expected: 7
        
        // Test case 2: Target not found
        System.out.println("\nSearching for 10:");
        System.out.println("Index: " + linearSearch(arr, 10)); // Expected: -1
        
        // Test case 3: Target at beginning
        System.out.println("\nSearching for 1:");
        System.out.println("Index: " + linearSearch(arr, 1)); // Expected: 0
        
        // Test case 4: Target in middle
        System.out.println("\nSearching for 4:");
        System.out.println("Index: " + linearSearch(arr, 4)); // Expected: 3
        
        // Test case 5: Optimized search on sorted array
        System.out.println("\nOptimized search for 6:");
        System.out.println("Index: " + optimizedLinearSearch(arr, 6)); // Expected: 5
        
        // Test case 6: Search with count
        int arrWithDuplicates[] = { 1, 2, 2, 2, 3, 4, 2, 5 };
        System.out.println("\nArray with duplicates: [1, 2, 2, 2, 3, 4, 2, 5]");
        System.out.println("Searching for 2:");
        int result[] = linearSearchWithCount(arrWithDuplicates, 2);
        System.out.println("First index: " + result[0] + ", Count: " + result[1]); // Expected: 1, 4
        
        // Test case 7: Empty array
        int emptyArr[] = {};
        System.out.println("\nEmpty array search for 5:");
        System.out.println("Index: " + linearSearch(emptyArr, 5)); // Expected: -1
    }
}

