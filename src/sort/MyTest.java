//package sort;

public class MyTest {
	public static Dates[] generateDates() {
		Dates[] dates = new Dates[6];
		for(int i = 0; i < 6; i++) {
			dates[i] = new Dates(generateDate());
		}
		return dates;
	}
	public static int generateDate() {
		int year = (int)(Math.random()*20+2000)*10000;
		int month = (int)(Math.random()*11+1)*100;
		int day = (int)(Math.random()*28+1);
		return year+month+day;
	}
	public static Firstnames[] generateNames() {
		Firstnames[] names = new Firstnames[6];
		for(int j = 0; j < 6; j++) {
			int len = (int)(Math.random()*3)+3;
			String name = "";
			
			for(int i = 0; i < len; i++) {
				name += (char)(int)(Math.random()*26+'a');
			}
			names[j] = new Firstnames(name);
		}
		
		return names;
	}
	
	public static void printArr(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i].toString());
		}
	}
	
	public static void test() {
		Dates[] dates = generateDates();
		Firstnames[] names = generateNames();
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100; i++) {
			dates = generateDates();
			names = generateNames();
			Insertion.sort(dates);
			Insertion.sort(names);
		}
		System.out.println("Insertion "+String.valueOf(System.currentTimeMillis()-start)+" "+Insertion.iters);
		//printArr(dates);
		//printArr(names);
		start = System.currentTimeMillis();
		for(int i = 0; i < 100; i++) {
			dates = generateDates();
			names = generateNames();
			Selection.sort(dates);
			Selection.sort(names);
		}
		System.out.println("Selection "+String.valueOf(System.currentTimeMillis()-start)+" "+Selection.iters);
		//printArr(dates);
		//printArr(names);
		start = System.currentTimeMillis();
		for(int i = 0; i < 100; i++) {
			dates = generateDates();
			names = generateNames();
			Bubble.sort(dates);
			Bubble.sort(names);
		}
		System.out.println("Bubble "+String.valueOf(System.currentTimeMillis()-start)+" "+Bubble.iters);
		//printArr(dates);
		//printArr(names);
		start = System.currentTimeMillis();
		for(int i = 0; i < 100; i++) {
			dates = generateDates();
			names = generateNames();
			Merge.sort(dates);
			Merge.sort(names);
		}
		System.out.println("Merge "+String.valueOf(System.currentTimeMillis()-start)+" "+Merge.iters);
		//printArr(dates);
		//printArr(names);
		start = System.currentTimeMillis();
		for(int i = 0; i < 100; i++) {
			dates = generateDates();
			names = generateNames();
			Quick.sort(dates);
			Quick.sort(names);
		}
		System.out.println("Quick "+String.valueOf(System.currentTimeMillis()-start)+" "+Quick.iters);
		//printArr(dates);
		//printArr(names);
		start = System.currentTimeMillis();
		for(int i = 0; i < 100; i++) {
			dates = generateDates();
			names = generateNames();
			Heap.sort(dates);
			Heap.sort(names);
		}
		System.out.println("Heap "+String.valueOf(System.currentTimeMillis()-start)+" "+Heap.iters);
		//printArr(dates);
		//printArr(names);
	}
	public static void main(String[] args) {
		test();
	}
}
