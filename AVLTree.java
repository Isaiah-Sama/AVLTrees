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

	public Node insert(Node t, int a) {
		if(t==null) {
			return(new Node(a));
		}
		else if(a<t.data) {
			t = Node
		}
	}
}
