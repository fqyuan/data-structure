package com.fqyuan.linkedlist;

import java.util.Random;

public class TestLinkList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int val = random.nextInt(100);
			System.out.print(val + " ");
			list.insertAtStart(val);
		}
		System.out.println();
		list.printList();

		System.out.println("Delete at position 1: ");
		list.deleteItem(1);
		list.printList();

		System.out.println("Insert at start with value 1: ");
		list.insertAtStart(1);
		list.printList();

		System.out.println("Delete at position 3: ");
		list.deleteItem(3);
		list.printList();

		System.out.println("The size of the list is: " + list.size());

		System.out.println("Insert at positon 3 with value 33:");
		list.insertAtPos(3, 333);
		list.printList();

		System.out.println("Delete at positon: 1");
		list.deleteItem(1);
		list.printList();

		System.out.println("Delete at position size(): ");
		list.deleteItem(list.size());
		list.printList();

		System.out.println("Insertion at end: ");
		list.insertAtEnd(100);
		list.printList();

		System.out.println("Sort the array: ");
		list.bubbleSort();
		// list.selectSort();
		list.printList();
	}
}
