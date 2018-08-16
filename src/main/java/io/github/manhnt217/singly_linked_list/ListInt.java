package io.github.manhnt217.singly_linked_list;

/**
 * @author manhnt
 */
public class ListInt {

	private int size;
	private Node head;
	private Node last; //for faster appendation

	public ListInt() {
		this.size = 0;
		head = null;
		last = null;
	}

	public int get(int index) {
		if (index < 0 || index > this.size - 1) throw new ArrayIndexOutOfBoundsException(index);
		Node current = head;
		while (index > 0) {
			current = head.next;
			index--;
		}
		return current.value;
	}

	/**
	 * Append the new element to the end of the list
	 * @param element element to append
	 */
	public void append(int element) {
		if (last == null) { //for the first element
			last = new Node(element);
			head = last;
			size = 1;
		} else {
			Node newNode = new Node(element);
			last.next = newNode;
			last = last.next;
			size++;
		}
	}

	/**
	 * Remove the last element of the list
	 */
	public int removeTail() {
		if (size == 0) throw new IllegalStateException("Empty list");
		if (size == 1) {
			Node temp = last;
			head = null;
			last = null;
			size = 0;
			return temp.value;
		} else {
			Node current = head;
			while (current.next.next != null) current = current.next;
			Node temp = current.next;
			//update 'last' element
			last = current;
			last.next = null;
			size--;
			return temp.value;
		}
	}

	/**
	 * Remove all the elements greater than a threshold
	 * @param threshold
	 */
	public void removeGreaterThan(int threshold) {
		if (size == 0) return;
		if (size == 1 && head.value > threshold) { // remove the only element (empty the list)
			head = null;
			last = null;
			size = 0;
		}

		Node current = head;
		while (current.next != null) {
			if (current.next.value > threshold) {
				//remove next node;
				current.next = current.next.next;
				size--;
			} else {
				current = current.next;
			}
		}

		//update 'last' element
		last = current;
	}

	@Override
	public String toString() {
		if (this.size == 0) return "[]";
		StringBuilder sb = new StringBuilder("["); //open brace
		Node current = head;
		while (current != null) {
			sb.append(current.value).append(", ");
			current = current.next;
		}

		String s = sb.substring(0, sb.length() - ", ".length()); //remove redundant characters
		return s + "]"; //close brace
	}

	private class Node {

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public Node(int value) {
			this(value, null);
		}

		private int value;
		private Node next;
	}
}
