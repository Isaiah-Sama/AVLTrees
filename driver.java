/* Name: Isaiah Samaniego
   CSC 130-03
   Assignment 2
   Professor Ouyang
 */
package main;

import java.util.*;
import java.io.*;

public class driver {
	public static void main(String args[]) {
		int [] a = {1,2,3,4,5,6,7};
		//declare AVL roots
		AVLTree tree = new AVLTree();
		AVLTree.Node rootTree1 = null;
		//AVLTree.Node rootTree2 = null;
		
		//Insert array into AVL Tree
		for(int x = 0; x < a.length; x++) {
			rootTree1 = tree.insert(rootTree1, a[x]);
			
		}
		tree.printTree(rootTree1);
	}
}

