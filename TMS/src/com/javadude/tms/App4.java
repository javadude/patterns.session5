package com.javadude.tms;

import com.javadude.template2withstrategy.Walker3;

public class App4 {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(42);
		root.insert(84);
		root.insert(57);
		root.insert(10);
		root.insert(31);
		root.insert(93);
		root.insert(4);

		Walker3 walker3 = new Walker3();

		System.out.println("Pre Order");
		System.out.println("========");
		walker3.setPreOrder((node) -> {System.out.println(node.getData());});
		walker3.walk(root);
		System.out.println();

		System.out.println("In Order");
		System.out.println("========");
		walker3.setPreOrder(null);
		walker3.setInOrder((node) -> {System.out.println(node.getData());});
		walker3.walk(root);
		System.out.println();
		
		System.out.println("Post Order");
		System.out.println("========");
		walker3.setInOrder(null);
		walker3.setPostOrder((node) -> {System.out.println(node.getData());});
		walker3.walk(root);
		
		System.out.println("In Order ('locking')");
		System.out.println("========");
		walker3.setPreOrder((node) -> {System.out.println("locking subtree");});
		walker3.setInOrder((node) -> {System.out.println(node.getData());});
		walker3.setPostOrder((node) -> {System.out.println("unlocking subtree");});
		walker3.walk(root);
	}
}
