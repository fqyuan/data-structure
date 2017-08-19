package com.fqyuan.heap;

public class Heap {
	private static final int CAPACITY = 2;
	private int size; // Number of elements in heap.
	private int[] heap; // The heap array.

	private void doubleSize() {
		int[] old = heap;
		heap = new int[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}

	public static void main(String[] args) {
		String str = "1|2|3|4|";
		String[] strings = str.split("\\|");
		for (int i = 0; i < strings.length; i++)
			System.out.println(strings[i]);
	}
}
