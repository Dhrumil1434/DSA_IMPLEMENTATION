package STEP_3_ARRAY.EASY;

/*
 * Problem: Rotate array by K positions (both left and right)
 * 
 * Key Insight: k = k % n is crucial because:
 * - Rotating by n positions brings array back to original state
 * - Rotating by n+1 is same as rotating by 1
 * - This optimization handles large k values efficiently
 * 
 * Example: Array [1,2,3,4,5,6] with n=6
 * - k=6: [1,2,3,4,5,6] → [1,2,3,4,5,6] (no change)
 * - k=7: [1,2,3,4,5,6] → [2,3,4,5,6,1] (same as k=1)
 * - k=8: [1,2,3,4,5,6] → [3,4,5,6,1,2] (same as k=2)
 * 
 * So k = k % n gives us the effective rotation needed
 */

class TempArrayApproach {
    
    /*
     * RIGHT ROTATION BY K PLACES
     * 
     * Intuition: Move last k elements to front
     * Example: [1,2,3,4,5,6] with k=2
     * - Last 2 elements: [5,6]
     * - Move them to front: [5,6,1,2,3,4]
     * 
     * Steps:
     * 1. Store last k elements in temp array
     * 2. Shift remaining elements right by k positions
     * 3. Place temp elements at beginning
     */
    public static int[] rotateElementRightByKplace(int arr[], int k) {
        int n = arr.length;
        if (n < 1) {
            return new int[0];
        }
        
        // CRITICAL: Handle large k values efficiently
        k = k % n;
        
        // If k is 0 or n, no rotation needed
        if (k == 0) {
            return arr;
        }
        
        // Step 1: Store last k elements in temp array
        int temp[] = new int[k];
        for (int i = n - k; i < n; i++) {
            temp[i - n + k] = arr[i];  // temp[0] = arr[n-k], temp[1] = arr[n-k+1], etc.
        }
        
        // Step 2: Shift remaining elements right by k positions
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];  // arr[n-1] = arr[n-k-1], arr[n-2] = arr[n-k-2], etc.
        }
        
        // Step 3: Place temp elements at beginning
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
        
        return arr;
    }

    /*
     * LEFT ROTATION BY K PLACES
     * 
     * Intuition: Move first k elements to end
     * Example: [1,2,3,4,5,6] with k=2
     * - First 2 elements: [1,2]
     * - Move them to end: [3,4,5,6,1,2]
     * 
     * Steps:
     * 1. Store first k elements in temp array
     * 2. Shift remaining elements left by k positions
     * 3. Place temp elements at end
     */
    public static int[] rotateArrayLeftByKPlace(int arr[], int k) {
        int n = arr.length;
        if (n == 0) {
            return new int[0];
        }
        
        // CRITICAL: Handle large k values efficiently
        k = k % n;
        
        // If k is 0 or n, no rotation needed
        if (k == 0) {
            return arr;
        }
        
        // Step 1: Store first k elements in temp array
        int temp[] = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];  // temp[0] = arr[0], temp[1] = arr[1], ..., temp[k-1] = arr[k-1]
        }
        
        // Step 2: Shift remaining elements left by k positions
        for (int i = 0; i < n - k; i++) {
            arr[i] = arr[i + k];  // arr[0] = arr[k], arr[1] = arr[k+1], ..., arr[n-k-1] = arr[n-1]
        }
        
        // Step 3: Place temp elements at end
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - n + k];  // arr[n-k] = temp[0], arr[n-k+1] = temp[1], etc.
        }
        
        return arr;
    }
}

public class p6 {
    public static void main(String[] args) {
        // Test case 1: Right rotation by 3
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Original array: [1, 2, 3, 4, 5, 6]");
        System.out.println("Right rotation by k=3:");
        
        int oneop[] = TempArrayApproach.rotateElementRightByKplace(arr, 3);
        System.out.println("Output: ");
        for (int x : oneop) {
            System.out.print(x + " ");
        }
        System.out.println(); // Expected: [4, 5, 6, 1, 2, 3]
        
        // Test case 2: Left rotation by large k (demonstrates k % n optimization)
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("\nOriginal array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
        System.out.println("Left rotation by k=3000001:");
        System.out.println("Note: 3000001 % 10 = 1, so this is same as rotating by 1");
        
        int twoop[] = TempArrayApproach.rotateArrayLeftByKPlace(arr1, 3000001);
        System.out.println("Output: ");
        for (int x : twoop) {
            System.out.print(x + " ");
        }
        System.out.println(); // Expected: [2, 3, 4, 5, 6, 7, 8, 9, 10, 1]
    }
}
