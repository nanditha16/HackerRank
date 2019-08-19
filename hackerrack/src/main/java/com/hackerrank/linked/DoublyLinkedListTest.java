package com.hackerrank.linked;

import java.util.Scanner;

import com.hackerrank.linked.DoublyLinkedListNode.DoublyLinkedList;

public class DoublyLinkedListTest {

	/*
	 * The first line contains an integer t, the number of test cases. 1 <= t <= 10
	 * 
	 * Each of the test case is in the following format:
	 * 
	 * The first line contains an integer n, the number of elements in the linked list. 1 <= n <= 1000
	 * Each of the next n lines contains an integer, the data for each node of the linked list.
	 * 
	 * The last line contains an integer data which needs to be inserted 
	 * into the sorted doubly-linked list. 1 <= DoublyLinkedListNode[i].data <= 1000
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	       
		int testCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		
		// To create an initial DoublyLinkedList for each testCount
		while(testCount-- > 0) {
			DoublyLinkedList dlist = new DoublyLinkedList();
			
			int dlistItem = scanner.nextInt();
			while(dlistItem-- > 0) {
				int newData  = scanner.nextInt();
				dlist.insertNode(newData);
			}
			
			// new data to be inserted in sorted list
			//int newData = scanner.nextInt();
			
			// print the list before insertion
			DoublyLinkedList.printDoublyLinkedList(dlist.head);
			System.out.println();
			
			// sortedInsert
			//DoublyLinkedListNode dlist_head = DoublyLinkedList.sortedInsert(dlist.head, newData);
		
			// print the list after insertion
			//DoublyLinkedList.printDoublyLinkedList(dlist_head);
						
			//reverse a list
			  DoublyLinkedListNode dlist_reverse = DoublyLinkedList.reverse(dlist.head);
			
			  // print the list after insertion
			  DoublyLinkedList.printDoublyLinkedList(dlist_reverse);
				
			  
		}	
		scanner.close();
	}

}
