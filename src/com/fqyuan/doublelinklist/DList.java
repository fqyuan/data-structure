package com.fqyuan.doublelinklist;

import java.util.Random;

public class DList {

	public static void main(String[] args) {
		DoubleList<Integer> doubleList = new DoubleList<>();
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int val = random.nextInt(100);
			doubleList.insertAtStart(val);
			System.out.print(val + " ");
		}
		System.out.println();

		System.out.println("The original oder is:");
		doubleList.printList();
		System.out.println("The reverse iteration is:");
		doubleList.printReverseList();

		System.out.println("Insert at start:");
		doubleList.insertAtStart(111);
		doubleList.printList();

		System.out.println("Insert at end:");
		doubleList.insertAtEnd(999);
		doubleList.printList();

		System.out.println("Insert at a given position: ");
		doubleList.insertAtPos(5, 555);
		doubleList.printList();

		System.out.println("Delete a item at giben position: ");
		doubleList.deleteItem(doubleList.getNum());
		doubleList.printList();

		// System.out.println("Bubble Sort the Double list:");
		// doubleList.bubbleSort();
		// doubleList.printList();

		System.out.println("Select sort the Double list");
		doubleList.selectSort();
		doubleList.printList();

	}

}
