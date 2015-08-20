package com.javadude.template2withstrategy;

import com.javadude.tms.BinaryTreeNode;

// NULL OBJECT - ALLOWS AVOIDANCE OF NULL CHECKS!
public class NullNodeStrategy implements NodeStrategy {

	@Override
	public void dealWithMe(BinaryTreeNode node) {
		// DO NOTHING
	}

}
