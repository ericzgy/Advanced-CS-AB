//Name: Eric Guan     Date: 1/6/17
import java.util.*;
//Name of the Lab: BXT Lab
//Purpose of the program: to create a program that can take any String input with numbers and operators, and convert that into
//                       a Binary Expression Tree, and then display it normally as well as in pre and in order. The program
//                       can also evaluate the expressions to get a number.
//Due date: today
//When i submitted: today
//What I learned: I learned how to work much better with Binary Expression Trees, and improved my skills with recursively 
//               managing trees
//How I feel about this lab: I enjoyed this lab; I didn't find it too challenging, and when I finished everything i felt 
//                          a great sense of accomplishment. I worked on it in class which gave me a good head start at home,
//                          and I feel that the lab sufficiently prepared me for any BXT problems that may be on the test.
//The credits: I asked James Zhang, and Oakton Alumni who is a freshman at Virginia Tech, to explain the concept of Binary
//            Expression Trees to me. He explained more in depth and helped me with the logic of my code. 
// Who I helped: no one

 	/***********************************
	Represents a binary expression tree.
	The BXT can build itself from a postorder expression.  It can
	evaluate and print itself. It also prints an inorder string and a preorder string.  
	************************************/
public class EricGuan8thPeriodBXTLab
{
   private int count;
   private TreeNode root;
   
   public EricGuan8thPeriodBXTLab()
   {
      count = 0;
      root = null;
   }
   public EricGuan8thPeriodBXTLab(Object obj)
   {
      count = 1;
      root = new TreeNode(obj, null, null);
   }
      /***********************
   	Builds a BXT from a postfix expression.  Uses a helper stack of TreeNodes.
   	****************************/
   public void buildTree(String str)
   {
      StringTokenizer st = new StringTokenizer(str);
      Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode node = null;
      while (st.hasMoreTokens())
      {
         String next = st.nextToken();
         if (isOperator(next))
         {
            node = new TreeNode(next);
            node.setRight(stack.pop());
            node.setLeft(stack.pop());
            stack.push(node);
         }
         else
            stack.push(new TreeNode(next));
      }
      root = node;
   }
   public double evaluateTree()
   {
      return evaluateNode(root);
   }
   private double evaluateNode(TreeNode root)  //recursive
   {
      if (isOperator(root.getValue().toString()))
      {
         return computeTerm(root.getValue().toString(), evaluateNode(root.getLeft()), evaluateNode(root.getRight()));
      }
      else
      {
         return Double.parseDouble(root.getValue().toString());
      }   }
   private double computeTerm(String s, double a, double b)
   {
      double result = 0;
      if(s.equals("+"))
         result=a+b;
      else if(s.equals("-"))
         result=a-b;   
      else if(s.equals("*"))
         result=a*b;
      else
         result=a/b;      
      return result;
   }
   private boolean isOperator(String s)
   {
      boolean result = false;
      if(s.equals("-")||s.equals("+")||s.equals("*")||s.equals("/"))
         result = true;
      return result;
   }
   public void display(){
      display(root,0);
   }
   private static void display(TreeNode t, int level)
   {
      if(t == null)
         return;
      display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         System.out.print("\t");
      System.out.println(t.getValue());
      display(t.getLeft(), level + 1); //recurse left
   }
   public  void inorderTraverse(){
      inorderTraverse(root);
   } 
   public static void inorderTraverse(TreeNode t){
      if(t==null)
         return;
      else{
         inorderTraverse(t.getLeft());
         System.out.print(t.getValue());
         inorderTraverse(t.getRight());
      }   
   }
   public void preorderTraverse(){
      preorderTraverse(root);
   }
   public static void preorderTraverse(TreeNode t)
   {
      if(t == null)
         return;
      System.out.print(t.getValue());  //preorder visit
      preorderTraverse(t.getLeft());         //recurse left
      preorderTraverse(t.getRight());        //recurse right
   }
}

/*


  ----jGRASP exec: java BXT_shell
 Input postfix string:  14 -5 /
 	-5
 /
 	14
 Infix order:  14/-5
 Prefix order:  /14-5
 Evaluates to -2.8
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java BXT_shell
 Input postfix string:   3 4 5 + *
 		5
 	+
 		4
 *
 	3
 Infix order:  3*4+5
 Prefix order:  *3+45
 Evaluates to 27.0
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java BXT_shell
 Input postfix string:   2 3 + 5 / 4 5 - *
 		5
 	-
 		4
 *
 		5
 	/
 			3
 		+
 			2
 Infix order:  2+3/5*4-5
 //Prefix order:  *///+235-45
 //Evaluates to -1.0
 // ----jGRASP: operation complete.
 
 /*
 NOTE TO MR LAU: The output became difficult withthe comments on the last one, so feel free to run the last one over again, 
 I promise that it works, I had to add extra comments or else the code would not compile!!!
 
*/