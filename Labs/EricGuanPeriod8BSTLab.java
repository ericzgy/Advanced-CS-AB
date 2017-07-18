/*
Name: Eric Guan   Period: 8
Name of the lab/assignment: BST Lab
Purpose of the program: The purpose of the program is to take in a String, then separate that String by character
into a Binary Search Tree. The program can do a variety of tasks to this tree, such as display it sideways, find
the min/max or a specific value, and print from smallest value to largest value.
Due Date: 12/15/16 at 11:59 pm    Date submitted: some time before the due date 
What I learned: I learned a a little more about messing around with Binary Trees. I definitely like this data structure
because of how it is already sorted, it makes the methods very logical and fun to write. This lab built on what I already
learned from the Tree Lab and helped to reinforce my knowledge. 
How I feel about the lab: I have positive feelings about this lab, because it was not that challenging.
Who helped me: Adam El Sheikh, at first I did not know how to construct the tree in the main method, however he responded with
"dude, just use a for loop." After that, I figured it out and also looked at the Tree Lab to understand how to write main.
Who I helped: no one
*/






import java.util.Scanner;
	/****************************************************************
	Practice with a Binary Search Tree. Uses TreeNode.
    Prompt the user for an input string.  Build a Binary Search Tree 
	using Comparables.  Display it as a sideways tree (take the code 
	from the Tree Lab).  Prompt the user for a target and search the tree 
	for it.  Display the tree's minimum and maximum values.  Print 
	the data in order from smallest to largest.
	*****************************************************************/
public class EricGuanPeriod8BSTLab
{
   public static void main(String[] args)
   {
          // your code goes here
      Scanner console = new Scanner(System.in);
      String s = console.next();
      TreeNode root = new TreeNode("" + s.charAt(0), null, null);
      for(int pos = 1; pos < s.length(); pos++)
         insert(root, "" + s.charAt(pos));
      display(root,0);
      System.out.print("Target: ");
      String target = console.next();
      if(find(root,target))
         System.out.println("Target is in tree");
      else
         System.out.println("Target is not in tree"); 
      System.out.println("Max: " + max(root));
      System.out.println("Min: " + min(root));
      smallToLarge(root);     
   }
      
   	/****************************************************************
   	Recursive algorithm to build a BST:  if the node is null, insert the 
   	new node.  Else, if the item is less, set the left node and recur to 
   	the left.  Else, if the item is greater, set the right node and recur 
   	to the right.   
   	*****************************************************************/
   public static TreeNode insert(TreeNode t, String s)
   {  	
      if(t==null)
         return new TreeNode(s);
      int compare = s.compareTo((String)t.getValue());
      if(compare<0)
         t.setLeft(insert(t.getLeft(),s));
      else if(compare>0)
         t.setRight(insert(t.getRight(),s));
      return t;         
   }
   public static void display(TreeNode t, int level)
   {
      if(t == null)
         return;
      display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         System.out.print("\t");
      System.out.println(t.getValue());
      display(t.getLeft(), level + 1); //recurse left
   }
   	
     /***************************************************************
      Iterative algorithm:  create a temporary pointer p at the root.  
   	While p is not null, if the p's value equals the target, return true.  
   	If the target is less than the p's value, go left, otherwise go right.   
   	If the target is not found, return false. 
      
   	Find the target. Recursive algorithm:  If the tree is empty, 
   	return false.  If the target is less than the current node 
   	value, return the left subtree.  If the target is greater, return 
   	the right subtree.  Otherwise, return true.   
   . ****************************************************************/    
   public static boolean find(TreeNode t, Comparable x)
   {
      TreeNode p = t;
      while(p!=null){
         String compareT = (String)t.getValue();
         int compare = compareT.compareTo((String)x);
         if(compare==0)
            return true;
         else if(compare>0)
            t=t.getLeft();
         else if(compare<0)
            t=t.getRight();
      }
      return false;        
   }
   
     /***************************************************************
   	starting at the root, return the min value in the BST.   
   	Use iteration.   Hint:  look at several BSTs. Where are 
   	the min values always located?  
   	***************************************************************/
   public static Object min(TreeNode t)
   {
      TreeNode temp = t;
      while(temp.getLeft()!=null){
         temp=temp.getLeft();
      }
      return temp.getValue();
   }
   /*****************************************************************
   	starting at the root, return the max value in the BST.  
   	Use recursion!
    *****************************************************************/
   public static Object max(TreeNode t)
   {
      TreeNode temp = t;
      while(temp.getRight()!=null){
         temp=temp.getRight();
      }
      return temp.getValue();
   }
   public static void smallToLarge(TreeNode t)
   {
      if(t!=null){
         smallToLarge(t.getLeft());
         System.out.print(" " + t.getValue());
         smallToLarge(t.getRight());
      }    
   }
}  //end of class

/*
  ----jGRASP exec: java BinarySearchTree_SHELL
 362814
 		8
 	6
 		4
 3
 	2
 		1
 Target: 2
 Target is in tree
 Max: 8
 Min: 1
  1 2 3 4 6 8
  ----jGRASP: operation complete.
  
      
  ----jGRASP exec: java BinarySearchTree_SHELL
 15283946
 			9
 		8
 			6
 	5
 				4
 			3
 		2
 1
 Target: 6
 Target is in tree
 Max: 9
 Min: 1
  1 2 3 4 5 6 8 9
  ----jGRASP: operation complete.
  
*/