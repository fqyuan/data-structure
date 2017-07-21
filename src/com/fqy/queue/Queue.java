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
	 * ��ѭ�����нṹ�£���front==rearʱΪ�ն��У���front==(rear+1)%maxSizeʱΪ�����С�
	 * ע�⣬������ʱ������һ��Ԫ�ؿռ�δ��ʹ�á��������ÿռ䣬���βָ��rearָ��ÿռ䵼���ˣ� �����кͿն����ж�������ͬ��
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
