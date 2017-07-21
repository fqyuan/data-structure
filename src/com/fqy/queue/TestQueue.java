package com.fqy.queue;

import java.util.Random;

public class TestQueue {

	public static void main(String[] args) {
		// The actual elements a queue can hold is 10-1;
		Queue<Integer> queue = new Queue<>(Integer[].class, 11);
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int val = random.nextInt(100);
			System.out.print(val + " ");
			queue.enqueue(val);
		}
		System.out.println();
		queue.traverseQueue();
		System.out.println("\n" + queue.getTotal());
		while (!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}
	}

}
