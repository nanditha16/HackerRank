package com.hackerrank.linked;

public class SinglyLinkedListNode {
	public int data;
	public SinglyLinkedListNode next;
	
	SinglyLinkedListNode(int nodeData){
		this.data = nodeData;
		this.next = null;
	}
	
	 static class SinglyLinkedList {
		 public SinglyLinkedListNode head;
		 public SinglyLinkedListNode tail;
		 
		 //To get the List of nodes
		 public SinglyLinkedList() {
			 this.head = null;
			 this.tail = null;
		 }
		 
		 /*
		  * Insert a given data as a node into SinglyLinkedList
		  */
		 public void insertNode(int nodeData) {
			 //create a node for given data
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
				
			if(this.head == null) {
				//first node
				this.head = node;
			} else {
				//add to last
				this.tail.next = node;
			}
			
			//upadate the tail reference
			this.tail = node;
			
		}
		 
		 /*
		  * delete a node
		  */
		 public void deleteNodeWithValue(int nodeData) {
			 // Base case:  if list is empty
			 if(this.head == null) {
				 return;
			 }
			 
			 // Case 1: if head is the value to be deleted
			 if(this.head.data == nodeData) {
				 this.head = this.head.next;
				 return;
			 }
			 
			 // Case 2: if value is in the middle or end
			 // Initialise current to traverse through the link
			 SinglyLinkedListNode current = this.head;
			 while(current.next != null) {
				 if(current.next.data == nodeData) {
					 current.next = current.next.next;
					 return;
				 }
				 current = current.next;
			 }
		 }
		 
		 /*
		  * insertNodeAtPosition : given the pointer to the head node of a linked list, 
		  * an integer to add to the list and the position at which the integer must be inserted.  
		  * 
		  * Create a new node with the given integer, 
		  * insert this node at the desired position and 
		  * return the head node.
		  * 
		  * A position of 0 indicates head (starts from 0), 
		  * a position of 1 indicates one node away from the head and so on. 
		  * The head pointer given may be null meaning that the initial list is empty.
		  * 
		  * It must return a reference to the head node of your finished list.
		  * 
		  * insertNodeAtPosition has the following parameters:
		  * 	head: a SinglyLinkedListNode pointer to the head of the list
		  * 	data: an integer value to insert as data in your new node
		  * 	position: an integer position to insert the new node, zero based indexing
		  */
		 public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
			
			 //Initialize to temp
			 SinglyLinkedListNode temp = head;
			 
			 // Create a new node with the given integer,
			 SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
			
			 // insert this node at the desired position
			 if(position == 0) {
				 head = newNode; 	
				 newNode.next = temp;
			 } else {
				 //traverse to the position
				 while(position-- > 1) {
					 temp = temp.next;
				 }	
				 newNode.next = temp.next;
				 temp.next = newNode;
			 }
			 return head;
		 }
		 
		 /*
		  * A linked list is said to contain a cycle 
		  * if any node is visited more than once while traversing the list. 
		  * 
		  * It must return a boolean true if the graph contains a cycle, or false.
		  * 
		  * head: : a pointer to a Node object that points to the head of a linked list.
		  *  If the list is empty, head will be null.
		  *  FLoyd's cycle-finding 
		  */
		 public static boolean hasCycle(SinglyLinkedListNode head) {
			 //Initialise slow_traverse and fast_traverse to head
			 SinglyLinkedListNode slow_traverse = head;
			 SinglyLinkedListNode fast_traverse = head;
			 
			 // Loop till the 
			 while(slow_traverse != null && fast_traverse != null && fast_traverse.next != null) {
				 slow_traverse = slow_traverse.next;
				 fast_traverse = fast_traverse.next.next;
				 
				 if(slow_traverse == fast_traverse) {
					 System.out.println("Found loop"); 
					 return true;
				 }
			 }
			return false;
			 
		 }
		 
		 /*
		  * Given pointers to the head nodes of 2 linked lists that merge together at some point, 
		  * find the Node where the two lists merge. 
		  * 
		  * two head Nodes will be different, and neither will be NULL.
		  * 
		  * 
		  * hash all nodes of the first list and then check the second list.
		  * Step 1:   Create an empty hash table such that node address is used as key 
		  * 		and a binary value present/absent is used as the value.
		  * Step 2:   Traverse the first linked list and 
		  * 		insert all nodes’ addresses in the hash table.
		  * Step 3:   Traverse the second list. For every node check if it is present in the hash table. 
		  * If we find a node in the hash table, return the node.
		  */
		 public static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
	  
			  int head1Count = 0; // O(n)
			  int head2Count = 0; // O(m)
				
			  SinglyLinkedListNode currentHead1 = head1;
			  SinglyLinkedListNode currentHead2 = head2;
			  
			  // if either of the list is empty - no merge_point
			  if (currentHead1 == null || currentHead2 == null) {
		            return -1;
			  }
			  
			  //get the node count values of each lists
			  head1Count = getNodeCount(currentHead1);
			  head2Count = getNodeCount(currentHead2);

			  int diff = 0;
			   
			  // traverse the list which is shorter
		      if(head1Count > head2Count){
		            diff = head1Count-head2Count;
		            for(int i=0;i<diff;i++){
		            	currentHead1 = currentHead1.next;
		            }
		        }else{
		            diff = head2Count-head1Count;
		            for(int i=0;i<diff;i++){
		            	currentHead2 = currentHead2.next;
		            }
		        }
		      
		      while(currentHead1 != null && currentHead2 != null){
		    	  //pointing to same node return the merge point
		            if(currentHead1 == currentHead2){
		                return currentHead1.data;
		            }
		            currentHead1 = currentHead1.next;
		            currentHead2 = currentHead2.next;
		        }
			 return -1;
		 }
		

		private static int getNodeCount(SinglyLinkedListNode head) {
			int headCount = 0;
			 while(head != null){
				 head = head.next;
				  headCount++;
			  }
			return headCount;
		}

		/*
		  * Print the list 
		  */
		 public static void printSinglyLinkedList(SinglyLinkedListNode node) {
			 while(node != null) {
				 System.out.print(node.data + " ");
				 node = node.next;
			 }
		 }
		 
	 }
}
