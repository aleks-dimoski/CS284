package main;

interface Parallelizable {
	static void log ( String s) {
		System.out.println(s);
	}
	default void processInParallel () {
		log (" Parallelizable parallel ");
	}
}
public class Task implements Parallelizable {
	public static void main (String args []) {
		Task t = new Task ();
		t. processInParallel ();
		// t. log (" The end "); Doesn’t compile
		// Task . log (" The end "); Doesn’t compile either
		Parallelizable.log(" The end "); // Compiles !
	}
}