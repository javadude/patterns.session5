package com.javadude.template2withstrategy;

import com.javadude.tms.BinaryTreeNode;

// COMMUNICATION OF INTENT
public class Walker2 {
	private NodeStrategy preOrder;
	private NodeStrategy postOrder;
	private NodeStrategy inOrder;
	
	public void setPreOrder(NodeStrategy preOrder) {
		this.preOrder = preOrder;
	}

	public void setPostOrder(NodeStrategy postOrder) {
		this.postOrder = postOrder;
	}

	public void setInOrder(NodeStrategy inOrder) {
		this.inOrder = inOrder;
	}

	// TEMPLATE METHOD: ALGORITHM WITH REPLACEABLE STEPS
	public void walk(BinaryTreeNode node) {
		if (preOrder != null)
			preOrder.dealWithMe(node);	// STRATEGY HOOK CALL
		if (node.getLeft() != null)
			walk(node.getLeft());
		if (inOrder != null)
			inOrder.dealWithMe(node);	// STRATEGY HOOK CALL
		if (node.getRight() != null)
			walk(node.getRight());
		if (postOrder != null)			
			postOrder.dealWithMe(node);	// STRATEGY HOOK CALL
	}
}
