package com.javadude.template1;

import com.javadude.tms.BinaryTreeNode;

public class AverageWalker extends Walker {
	private int sum = 0;
	private int count = 0;

	@Override
	protected void dealWithMe(BinaryTreeNode node) {
		sum += node.getData();
		count++;
	}
	
	public int getAverage() {
		return sum/count;
	}
}
