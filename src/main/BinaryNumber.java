package main;

/*
 *  Aleksandar Dimoski - CS284 Section D
 *  
*/


public class BinaryNumber {
	private int data[];   // Bits as 1 or 0 in an array
	private int length;   // Length of the array
	
	public BinaryNumber(int length) {
		//Constructor
		this.length = length;
		data = new int[length];
	}
	public BinaryNumber(String str) {
		//Constructor; prints error and sets data = {0} if there is a char in the string not equal to 0 or 1
		length = str.length();
		data = new int[length];
		
		
		for(int i = 0; i < length; i++) {
			if(!(str.charAt(i)=='0' || str.charAt(i)=='1')) {
				System.out.println(data[i]);
				System.out.println("Error: String input contains a char besides 0 or 1. Exiting.");
				data = new int[] {0};
				break;
			}
			data[i] = Character.getNumericValue(str.charAt(i));
		}
	}
	public int getLength() {
		// Returns the length
		length = data.length;
		return length;
	}
	public int getDigit(int index) {
		// Returns digit at index
		if(index<data.length)
			return data[index];
		System.out.println("Error: OutOfBounds Exception. Last (rightmost) value in array returned instead.");
		return data[data.length];
	}
	public int[] getInnerArray() {
		// Returns the array
		return data;
	}
	public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		// Takes the bitwise or of two binary numbers
		
		// Resizes both arrays to be the same size(length) using helper functions
		int[][] bothData = arrayResizer(bn1.data,bn2.data);
		// Create a new array to store the result
		int[] bworArr = new int[bothData[0].length];
		
		for(int i = 0; i < bothData[0].length; i++) {
			if(bothData[0][i]==1 || bothData[1][i]==1)
				bworArr[i] = 1;
		}
		return bworArr;
	}
	public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		// Takes the bitwise and of two binary numbers
		
		// Resizes both arrays to be the same size(length) using helper functions
		int[][] bothData = arrayResizer(bn1.data,bn2.data);
		// New array for result
		int[] bwandArr = new int[bothData[0].length];
		
		for(int i = 0; i < bothData[0].length; i++) {
			if(bothData[0][i]==1 && bothData[1][i]==1)
				bwandArr[i] = 1;
		}
		return bwandArr;
	}
	public void bitShift(int direction, int amount) {
		// Shifts a binary number over by a certain amount
		int[] newArr;
		// Check if input is valid, and perform operation by copying appropriate data into a certain location in a new array
		if(direction == 1 && amount > data.length) {
			System.out.println("Error: Shift unsuccessful. BitShift amount is too high. Enter at most the number of digits in the BinaryNumber.");
			data = new int[] {0};
		} else if(direction == -1) {
			data = append(data, amount);
		} else if(direction == 1) {
			newArr = new int[data.length-amount];
			System.arraycopy(data, 0, newArr, 0, data.length-amount);
			data = newArr;
		} else {
			System.out.println("Error: Shift unsuccessful. Direction invalid. Enter either -1 or 1.");
		}
		// Update length
		length = data.length;
	}
	public void add(BinaryNumber aBinaryNumber) {
		// Adds two binary numbers by first converting to decimal, adding, then converting to binary
		int sum = aBinaryNumber.toDecimal() + this.toDecimal();
		data = decimalToBinary(sum);
		length = data.length;
	}
	public String toString() {
		// For each loop to add each element to a string
		String hold = "";
		for(int i : data)
			hold += i;
		return hold;
	}
	public int toDecimal() {
		// Converts data array to decimal
		int decimal = 0;
		for(int i = 0; i < data.length; i++) {
			decimal += (int) (Math.pow(2, data.length-1-i)*data[i]);
		}
		return decimal;
	}
	
	private int[] decimalToBinary(int input) {
		// Converts decimal value to int[] and returns it
		String hold = "";
		int iter = 0;
		
		while(input > 0) {
			hold = input % 2 + hold;
			input /= 2;
		}
		
		int[] bin = new int[hold.length()];
		for(int i = 0; i < hold.length(); i++) {
			bin[i] = Character.getNumericValue(hold.charAt(i));
		}
		
		return bin;
	}
	private static int[][] arrayResizer(int[] bn1, int[] bn2) {
		// Takes two int[] as input and returns int[][] with both arrays of the same length, with 0's prepended where needed
		// Find out which array is larger and prepend to that array
		if(bn1.length == bn2.length) {
			return new int[][] {bn1, bn2};
		} else if (bn1.length > bn2.length) {
			return new int[][] {bn1, prepend(bn2, bn1.length-bn2.length)};
		} else {
			return new int[][] {prepend(bn1, bn2.length-bn1.length), bn2};
		}
	}
	private static int[] prepend(int[] arr, int amount) {
		// Prepend zeroes to array
		int[] newArr = new int[arr.length+amount];
		System.arraycopy(arr, 0, newArr, amount, arr.length);
		return newArr;
	}
	private static int[] append(int[] arr, int amount) {
		// Append zeroes to end of array
		int[] newArr = new int[arr.length+amount];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		return newArr;
	}
}
