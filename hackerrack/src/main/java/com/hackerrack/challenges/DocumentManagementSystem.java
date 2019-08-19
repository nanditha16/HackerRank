package com.hackerrack.challenges;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
public class DocumentManagementSystem {

	public static class Heading {
		protected int weight;
		protected String text;

		public Heading(int weight, String text) {
			this.weight = weight;
			this.text = text;
		}

	}

	/*
	 * TreeNode Array
	 */
	public static class Node {
		protected Heading heading;
		protected List<Node> children;

		public Node(Heading heading) {
			this.heading = heading;
			this.children = new ArrayList<>();
		}

	}

	public static class WeightCompare implements Comparator<Heading> {

		@Override
		public int compare(Heading m1, Heading m2) {
			if (m1.weight < m2.weight)
				return -1;
			if (m1.weight > m2.weight)
				return 1;
			else
				return 0;
		}

	}

	/**
	 * Parses a line of input. This implementation is correct for all predefined
	 * test cases.
	 */
	private static Heading parse(String record) {
		String[] parts = record.split(" ", 2);
		int weight = Integer.parseInt(parts[0].substring(1));
		Heading heading = new Heading(weight, parts[1].trim());
		return heading;
	}

	/**
	 * Converts a node to HTML. This implementation is correct for all predefined
	 * test cases.
	 */
	private static String toHtml(Node node) {
		StringBuilder buf = new StringBuilder();
		if (!node.heading.text.isEmpty()) {
			buf.append(node.heading.text);
			buf.append("\n");
		}
		Iterator<Node> iter = node.children.iterator();
		if (iter.hasNext()) {
			buf.append("<ul>");

			while (iter.hasNext()) {
				Node child = iter.next();
				buf.append("<li>");
				buf.append(toHtml(child));
				buf.append("</li>");
				if (iter.hasNext()) {
					buf.append("\n");
				}
			}
			buf.append("</ul>");
		}
		return buf.toString();
	}

	private static Node toOutline(List<Heading> headings) {
		// Implement this function. Sample code below builds an
		// outline of only the first heading.
		
		Node root = new Node(new Heading(0, ""));
		root.children.add(new Node(headings.get(0)));
		Node parentNode = root;

		for (int i = 1; i < headings.size(); i++) {
			// search for the place where it has to be added as a child
			parentNode = searchNode(root, headings.get(i));
			 System.out.println(parentNode.heading.text + " --> " + headings.get(i).text);
			// Add the new node to the parentNode
			//addToHeirarchy(parentNode, headings.get(i));
		}
		return root;
	}

	private static Node addToHeirarchy(Node parentNode, Node heading) {
		int index = parentNode.children.size();
		parentNode.children.add(index, heading);
		return parentNode;
	}

	/*
	 * return the node that has the same value as given input else BFS Search
	 * 
	 */
	private static Node searchNode(Node root, Heading heading) {
		Node grandParent = root;
		
		Node parent = root;
		int indexOfParent = 0;
		
		Iterator<Node> iter = root.children.iterator();
		
		while (iter.hasNext()) {
			parent = iter.next(); //layer arrayList
			
			indexOfParent = grandParent.children.size();
			if ((heading.weight == 1)) {
				addToHeirarchy(root, new Node(heading));
				return root;
			}
				
			if(indexOfParent > 1) {
				parent = grandParent.children.get(indexOfParent-1);
				
			} 
			
			if ((parent.heading.weight == (heading.weight - 1))) {
				addToHeirarchy(parent, new Node(heading));
				break;
			} else if ((parent.heading.weight == (heading.weight + 1))){
				root.children.set(indexOfParent -1, addToHeirarchy(new Node(heading),parent));
				parent = root;
				break;
			} 
			
			grandParent = parent;
			iter = grandParent.children.iterator();
		}

		return parent;

	}

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Heading> headings = new ArrayList<>();
		String line = br.readLine().trim();
		while (!("".equals(line))) {
			headings.add(parse(line));
			line = br.readLine().trim();
		}
//        for (String line = br.readLine().trim(); (line != null || !line.isEmpty() || !("".equals(line))); line = br.readLine().trim()) {
//            headings.add(parse(line));
//        }

		Node outline = toOutline(headings);
		String html = toHtml(outline);
		System.out.println(html);

	}

}
