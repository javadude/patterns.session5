package com.javadude.template1;

import com.javadude.tms.BinaryTreeNode;

public class SumWalker extends Walker {
	private int sum = 0;

	@Override
	protected void dealWithMe(BinaryTreeNode node) {
		sum += node.getData();
	}
	
	public int getSum() {
		return sum;
	}
}
