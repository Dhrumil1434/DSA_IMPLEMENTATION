package STEP_3_ARRAY.EASY;


public class p3 {
    
    /*
     * now we are going to implement the brute force solution for the checking if the array is sorted or not 
     * we can think like first we can take the pointer which will be start from the first element of the array till 
     * last element and will stop or return when the elemennt would be not less than the next element
     * now lets work with the optimal solution for the checking if the array is sorted or not 
     * we can think like first we can take the pointer which will be start from the first element of the array till 
     * last element and will stop or return when the elemennt would be not less than the next element
     */
    public static boolean isSortedDoubleLoop(int arr[])
    {
        boolean isSorted = true;
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array is not containing enough elements !!");
        }
        for(int i=0;i<arr.length-1;i++)
        {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    isSorted = false;
                    break;
                }
            }
        }
        return isSorted;
    }
    /*
     * now we are going to implement the optimal solution for the checking if the array is sorted or not 
     * we can think like first we can take the pointer which will be start from the first element of the array till 
     * last element and will stop or return when the elemennt would be not less than the next element
     * now lets work with the optimal solution for the checking if the array is sorted or not 
     * we can think like first we can take the pointer which will be start from the first element of the array till 
     * last element and will stop or return when the elemennt would be not less than the next element
     */
    public static boolean isSorted(int arr[])
    {
        if(arr.length<2)
        {
            throw new IllegalArgumentException("Array is not containing enough elements !!");
        }
        boolean flag = true;
        for (int i = 0; i < arr.length-1; i++) {
            if (!(arr[i] < arr[i + 1])) {
                flag = false;
            }

        }
        return flag;
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,25 };
        System.out.println(isSorted(arr));
        System.out.println(isSortedDoubleLoop(arr));
    }
}
