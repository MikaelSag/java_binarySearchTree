package hw3;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		binarySearchTree bst = new binarySearchTree();
		Node root = null;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Create the Binary Search Tree by entering integers seperated by whitespace, when finished type 12345");
		while(true)		// user can create the tree, inputting integers
		{
			int val = scnr.nextInt();
			if (val == 12345)
			{
				break;
			}
			root = bst.insert(val, root);
		}
		
		int choice = 0;
		Scanner menu = new Scanner(System.in);
		
		while(choice != -1)		// menu 
		{
			System.out.println();
			System.out.println("----------------------");
			System.out.println("1. Traverse in Order");
			System.out.println("2. Height");
			System.out.println("3. All Nodes");
			System.out.println("4. All Leaves");
			System.out.println("5. Is AVL?");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("-1. End Program");
			System.out.println("----------------------");
			System.out.println();
			choice = menu.nextInt();
			
			switch(choice)
			{
				case 1:
					bst.inOrderTraverse(root);
					break;
				case 2:
					System.out.println("Height of " + bst.height(root));
					break;
				case 3:
					System.out.println(bst.numOfNodes(root) + " nodes");
					break;
				case 4:
					System.out.println(bst.numOfLeaves(root) + " leaves");
					break;
				case 5: 
					if (bst.isAVL(root))
					{
						System.out.println("The tree is an AVL tree");
					}
					else
					{
						System.out.println("The tree is not an AVL tree");
					}
					break;
			}
		}

	}

}
