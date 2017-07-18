/* Name: Eric Guan Period: 8
Name of the Lab/Assignment: Recursion Lab Part I
Purpose of the program: The purpose of the program is to have a menu-driven program that perform a variety of tasks involving int, long, and char data types recursively. These tasks are printing all characters in the alphabet to a certain letter, saying how many factors of 2 are in an integer, stating whether or not an integer is a power of 3, reversing a long, converting base 10 to base 5, and printing a long with commas between every 3 digits starting from left to right. 
Due date: 10/16/16 at midnight
Date submitted: 10/16/16 before midnight
What I learned: I learned how to work much better with recursion. Previously through the first worksheet, I had learned the logic behind using a helper method to do the recursion, but I like that this lab gave me the opportunity to learn recursion in the method itself, not through referencing a helper method. In addition, I learned more about the long data type, like how it is 64-bit as opposed to the 32-bit int. Before this lab I had never worked with the long type so it is great to work with a new data type, even if it did not affect the logic of the code. Lastly, and I think the most important, is that I reinforced my recursive logic skills. Recursion does not come easy to me, so I had to spend a good amount of time on each method just thinking about the work that each method call would do. I really, really liked that we received in class time to work on the lab, because my demanding schedule doesn’t always leave me enough time to work on labs outside of the classroom. 
How I feel about this lab: I feel like I answered a little of this in the previous question, but I thoroughly enjoyed the lab. It’s hard for me to learn information just from one time, so the repeated practice from the worksheets and the lab help a lot. 
Most difficult method: The most difficult method for me to write was the base5 method. This is because I completely forgot how to convert from base 10 to base 5, and the YouTube videos I was watching were helpful, but still did not help because the logic was different. The videos worked progressively, which is more in an iterative fashion. Because the lab is recursive, and there was nothing for me to read, I was having trouble. Luckily I received some help from Adam El Sheikh, and after that the method became much, much easier.
Who helped me: Adam El Sheikh sent me this link - http://mathcentral.uregina.ca/QQ/database/QQ.09.07/s/angela1.html to explain how to convert to base 10. I think just having the information there for me to read was much better than rewinding and rewatching YouTube videos. Once I saw the steps, the recursive logic just popped into my head and I was able to write the method with no problems. 
Who I helped: no one  */



import java.util.Scanner;   
public class RecursionLab
{
   //Pre: c is a lower case letter - Post: all lower case letters a-char c are printed 
   public static void letters(char c)
   {
      if(c=='a')
         System.out.print('a');
      else{
         letters((char)(c-1));
         System.out.print(c);  
      }   
   }
	//Pre: none - Post: returns number of times two can go into x
   public static int twos(int x)
   {
      if(x%2!=0)
         return 0;
      else
         return 1+twos(x/2);   
   }
	//Pre: none - Post: returns if x is a power of 3
   public static boolean powerof3(int x)
   {
      if(x==0)
         return false;
      if(x==1)
         return true;
      else{
         return powerof3(x/3);
      
      }      
   }
	//Pre: none - Post: returns String of x reversed 
   public static String reverse(long x)
   {
      if(x<10&&x>-10)
      {
         if(x>-10&&x<0){
            return x*-1 + "";
         }
         else
            return x+"";
      }
      else if(x<=-10){
         String result=reverse(x*-1);
         return "-" + result;
      }
      else{
         return x%10 + reverse(x/10);
      }
   }
	//Pre: x > 0 - Post: Prints x in base 5
   public static void base5(int x)
   {
      int quotient = x/5;
      int remainder=x%5;
      if(quotient==0){
         System.out.print(remainder);
         return;
      }
      else
         base5(quotient);
      System.out.print(remainder);
   }
	// Pre: x > 0 - Post: Prints x with commas
   public static void printWithCommas(long x)
   {
      String store=Long.toString(x);
      if(store.length()<=3){
         System.out.print(x);
         return;
      }
      else{
         printWithCommas(x/1000);
         System.out.print(","+store.substring(store.length()-3,store.length()));   
      }
   }
   public static void main(String []args)
   {
      Scanner scan = new Scanner (System.in);
      int choice;
      do
      {
         System.out.println("\n\n1)Letters"+
                           "\n2)Twos"+
                           "\n3)Power Of 3"+
                           "\n4)Reverse"+
                           "\n5)Base 5"+
                           "\n6)Print With Commas"+
                           "\n7)Exit");
         choice = scan.nextInt();
         if (choice == 1)
         {
            System.out.println("Enter a letter");
            char charA = scan.next().charAt(0);
            if (charA < 'a' || charA > 'z')
               System.out.println("That letter not valid");
            else
               letters(charA);
         }
         else if (choice == 2)
         {
            System.out.println("Enter a number");
            System.out.println(twos(scan.nextInt()));
         }
         else if (choice == 3)
         {
            System.out.println("Enter a number");
            int input = scan.nextInt();
            if(powerof3(input))
               System.out.println(input+" is a power of 3."+"\n");
            else
               System.out.println(input+" is not a power of 3."+"\n");   
            //System.out.println(powerof3(scan.nextInt()));
         }
         else if (choice == 4)
         {
            System.out.println("Enter a number");
            System.out.println(reverse(scan.nextLong()));
         }
         else if (choice == 5)
         {
            System.out.println("Enter a number");
            int number = scan.nextInt();
            if (number > 0)
               base5(number);
            else
               System.out.println("That number is not valid");
         }
         else if (choice == 6)
         {
            System.out.println("Enter a number");
            int number = scan.nextInt();
            if (number > 0)
               printWithCommas(number);
            else
               System.out.println("That number is not valid");
         }
      }while(choice != 7);
   }
}

/*
 
  ----jGRASP exec: java RecursionLab
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 1
 Enter a letter
 a
 a
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 1
 Enter a letter
 d
 abcd
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 1
 Enter a letter
 w
 abcdefghijklmnopqrstuvw
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 2
 Enter a number
 -12
 2
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 2
 Enter a number
 128
 7
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 2
 Enter a number
 100
 2
 
    
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 3
 Enter a number
 80
 80 is not a power of 3.
 
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 3
 Enter a number
 81
 81 is a power of 3.
 
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 3
 Enter a number
 531441
 531441 is a power of 3.
 
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 4
 Enter a number
 -21
 -12
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 4
 Enter a number
 123456
 654321
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 4
 Enter a number
 211548
 845112


 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 5
 Enter a number
 136
 1021
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 5
 Enter a number
 419
 3134
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 5
 Enter a number
 5
 10
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 6
 Enter a number
 1
 1
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 6
 Enter a number
 1000000
 1,000,000
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 6
 Enter a number
 12045670
 12,045,670
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 7
 
  ----jGRASP: operation complete.
*/