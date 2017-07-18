/** Name: Eric Guan      Period: 8
Name of the lab/assignment: Josephus Lab Assignment
Purpose of the program: The purpose of the program is to read a file containing numbers, and then to insert them in to a linked list. It then takes an index, and removes the node at that index until there is only one node left. The numerical value of that node indicates the index of the node that will be left at the end. The program will then read another file, this time of names, and put them into a new linked list. Using the winning index, the program will set that node to the object, so when the values are removed from the new linked list the program will return the winner: Josephus!
Due Date: October 11th 2016
Date Submitted: October 11th, left sick 
What I learned: I learned how to work with Circular Singly Linked Lists much better. I thought that I had a good grasp on just Singly Linked Lists, however as I began the lab I found myself very confused, especially with implementing the main method. However, I moved past my mistakes, and through countless hours debugging each and every method using the canvas feature, I think that I have a better understanding of the internal representation of circular linked lists, as well as methods needed to modify singly linked lists.
How I feel about the lab: My feelings about this lab are generally positive. I did have some trouble understanding the directions when I first started, but once I started coding I figured it out, and I can only blame myself since I was talking in class. Looking back, I wish that I had used my classroom time in a more efficient manner so that my time at home could be better spent on other subjects rather than spending most of a 4 day weekend on a cs lab. Nevertheless, I don’t feel that the lab was tremendously bad, and I think that for people with a decent understanding of CSLL, it would have been easy. For people like myself who’s understanding was a little shaky, I like that the lab helped us reinforce our knowledge through first hand experience.
Most difficult method: Believe it or not, I struggled the most with the main method. My methodology for the lab was to write all of the other methods, then return to implement the main method and test it. However, when I was done with the other programs I found that I was completely confused on what to do. Thankfully, Adam El Sheikh explained the fundamentals of what the lab should do. In addition, he taught me how to use the infile.nextInt(); and infile.nextLine();. That little bit of knowledge helped me to finish defining the rest of the lab.
Who helped me: Michele Wang helped me with the logic of the remove method. The biggest help to me was Adam El Sheikh. While he did not provide any code, his way of explaining how the code to function inspired confidence in myself. Just explaining a certain part was enough to make me understand how the entire chunk would work. In addition, his calm disposition helped to calm me down when I was distressed about a certain part not working. He even checked up on me from time to time, just to make sure that I wasn’t too stressed about the lab. I believe his support was crucial to my success in this lab.  **/


import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
	
public class Josephus_shell
{
   public static void main(String[] args) throws FileNotFoundException
   {
       // Ask the user how many names are needed to play the game
      int size = Integer.parseInt(JOptionPane.showInputDialog("How many names (2-20)?"));
      Scanner infile = new Scanner(new File("numbers.txt"));
      
      // Create the circular linked list by using the insert method, head is p
      // your code goes here ...    
      // declare and initialize p (the head of the circular list here
      ListNode pointer = new ListNode(infile.nextInt(),null);
      for(int k=2;k<=size;k++){  
         insert(pointer,k);
      }
      print(pointer);
       // ask for the value of n before playing the game
      int n = Integer.parseInt(JOptionPane.showInputDialog("Enter the nth term."));
       
      // start playing the game by using the remove method
      for(int k=size;k>1;k--){
         pointer=remove(pointer,n);
      }
      int answer=(int)(pointer.getValue());
      // Second part of the lab: dealing with names.  This part is
      // very much like the first part.  Create a circular singly linked
      // list with names stored in each node.
      // Note: need to replace the "winner" node with the name 
      //           "Josephus"
      System.out.println("\n ****  Now start all over.  *** \n");
    //*************************************************************  
      size = Integer.parseInt(JOptionPane.showInputDialog("How many names (2-20)?"));
      Scanner console = new Scanner(new File("j_names.txt"));
       // reset p here and the counter to 0
      pointer=null;
      pointer=new ListNode(console.nextLine(),null);
      for(int k=2;k<=size;k++){  
         insert(pointer,console.nextLine());
      }
      print(pointer);
      replaceAt(pointer,"Josephus",answer);
      n = Integer.parseInt(JOptionPane.showInputDialog("Enter the nth term."));
      for(int k=size;k>1;k--){
         pointer=remove(pointer,n);
      }
      System.exit(0);
   }  // end of main





    //**************************  Methods *******************************
    //pre: none
    // post: a node has been created and inserted into the Circular Linked List
   private static ListNode insert(ListNode p, Object obj)
   {
      if(p==null){
         ListNode putIn = new ListNode(obj,p);
         p.setNext(putIn);
      }
      else{
         ListNode putIn = new ListNode(obj,p);
         for(;p!=null;p=p.getNext()){
            if(p.getNext()==null || p.getNext().getValue().equals(1)|| p.getNext().getValue().equals("Michael")){
               p.setNext(putIn);
               break;
            }
         }
      }
      return p;
   }  // end of insert


