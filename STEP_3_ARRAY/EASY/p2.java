package STEP_3_ARRAY.EASY;

import java.util.Arrays;

/*
 * find second largest and second smallest element from an array
 * first let's think about to find the second largest element from an array 
 * we can think like first we can do the sorting and just returning the Arr[N-2]th element 
 * but suppose if we have the following scenario like arr = [1,2,3,4,4] 
 * now in this case ans would be 4 which is not second largest for sure now what we can do 
 * we have to take the pointer which will be start from the second last element of the sorted array till 
 * first element and will stop or return when the elemennt would be not equal to the largest
 
 * now lets work with the finding second smallest element from an array
 * we can think like first we can do the sorting and just returning the Arr[1]th element 
 * but suppose if we have the following scenario like arr = [2,2,2,2,3]
 * now in this case ans would be 2 which is not second smallest for sure now what we can do 
 * we have to take the pointer which will be start from the second element of the sorted array till 
 * last element and will stop or return when the elemennt would be not equal to the smallest
*/
public class p2 {
    /*
     * now lets work with the finding second largest in the brute force manner
    */
    public static int secondLargestElement(int arr[])
    {
        if (arr.length < 2) {
            return -1;
        }
        Arrays.sort(arr);
        int secondLargest = -1;
        int largest = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                secondLargest = arr[i];
                break;
            }
        }
        return secondLargest;
    }

    public static int secondSmallestElement(int arr[])
    {
         if(arr.length < 2 )
         {
             return -1;
         }
         Arrays.sort(arr);
         int smallest = arr[0];
         int secondSmallest = -1;

         for (int i = 1; i < arr.length;i++)
         {
             if (arr[i] != smallest) {
                 secondSmallest = arr[i];
                 break;
             }
         }
         return secondSmallest;
    }
    public static void main(String[] args) {
        int arr[] = { 2,2,2,9};
        System.out.println("Second Largest :" + secondLargestElement(arr));
        System.out.println("Second Smallest :" + secondSmallestElement(arr));
        int ans[] = BetterSolution.secondLargestAndSmallestElement(arr);
        for(int x: ans)
        {
            System.out.println(x);
        }
        System.out.println("Optimal Second Largest :" + OptimalSolution.secondLargest(arr));
         System.out.println("Optimal Second Smallest :"+ OptimalSolution.secondSmallest(arr));
    }
    
}
/*
time complexity for the second largest element is O(nlogn) because we are using the sort function which takes O(nlogn) time complexity and 
space complexity for the second largest element is O(1) because we are not using any extra space

time complexity for the second smallest element is O(nlogn) because we are using the sort function which takes O(nlogn) time complexity and 
space complexity for the second smallest element is O(1) because we are not using any extra space
*/


/*Solution 2(Better Solution)
Intuition:
Even though we want to have just the second smallest and largest elements, we are still sorting the entire array for that and thus increasing the time complexity. Can we somehow try to not sort the array and still get our answer?

Approach:
Find the smallest and largest element in the array in a single traversal
After this, we once again traverse the array and find an element that is just greater than the smallest element we just found.
Similarly, we would find the largest element which is just smaller than the largest element we just found
Indeed, this is our second smallest and second largest element.
*/

class BetterSolution {
    public static int[] secondLargestAndSmallestElement(int arr[]) {
        int ans[] = { -1, -1 };
        if (arr.length < 2) {
            return ans;
        }
        int large = arr[0];
        int small = arr[0];
        int n = arr.length - 1;
        for (int i = 0; i <= n; i++) {
            large = Math.max(large, arr[i]);
            small = Math.min(small, arr[i]);
        }
        int secondLarge = Integer.MIN_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if (arr[i] > secondLarge && arr[i] != large) {
                secondLarge = arr[i];
            }
            if (arr[i] < secondSmall && arr[i] != small) {
                secondSmall = arr[i];
            }
        }
        ans[0] = secondLarge;
        ans[1] = secondSmall;
        return ans;
    }
}

/*
 * Now we are going to implement the optimal solution for the second largest and smallest 
 * by removing the second pass as done in the previous implementation 
*/

class OptimalSolution {
    public static int secondLargest(int arr[])
    {
        if(arr.length < 2)
        {
            return -1;
        }
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            } else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        return second_large;
    }

    public static int secondSmallest(int arr[])
    {
         if(arr.length < 2 )
         {
             return -1;
         }
         int small = Integer.MAX_VALUE;
         int second_smallest = Integer.MAX_VALUE;

         for(int i=0;i<arr.length;i++)
         {
             if (arr[i] < small) {
                 second_smallest = small;
                 small = arr[i];
             } else if (arr[i] < second_smallest && arr[i] != small) {
                 second_smallest = arr[i];
             }
         }
         return second_smallest;
    }
}
/*
 * time complexity for the second largest element is O(n) because we are using the single pass to find the second largest element
 * space complexity for the second largest element is O(1) because we are not using any extra space
 * 
 * time complexity for the second smallest element is O(n) because we are using the single pass to find the second smallest element
 * space complexity for the second smallest element is O(1) because we are not using any extra space
*/