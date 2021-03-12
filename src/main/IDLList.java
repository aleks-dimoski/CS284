package main;

import java.util.ArrayList;

public class IDLList<E> {
	private class Node<E> {
		// Node class for data storage for DLL
		E data;
		Node<E> prev;
		Node<E> next;
		
		public Node(E elem) {
			// Assign data
			data = elem;
		}
		public Node(E elem, Node<E> prev, Node<E> next) {
			// Assign data and set references to neighboring nodes
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
		// Instantiate values
		size = 0;
		indices = new ArrayList<Node<E>>();
	}
	
	public boolean add(int index, E elem) {
		// Check for out-of-bounds
		if(index > size) {
			System.out.println("Error: index out of bounds");
			return true;
		}
		
		// Test cases where element would be added to beginning or end of list
		if(index == size) {
			return append(elem);
		}
		if(index == 0) {
			return add(elem);
		}
		
		// Insert node into middle of list and arrange surrounding nodes with references
		Node<E> node = new Node(elem, indices.get(index-1), indices.get(index));
		indices.get(index-1).next = node;
		indices.get(index).prev = node;
		indices.add(index, node);
		
		updateSize();
		return true;
	}
	
	public boolean add(E elem) {
		// Adds node to beginning of list
		Node<E> node;
		
		// Checks for surrounding nodes that need to be changed
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
		// Adds node to end of list
		Node<E> node;
		
		// Checks for surrounding nodes
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
		// Return data at index
		return indices.get(index).data;
	}
	
	public E getHead() {
		// Return data at head
		return head.data;
	}
	
	public E getLast() {
		// Return data at tail
		return tail.data;
	}
	
	public E remove() {
		// Removes the first element and returns data that was there
		E el;
		
		// Check for surrounding nodes to update them
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
		// Removes last element and returns data that was there
		E el;
		
		//Check for surrounding nodes to update them
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
		// Removes element at specified index and returns data that was there
		E el;
		
		// Checks for surrounding nodes to update them, and for out-of-bounds error
		if(index > size) {
			throw new IllegalStateException("Error: index out of bounds");
		}
		if(index == size) {
			return removeLast();
		}
		if(index == 0) {
			return remove();
		}
		
		// Hold data to return it and update node connections
		el = indices.get(index).data;
		indices.remove(index);
		indices.get(index-1).next = indices.get(index);
		indices.get(index).prev = indices.get(index-1);
		
		updateSize();
		return el;
	}
	
	public boolean remove(E elem) {
		// Removes first instance of 'elem' if found in list & return true; return false if not found
		for(int i = 0; i < size; i++) {
			if(indices.get(i).data.equals(elem)) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		// Returns list as string, space delimited
		String hold = "";
		for(int i = 0; i < size; i++) {
			hold += indices.get(i).data.toString() + " ";
		}
		return hold;
	}
	
	public int size() {
		// Returns size of list
		return size;
	}
	
	private void updateSize() {
		// Updates the size
		size = indices.size();
		head = indices.get(0);
		tail = indices.get(size-1);
	}
}
