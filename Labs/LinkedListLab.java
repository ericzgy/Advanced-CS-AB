import java.util.NoSuchElementException;
import java.util.*;
public class LinkedListLab
{
   public static void main(String [] args)
   {
      Scanner  input = new Scanner (System.in);
      ListNode <Integer> h = new ListNode <Integer>( new Integer(5), null);
      h= new ListNode<Integer>(new Integer(4), h);
      h= new ListNode<Integer>(new Integer(3), h);
      h= new ListNode<Integer>(new Integer(2), h);
      h= new ListNode<Integer>(new Integer(1), h);
      char option ;
      try{
         do
         {
            option = menu();
            if( option  == 'a')
            {
               System.out.println("list: ");
               printLinkedList(h);
            }	
            else if(option == 'b')
            {
               System.out.println("The List has at least two element?");
               System.out.println(hasTwo(h));
            }	
            else if( option  =='c')
            {
               System.out.print("The size of the linked list is: ");
               System.out.println(size(h));
            }	
            else if( option  == 'd')
            {
               h = removeFirst(h);
               System.out.println("New list is: ");
               printLinkedList(h);
            }
            else  if( option  == 'e')
            {
               System.out.println("Enter number: ");
               int num = input.nextInt();
               append(h, new Integer(num));
               System.out.println("New list is: ");
               printLinkedList(h);
            }
            else if( option  == 'f')
            {
               h = reverseList(h);
               System.out.println("Reverse is: ");
               printLinkedList(h);
            }
            else if( option  == 'g')
            {
               h = rotate(h);
               System.out.println("rotated array is: ");
               printLinkedList(h);
            }
            else if( option  == 'h')
            {
               printLinkedList(h);
               System.out.println("\nmiddle node is: "+middleNode(h).getValue());
            }
            
            else if( option  == 'i')
            {
               h = removeLast(h);
               System.out.print("New list is: ");
               printLinkedList(h);
            }
            else if(option == 'j'){
               System.out.println("Enter a number: ");
               int num = input.nextInt();
               h = remove(h,num);
               System.out.println("New list is: ");
               printLinkedList(h);
            }
         } while (option != 'z');
      }
      catch(NoSuchElementException e){
         System.out.print("Caught NoSuchElementException: " + e);
      }
   }
   //pre:none
   //post:the values in head are printed out
   public static void printLinkedList(ListNode head)
   {
      if(head!=null){
         for(;head!=null;head=head.getNext()){
            System.out.println(head.getValue());
         }
      }
   }
   //pre:none
   //post:returns true if head has two nodes,false otherwise 
   public static boolean hasTwo(ListNode <Integer> head)
   {
      boolean result = false;
      if(head!=null){
         int count = 0;
         for(;head!=null;head=head.getNext()){
            count++;
            if(count>=2)
               result=true;
         }
      }
      return result;
   
   }
   //pre:none
   //post:returns how large head is
   public static int size(ListNode  <Integer> head)
   {
      int count = 0;
      if(head!=null){
         for(;head!=null;head=head.getNext()){
            count++;
         }
      }
      return count;
   }
   //pre:none
   //post: first node has been removed
   public static ListNode  <Integer> removeFirst(ListNode  <Integer> head)throws NoSuchElementException
   {	
      if(head!=null){
         head=head.getNext();
      }
      else{
         throw new NoSuchElementException("LinkedList is null");
      }
      return head;
   }
   //pre:none
   //post:last node has been removed
   public static ListNode  <Integer> removeLast(ListNode  <Integer> head)
   {	
      if (head != null){
         ListNode <Integer> previous ;
         ListNode <Integer> next;
         next = head;
         previous = head;
         for (; next.getNext() != null; previous = next, next = next.getNext());
         if (previous == head) 
            head = null;
         else
         {
            previous.setNext (null);
         }
      }
      else{
         throw new NoSuchElementException("LinkedList is null");
      }
      return head;
   }
   //pre:none
   //post:all nodes containing value have been removed from head
   public static ListNode remove(ListNode  <Integer> head,  Integer value)
   {	
      ListNode<Integer> result = null;
      if(head!=null){
         for(;head!=null;head=head.getNext()){
            if(!(head.getValue().equals(value))){
               result=new ListNode<Integer>(head.getValue(),result);
            }
            
         }
      }
      else{
         throw new NoSuchElementException("LinkedList is null");
      }
      return result;
   }
   //pre:none
   //post:head has a new node attached to the end of it
   public static void append(ListNode  <Integer> head, Integer value)
   {
      if(head!=null){
         for(;head!=null;head=head.getNext()){
            if(head.getNext()==null){
               head.setNext(new ListNode<Integer>(value,null));
               break;
            }
         }
      }
      else
         head.setValue(value);
   }
   //pre:none
   //post:the order of head is reversed
   public static ListNode reverseList(ListNode<Integer> head)
   {
      ListNode<Integer> reverse = null;
      if(head!=null){
         for(;head!=null;head=head.getNext()){
            reverse = new ListNode<Integer>(head.getValue(),reverse);
         }
      }
      return reverse;
   }
   //pre:none
   //post:head is shifted by 1, so last node is now first
   public static ListNode  <Integer> rotate(ListNode  <Integer> head)
   {  
      if(head!=null){
         head = reverseList(head);
         Integer e = head.getValue();
         head = removeFirst(head);
         head = reverseList(head);
         head = new ListNode<Integer>(e,head);
      }
      return head;
   }
   
