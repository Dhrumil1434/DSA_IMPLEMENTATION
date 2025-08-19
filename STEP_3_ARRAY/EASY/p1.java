// Find the largest element in the array
// Time Complexity: O(nlogn)
// Space Complexity: O(1)

// Brute Force Approach
// 1. Sort the array
// 2. Return the last element
// 3. Edge Case: If the array is empty, return -1

// Optimal Approach
// 1. Initialize a variable to store the largest element
// 2. Iterate through the array and update the largest element
// 3. Return the largest element
// 4. Edge Case: If the array is empty, return -1

// Edge Case: If the array is empty, return -1
// 1. If the array is empty, return -1
// 2. If the array has only one element, return the element
package STEP_3_ARRAY.EASY;

import java.util.Arrays;

public class p1 {
    public static int largestElement(int arr[])
    {
        if (arr.length == 0) {
            return -1;
        }
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 33, 44, 66, 454, 22, 11 };
        System.out.println(largestElement(arr));
        System.out.println(BetterApproach.largestElement(arr));
    }
}
/* output:
454
*/
class BetterApproach{
    public static int largestElement(int arr[]){
        if (arr.length == 0) {
            return -1;
        }
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max; 
    }
}
/* output:
454
*/
