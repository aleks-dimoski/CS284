//package sort;

public class Quick {
	static int iters = 0;
	
	public static void sort(Comparable[] a) {
		quickSort(a, 0, a.length-1);
	}
	
	static int partition(Comparable[] arr, int low, int high)
	{
	    Comparable pivot = arr[high];
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	        if (arr[j].compareTo(pivot) > 0) {
	            i++;
	            Comparable temp = arr[j];
	            arr[j] = arr[i];
	            arr[i] = temp;
	            iters++;
	        }
	    }
	    Comparable temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;
        iters++;
	    return (i + 1);
	}
	
	static void quickSort(Comparable[] arr, int l, int h)
	{
	    if (l < h) {
	        int i = partition(arr, l, h);
	        quickSort(arr, l, i - 1);
	        quickSort(arr, i + 1, h);
	    }
	}
}
