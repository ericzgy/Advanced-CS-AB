//Eric Guan

import java.util.*;
public class EricGuanPeriod8TextEditor{
   public static void main(String []args){
      Scanner console = new Scanner(System.in);
      String input = "";
      do{
         System.out.print("Enter a line of text: ");
         String s = console.nextLine();
         System.out.print("Here is the line you entered: ");
         String answer = doIt(s);
         System.out.print(answer);
         System.out.println();
         System.out.println();
         System.out.print("Again(y/n)? ");
         input = console.nextLine();
      }
      while(!(input.equals("n")));
   }
   public static String doIt(String s){
      Stack input = new Stack();
      String result="";
      for(int k = s.length()-1;k>=0;k--){
         input.push(s.substring(k,k+1));
      }
      while(!input.isEmpty()){
         result+=input.pop();
         if(result.substring(result.length()-1,result.length()).equals("-")&&result.length()>2){
            result = result.substring(0,result.length()-2);
         }
         else if(result.substring(result.length()-1,result.length()).equals("-")&&result.length()<=2){
            result="";
         }
         else if(result.substring(result.length()-1,result.length()).equals("$")){   
            result="";
         }
      }
      return result;
   }
}
/*
  ----jGRASP exec: java TextEditor
 Enter a line of text: AP$$-Compp-utee-r Sic--cei--ience
 Here is the line you entered: Computer Science
 
 Again(y/n)? y
 Enter a line of text: Ca-noe$Ra3-fx-t
 Here is the line you entered: Raft
 
 Again(y/n)? y
 Enter a line of text: Heii--ll0-o Mr.-.-. Lau--au
 Here is the line you entered: Hello Mr. Lau
 
 Again(y/n)? y
 Enter a line of text: Another $ An-noiu--t-thew-r Twq--est
 Here is the line you entered:  Another Test
 
 Again(y/n)? n
 
  ----jGRASP: operation complete.
*/