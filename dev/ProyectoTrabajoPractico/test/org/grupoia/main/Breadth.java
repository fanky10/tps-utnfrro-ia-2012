package org.grupoia.main;



public class Breadth
/* Breadth-first search
 * produces a binary search tree using Comparable
 *
 */
{
	public static void main(String[] asd)
	{
		Tree t = new Tree();
		String s = "qwertyuiop";
                //not in use?
		//int len = s.length();
		t.bst(s);
		t.infix();
		t.breadth();
		System.out.println("Breadth first search");
		System.out.println();
	}
}

class Tree
{
	private class Node
	{
		Object info;
		Node left, right;
		
		public String toString()
		{
			return "" + info;
		}
	}
	
	 private Node root;
	 
	 private Node subtree(Object obj)
	 {
	 	 Node temp = new Node();
	 	 temp.info = obj;
	 	 temp.right = null;
	 	 temp.left = null;
	 	 return temp;
	 }
	 
	 public void breadth()
	 { 
	 	//see what the hell does it do 

//	 	Node item;
//	 	if( root != null)
//	 	{
//	 		q.addNode(root);
//	 		while(!q.isEmpty() )
//	 		{
//	 			item = (Node)q.remove();
//	 			System.out.println(item);
//	 			if(item != null)
//	 			{
//	 				if(item.left != null)
//	 				{
//	 					q.addNode(item.left);
//	 				}
//	 				if(item.right != null)
//	 				{
//	 					q.addNode(item.right);
//	 				}
//	 			}
//	 		}
//	 	}
	 }

	 public void bst(String s)
	 {
	 	int len = s.length();
	 	Node p = null, q ;//p will chase q
	 	root = subtree( new Character(s.charAt(0) ) );
	 	Comparable item;
	 	char ch;
	 	for(int j = 1; j < len; j++)
	 	{
	 		q = root;
	 		ch = s.charAt(j);
	 		item = new Character(ch);
	 		while(q != null)
	 		{
	 			p = q;
	 			if(item.compareTo(q.info) > 0 )
	 			{
	 				q = q.right;
	 			}
	 			else
	 			{
	 				q = q.left;
	 			}
	 		}//q = null, now insert node to p.left or p.right
	 		if(item.compareTo(p.info) > 0)
	 		{
	 			p.right = subtree(item);
	 		}
	 		else
	 		{
	 			p.left = subtree(item);
	 		}
	 	}
	 }
	 
	 public void infix()
	 {
	 	infix(root);
	 	System.out.println();	 		
	 }
	 	
	 private void infix(Node t)
	 {
	 	if(t != null)
	 	{
	 	    infix(t.left);
	 		System.out.print(t);
	 		infix(t.right);
	 	}
	 }
}
	 						
	 		
	 	 
	 