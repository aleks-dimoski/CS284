//package sort;

public class Insertion {
	static int iters = 0;
	
	public static void sort(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			int j = i-1;
			Comparable swap = a[i];
			while(j >= 0 && a[j].compareTo(swap) < 0) {
				a[j+1] = a[j];
				j--;
				iters++;
			}
			a[j+1] = swap;
		}
	}
}
