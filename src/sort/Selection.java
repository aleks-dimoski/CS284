//package sort;

public class Selection {
	static int iters = 0;
	
	public static void sort(Comparable[] a) {
		for(int i = 0; i < a.length-1; i++) {
			int min = i;
			for(int j = i; j < a.length; j++) {
				if(a[min].compareTo(a[j]) < 0) {
					min = j;
				}
				iters++;
			}
			Comparable hold = a[i];
			a[i] = a[min];
			a[min] = hold;
		}
	}
}
