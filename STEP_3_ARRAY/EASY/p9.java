package STEP_3_ARRAY.EASY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
* Problem: we are going to find the union of the 2 sorted arrays
* initially i can think of the approach like as we want to get the unique elements from the given 2 data sets 
* we would travers the 2 arrays and initialise the hashset which leads to store the unique elements only 
* then after the insertion all the elemenet will copy to the ans array then return 
*/
class BruteForce {
    public static int[] unionOfTwoSortedArray(int arr1[], int arr2[]) {
        if (arr1.length < 1 && arr2.length < 1) {
            return new int[0];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr1) {
            set.add(x);
        }
        for (int x : arr2) {
            set.add(x);
        }
        int n = set.size();
        int temp[] = new int[n];
        int i = 0;
        for (int x : set) {
            temp[i++] = x;
        }
        return temp;
    }

}

class Optimal 
{
    public static void unionOfTwoSortedArray(int arr1[], int arr2[]) {
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        // ✅ leftover handling OUTSIDE
        while (i < arr1.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        while (j < arr2.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        for (int x : union) {
            System.out.print(" " + x);
        }
    }
}

public class p9 {
    public static void main(String[] args) {
        int arr1[] = {1,2,2,3,3,4,5};
        int arr2[] = { 6, 7, 1, 2, 3, 7, 8 };
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int ans[] = BruteForce.unionOfTwoSortedArray(arr1, arr2);
        System.out.println("BruteForce Answer :");
        if (ans.length < 1)
        {
            System.out.println("invalid data was provided !");
        }
        for(int x: ans)
        {
            System.out.print(" " + x);
        }
        System.out.println();
        System.out.println();
        System.out.println("Optimal Answer");
        int arr3[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int arr4[] = { 1, 2, 3, 3, 4, 4, 5, 5 };
        Optimal.unionOfTwoSortedArray(arr3, arr4);
        
    }
    
}
