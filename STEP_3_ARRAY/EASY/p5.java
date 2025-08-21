package STEP_3_ARRAY.EASY;



/*
 * following is the brute force approach to rotate the array by one place
 intution steps are as follows:
 1. we will take the first element of the array and store it in a temporary variable
 2. we will then shift the rest of the array to the left by one place in temp array which take the O(n) space
 3. we will then put the temporary variable at the end of the temp array
 4. we will return the modified temp array
 
*/
class BruteForce {
    public static int[] rotateArrayLeftByOnePlace(int arr[]) {
        if (arr.length < 1) {
            return new int[0];
        }
        int temp[] = new int[arr.length];
        int first_element = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            temp[i-1] = arr[i];
        }
        temp[temp.length - 1] = first_element;
        return temp;
    }
}
/*
time complexity : O(n) because we are traversing the array once
space complexity : O(n) because we are  using  extra space of temp[n]
*/


/*
 * Now lets modify the bruteforce approach by optimize the space complexity 
 * we can do same shifting without implement extra array
 * store the first element in the temp variable
 * we can use the same array and in single pass do the shifting 
 * then just assign the temp to the last element , and return the array
*/

class OptimalSolution {

    public static int[] rotateArrayLeftByOnePlace(int arr[]) {
        if (arr.length < 1) {
            return new int[0];
        }
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
        return arr;
    }
}

/*
 * time complexity is O(n) as we have to parse the array once 
 * space complexity is O(1) as we are not using any extra space 
*/
public class p5 {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 5 };
        int ans[] = BruteForce.rotateArrayLeftByOnePlace(arr);
        System.out.println("Brute Force Output : ");
        for (int x : ans) {
            System.out.println(x);
        }
        System.out.println("Optimal Solution Output :");
        int oans[] = OptimalSolution.rotateArrayLeftByOnePlace(arr);
        for(int x: oans)
        {
             System.out.println(x);
        }

    }
}

