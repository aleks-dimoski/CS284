//package sort;

import java.util.Arrays;

public class Merge {
	static int iters = 0;
	
	public static void sort(Comparable[] a) {
		srt(a, 0, a.length-1);
	}
	
	public static void merge(Comparable[] a, int l, int m, int r) {
        int l1 = m - l + 1;
        int l2 = r - m;
        Comparable arrL[] = new Comparable[l1];
        Comparable arrR[] = new Comparable[l2];
        
        for (int i = 0; i < l1; ++i)
            arrL[i] = a[l + i];
        for (int j = 0; j < l2; ++j)
            arrR[j] = a[m + 1 + j];
        
        int i = 0, j = 0;
        
        int k = l;
        while (i < l1 && j < l2) {
            if (arrL[i].compareTo(arrR[j]) >= 0) {
                a[k] = arrL[i];
                i++;
            }
            else {
                a[k] = arrR[j];
                j++;
            }
            iters++;
            k++;
        }
        
        while (i < l1) {
            a[k] = arrL[i];
            i++;
            k++;
        }
        
        while (j < l2) {
            a[k] = arrR[j];
            j++;
            k++;
        }
    }
	
    public static void srt(Comparable[] arr, int b, int e) {
        if (b < e) {
            int m = b + (e-b)/2;
            
            srt(arr, b, m);
            srt(arr, m + 1, e);
            
            merge(arr, b, m, e);
        }
    }
}
