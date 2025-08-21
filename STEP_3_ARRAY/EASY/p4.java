package STEP_3_ARRAY.EASY;

import java.util.Arrays;
// this is the brute force solution for the counting the duplicate element in the array
// we can think like first we can take the hashset and add the element in the hashset
// then we can iterate the hashset and add the element in the array
// then we can return the size of the hashset
// this is the brute force solution for the counting the duplicate element in the array
// we can think like first we can take the hashset and add the element in the hashset
// then we can iterate the hashset and add the element in the array
import java.util.HashSet;

public class p4 {

    public static int countDuplicateElement(int arr[])
    {
        HashSet<Integer> set = new HashSet<>();
        if (arr.length < 1) {
            return -1;
        }
        for (int x : arr) {
            set.add(x);
        }
        int i = 0;
        for (int x : set)
        {
            arr[i++] = x;
        }
        return set.size();
    }
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 7 };
        System.out.println("Unique Element :" + countDuplicateElement(arr));
        System.out.println("Unique Element Optimal :" + OptimalSolution.removeDuplicates(arr));
        
    }
    
}
/*
following is the in detailed explanation of time and space complexity of the code
time complexity : O(n*log(n))+ O(n)
we are using the hashset to store the element in the array
space complexity : O(log(n)) and we have n element so O(n*log(n))
we are using the hashset to store the element in the array
so the space complexity is O(n)
*/


class OptimalSolution 
{
   static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
     
}   