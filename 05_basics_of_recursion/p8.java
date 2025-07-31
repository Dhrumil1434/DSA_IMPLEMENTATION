/*
Now lets optimize the space complexity by using 1 pointer
*/
class p8 
{
    public static int[] reverse(int arr[],int i)
    {
        if (i >= arr.length / 2) {
            return arr;
        }
        ArrayUtils.swap(arr, i, arr.length - 1 - i);
        return reverse(arr, i + 1);
    }
    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        int ans[] = reverse(arr, 0);
        for(int x: ans)
        {
            System.out.println(x);
        }
    }
}
/*walkthrough
how the recursion works:
1. we are passing the array and the index
2. we are swapping the elements at the index and the last index
3. we are incrementing the index
4. we are calling the function recursively until the index is greater than the length of the array divided by 2
5. we are returning the array
*/
/*time complexity:
O(n): because we are iterating through the array once
space complexity:
O(n): because we are using a recursive stack
*/