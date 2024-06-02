package hw3;

public class binarySearchTree {
	
	Node root;
	int leafCount = 0;
	int total = 0;
	int leftHeight = 0;
	int rightHeight = 0;
	
	public Node insert(int val, Node node)
	{
		if (node == null)
		{
			return(new Node(val, null, null)); 
		}
		else
		{
			if (val < node.data)
			{
				if (node.left == null)
				{
					node.left = new Node(val, null, null);
				}
				else
				{
					insert(val, node.left);
				}
			}
			else if (val > node.data)
			{
				if (node.right == null)
				{
					node.right = new Node(val, null, null);
				}
				else
				{
					insert(val, node.right);
				}
			}
			return node;
		}
	}
	
	public void numOfNodesHelp(Node node)
	{
		if (node != null)
		{
			total += 1;
			numOfNodesHelp(node.left);
			numOfNodesHelp(node.right);
		}
	}
	
	public int numOfNodes(Node node)
	{
		numOfNodesHelp(node);
		int temp = total;
		total = 0;
		return temp;
	}
	
	public void numOfLeavesHelp(Node node)
	{
		if (node != null)
		{
			numOfLeavesHelp(node.left);
			numOfLeavesHelp(node.right);
			if(node.left == null)
			{
				if(node.right == null)
				{
					leafCount += 1;
				}
				
			}
		}
	}
	
	public int numOfLeaves(Node node)
	{
		numOfLeavesHelp(node);
		int temp = leafCount;
		leafCount = 0;
		return temp;
	}
	
	public void heightLeft(Node node)
	{
		if (node != null)
		{
			leftHeight += 1;
			heightLeft(node.left);
		}
	}
	
	public void heightRight(Node node)
	{
		if (node != null)
		{
			rightHeight += 1;
			heightRight(node.right);
		}
	}
	
	public int height(Node node)
	{
		heightRight(node);
		heightLeft(node);
		int tempL = leftHeight;
		int tempR = rightHeight;
		leftHeight = 0;
		rightHeight = 0;
		if (tempL >= tempR)
		{
			return tempL;
		}
		else
		{
			return tempR;
		}
	}
	
	public boolean isAVL(Node node)
	{
		heightRight(node);
		heightLeft(node);
		int tempL = leftHeight;
		int tempR = rightHeight;
		leftHeight = 0;
		rightHeight = 0;
		if (tempL - tempR == -1)
		{
			return true;
		}
		else if(tempL - tempR == 1)
		{
			return true;
		}
		else if(tempL - tempR == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void inOrderTraverse(Node node)
	{
		if (node != null)		
		{
			inOrderTraverse(node.left);		// program will traverse left recursively until it reaches a null node
			System.out.println(node.data);	// once it is all the way left and the base case fails, it will move backwards printing each node
			inOrderTraverse(node.right);	// each time it moves backwards it will check first if there is a left node, then if there is a right
		}
	}
	
}
