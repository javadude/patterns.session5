package com.javadude.template1;

import com.javadude.tms.BinaryTreeNode;

// OFTEN ABSTRACT (unless reasonable default for hooks) 
public abstract class Walker {
	
	// TEMPLATE METHOD: ALGORITHM WITH REPLACEABLE STEPS
	public void inorder(BinaryTreeNode node) {
		if (node.getLeft() != null)
			inorder(node.getLeft());

		dealWithMe(node);  // CALL TO HOOK METHOD
		
		if (node.getRight() != null)
			inorder(node.getRight());
	}
	
	// HOOK METHOD - REPLACE IN SUBCLASSES
	protected abstract void dealWithMe(BinaryTreeNode node);
}