  // prints the circular linked list.   
  //pre: none
  //post:the method prints out every value inside the array 
   public static void print(ListNode p)
   {
      if(p == null)
      {
         System.out.println("[]");
         return;
      }  
      else{
         ListNode temp = p; 	
         for(;temp!=null;temp=temp.getNext()){
            if(temp.getNext()==p){
               System.out.print(temp.getValue() + " ");
               break;
            }  
            System.out.print(temp.getValue() + " ");
         }
         System.out.println("");
      }
      //  your code goes here
   } // end of print

   // pre:p is not an empty(null) ListNode
   //post: removes the node p after counting n nodes.
   private static ListNode remove(ListNode p, int n)
   {
      if(n==1){
         ListNode temp=p;
         while(temp.getNext()!=p){
            temp=temp.getNext();
         }
         p=temp;
         p.setNext(p.getNext().getNext());
      }
      else{
         for(int k=1;k<n-1;k++){
            p=p.getNext();
         }
         p.setNext(p.getNext().getNext());
         p = p.getNext();
      }
      print(p);
      return p;
   }
  // end of remove	
   //pre:p is not null and pos is an index in the linked list
   //post: replaces the value (the string) at the winning node.
   private static void replaceAt(ListNode p, Object obj, int pos)
   {
      for(int k=0;k<pos-1;k++){
         p=p.getNext();
      }
      p.setValue(obj);
   }  // end of replaceAt
} // end of Josephus_shell

