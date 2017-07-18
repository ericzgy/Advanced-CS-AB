//Name: Eric Guan
//Date: 2/20/17
// What I learned: I learned how to work with Sets better, as well as the logic required to solve this lab. As a note, when
//                googling how to use Iterator to traverse a Set, I came across the for-each loop way, and wanted to try it.
                //in this specific instance it proved to be effective, but I also learned the Iterator way in case of future
                //assessements or labs without easy data types such as char.
// How I feel about this lab: I am quite pleased with this assignment. I'm thankful for the long weekend, because it provided me
                            //with plenty of time to ponder and figure out this lab. It took me a while as always, but I eventually
                            //figured it out by myself. The only help that I received was from the website that showed me that
                            //for-each loops can be used to traverse Sets. This is the second lab in a row that I did with no outside
                            //help, and I hope to continue this trend moving ahead into third and fourth quarter. :)
// What I wonder: I wonder how to write a similarly efficient class without using the Set data structure
// Question:  If Java didn't implement Sets, how would you solve this programming problem?  Be creative!
//I would use ArrayList, but have a method that sorts alphabetically the ArrayList after putting the characters in, so that
//when I see which characters are in every list later on, it is easier
import java.util.*;
import java.io.*;
public class EricGuan8thPeriodSetsOfLetters
{
   public static void main(String[] args) throws FileNotFoundException
   {
        // for each line read, convert the String to a character array by using toCharArrays() of String class
        // need to create 3 sets of Character:  lower case, upper case, punctuation marks
        
        // for each character in each line, check if it is a letter (use Character.isLetter() 
        //AND lower case (use Character.isLowerCase()
        //                                                                                                                                                  upper case  (use Character.isUpperCase()
        //    punctwise, it is a punctuation mark put each to its corresponding set.
        // 
        // Need to check the common characters in each group:  lower, upper, punctuation marks.
        // You need to use an iterator to iterate over each set.  You might need to use the contains
        // and remove methods of Set.
   
      Scanner console = new Scanner(new File("Declaration.txt"));
      //ArrayLists to store characters for comparison later
      ArrayList<Character> upperStore = new ArrayList<Character>();
      ArrayList<Character> lowerStore = new ArrayList<Character>();
      ArrayList<Character> punctStore = new ArrayList<Character>();
      //if statement then while loop to put characters in the store ArrayList before making comparisons later on
      if(console.hasNextLine()){
         Set<Character> upper = new TreeSet<Character>();
         Set<Character> lower = new TreeSet<Character>();
         Set<Character> punct = new TreeSet<Character>();        
         String input = console.nextLine();
         char[] a = input.toCharArray();
         for(int k = 0; k<a.length; k++){
            if(Character.isLetter(a[k])){
               if(Character.isUpperCase(a[k]))
                  upper.add(a[k]);
               else
                  lower.add(a[k]);
            } 
            else
               punct.add(a[k]);
         }
         System.out.println("" + input);
         System.out.print("Lower case:");
         for(char c : lower){
            System.out.print(" " + c);
            lowerStore.add(c);
         }
         System.out.println("");
         System.out.print("Upper case:");
         for(char c : upper){
            System.out.print(" " + c);
            upperStore.add(c);
         }
         System.out.println("");
         System.out.print("Punct:");
         for(char c : punct){
            System.out.print(" " + c);
            punctStore.add(c);
         }
         System.out.println("");
         System.out.println("");
      }
      while(console.hasNextLine()){
         Set<Character> upper = new TreeSet<Character>();
         Set<Character> lower = new TreeSet<Character>();
         Set<Character> punct = new TreeSet<Character>();
         String input = console.nextLine();
         char[] b = input.toCharArray();
         for(int k = 0; k<b.length; k++){
            if(Character.isLetter(b[k])){
               if(Character.isUpperCase(b[k]))
                  upper.add(b[k]);
               else
                  lower.add(b[k]);
            } 
            else
               punct.add(b[k]);
         }
      
         System.out.println("" + input);
         System.out.print("Lower case:");
         for(char c : lower){
            System.out.print(" " + c);
         }
         System.out.println("");
         System.out.print("Upper case:");
         for(char c : upper){
            System.out.print(" " + c);
         }
         System.out.println("");
         System.out.print("Punct:");
         for(char c : punct){
            System.out.print(" " + c);
         }
         System.out.println("");
         System.out.println("");
         for(int k = 0; k<lowerStore.size(); k++){
            boolean a = false;        
            for(char i: lower){
               if(Character.compare(lowerStore.get(k), i) == 0){
                  a = true;
                  break;
               }
            }
            if(a == false)
               lowerStore.remove(k);
         }
         //for(char d: upperStore)
         for(int k = 0; k<upperStore.size(); k++){
            boolean a = false;
         
            for(char i: upper){
               if(Character.compare(upperStore.get(k), i) == 0){
                  a = true;
                  break;
               }
            }
            if(a == false)
               upperStore.remove(k);
         }
         for(int k = 0; k<punctStore.size(); k++){
            boolean a = false;
            for(char i: punct){
               if(Character.compare(punctStore.get(k), i) == 0){
                  a = true;
                  break;
               }
            }
            if(a == false)
               punctStore.remove(k);
         }
      }
      System.out.println("CHARACTERS IN EVERY LINE:");
      System.out.print("Lower case:");
      for(char a : lowerStore){
         System.out.print(" " + a);
      }
      System.out.println("");
      System.out.print("Upper case:");
      for(char a : upperStore){
         System.out.print(" " + a);
      }
      System.out.println("");
      System.out.print("Punct:");
      for(char a : punctStore){
         System.out.print(" " + a);
      }
   }
}



