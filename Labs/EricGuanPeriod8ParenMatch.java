//  Name: Eric Guan
//  Date: 15 November 2016
//  Period: 8
//  What I Learned: I learned how to work with stacks much better; I had never used the peek() or isEmpty() methods
// so it's good that I got this chance to familiarize myself with them. In addition, I became more familiar with the 
// String class. This was the first time I have ever used charAt, and I also experimented with CharSequence and the 
// contains method for this lab. While I did not use the CharSequence interface or the contains method in the end, 
// I still feel as though I benefited from trying it. 
//  How I feel about this lab: I have positive feelings regarding this assignment. I very much apreciated the 
// opportunity to work on the lab in class expecially. I asked Adam to clarify for me the popping and peeking of 
// stacks and was able to fnish half of the lab before I got home. As for the lab itself, I enjoyed it because it 
// was a simple assignment that reinforced the Stack and String concepts. 
//  Who helped me: Adam El Sheikh, as mentioned above
//  Who I helped: no one
import java.util.*;
public class EricGuanPeriod8ParenMatch
{
   public static final String LEFT  = "([{<";
   public static final String RIGHT = ")]}>";
   public static void main(String[] args)
   {
   
      System.out.println("Enter an expression with grouping symbols,");
      System.out.println("such as (2+3)-[5*(6+1)]IndexMals");
      Scanner keyboard = new Scanner(System.in);
      String s = keyboard.next();  
      while(!s.equals("-1"))
      {
         boolean flag = check(s);
         if(flag)
            System.out.println(s + " is good.");
         else
            System.out.println("No, no, no.  Bad.  " + s);
         System.out.println();
         s = keyboard.next();
      }
   }
   // precondition:none
   // postcondition:returns true if the parentheses match with each other, false otherwise
   public static boolean check(String s)
   {
      boolean result=true;
      Stack<String> stack = new Stack<String>();
      for(int k=0;k<s.length();k++){
         if(LEFT.indexOf(s.charAt(k))!=-1){
            stack.push(s.substring(k,k+1));
         }
         if(RIGHT.indexOf(s.charAt(k))!=-1){
            String temp=s.substring(k,k+1);
            int index=RIGHT.indexOf(temp);
            if((!(stack.isEmpty()))&&(stack.peek().equals(LEFT.substring(index,index+1)))){
               stack.pop();
            }
            else
               return false;
         }
      }  
      if(!(stack.isEmpty())){
         result=false;
      }
      return result;
   }
}

/*
  ----jGRASP exec: java ParenMatch_Shell
 Enter an expression with grouping symbols,
 such as (2+3)-[5*(6+1)]IndexMals
 ((5+7)*3
 No, no, no.  Bad.  ((5+7)*3
 
 [(5+7]*3)
 No, no, no.  Bad.  [(5+7]*3)
 
 [(5+7)*3])
 No, no, no.  Bad.  [(5+7)*3])
 
 ([(5+7)*3]
 No, no, no.  Bad.  ([(5+7)*3]
 
 )5+7(
 No, no, no.  Bad.  )5+7(
 
 (5+7)
 (5+7) is good.
 
 ((5+7)*3)
 ((5+7)*3) is good.
 
 [(5+7)*]3
 [(5+7)*]3 is good.
 
 <{5+7}*3>
 <{5+7}*3> is good.
 
 (5+7)*3
 (5+7)*3 is good.
 
 5+(7*3)
 5+(7*3) is good.
 
  5+7
 5+7 is good.
 
 -1
 
  ----jGRASP: operation complete.
*/