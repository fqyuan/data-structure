package com.fqyuan.tree;

public class BSTTree<T> {
	private Node root;

	public BSTTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insertItr(T data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if ((int) data <= (int) current.data) {
				current = current.lchild;
				if (current == null) {
					parent.lchild = newNode;
					return;
				}
			} else {
				current = current.rchild;
				if (current == null) {
					parent.rchild = newNode;
					return;
				}
			}
		}
	}

	public void insert(T data) {
		root = insert(root, data);
	}

	private Node insert(Node node, T item) {
		if (node == null) {
			node = new Node(item);
		} else {
			if ((int) (item) <= (int) (node.data))
				node.lchild = insert(node.lchild, item);
			else
				node.rchild = insert(node.rchild, item);
		}
		return node;
	}

	public boolean search(T val) {
		return search(root, val);
	}

	// Function to search for an element recursively
	private boolean search(Node node, T val) {
		boolean found = false;
		while ((node != null) && !found) {
			if ((int) node.data < (int) val)
				found = search(node.lchild, val);
			else if ((int) node.data > (int) val)
				found = search(node.rchild, val);
			else {
				found = true;
			}

		}
		return found;
	}

	public boolean delete(T item) {
		Node parent = root;
		Node current = root;

		boolean isLeftChild = false;
		while (current.data != item) {
			parent = current;
			if ((int) item < (int) current.data) {
				isLeftChild = true;
				current = current.lchild;
			} else {
				isLeftChild = false;
				current = current.rchild;
			}
			if (current == null) {
				return false;
			}
		}

		// If we are here, it means that we have found the node.
		// Case 1: If node to be deleted has no children
		if (current.lchild == null && current.rchild == null) {
			if (current == root) {
				root = null;
			}
			if (isLeftChild == true) {
				parent.lchild = null;
			} else {
				parent.rchild = null;
			}

		}

		// Case 2: if node to be deleted has only one child
		else if (current.lchild == null) {
			if (current == root) {
				root = current.rchild;
			} else if (isLeftChild) {
				parent.lchild = current.rchild;
			} else {
				parent.rchild = current.rchild;
			}
		} else if (current.rchild == null) {
			if (current == root) {
				root = current.lchild;
			} else if (isLeftChild) {
				parent.lchild = current.lchild;
			} else {
				parent.rchild = current.lchild;
			}
		}

		// Case 3: if node to be deleted has two children
		else if (current.lchild != null && current.rchild != null) {
			// First find the minimum element in the right sub tree.
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.lchild = successor;
			} else {
				parent.rchild = successor;
			}
			successor.lchild = current.lchild;
		}
		return true;
	}

	private Node getSuccessor(Node delNode) {
		Node successor = null;
		Node successorParent = null;
		Node current = delNode.rchild;

		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.lchild;
		}
		// Check if the successor has the right child, it can't have left child
		// for sure, if it does have the child child, add it to the left of
		// successorParent.
		if (successor != delNode.rchild) {
			successorParent.lchild = successor.rchild;
			successor.rchild = delNode.rchild;
		}
		return successor;
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		// WHy isEmpty() not available here?
		if (root != null) {
			inOrder(root.lchild);
			System.out.print(root.data + " ");
			inOrder(root.rchild);
		}
	}

	class Node {
		private Node lchild;
		private Node rchild;
		private T data;

		public Node(T data) {
			this.data = data;
			lchild = null;
			rchild = null;
		}
	}
}