package com.javadude.tms;

import com.javadude.template1.AverageWalker;
import com.javadude.template1.PrintWalker;
import com.javadude.template1.SumWalker;

public class App2 {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(42);
		root.insert(84);
		root.insert(57);
		root.insert(10);
		root.insert(31);
		root.insert(93);
		root.insert(4);
		
		System.out.println("In Order");
		System.out.println("========");
		PrintWalker printWalker = new PrintWalker();
		printWalker.inorder(root);
		
		AverageWalker averageWalker = new AverageWalker();
		averageWalker.inorder(root);
		System.out.println("Average: " + averageWalker.getAverage());
		
		SumWalker sumWalker = new SumWalker();
		sumWalker.inorder(root);
		System.out.println("Sum: " + sumWalker.getSum());
	}
}
