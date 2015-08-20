package com.javadude.tms;

public class App {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(42);
		root.insert(42);
		root.insert(84);
		root.insert(57);
		root.insert(10);
		root.insert(31);
		root.insert(93);
		root.insert(4);
		
		root.inorder();
	}
}