/*
 
  ----jGRASP exec: java -Xnoagent -Djava.compiler=NONE -Xdebug -Xrunjdwp:transport=dt_socket,suspend=y,server=y Josephus_shell
  ----jGRASP: connected to debugger.
 1 2 3 4 5 
 3 4 5 1 
 5 1 3 
 3 5 
 3 
 
  ****  Now start all over.  *** 
 
 Michael Hannah Jacob Ruth Matthew
 Josephus Ruth Matthew Michael 
 Matthew Michael Josephus 
 Josephus Matthew 
 Josephus 
 
  ----jGRASP: operation complete.
  
       ----jGRASP exec: java Josephus_shell
 1 2 3 4 5 
 5 1 2 3 
 5 1 2 
 1 2 
 1 
 
  ****  Now start all over.  *** 
 
 Michael Hannah Jacob Ruth Matthew 
 Matthew Josephus Hannah Jacob 
 Matthew Josephus Hannah 
 Josephus Hannah 
 Josephus 
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java Josephus_shell
 1 2 3 4 5 
 3 4 5 1 
 5 1 3 
 3 5 
 3 
 
  ****  Now start all over.  *** 
 
 Michael Hannah Jacob Ruth Matthew 
 Josephus Ruth Matthew Michael 
 Matthew Michael Josephus 
 Josephus Matthew 
 Josephus 
 
  ----jGRASP: operation complete.
    ----jGRASP exec: java Josephus_shell
 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 
 13 14 15 16 17 18 19 20 1 2 3 4 5 6 7 8 9 10 11 
 5 6 7 8 9 10 11 13 14 15 16 17 18 19 20 1 2 3 
 18 19 20 1 2 3 5 6 7 8 9 10 11 13 14 15 16 
 11 13 14 15 16 18 19 20 1 2 3 5 6 7 8 9 
 6 7 8 9 11 13 14 15 16 18 19 20 1 2 3 
 1 2 3 6 7 8 9 11 13 14 15 16 18 19 
 18 19 1 2 3 6 7 8 9 11 13 14 15 
 15 18 19 1 2 3 6 7 8 9 11 13 
 15 18 19 1 2 3 6 7 8 9 11 
 18 19 1 2 3 6 7 8 9 11 
 1 2 3 6 7 8 9 11 18 
 6 7 8 9 11 18 1 2 
 11 18 1 2 6 7 8 
 7 8 11 18 1 2 
 7 8 11 18 1 
 11 18 1 7 
 11 18 1 
 11 18 
 11 
 
  ****  Now start all over.  *** 
 
 Michael Hannah Jacob Ruth Matthew Elizabeth Josiah Jesse Elisha Sarah Elijah David Israel Leah Meshach Abednego Joshua Rebecca Daniel Eleazar 
 Israel Leah Meshach Abednego Joshua Rebecca Daniel Eleazar Michael Hannah Jacob Ruth Matthew Elizabeth Josiah Jesse Elisha Sarah Josephus 
 Matthew Elizabeth Josiah Jesse Elisha Sarah Josephus Israel Leah Meshach Abednego Joshua Rebecca Daniel Eleazar Michael Hannah Jacob 
 Rebecca Daniel Eleazar Michael Hannah Jacob Matthew Elizabeth Josiah Jesse Elisha Sarah Josephus Israel Leah Meshach Abednego 
 Josephus Israel Leah Meshach Abednego Rebecca Daniel Eleazar Michael Hannah Jacob Matthew Elizabeth Josiah Jesse Elisha 
 Elizabeth Josiah Jesse Elisha Josephus Israel Leah Meshach Abednego Rebecca Daniel Eleazar Michael Hannah Jacob 
 Michael Hannah Jacob Elizabeth Josiah Jesse Elisha Josephus Israel Leah Meshach Abednego Rebecca Daniel 
 Rebecca Daniel Michael Hannah Jacob Elizabeth Josiah Jesse Elisha Josephus Israel Leah Meshach 
 Meshach Rebecca Daniel Michael Hannah Jacob Elizabeth Josiah Jesse Elisha Josephus Israel 
 Meshach Rebecca Daniel Michael Hannah Jacob Elizabeth Josiah Jesse Elisha Josephus 
 Rebecca Daniel Michael Hannah Jacob Elizabeth Josiah Jesse Elisha Josephus 
 Michael Hannah Jacob Elizabeth Josiah Jesse Elisha Josephus Rebecca 
 Elizabeth Josiah Jesse Elisha Josephus Rebecca Michael Hannah 
 Josephus Rebecca Michael Hannah Elizabeth Josiah Jesse 
 Josiah Jesse Josephus Rebecca Michael Hannah 
 Josiah Jesse Josephus Rebecca Michael 
 Josephus Rebecca Michael Josiah 
 Josephus Rebecca Michael 
 Josephus Rebecca 
 Josephus 
 
  ----jGRASP: operation complete.
  
       ----jGRASP exec: java Josephus_shell
 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
 10 11 12 13 14 15 1 2 3 4 5 6 7 8 
 4 5 6 7 8 10 11 12 13 14 15 1 2 
 14 15 1 2 4 5 6 7 8 10 11 12 
 10 11 12 14 15 1 2 4 5 6 7 
 6 7 10 11 12 14 15 1 2 4 
 4 6 7 10 11 12 14 15 1 
 4 6 7 10 11 12 14 15 
 6 7 10 11 12 14 15 
 10 11 12 14 15 6 
 14 15 6 10 11 
 11 14 15 6 
 14 15 6 
 14 15 
 15 
 
  ****  Now start all over.  *** 
 
 Michael Hannah Jacob Ruth Matthew Elizabeth Josiah Jesse Elisha Sarah Elijah David Israel Leah Meshach 
 Sarah Elijah David Israel Leah Josephus Michael Hannah Jacob Ruth Matthew Elizabeth Josiah Jesse 
 Ruth Matthew Elizabeth Josiah Jesse Sarah Elijah David Israel Leah Josephus Michael Hannah 
 Leah Josephus Michael Hannah Ruth Matthew Elizabeth Josiah Jesse Sarah Elijah David 
 Sarah Elijah David Leah Josephus Michael Hannah Ruth Matthew Elizabeth Josiah 
 Elizabeth Josiah Sarah Elijah David Leah Josephus Michael Hannah Ruth 
 Ruth Elizabeth Josiah Sarah Elijah David Leah Josephus Michael 
 Ruth Elizabeth Josiah Sarah Elijah David Leah Josephus 
 Elizabeth Josiah Sarah Elijah David Leah Josephus 
 Sarah Elijah David Leah Josephus Elizabeth 
 Leah Josephus Elizabeth Sarah Elijah 
 Elijah Leah Josephus Elizabeth 
 Leah Josephus Elizabeth 
 Leah Josephus 
 Josephus 
 
  ----jGRASP: operation complete.
 ----jGRASP exec: java Josephus_shell
 1 2 3 4 5 6 7 8 9 10 11 12 13 
 3 4 5 6 7 8 9 10 11 12 13 1 
 5 6 7 8 9 10 11 12 13 1 3 
 7 8 9 10 11 12 13 1 3 5 
 9 10 11 12 13 1 3 5 7 
 11 12 13 1 3 5 7 9 
 13 1 3 5 7 9 11 
 3 5 7 9 11 13 
 7 9 11 13 3 
 11 13 3 7 
 3 7 11 
 11 3 
 11 
 
  ****  Now start all over.  *** 
 
 Michael Hannah Jacob Ruth Matthew Elizabeth Josiah Jesse Elisha Sarah Elijah David Israel 
 Jacob Ruth Matthew Elizabeth Josiah Jesse Elisha Sarah Josephus David Israel Michael 
 Matthew Elizabeth Josiah Jesse Elisha Sarah Josephus David Israel Michael Jacob 
 Josiah Jesse Elisha Sarah Josephus David Israel Michael Jacob Matthew 
 Elisha Sarah Josephus David Israel Michael Jacob Matthew Josiah 
 Josephus David Israel Michael Jacob Matthew Josiah Elisha 
 Israel Michael Jacob Matthew Josiah Elisha Josephus 
 Jacob Matthew Josiah Elisha Josephus Israel 
 Josiah Elisha Josephus Israel Jacob 
 Josephus Israel Jacob Josiah 
 Jacob Josiah Josephus 
 Josephus Jacob 
 Josephus 
 
  ----jGRASP: operation complete.
 
*/