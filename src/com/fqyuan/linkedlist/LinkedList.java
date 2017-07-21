package com.fqyuan.linkedlist;

/*
 * Version with dummy node or not.
 * This is one without a dummy node.
 */
public class LinkedList<T> {
	private Node head;

	public LinkedList() {
		head = new Node();
		head.value = null;
		head.link = null;
	}

	public boolean isEmpty() {
		return head.value == null;
	}

	// Insert before the head node.
	public boolean insertAtStart(T item) {
		if (!isEmpty()) {
			Node node = new Node();
			node.value = item;
			node.link = head;
			head = node;
			return true;
		} else {
			head.value = item;
			head.link = null;
			return true;
		}
	}

	// Insert after the end node.
	public boolean insertAtEnd(T item) {
		// First find the position to insert after
		if (!isEmpty()) {
			Node node = head;
			while (node.link != null)
				node = node.link;
			// Then 'node' is the last element of the list
			Node newNode = new Node();
			newNode.value = item;
			newNode.link = null;

			node.link = newNode;

			return true;
		} else {
			head.value = item;
			head.link = null;
			return true;
		}
	}

	// Insert after a given position.
	public boolean insertAtPos(int pos, T item) {
		if (pos > size())
			return false;
		/*
		 * First find the position to insert. The position to insert will be 1
		 * to size.
		 */
		Node pNode = head;
		for (int i = 0; i < pos - 1; i++) {
			pNode = pNode.link;
		}
		Node qNode = pNode.link;

		Node newNode = new Node();
		newNode.value = item;
		newNode.link = qNode;

		pNode.link = newNode;
		return true;
	}

	// Delete an item at a given position
	public boolean deleteItem(int pos) {
		if (pos > size())
			return false;
		if (isEmpty())
			return false;
		// First find the position to delete
		if (pos == 1) {
			Node pNode = head.link;
			head.link = null;
			head = pNode;
			return true;
		}
		if (pos == size()) {
			Node preNode = head;
			for (int i = 0; i < pos - 2; i++) {
				preNode = preNode.link;
			}
			preNode.link = null;
			return true;
		}

		Node preNode = head;
		for (int i = 0; i < pos - 2; i++) {
			preNode = preNode.link;
		}
		Node node = preNode.link;
		Node nextNode = node.link;
		preNode.link = nextNode;
		node.link = null;

		return true;
	}

	// Select sort the list
	public void selectSort() {
		for (Node p = head; p.link != null; p = p.link) {
			for (Node q = p.link; q != null; q = q.link) {
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
		for (Node p = head; p.link != null; p = p.link) {
			for (Node q = head; q.link != null; q = q.link) {
				if ((int) q.value > (int) q.link.value) {
					T temp = q.value;
					q.value = q.link.value;
					q.link.value = temp;
				}
			}
		}
	}

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.value + " ");
			n = n.link;
		}
		System.out.println();
	}

	public int size() {
		if (isEmpty())
			return 0;
		int sz = 0;
		Node node = head;
		while (node != null) {
			node = node.link;
			sz++;
		}
		return sz;
	}

	class Node {
		private T value;
		private Node link;
	}
}
