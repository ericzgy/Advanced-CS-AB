import java.util.*;
public class Infix_Shell
{
   public static void main(String[] args)
   {
      System.out.println("Enter an infix expression, single digits");
      System.out.println("such as 1+2*3 or (1+2)*3");
      Scanner keyboard = new Scanner(System.in);//  (3*(4+5)-2)/5
      String s = keyboard.next();  
      while(!s.equals("-1"))
      {
         System.out.println(s + "  -->  " + trans(s) + "  -->  " + EricGuanPeriod8Postfix.eval(trans(s)) + "\n");
         s = keyboard.next();  
      }
   }
   //pre:String x is a valid infix expression
   //post: returns the postfix notation of the entered infix expression
   public static String trans(String x)
   {
      String result = "";
      Stack<String> stack = new Stack<String>();
      for(int k=0;k<x.length();k++){
         if(Character.isDigit(x.charAt(k))){
            result+=x.charAt(k);
         }
         else if(x.charAt(k)=='('){
            stack.push(x.substring(k,k+1));
         }
         else if(x.charAt(k)==')'){
            while(!(stack.peek().equals("("))){
               String s = stack.pop();
               result+=s;
            } 
            stack.pop(); 
         }
         else{
            if(x.charAt(k)=='+'||x.charAt(k)=='-'){
               if(stack.isEmpty()){
                  stack.push(x.substring(k,k+1));
               }
               else{
                  while((!(stack.isEmpty()))&&(!(stack.peek().equals("(")))){
                     String s = stack.pop();
                     result+=s;
                  } 
                  stack.push(x.substring(k,k+1));
               }
            }
            else if(x.charAt(k)=='*'||x.charAt(k)=='/'){
               if(stack.isEmpty()){
                  stack.push(x.substring(k,k+1));
               }
               else if(isLower(stack.peek().charAt(0),x.charAt(k))){
                  stack.push(x.substring(k,k+1));
               }
               else{
                  while((!(stack.isEmpty()))&&(!(stack.peek().equals("(")))){
                     String s = stack.pop();
                     stack.push(s);
                  } 
                  stack.push(x.substring(k,k+1));
               }
            }
         }
      } 
      while(!(stack.isEmpty())){
         String s = stack.pop();
         result+=s;
      } 
      return result;
   }
   //pre:none
   //post: returns true if second char is of higher precedence than the first, false otherwise
   public static boolean isLower(char c1, char c2){
      return ((c1 == '+' || c1 == '-') && (c2 == '*' || c2 == '/'));
   }
}


/*
 
  ----jGRASP exec: java Infix_Shell
 Enter an infix expression, single digits
 such as 1+2*3 or (1+2)*3
 3+4*5
 3+4*5  -->  345*+  -->  23
 
 3*4+5
 3*4+5  -->  34*5+  -->  17
 
 (4+5)-5*3
 (4+5)-5*3  -->  45+53*-  -->  -6
 
 (3+4)*(5+6)
 (3+4)*(5+6)  -->  34+56+*  -->  77
 
 (3*(4+5)-2)/5
 (3*(4+5)-2)/5  -->  345+*2-5/  -->  5
 
 8+1*2-9/3
 8+1*2-9/3  -->  812*+93/-  -->  7
 
 -1
 
  ----jGRASP: operation complete.
 
*/