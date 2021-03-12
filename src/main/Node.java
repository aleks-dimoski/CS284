package main;

public class Node {
	//  Instance  variables:
	private int element;
	private Node next;
	//  Simple  constructors:
	public  Node() {
		this(0, null);
	}
	public  Node(int e, Node n) {
		element = e; 
		next = n;
	}
	//  Accessor  methods:
	int getElement () {
		return  element;
	}
	Node getNext () {
		return  next;
	}
	//  Modifier  methods:
	void setElement(int newElem) {
		element = newElem;
	}
	void setNext(Node newNext) {
		next = newNext;
	}
	public Node reverse(Node P) {
		Node p = new Node(0, P.getNext());
		Node n = new Node(P.getElement(), null);
		
		while(p.getNext() != null) {
			p = p.getNext();
			n = new Node(p.getElement(), n);
		}
		return n;
	}
	public Node test() {
		Node n = new Node(1, this);
		for(int i = 2; i < 10; i++) {
			n = new Node(i, n);
		}
		return n;
	}
	public String toString() {
		String a = ""+element+" ";
		if(getNext() != null) {
			a += getNext().toString();
		}
		return a;
	}
}