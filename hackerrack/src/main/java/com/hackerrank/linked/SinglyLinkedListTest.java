package com.hackerrank.linked;

import java.util.Scanner;

import com.hackerrank.linked.SinglyLinkedListNode.SinglyLinkedList;

public class SinglyLinkedListTest {

	/*
	 * The first line contains an integer n, the number of elements in the linked list.  1 <= n <= 1000
	 * Each of the next n lines contains an integer SinglyLinkedListNode[i].data. 
	 * 		1 <= SinglyLinkedListNode[i].data <= 1000, and SinglyLinkedListNode[i] is the ith element of list
	 * insertNodeAtPosition: The new data that needs to be added at position
	 * insertNodeAtPosition: The last line contains an integer position. 0 <= position <= n
	 * 
	 * findMergeNode: llist2Count
	 * findMergeNode: llist2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	       
		// list 1 :
		int llistCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		SinglyLinkedList llist = new SinglyLinkedList();
		
		// To create an initial SinglyLinkedList
		while(llistCount-- > 0) {
			int llistItem = scanner.nextInt();
			llist.insertNode(llistItem);
		}
		
	
//		// new data to be inserted at given Position
		int newData = scanner.nextInt();
//		
//		// position at which newData has to be inserted
		int position = scanner.nextInt();
		
		// print the list before insertion
		SinglyLinkedList.printSinglyLinkedList(llist.head);
		System.out.println();
		// insertNodeAtPosition - inserting in a list that's given
		SinglyLinkedListNode llist_head = SinglyLinkedList.insertNodeAtPosition(llist.head, newData, position);
	
		// print the list after insertion
		SinglyLinkedList.printSinglyLinkedList(llist_head);
		
		
		//Floyd's cycle dection
		System.out.println(SinglyLinkedList.hasCycle(llist.head));
		
		// list 2 :
		int llist2Count = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				
		SinglyLinkedList llist2 = new SinglyLinkedList();
				
		// To create an initial SinglyLinkedList
		while(llist2Count-- > 0) {
			int llistItem = scanner.nextInt();
			llist2.insertNode(llistItem);
		}
		
		SinglyLinkedList.printSinglyLinkedList(llist2.head);
		System.out.println();
			
		int merged_point = SinglyLinkedList.findMergeNode(llist.head, llist2.head);
		
		System.out.println("Merge Point : " + merged_point);
	
		scanner.close();
	}

}
