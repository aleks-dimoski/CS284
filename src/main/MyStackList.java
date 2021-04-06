package main;

public class MyStackList<Item> {
	private Node first = null;
	
	private class Node
	{
		Item item;
		Node next;
	}
	public void push(Item item) {
		Node add = new Node();
		add.item = item;
		add.next = first;
		first = add;
	}
	public Item pop() {
		Item hold = null;
		if(!isEmpty()) {
			hold = first.item;
			if(!(first.next == null)) {
				first = first.next;
			}
		}
		return hold;
	}
	public boolean isEmpty() {
		return (first.item == null && first.next == null) || first == null;
	}
	public String toString() {
		String hold = "";
		Node next = first;
		while(!(next == null)) {
			hold += next.item+ " ";
			next = next.next;
		}
		return hold;
	}
}
