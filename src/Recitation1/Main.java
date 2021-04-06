package Recitation1;

import java.util.Arrays;

import main.ArithSolver;
import main.IDLList;
import main.MyStackArray;
import main.MyStackList;

public class Main {

	public static void main(String[] args) {
		MyStackList<Integer> sArr = new MyStackList<Integer>();
		for(int i = 0; i < 9; i++) {
			sArr.push((Integer)i);
			System.out.println(sArr.toString());
		}
		System.out.println(sArr.toString());
		for(int i = 0; i < 4; i++) {
			System.out.println(sArr.pop());
		}
		System.out.println(sArr.toString());
		System.out.println(ArithSolver.evaluate("(1+((2+3)*(4*5)))"));
	}
}
