package com.fqyuan.doublelinklist;

public class DoubleList<T> {
	private Node head;
	private Node tail;
	private int num;

	public DoubleList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	public boolean isEmpty() {
		return num == 0;
	}

	public int getNum() {
		return num;
	}

	// Insert before the head node.
	public boolean insertAtStart(T item) {
		if (isEmpty()) {
			head.value = item;
			head.prev = null;
			head.next = tail;
			num++;
			return true;
		} else {
			Node newNode = new Node();
			newNode.value = item;
			newNode.prev = null;
			newNode.next = head;

			head.prev = newNode;
			head = newNode;
			num++;
			return true;
		}
	}

	// Insert after the end node.
	public boolean insertAtEnd(T item) {
		if (isEmpty()) {
			tail.value = item;
			num++;
			return true;
		} else {
			Node newNode = new Node();
			newNode.value = item;
			newNode.prev = tail.prev;
			newNode.next = tail;

			tail.prev.next = newNode;
			tail.prev = newNode;
			num++;
			return true;
		}
	}

	// Insert after a given position.
	public boolean insertAtPos(int pos, T item) {
		if (pos > num)
			return false;
		/*
		 * First find the position to insert. The position to insert will be 1
		 * to size.
		 */
		Node pNode = head;
		for (int i = 0; i < pos - 1; i++) {
			pNode = pNode.next;
		}

		Node qNode = pNode.next;

		Node newNode = new Node();
		newNode.value = item;
		newNode.next = qNode;
		newNode.prev = pNode;

		// Attention, link the original node to the new.
		pNode.next = newNode;
		qNode.prev = newNode;

		num++;
		return true;
	}

	// Delete an item at a given position
	public boolean deleteItem(int pos) {
		if (pos > num)
			return false;
		if (isEmpty())
			return false;
		// First find the position to delete
		if (pos == 1) {
			Node pNode = head.next;
			head.next = null;
			head = pNode;
			num--;
			return true;
		}
		if (pos == num) {
			Node tarNode = head;
			for (int i = 0; i < pos - 1; i++) {
				tarNode = tarNode.next;
			}
			tarNode.next = null;
			num--;
			return true;
		}

		Node tarNode = head;
		for (int i = 0; i < pos - 1; i++) {
			tarNode = tarNode.next;
		}
		Node preNode = tarNode.prev;
		Node nextNode = tarNode.next;
		preNode.next = nextNode;
		nextNode.prev = preNode;
		tarNode.next = null;
		tarNode.prev = null;

		return true;
	}

	// Select sort the list
	public void selectSort() {
		for (Node p = head; p.next != null; p = p.next) {
			for (Node q = p.next; q != null; q = q.next) {
				if ((int) p.value > (int) q.value) {
					T temp = p.value;
					p.value = q.value;
					q.value = temp;
				}
			}
		}
	}

	// Bubble sort the list
	public void bubbleSort() {
		for (Node p = head; p.next != null; p = p.next) {
			for (Node q = head; q.next != null; q = q.next) {
				if ((int) q.value > (int) q.next.value) {
					T temp = q.value;
					q.value = q.next.value;
					q.next.value = temp;
				}
			}
		}
	}

	public void printList() {
		Node n = head;
		while (n.next != null) {
			System.out.print(n.value + " ");
			n = n.next;
		}
		System.out.println();
	}

	public void printReverseList() {
		Node n = tail.prev;
		while (n != null) {
			System.out.print(n.value + " ");
			n = n.prev;
		}
		System.out.println();
	}

	class Node {
		private T value;
		private Node prev;
		private Node next;
	}
}