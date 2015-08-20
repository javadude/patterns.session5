package com.javadude.tms;

// Simple Binary Tree Implementation that stores integers in ascending order
public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	
	public BinaryTreeNode(int data) {
		this.data = data;
	}
	
	public void insert(int n) {
		if (n < data)
			if (left == null)
				left = new BinaryTreeNode(n);
			else
				left.insert(n);
		else
			if (right == null)
				right = new BinaryTreeNode(n);
			else
				right.insert(n);
	}
	public int getData() {
		return data;
	}
	public void inorder() {
		if (left != null) {
			left.inorder();
		}
		System.out.println(data);
		if (right != null) {
			right.inorder();
		}
	}
}
