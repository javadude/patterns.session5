package com.javadude.tms;

import com.javadude.template2withstrategy.Walker2;

public class App3 {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(42);
		root.insert(84);
		root.insert(57);
		root.insert(10);
		root.insert(31);
		root.insert(93);
		root.insert(4);

		Walker2 walker2 = new Walker2();

		System.out.println("Pre Order");
		System.out.println("========");
		walker2.setPreOrder((node) -> {System.out.println(node.getData());});
		walker2.walk(root);
		System.out.println();

		System.out.println("In Order");
		System.out.println("========");
		walker2.setPreOrder(null);
		walker2.setInOrder((node) -> {System.out.println(node.getData());});
		walker2.walk(root);
		System.out.println();
		
		System.out.println("Post Order");
		System.out.println("========");
		walker2.setInOrder(null);
		walker2.setPostOrder((node) -> {System.out.println(node.getData());});
		walker2.walk(root);
		
		System.out.println("In Order ('locking')");
		System.out.println("========");
		walker2.setPreOrder((node) -> {System.out.println("locking subtree");});
		walker2.setInOrder((node) -> {System.out.println(node.getData());});
		walker2.setPostOrder((node) -> {System.out.println("unlocking subtree");});
		walker2.walk(root);
	}
}
