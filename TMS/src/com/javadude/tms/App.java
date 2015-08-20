package com.javadude.tms;

public class App {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(42);
		// D'oh! had a duplicate "42" in there...
		root.insert(84);
		root.insert(57);
		root.insert(10);
		root.insert(31);
		root.insert(93);
		root.insert(4);
		
		System.out.println("In Order");
		System.out.println("========");
		printInorder(root);
		System.out.println();
		System.out.println("Sum: " + sumInorder(root));
	}
	private static void printInorder(BinaryTreeNode node) {
		if (node.getLeft() != null) {
			printInorder(node.getLeft());
		}
		System.out.println(node.getData());
		if (node.getRight() != null) {
			printInorder(node.getRight());
		}
	}
	private static int sumInorder(BinaryTreeNode node) {
		int sum = 0;
		if (node.getLeft() != null) {
			sum += sumInorder(node.getLeft());
		}
		sum += node.getData();
		if (node.getRight() != null) {
			sum += sumInorder(node.getRight());
		}
		return sum;
	}
}
