package main;

import java.util.ArrayList;

public class IDLList<E> {
	private class Node<E> {
		E data;
		Node<E> prev;
		Node<E> next;
		
		public Node(E elem) {
			data = elem;
		}
		public Node(E elem, Node<E> prev, Node<E> next) {
			data = elem;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;
	
	public IDLList() {
		size = 0;
		indices = new ArrayList<Node<E>>();
	}
	public boolean add(int index, E elem) {
		if(index > size) {
			System.out.println("Error: index out of bounds");
			return true;
		}
		
		if(index == size) {
			return append(elem);
		}
		if(index == 0) {
			return add(elem);
		}
		
		Node<E> node = new Node(elem, indices.get(index-1), indices.get(index));
		indices.get(index-1).next = node;
		indices.get(index).prev = node;
		indices.add(index, node);
		
		updateSize();
		return true;
	}
	public boolean add(E elem) {
		Node<E> node;
		if(size >= 1) {
			node = new Node(elem, null, indices.get(0));
			indices.get(0).prev = node;
		} else {
			node = new Node(elem, null, null);
		}
		
		indices.add(0, node);
		updateSize();
		return true;
	}
	public boolean append(E elem) {
		Node<E> node;
		if(size == 0) {
			return add(elem);
		} else {
			node = new Node(elem, indices.get(size-1), null);
			indices.get(size-1).next = node;
		}
		
		indices.add(size, node);
		updateSize();
		return true;
	}
	public E get(int index) {
		return indices.get(index).data;
	}
	public E getHead() {
		return head.data;
	}
	public E getLast() {
		return tail.data;
	}
	public E remove() {
		E el;
		if(size == 0) {
			throw new IllegalStateException("Error: There are no elements to be removed from the list");
		}
		if(size > 1) {
			indices.get(1).prev = null;
		}
		el = indices.get(0).data;
		indices.remove(0);
		updateSize();
		return el;
	}
	public E removeLast() {
		E el;
		if(size == 0) {
			throw new IllegalStateException("Error: There are no elements to be removed from the list");
		}
		if(size > 1) {
			indices.get(size-2).next = null;
		}
		el = indices.get(size-1).data;
		indices.remove(size-1);
		updateSize();
		return el;
	}
	public E removeAt(int index) {
		E el;
		if(index > size) {
			throw new IllegalStateException("Error: index out of bounds");
		}
		if(index == size) {
			return removeLast();
		}
		if(index == 0) {
			return remove();
		}
		el = indices.get(index).data;
		indices.remove(index);
		indices.get(index-1).next = indices.get(index);
		indices.get(index).prev = indices.get(index-1);
		
		updateSize();
		return el;
	}
	public boolean remove(E elem) {
		for(int i = 0; i < size; i++) {
			if(indices.get(i).data.equals(elem)) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}
	public String toString() {
		String hold = "";
		for(int i = 0; i < size; i++) {
			hold += indices.get(i).data.toString() + " ";
		}
		return hold;
	}
	public int size() {
		return size;
	}
	private void updateSize() {
		size = indices.size();
	}
}
