package com.hackerrank.linked;

public class DoublyLinkedListNode {
	public int data;
	public DoublyLinkedListNode next;
	public DoublyLinkedListNode prev;
	
	DoublyLinkedListNode(int nodeData){
		this.data = nodeData;
		this.next = null;
		this.prev = null;
	}
	
	 static class DoublyLinkedList {
		 public DoublyLinkedListNode head;
		 public DoublyLinkedListNode tail;
		 
		 //To get the List of nodes
		public  DoublyLinkedList(){
			 this.head = null;
			 this.tail = null;
		 }
		
		/*
		  * Insert a given data as a node into DoublyLinkedList
		  */
		public void insertNode(int nodeData) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);
			
			if(this.head == null) {
				//first node
				this.head = node;
			} else {
				// add to last and update both next and prev
				this.tail.next = node;
				node.prev = this.tail;
			}
			//update tail
			this.tail = node;
		}
		
		/*
		 * Given a reference to the head of a doubly-linked list and an integer,data , 
		 * create a new DoublyLinkedListNode object having data value data and 
		 * insert it into a sorted linked list while maintaining the sort.
		 * 
		 * 
		 * 	head: A reference to the head of a doubly-linked list of DoublyLinkedListNode objects.
		 * 	data: An integer denoting the value of the  field for the DoublyLinkedListNode
		 *  you must insert into the list.
		 * 
		 * Note: An empty list and a list with one element are sorted lists.
		 * 
		 * 
		 *  return a reference to the  of the same list that was passed to it as a parameter.
		 */
		public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) { 
			//Create a new node 
			DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
			
			//Base case : If the list is empty	
			if(head == null) { 
				head = newNode;
			} 
			/*
			 * case 2: At the beginning of the list – 
			 * while currentNode.next is not None:
			 * 	If true, then its newNode.next = currentNode
			 * 					  newNode.prev = NULL.
			 * 					  head.prev = newNode. 
			 * 					  head = newNode 
			 */
			if(head.data >= data) { 
				newNode.next = head;
				newNode.next.prev = newNode;
				head = newNode;
			} else {
			/*
			 * case 3: Somewhere in the middle of the list – 
			 * Traverse through the link and for every current value
			 * 		1. check for the position to be inserted
			 * 		2. update links
			 * 			newNode forward link
			 * 			newNode backward link
			 *			oldNode backward link
			 *			oldNode forward link
			 */
				// Initialize to temp
				DoublyLinkedListNode current = head;
				
				// Traverse till we get the appropriate place to insert
				while(current.next != null && current.next.data < data) {
			           current = current.next;
			    }
				
				//case 3a: Middle case: newNode will have to be inserted at: current and current.next
				newNode.prev = current;		 // newNode backward link
				newNode.next = current.next; // newNode forward link
				
				
				//case 3b: In the last: after current
				if(current.next != null) {
					current.next.prev = newNode;
				}
				current.next = newNode; // oldNode forward link		
			}
			
			return head;
		}
		
		
		/*
		 * Reverse the order of the nodes in the list.
		 * The head node might be NULL to indicate that the list is empty. 
		 * Change the next and prev pointers of all the nodes so that the direction of the list is reversed. 
		 * Return a reference to the head node of the reversed list.
		 * 
		 * head: a reference to the head of a DoublyLinkedList - Recursively
		 * 
		 * 
		 * Step 1:  If list is empty, return null
		 * Step 2:  Reverse head by swapping prev and next
		 * Step 3:  If prev = null then list is fully reversed. Else call recursively : reverse(prev)
		 */
		public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
			// Initialize to temp
			DoublyLinkedListNode temp = null;
			
			//base case: list is empty
			if (head == null) {
		        return null; 
			}
			
			//recuresive case: swap prev and next
			temp = head.next;
			head.next = head.prev;
			head.prev = temp;

			//if prev is null, reverse is completed
			if(head.prev == null) {
				return head;
			} 
			
			return reverse(head.prev);
		}
		
		 /*
		  * Print the list 
		  */
		public static void printDoublyLinkedList(DoublyLinkedListNode node) {
			 while(node != null) {
				 System.out.print(node.data + " ");
				 node = node.next;
			 }
		}
		
		
	 }
}
