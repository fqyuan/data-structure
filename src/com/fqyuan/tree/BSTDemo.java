package com.fqyuan.tree;

import java.util.Random;

public class BSTDemo {

	public static void main(String[] args) {
		BSTTree<Integer> bstTree = new BSTTree<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			bstTree.insert(random.nextInt(100));
		}
		System.out.println(bstTree.isEmpty());
		bstTree.inOrder();

		System.out.println();
		bstTree.delete(35);
		bstTree.inOrder();
	}
}
