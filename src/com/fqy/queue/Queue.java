package com.fqy.queue;

import java.lang.reflect.Array;

public class Queue<T> {
	private int size;
	private int total;
	private int front;
	private int rear;
	private T[] queue;

	@SuppressWarnings("unchecked")
	public Queue(int size) {
		this.size = size;
		total = 0;
		front = 0;
		rear = 0;
		total = 0;
		queue = (T[]) new Object[this.size];
	}

	// Why code like this? To produce 'generic' array
	public Queue(Class<T[]> cl, int size) {
		this.size = size;
		total = 0;
		front = 0;
		rear = 0;
		total = 0;
		queue = cl.cast(Array.newInstance(cl.getComponentType(), this.size));
	}

	public boolean enqueue(T item) {
		if (!isFull()) {
			queue[rear] = item;
			// Special case
			rear = (rear + 1) % size;
			total++;
			return true;
		} else {
			return false;
		}
	}

	public T dequeue() {
		if (!isEmpty()) {
			T item = queue[front];
			queue[front] = null;
			front = (front + 1) % size;
			total--;

			return item;
		} else
			return null;
	}

	public void traverseQueue() {
		int index = front;
		for (int i = 0; i < total; i++) {
			System.out.print(queue[index] + " ");
			index = (index + 1) % size;
		}
	}

	/*
	 * 在循环队列结构下，当front==rear时为空队列，当front==(rear+1)%maxSize时为满队列。
	 * 注意，满队列时，仍有一个元素空间未被使用。若不留该空间，则队尾指针rear指向该空间导致了， 满队列和空队列判定条件相同。
	 */
	public boolean isFull() {
		// return total == size;
		return (rear + 1) % size == front;
	}

	public boolean isEmpty() {
		// return total == 0;
		return rear == front;
	}

	public int getTotal() {
		return total;
	}
}
