package STEP_3_ARRAY.EASY;

import java.util.ArrayList;

class BruteForce {
    public static void interSection(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int v[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i] == arr2[j] && v[j] == 0) {
                    ans.add(arr1[i]);
                    v[j] = 1;
                    break;
                }
                if (arr2[j] > arr1[i]) {
                    break;
                }
            }
        }
        for (int x : ans) {
            System.out.print(" " + x);
        }
    }
}

class OptimalSolution {
    public static void interSection(int arr1[],int arr2[])
    {
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i < arr1.length && j < arr2.length)
        {
            if (arr1[i] < arr2[j])
            {
                i++;
            }
            if (arr2[j] < arr1[i]) {
                j++;
            }
            if (arr1[i] == arr2[j]) {
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        for(int x: ans)
        {
            System.out.print(" "+x);
        }
    }
}

public class p10 {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 3, 4 , 5, 6, 7, 8 , 9 , 10};
        int arr2[] = { };
        System.out.println("Brute Force Approach :");
        BruteForce.interSection(arr1, arr2);
        System.out.println("\n\n\n");
        System.out.println("Optimal approach :");
         int arr3[] = { 1, 2, 3, 3, 4 };
         int arr4[] = {  };
        OptimalSolution.interSection(arr3, arr4);
    }
    
}
