package com.hackerrank.graphtheory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


/**
 * Land has n cities numbered from 1 to n. 
 * The cities are connected by m bidirectional roads
 *
 * You are given q queries, where each query consists of a
 *  map of HackerLand and value of c_lib and c_road.
 *  
 *  roadsAndLibraries : 
 *  	For each query, find the minimum cost of making libraries 
 *  accessible to all the citizens and print it on a new line.
 *  
 *  1st line :  
 *  	q - the number of queries.
 *  2nd line :
 *  	n		- the number of cities
 *  	m		- bidirectional roads
 *  	c_lib	- the cost to build a library
 *  	c_road	- the cost to repair a road	
 *  subsequent m lines :
 *  	two space-separated integers {u,v}
 *  
 */
public class RoadsAndLibraries 
{
	private static final Scanner in = new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	int q = in.nextInt();
    	in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    	
        for(int a0 = 0; a0 < q; a0++){
        	try {
        	in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String[] nmC_libC_road = in.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);
            int m = Integer.parseInt(nmC_libC_road[1]);
            int c_lib = Integer.parseInt(nmC_libC_road[2]);
            int c_road = Integer.parseInt(nmC_libC_road[3]);
        	
            
            //adjacentList : Initialize to store the n cities
            @SuppressWarnings("unchecked")
			LinkedList<Integer>[] adjListArray = new LinkedList[n];

            /*
 			 * a new list for each node such that adjacent nodes can be stored
 			 * 
 			 */
 			for (int i = 0; i < n; i++) {
 				adjListArray[i] = new LinkedList<>();
 			}
            
            for (int j = 0; j < m; j++) {
            	int u = in.nextInt();
            	u--; // adjacentList starts from 0
            	int v = in.nextInt();
            	v--;
            	 // edges
            	// Add an edge from src to dest.
         		adjListArray[u].add(v);

         		// If graph is undirected
         		adjListArray[v].add(u);
            }
            
          long result = roadsAndLibraries(n, c_lib, c_road, adjListArray);
         System.out.println(String.valueOf(result));
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        	
        
        in.close();
    }
  
	private static long roadsAndLibraries(int n, int c_lib, int c_road, LinkedList<Integer>[] adjListArray) {
		
		/*
		 * Case 1: if the cost of building a library is less than 
		 * 		the cost of repairing a road
		 */
		if(c_road >= c_lib) { 
			return ((long)c_lib * (long)n);
		} 
		
		/*
         * Case n : DFS Modified
         */
		long cost = 0;
		boolean[] visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				long tmpCost = c_lib;
				//unvisited cities track
				Stack<Integer> stack = new Stack<>();
				stack.push(i);
				visited[i] = true;
				
				//iterate over the cities
				while(!stack.empty()) {
					int u = stack.pop();
					
					
					Iterator<Integer> it = adjListArray[u].iterator();
					while(it.hasNext()) {
						// to get the adjacent city
						int v = it.next();
						if(!visited[v]) {
							stack.push(v);
							visited[v] = true;
							tmpCost += c_road;
						}
					}
				}
				cost += tmpCost;
			}
		}
		
		return cost;
	}
}
