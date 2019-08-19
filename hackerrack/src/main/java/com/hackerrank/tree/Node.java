package com.hackerrank.tree;

public class Node {
	public Node left;
	public Node right;
	public int data;
	

	/*
	 * Node : Simple tree node
	 * 
	 */
	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	/*
	 * Node insert : Binary insert
	 * 
	 * In a binary tree, all nodes on the left branch of a node are less than the
	 * node value. All values on the right branch are greater than the node value.
	 */
	public static Node insert(Node root, int data) {
		if (null == root) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
		}

		return root;
	}

	/*
	 * Complete the getHeight or height function It must return the height of a
	 * binary tree as an integer.
	 * 
	 * root: a reference to the root of a binary tree. The Height of binary tree
	 * with single node is taken as zero.
	 * : Recursively
	 */	
	
	public static int getHeight(Node root) {
		
		if(root == null || (root.left == null && root.right == null) ) {
			return 0;
		} else {
			// Computing height on left and right sub trees
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);
	
			// return the one which is longest
			return Math.max(leftHeight, rightHeight)  +1;
		}
		
	}

	
	/*
	 * You are given pointer to the root of the binary search tree and two values v1 and v2. 
	 * You need to return the lowest common ancestor (LCA) of v1 and v2 in the binary search tree.
	 * 
	 *  return a pointer to the lowest common ancestor node of the two values given.
	 *  
	 *  lca has the following parameters: 
	 *  - root: a pointer to the root node of a binary search tree 
	 *  - v1: a node.data value 
	 *  - v2: a node.data value
	 *  
	 *  : single traversal of Binary Tree - Recursive
	 */
	
	public static Node lowestCommonAncestor(Node root, int v1, int v2) {
		// If any of the given keys (v1 and v2) matches with root, then root is LCA 
		if (root == null) {
            return null; 
		}
		// If both v1 and v2 are smaller than root, then LCA lies in left 
        if (root.data > v1 && root.data > v2) {
            return lowestCommonAncestor(root.left, v1, v2); 
        }

        // If both v1 and v2 are larger than root, then LCA lies in right 
        if (root.data < v1 && root.data < v2) {
            return lowestCommonAncestor(root.right, v1, v2); 
        }
        
        // if the v1 and v2 is on either side of the root, then root itself is LCA
        return root;
	}
}
