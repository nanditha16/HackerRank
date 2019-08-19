package com.hackerrank.tree;

import java.util.Scanner;

public class BinaryTreeTest {
		
	/*
	 * 
	 * Node values are inserted into a binary search tree 
	 * before a reference to the tree's root node is passed to your function. 
	 * 
	 * The first line contains an integer n, the number of nodes in the tree.  1 <= n <= 20 or 25
	 * 
	 * Next line contains n space separated integer 
	 *   where ith integer denotes node[i].data and 1 <= node[i].data. <= 20 or 25
	 * 
	 * for LCA: 
	 * The third line contains two space-separated integers, v1 and v2. 1 <= v1, v2 <= 25, v1 not equal to v2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	       
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		Node rootTree = null;
   
		// To create a binary tree
		while(n-- > 0) {
			int data = scanner.nextInt();
			rootTree = Node.insert(rootTree, data);
		}
		
		//only for LCA: to get LCA
		int v1 = scanner.nextInt();
		int v2 = scanner.nextInt();
	      
		
		// To get the height of a binary tree
		int height = Node.getHeight(rootTree);
	    System.out.println(height);
	        
	    //LCA - Lowest Common Ancestor
	    Node ancestor = Node.lowestCommonAncestor(rootTree,v1,v2);
        System.out.println(ancestor.data);
        
		scanner.close();
	}
	
}
