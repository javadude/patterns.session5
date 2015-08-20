package com.javadude.template1;

import com.javadude.tms.BinaryTreeNode;

public class PrintWalker extends Walker {
	@Override
	protected void dealWithMe(BinaryTreeNode node) {
		System.out.println(node.getData());
	}
}
