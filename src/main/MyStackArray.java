package main;

import java.lang.reflect.Array;

public class MyStackArray<Item> {
	public Item[] s;
	public int N=0;
	public MyStackArray() {
		s = (Item[]) new Object[2];
	}
	public boolean isEmpty() {
		return N==0;
	}
	public void push(Item item) {
		Item[] hold;
		if(N >= s.length) {
			hold = (Item[]) new Object[N*2];
		} else {
			hold = (Item[]) new Object[s.length];
		}
		
		for(int i = 0; i < N; i++) {
			hold[i+1] = s[i];
		}
		s = hold;
		s[0] = item;
		N++;
	}
	public Item pop() {
		Item[] holdA;
		N--;
		if(N == 0)
			return null;
		if(N <= s.length/4) {
			holdA = (Item[]) new Object[s.length/2];
		} else {
			holdA = (Item[]) new Object[s.length];
		}
		for(int i = 0; i < N; i++) {
			holdA[i] = s[i+1];
		}
		Item hold = s[0];
		s = holdA;
		return hold;
	}
	public String toString() {
		String hold = "";
		for(Item i : s) {
			hold += i+" ";
		}
		return hold;
	}
}
