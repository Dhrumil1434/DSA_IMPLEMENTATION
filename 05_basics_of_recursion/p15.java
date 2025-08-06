public class p15 {
    
  public static int partition(int arr[], int low, int high) {
    int pivot = arr[low];
    int i = low;
    int j = high;

    while (i < j) {
        while (i <= high && arr[i] <= pivot) {
            i++;
        }
        while (j >= low && arr[j] > pivot) {
            j--;
        }
        if (i < j) {
            ArrayUtils.swap(arr, i, j);
        }
    }
    ArrayUtils.swap(arr, low, j);
    return j;
}

   public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pindex = partition(arr, low, high);
            quickSort(arr, low, pindex - 1);
            quickSort(arr, pindex + 1, high);
        }
    }
    public static void main(String[] args) {
        int a[] = { 6, 5, 4, 3, 2, 1, 0 };
        quickSort(a, 0, a.length - 1);
        for(int x: a)
        {
             System.out.println(x);
        }
    }
}
