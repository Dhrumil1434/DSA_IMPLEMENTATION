package STEP_3_ARRAY.EASY;

import java.util.HashMap;
import java.util.Map.Entry;

// find the number which appears once and others are the twise

class BruteForce1 {
    public static int OnceOccuredNumber(int arr[])
    {
        if (arr.length < 1) {
            return -1;
        }
      int n = arr.length;

        //Run a loop for selecting elements:
        for (int i = 0; i < n; i++) {
            int num = arr[i]; // selected element
            int cnt = 0;

            //find the occurrence using linear search:
            for (int j = 0; j < n; j++) {
                if (arr[j] == num)
                    cnt++;
            }

            // if the occurrence is 1 return ans:
            if (cnt == 1) return num;
        }

        //This line will never execute
        //if the array contains a single element.
        return -1;
    }
    
}

class BruteForce2 {
    public static int OnceOccuredNumber(int arr[]) {
        if (arr.length < 1) {
            return -1;
        }
        int temp[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}

class BetterSolution1 {
    public static int getSingleElement(int[] arr) {
        //size of the array:
        int n = arr.length;

        // Declare the hashmap.
        // And hash the given array:
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }

        //Find the single element and return the answer:
        for (Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }

        //This line will never execute
        //if the array contains a single element.
        return -1;
    }
}

class OptimalSolution {
    public static int getSingleElement(int arr[])
    {
        int xor = 0;
        for(int x: arr)
        {
            xor ^= x;
        }
        return xor;
    }
}

public class p13 {
   public static void main(String[] args) {
       System.out.println("Initial Brute Force to get the once occured number: ");
       int arr1[] = { 2, 2, 1 };
       System.out.println("brute force 1 output : " + BruteForce1.OnceOccuredNumber(arr1));
       System.out.println("brute force 2 output : " + BruteForce2.OnceOccuredNumber(arr1));
       System.out.println();
       System.out.println("Initial Better solution to get the once occured number:");
       System.out.println("better solution 1 output :" + BetterSolution1.getSingleElement(arr1));
        System.out.println();
       System.out.println("Initial Optimal solution to get the once occured number:");
       System.out.println("optimal output :"+ OptimalSolution.getSingleElement(arr1));
   }
    
}
