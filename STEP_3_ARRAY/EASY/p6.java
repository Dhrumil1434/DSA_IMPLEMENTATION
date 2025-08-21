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
            temp[i - n + k] = arr[i]; // temp[0] = arr[n-k], temp[1] = arr[n-k+1], etc.
        }

        // Step 2: Shift remaining elements right by k positions
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i]; // arr[n-1] = arr[n-k-1], arr[n-2] = arr[n-k-2], etc.
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
            temp[i] = arr[i]; // temp[0] = arr[0], temp[1] = arr[1], ..., temp[k-1] = arr[k-1]
        }

        // Step 2: Shift remaining elements left by k positions
        for (int i = 0; i < n - k; i++) {
            arr[i] = arr[i + k]; // arr[0] = arr[k], arr[1] = arr[k+1], ..., arr[n-k-1] = arr[n-1]
        }

        // Step 3: Place temp elements at end
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - n + k]; // arr[n-k] = temp[0], arr[n-k+1] = temp[1], etc.
        }

        return arr;
    }
}

class ReversalApproach {
    /*
     * LEFT ROTATION BY K PLACES USING REVERSAL METHOD
     * 
     * Intuition: Use three reversals to achieve rotation
     * Example: [1,2,3,4,5,6] with k=2
     * 
     * Step 1: Reverse first k elements: [2,1,3,4,5,6]
     * Step 2: Reverse remaining elements: [2,1,6,5,4,3]
     * Step 3: Reverse entire array: [3,4,5,6,1,2]
     * 
     * Result: [3,4,5,6,1,2] (left rotation by 2)
     * 
     * Mathematical Proof: 
     * - Original: [A, B, C, D] where A has k elements, B has n-k elements
     * - After Step 1: [A', B, C, D] where A' is reversed A
     * - After Step 2: [A', B', C, D] where B' is reversed B
     * - After Step 3: [D', C', B', A'] where D' is reversed D, C' is reversed C
     * - Final: [B, A] which is the desired left rotation
     */
    public static int[] rotateArrayLeftByKPlace(int arr[], int k) {
        int n = arr.length;
        if (n < 1) return new int[0];
        
        // CRITICAL: Handle large k values efficiently
        k = k % n;
        
        // If k is 0, no rotation needed
        if (k == 0) return arr;
        
        // Step 1: Reverse first k elements (0 to k-1)
        ArrayUtils.reverse(arr, 0, k - 1);
        
        // Step 2: Reverse remaining elements (k to n-1)
        ArrayUtils.reverse(arr, k, n - 1);
        
        // Step 3: Reverse entire array (0 to n-1)
        ArrayUtils.reverse(arr, 0, n - 1);
        
        return arr;
    }
    
    /*
     * RIGHT ROTATION BY K PLACES USING REVERSAL METHOD
     * 
     * Intuition: Use three reversals to achieve rotation
     * Example: [1,2,3,4,5,6] with k=2
     * 
     * Step 1: Reverse last k elements: [1,2,3,4,6,5]
     * Step 2: Reverse first n-k elements: [4,3,2,1,6,5]
     * Step 3: Reverse entire array: [5,6,1,2,3,4]
     * 
     * Result: [5,6,1,2,3,4] (right rotation by 2)
     * 
     * Mathematical Proof:
     * - Original: [A, B, C, D] where A has n-k elements, B has k elements
     * - After Step 1: [A, B', C, D] where B' is reversed B
     * - After Step 2: [A', B', C, D] where A' is reversed A
     * - After Step 3: [D', C', B', A'] where D' is reversed D, C' is reversed C
     * - Final: [B, A] which is the desired right rotation
     */
    public static int[] rotateArrayRigthByKPlace(int arr[], int k) {
        int n = arr.length;
        if (n < 1) return new int[0];
        
        // CRITICAL: Handle large k values efficiently
        k = k % n;
        
        // If k is 0, no rotation needed
        if (k == 0) return arr;
        
        // Step 1: Reverse last k elements (n-k to n-1)
        ArrayUtils.reverse(arr, n - k, n - 1);
        
        // Step 2: Reverse first n-k elements (0 to n-k-1)
        ArrayUtils.reverse(arr, 0, n - k - 1);
        
        // Step 3: Reverse entire array (0 to n-1)
        ArrayUtils.reverse(arr, 0, n - 1);
        
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
        int arr2[] = { 1, 2, 3, 4, 5, 6 };
        int arr3[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println("\nOriginal array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
        System.out.println("Left rotation by k=3000001:");
        System.out.println("Note: 3000001 % 10 = 1, so this is same as rotating by 1");
        
        int twoop[] = TempArrayApproach.rotateArrayLeftByKPlace(arr1, 3000001);
        System.out.println("Output: ");
        for (int x : twoop) {
            System.out.print(x + " ");
        }
        System.out.println(); // Expected: [2, 3, 4, 5, 6, 7, 8, 9, 10, 1]
        System.out.println("Reversal Approach");
        System.out.print("Input :");
        for(int x: arr2)
        {
            System.out.print(" " + x);
        }
        int ans_reversal[] = ReversalApproach.rotateArrayLeftByKPlace(arr2, 3);
        System.out.println("\n Answer :");
        for(int x: ans_reversal)
        {
            System.out.print(" " + x);
        }
        System.out.println();
         System.out.print("Input :");
        for(int x: arr3)
        {
            System.out.print(" " + x);
        }
        int ans_reversal2[] = ReversalApproach.rotateArrayRigthByKPlace(arr3, 3);
        System.out.println("\n Answer :");
        for(int x: ans_reversal2)
        {
             System.out.print(" "+ x);
        }
    }
}
