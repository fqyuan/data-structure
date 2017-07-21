package com.fqyuan.stack;

import java.lang.reflect.Array;

public class Stack<T> {
	private int size;
	private int top;
	private T[] stack;

	@SuppressWarnings("unchecked")
	public Stack() {
		top = -1;
		size = 50;
		stack = (T[]) new Object[size];
	}

	public Stack(Class<T[]> clz, int size) {
		top = -1;
		this.size = size;
		stack = clz.cast(Array.newInstance(clz.getComponentType(), size));
	}

	public boolean push(T item) {
		if (isFull()) {
			System.out.println("Error, the stack is full!");
			return false;
		} else {
			stack[++top] = item;
			return true;
		}

	}

	public T pop() {
		if (isEmpty()) {
			System.out.println("Illegal operation, empty stack.");
			return null;
		} else {
			return stack[top--];
		}

	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == stack.length - 1;
	}
}