/*
  ----jGRASP exec: java EricGuan8thPeriodSetsOfLetters
 We, therefore, the Representatives of the united States of 
 Lower case: a d e f h i n o p r s t u v
 Upper case: R S W
 Punct:   ,
 
 America, in General Congress, Assembled, appealing to the 
 Lower case: a b c d e g h i l m n o p r s t
 Upper case: A C G
 Punct:   ,
 
 Supreme Judge of the world for the rectitude of our intentions,
 Lower case: c d e f g h i l m n o p r s t u w
 Upper case: J S
 Punct:   ,
 
 do, in the Name, and by the Authority of the good People of 
 Lower case: a b d e f g h i l m n o p r t u y
 Upper case: A N P
 Punct:   ,
 
 these Colonies, solemnly publish and declare, That these United 
 Lower case: a b c d e h i l m n o p r s t u y
 Upper case: C T U
 Punct:   ,
 
 Colonies are, and of Right ought to be Free and Independent 
 Lower case: a b d e f g h i l n o p r s t u
 Upper case: C F I R
 Punct:   ,
 
 States; that they are Absolved from all Allegiance to the 
 Lower case: a b c d e f g h i l m n o r s t v y
 Upper case: A S
 Punct:   ;
 
 British Crown, and that all political connection between them 
 Lower case: a b c d e h i l m n o p r s t w
 Upper case: B C
 Punct:   ,
 
 and the State of Great Britain, is and ought to be totally 
 Lower case: a b d e f g h i l n o r s t u y
 Upper case: B G S
 Punct:   ,
 
 dissolved; and that as Free and Independent States, they have 
 Lower case: a d e h i l n o p r s t v y
 Upper case: F I S
 Punct:   , ;
 
 full Power to levy War, conclude Peace, contract Alliances, 
 Lower case: a c d e f i l n o r s t u v w y
 Upper case: A P W
 Punct:   ,
 
 establish Commerce, and to do all other Acts and Things which 
 Lower case: a b c d e g h i l m n o r s t w
 Upper case: A C T
 Punct:   ,
 
 Independent States may of right do. And for the support of this 
 Lower case: a d e f g h i m n o p r s t u y
 Upper case: A I S
 Punct:   .
 
 Declaration, with a firm reliance on the protection of divine 
 Lower case: a c d e f h i l m n o p r t v w
 Upper case: D
 Punct:   ,
 
 Providence, we mutually pledge to each other our Lives, our 
 Lower case: a c d e g h i l m n o p r s t u v w y
 Upper case: L P
 Punct:   ,
 
 Fortunes and our sacred Honor.
 Lower case: a c d e n o r s t u
 Upper case: F H
 Punct:   .
 
 CHARACTERS IN EVERY LINE:
 Lower case: d e n o r t
 Upper case:
 Punct:  
  ----jGRASP: operation complete.
 
*/