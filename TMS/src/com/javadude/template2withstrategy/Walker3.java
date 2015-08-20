package com.javadude.template2withstrategy;

import com.javadude.tms.BinaryTreeNode;

// COMMUNICATION OF INTENT
public class Walker3 {
	private static final NodeStrategy NULL_NODE_STRATEGY = new NullNodeStrategy();
	private NodeStrategy preOrder = NULL_NODE_STRATEGY;
	private NodeStrategy postOrder = NULL_NODE_STRATEGY;
	private NodeStrategy inOrder = NULL_NODE_STRATEGY;

	private NodeStrategy nullFix(NodeStrategy nodeStrategy) {
		if (nodeStrategy == null)
			return NULL_NODE_STRATEGY;
		return nodeStrategy;
	}
	public void setPreOrder(NodeStrategy preOrder) {
		this.preOrder = nullFix(preOrder);
	}

	public void setPostOrder(NodeStrategy postOrder) {
		this.postOrder = nullFix(postOrder);
	}

	public void setInOrder(NodeStrategy inOrder) {
		this.inOrder = nullFix(inOrder);
	}

	// TEMPLATE METHOD: ALGORITHM WITH REPLACEABLE STEPS
	public void walk(BinaryTreeNode node) {
		preOrder.dealWithMe(node);	// STRATEGY HOOK CALL - WOOHOO - NO NULL CHECK!
		if (node.getLeft() != null)
			walk(node.getLeft());
		inOrder.dealWithMe(node);	// STRATEGY HOOK CALL - WOOHOO - NO NULL CHECK!
		if (node.getRight() != null)
			walk(node.getRight());
		postOrder.dealWithMe(node);	// STRATEGY HOOK CALL - WOOHOO - NO NULL CHECK!
	}
}
