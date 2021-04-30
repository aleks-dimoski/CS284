//package sort;

public class Heap {
	static int iters = 0;
	public static void sort(Comparable[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--)
            heap(a, a.length, i);
        
        for (int i = a.length - 1; i > 0; i--) {
            Comparable temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            iters++;
            
            heap(a, i, 0);
        }
	}
	
	static void heap(Comparable arr[], int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        
        if (l < n && arr[l].compareTo(arr[largest]) < 0)
            largest = l;
        
        if (r < n && arr[r].compareTo(arr[largest]) < 0)
            largest = r;
        
        if (largest != i) {
            Comparable swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            iters++;
            
            heap(arr, n, largest);
        }
    }
}
