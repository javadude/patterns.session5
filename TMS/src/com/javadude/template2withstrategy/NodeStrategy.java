package com.javadude.template2withstrategy;

import com.javadude.tms.BinaryTreeNode;

// STRATEGY
public interface NodeStrategy {
	// HOOK METHOD
	void dealWithMe(BinaryTreeNode node);
}
