package main;

public class ArithSolver {
	static MyStackList<Double> vStack;
	static MyStackList<Character> oStack;
	
	public static double evaluate(String ex) {
		vStack = new MyStackList<Double>();
		oStack = new MyStackList<Character>();
		for(int i = 0; i < ex.length(); i++) {
			if(ex.charAt(i) >= 48 && ex.charAt(i) <= 58) {
				vStack.push((Double)(ex.charAt(i)-48.0));
			} else if(ex.charAt(i)=='+'||ex.charAt(i)=='-'||ex.charAt(i)=='*'||ex.charAt(i)=='/') {
				oStack.push(ex.charAt(i));
			} else if(ex.charAt(i)==')') {
				vStack.push(operation(vStack.pop(),vStack.pop(),oStack.pop()));
			}
		}
		
		return vStack.pop();
	}
	private static Double operation(Double a, Double b, Character o) {
		if(o == '+')
			return a+b;
		else if(o == '-')
			return a-b;
		else if(o == '*')
			return a*b;
		else if(o == '/')
			return a/b;
		return Double.valueOf(0);
	}
}