   //pre:head has an odd number of values
   //post:returns middle value of list
   public static ListNode  <Integer> middleNode(ListNode <Integer> head)
   {
      int middleIndex = 0;
      int count = 0;
      ListNode<Integer> result = null;
      ListNode<Integer> copy = head;
      for(;copy!=null;copy=copy.getNext()){
         count++;
         if(copy.getNext()==null){
            middleIndex = (count/2)+1;
            break;
         }
      }
      count = 0;
      for(;head!=null;head=head.getNext()){
         count++;
         if(count==middleIndex)
            result=head;
      }
      return result;
   }

   //pre:none
   //post:user has chosen which methods to call to use on ListNode<Integer> h
   public static char menu()
   {
      System.out.println("\n====> What would you like to do?");
      System.out.println("a) Print list");
      System.out.println("b) Check if list has at least two nodes");
      System.out.println("c) Get size of the list");
      System.out.println("d) Remove first node");
      System.out.println("e) Append a node");
      System.out.println("f) Reverse");
      System.out.println("g) Rotate");
      System.out.println("h) Get middle node");
      System.out.println("i) Remove last node");
      System.out.println("j) Remove a value from the list");
      System.out.println("z) Quit?");
      Scanner  input = new Scanner (System.in);
   
      return input.next().charAt(0);   
   }

   
}
/*
 ----jGRASP exec: java LinkedListLab
 
 ====> What would you like to do?
 a) Print list
 b) Check if list has at least two nodes
 c) Get size of the list
 d) Remove first node
 e) Append a node
 f) Reverse
 g) Rotate
 h) Get middle node
 i) Remove last node
 j) Remove a value from the list
 z) Quit?
 a
 list: 
 1
 2
 3
 4
 5
 
 ====> What would you like to do?
 a) Print list
 b) Check if list has at least two nodes
 c) Get size of the list
 d) Remove first node
 e) Append a node
 f) Reverse
 g) Rotate
 h) Get middle node
 i) Remove last node
 j) Remove a value from the list
 z) Quit?
 b
 The List has at least two element?
 true
 
 ====> What would you like to do?
 a) Print list
 b) Check if list has at least two nodes
 c) Get size of the list
 d) Remove first node
 e) Append a node
 f) Reverse
 g) Rotate
 h) Get middle node
 i) Remove last node
 j) Remove a value from the list
 z) Quit?
 c
 The size of the linked list is: 5
 
 ====> What would you like to do?
 a) Print list
 b) Check if list has at least two nodes
 c) Get size of the list
 d) Remove first node
 e) Append a node
 f) Reverse
 g) Rotate
 h) Get middle node
 i) Remove last node
 j) Remove a value from the list
 z) Quit?
 d
 New list is: 
 2
 3
 4
 5
 
 ====> What would you like to do?
 a) Print list
 b) Check if list has at least two nodes
 c) Get size of the list
 d) Remove first node
 e) Append a node
 f) Reverse
 g) Rotate
 h) Get middle node
 i) Remove last node
 j) Remove a value from the list
 z) Quit?
 e
 Enter number: 
 3
 New list is: 
 2
 3
 4
 5
 3
 
 ====> What would you like to do?
 a) Print list
 b) Check if list has at least two nodes
 c) Get size of the list
 d) Remove first node
 e) Append a node
 f) Reverse
 g) Rotate
 h) Get middle node
 i) Remove last node
 j) Remove a value from the list
 z) Quit?
 f
 Reverse is: 
 3
 5
 4
 3
 2
 
 ====> What would you like to do?
 a) Print list
 b) Check if list has at least two nodes
 c) Get size of the list
 d) Remove first node
 e) Append a node
 f) Reverse
 g) Rotate
 h) Get middle node
 i) Remove last node
 j) Remove a value from the list
 z) Quit?
 g
 rotated array is: 
 2
 3
 5
 4
 3
 
 ====> What would you like to do?
 a) Print list
 b) Check if list has at least two nodes
 c) Get size of the list
 d) Remove first node
 e) Append a node
 f) Reverse
 g) Rotate
 h) Get middle node
 i) Remove last node
 j) Remove a value from the list
 z) Quit?
 h
 2
 3
 5
 4
 3
 
 middle node is: 5
 
 ====> What would you like to do?
 a) Print list
 b) Check if list has at least two nodes
 c) Get size of the list
 d) Remove first node
 e) Append a node
 f) Reverse
 g) Rotate
 h) Get middle node
 i) Remove last node
 j) Remove a value from the list
 z) Quit?
 i
 New list is: 2
 3
 5
 4
 
 ====> What would you like to do?
 a) Print list
 b) Check if list has at least two nodes
 c) Get size of the list
 d) Remove first node
 e) Append a node
 f) Reverse
 g) Rotate
 h) Get middle node
 i) Remove last node
 j) Remove a value from the list
 z) Quit?
 j
 Enter a number: 
 2
 New list is: 
 4
 5
 3
 
 ====> What would you like to do?
 a) Print list
 b) Check if list has at least two nodes
 c) Get size of the list
 d) Remove first node
 e) Append a node
 f) Reverse
 g) Rotate
 h) Get middle node
 i) Remove last node
 j) Remove a value from the list
 z) Quit?
 z
 
  ----jGRASP: operation complete.
*/