/*
Reverse an array using recursion

Input: arr[] = {1, 2, 3, 4, 5}
Output: arr[] = {5, 4, 3, 2, 1}

Input: arr[] = {1, 2, 3, 4, 5, 6}
Output: arr[] = {6, 5, 4, 3, 2, 1}

*/
public class p7
{
    static void swap(int arr[],int i,int j)
    {
        int temp=arr[i];
         arr[i]=arr[j];
         arr[j] = temp;
    }
    public static int[] reverse(int arr[],int i,int j)
    {
         if(j>=i)
         {
             return arr;
         }
         swap(arr, i, j);
         reverse(arr,i+1,j-1);
         return arr;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int i=0;
        int j=arr.length-1;
        int ans[] = reverse(arr,i,j);
        for(int k=0;k<ans.length;k++)
        {
            System.out.println(ans[k]);
        }
    }
}
/*walkthrough
how the recursion works:
1. we are passing the array, the starting index and the ending index
2. we are swapping the elements at the starting and ending index
3. we are incrementing the starting index and decrementing the ending index
4. we are calling the function recursively until the starting index is greater than the ending index
5. we are returning the array
*/
/*time complexity:
O(n): because we are iterating through the array once
space complexity:
O(n): because we are using a recursive stack
*/