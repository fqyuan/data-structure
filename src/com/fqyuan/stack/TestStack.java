package com.fqyuan.stack;

import java.util.Random;

public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// testInteger();
		testPerson();
	}

	private static void testInteger() {
		Random random = new Random();

		Stack<Integer> s = new Stack<Integer>(Integer[].class, 15);
		for (int i = 0; i < 10; i++) {
			int val = random.nextInt(100);
			System.out.print(val + " ");
			s.push(val);
		}
		System.out.println();
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}

	private static void testPerson() {
		Random random = new Random();

		Stack<Student> s = new Stack<Student>(Student[].class, 10);
		for (int i = 0; i < 10; i++) {
			int val = random.nextInt(100);
			System.out.print(val + " ");
			Student stu = new Student(val, ("Student" + val));
			s.push(stu);
		}
		System.out.println();
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}
