/* Name: Isaiah Samaniego
   CSC 130-03
   Assignment 2
   Professor Ouyang
 */
package main;

import java.util.*;
import java.io.*;

public class AVLTree {
	public class Node {
		private int height = 1;
		public Node left, right;
		public int data;
		
		public Node(int value) {
			this.data = value;
			left = null;
			right = null;
		}
	}
	
	public void printTree(Node root) {
		 if(root == null) {
	            System.out.println("(XXXXXX)");
	            return;
	        }

	        int height = root.height,
	            width = (int)Math.pow(2, height-1);

	        // Preparing variables for loop.
	        List<Node> current = new ArrayList<Node>(1),
	            next = new ArrayList<Node>(2);
	        current.add(root);

	        final int maxHalfLength = 4;
	        int elements = 1;

	        StringBuilder sb = new StringBuilder(maxHalfLength*width);
	        for(int i = 0; i < maxHalfLength*width; i++)
	            sb.append(' ');
	        String textBuffer;

	        // Iterating through height levels.
	        for(int i = 0; i < height; i++) {

	            sb.setLength(maxHalfLength * ((int)Math.pow(2, height-1-i) - 1));

	            // Creating spacer space indicator.
	            textBuffer = sb.toString();

	            // Print tree node elements
	            for(Node n : current) {

	                System.out.print(textBuffer);

	                if(n == null) {

	                    System.out.print("        ");
	                    next.add(null);
	                    next.add(null);

	                } else {

	                    System.out.printf("(%6d)", n.data);
	                    next.add(n.left);
	                    next.add(n.right);

	                }

	                System.out.print(textBuffer);

	            }

	            System.out.println();
	            // Print tree node extensions for next level.
	            if(i < height - 1) {

	                for(Node n : current) {

	                    System.out.print(textBuffer);

	                    if(n == null)
	                        System.out.print("        ");
	                    else
	                        System.out.printf("%s      %s",
	                                n.left == null ? " " : "/", n.right == null ? " " : "\\");

	                    System.out.print(textBuffer);

	                }

	                System.out.println();

	            }

	            // Renewing indicators for next run.
	            elements *= 2;
	            current = next;
	            next = new ArrayList<Node>(elements);

	        }

	    }
	
	Node insert(Node t, int value) {
		//compare statements
		if(t==null) 
			return(new Node(value));
		if(value < t.data) 
			t.left = insert(t.left, value);
		else t.right = insert(t.right, value);
		//Height update
		t.height = Math.max(height(t.left), height(t.right))+1;
		int b = balance(t);
		if(b==2 && value < t.left.data) {
			return rotateRight(t);
		}
		else return doubleRotateRight(t);
		
	}
	
	public int height(Node t) {
		if(t==null)
			return 0;
		return t.height;
	}
	
	public int balance(Node t) {
		if(t==null)
			return 0;
		else return height(t.left)- height(t.right); 
	}
	
	/*public int heightUpdate(Node t) {
		return t.height = Math.max(heightUpdate(t.left), heightUpdate(t.right))+1;
	}*/
	
	Node findMin(Node t) {
		Node lowVal = t;
		while(lowVal != null) {
			lowVal = lowVal.left;
		}
		return lowVal;
	}
	
	/*public int remove() {
		return 0;
	}*/
	
	public Node rotateLeft(Node t) {
		Node nRight = t.right;
		Node nLeft = t.left;
		//rotate
		t.right = nLeft;
		nRight.left = t;
		//update height
		t.height = Math.max(height(t.left), height(t.right))+1;
		nRight.height = Math.max(height(nRight.left), height(nRight.right))+1;
		
		return nRight;
	}
		
	private Node rotateRight(Node t) {
		Node nLeft = t.left;
		Node nRight = nLeft.right;
		
		//rotate
		t.left = nRight;
		nLeft.right = t;
		//update height
		t.height = Math.max(height(t.left), height(t.right))+1;
		nLeft.height = Math.max(height(nLeft.left), height(nLeft.right))+1;
		
		return nLeft;
	}
		
	public Node doubleRotateRight(Node t) {
		
		return t;
	}
		
	public void doubleRotateLeft() {
		
	}
}
