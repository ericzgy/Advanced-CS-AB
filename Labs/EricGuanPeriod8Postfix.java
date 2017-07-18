//  Eric Guan Period 8
//
//  Postfix Expression Lab
//
//  The purpose of the program is to take in a simple String that consists of only single digit positive integers or operators 
// in the postfox notation, evaluate it, and return the result through the Stack data structure
//
//  Due date: 11/17/16 at 11:59 pm Date submitted: 11/17/16 sometime before 11:59
//
//  What I learned: I learned how to use the Integer.parseInt() method while solidying my knowledge of Stacks
//
//  How I feel about this lab: I didn't mind this lab at all; it was very doable and I finished it in less then 30 minutes
//
//  Most difficult method: I didn't find any of the methods particularly difficult, however I initially struggle a little with
// the eval(String x) method because I was unsure whether I should make the stack of type Integer or type String.
//
//  Who helped me: Jonathan Wen from 6th period clarified how both eval methods should work. He told me that the second one 
// is the method that actually does the computations, while the first calls the second and has the Stack and iteration
//
//  Who I helped: no one
import java.util.*;
public class EricGuanPeriod8Postfix
{
   public static void main(String[] args)
   {
      System.out.println("Enter a valid postfix expression (single digits only),");
      System.out.println("such as 35*1+");
      Scanner keyboard = new Scanner(System.in);
      String s = keyboard.next();  
      while(!s.equals("-1"))
      { 
         System.out.println(s + "  --->  " + eval(s) + "\n");
      // //        System.out.println((s = "354*+7*") + " = " + eval(s) + "\n");
      // //          System.out.println((s = "82-") + " = " + eval(s) + "\n");
      // //          System.out.println((s = "82/") + " = " + eval(s) + "\n");
         s = keyboard.next();
      }
   }
   public static int eval(String x)
   {
      Stack<Integer> stack = new Stack<Integer>();
      for(int k=0;k<x.length();k++){
         if(!(isOperator(x.charAt(k)))){
            stack.push(Integer.parseInt(x.substring(k,k+1)));
         }
         else if(isOperator(x.charAt(k))){
            int a=stack.pop();
            int b=stack.pop();
            int evalResult=eval(a,b,x.charAt(k));
            stack.push(evalResult);
         }
      }
      return stack.pop();
   }
   public static int eval(int a, int b, char ch)
   {
      int result=0;
      if(ch=='+')
         result=a+b;
      else if(ch=='-')
         result=b-a;
      else if(ch=='*')
         result=a*b;
      else if(ch=='/')
         result=b/a;
      return result;            
   }
   public static boolean isOperator(char ch)
   {
      if(ch=='*'||ch=='/'||ch=='+'||ch=='-')
         return true;
      else
         return false;        
   }
}

/*
  ----jGRASP exec: java EricGuanPeriod8Postfix
 Enter a valid postfix expression (single digits only),
 such as 35*1+
 345*+
 345*+  --->  23
 
 34*5+
 34*5+  --->  17
 
 45+53*-
 45+53*-  --->  -6
 
 34+56+*
 34+56+*  --->  77
 
 345+*2-5/
 345+*2-5/  --->  5
 
 812*+93/-
 812*+93/-  --->  7
 
 -1
 
  ----jGRASP: operation complete.
 
*/