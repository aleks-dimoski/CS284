//package sort;

public class Bubble {
	static int iters = 0;
	public static void sort(Comparable[] a) {
		for(int i = 0; i < a.length-1; i++) {
			for(int j = 0; j < a.length-i-1; j++) {
				if(a[j].compareTo(a[j+1]) < 0) {
					Comparable hold = a[j];
					a[j] = a[j+1];
					a[j+1] = hold;
					iters++;
				}
			}
		}
	}
}
