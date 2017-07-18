//Name:   Eric Guan
//Date:2/10/17
/* What I learned: I learned a lot from this lab about Hashtables and how to implement them, as well as how to write the
 methods that compose the class. I spent a large amount of time debugging and tracing my methods, as well as thinking about 
 the logic behind each method. It helped me that you provided a short description on what to write for each method. I 
 remembered what you said in class about trying the lab on my own and not asking anyone for help, so on this lab I did it 
 completely by myself. It took me much longer; I spent most of Saturday and Sunday thinking about the lab. Nevertheless, I
  am somewhat satisfied with the result. I feel much more comfortable with writing code for Hashtables. */
/* How I feel about this lab: I feel as though I may have answered this question somewhat on the previous reflection 
question, but maybe I can elaborate further in this question. I have mixed feelings about the lab. On one hand, I am 
happy that I was able to come up with solutions by myself for once without asking Adam or James or someone else for help. 
On the other hand, I am a little frusturated that it took me such a long time to figure out stuff that seems pretty easy now.
 Moving forward, I will need to improve my logical thinking and time management for sure. Still, if I had to choose one emotion
  I would say happy, because this lab represents a step in the right direction for me. */
/* What I wonder: Unfortuntely, there are still shortcomings in my programming. Other than working faster, I also had 
trouble altering the search method to work for chaining. I tried to write a method, however I had to work on other homework
 and did not have adequate time to complete the method. I tried, however, and attached the code because I would like to know 
 where I went wrong. The problem I was having was that it would not recognize the iterator() method. I tried to typecast test
  to LinkedLIst, but that did not work either. I am wondering how I could have implemented that into my code. I believe that
   my current search method works for linear probing. */

 /*****************************************************************************  
  Assignment:  A simple hashing program is given below. Compile 
 and run.  Notice that collisions occur.  You are to implement 
 three different collision schemes, namely, linear probing, 
 rehashing, and chaining (using a LinkedList <Object>) .
 *****************************************************************************/
import java.util.*;
public class EricGuan8thPeriodHashCode
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);  
      System.out.print("Enter the size of the array:  ");
      int arrayLength = keyboard.nextInt();       //20
      Hashtable table = new Hashtable(arrayLength);
      
      System.out.print("\nEnter the number of items:  ");
      int numItems = keyboard.nextInt();          //15
      System.out.print("\nThe Load Factor is " + (double)numItems/arrayLength);
      System.out.println();
      for(int i = 0; i < numItems; i++)
         table.add("Item "+i);
         
      System.out.println();
      System.out.print("Search for:  Item ");
      int i = keyboard.nextInt();
      String key = "Item " + i; 
      if(!table.contains(key))
         System.out.println(key + " NOT found");
   }  // main
}  // HashCode_shell
   
class Hashtable
{
   private int size;
   private Object[] table;
   public Hashtable(int numSlots)
   {
      size = numSlots;
      table = new Object[size];
   }
   //pre:none
   //post:new Object is added into Hashtable, if a collision occurs it is resolved by chaining
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % size);
      if(table[index] == null){
         table[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
      else{
         System.out.println(obj + "\t" + code + "\tCollision at "+ index);
         obj = chaining(index, obj);
         table[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
      
   }  // end of add
   
   
   // returns true if obj can be found in the table
   public boolean contains(Object obj)     //Big-O is O(1)
   {
      /*int index = Math.abs(obj.hashCode() % size);
      Object test = table[index];
      Iterator listIterator = test.iterator();
      if(test.equals(obj)){
         System.out.println(obj + " at index " + index);
         return true;
      }
      else if(listIterator.hasNext()){
         while(listIterator.hasNext()){
            if(listIterator.next().equals(obj)){
               System.out.println(obj + " at index " + index);
               return true;
            }
         }
      }
      else 
         return false; */
         
      int index = Math.abs(obj.hashCode() % size);
      Object found = table[index];
      if(found.equals(obj))
      {
         System.out.println(obj + " at index " + index);
         return true;
      }
      else 
         return false;
   }  // end of contains
   
   
   
  // implement collision resolution methods one at a time
  //pre:there is a collision of two Objects at index
  //post:collision is resolved using linear probing
   public int linearProbe(int index)
   {
      int linprobindex = index + 1;
      while(table[linprobindex] != null){
         if(linprobindex==index)
            break;
         if(linprobindex==table.length)
            linprobindex=0;
         linprobindex++;  
      }
      return linprobindex;
   }
      // NOTE:  NO NEED TO DO THE REHASH METHOD
      
      // Note: each table element is a singly linked list of Objects
   //pre:there is a collision of two objects in the Hashtable
   //post:collision is resolved b/c it's an array of LinkedLists so the value is just moved onto a new LL
   public Object chaining(int index, Object obj)
   {
      LinkedList list = new LinkedList();
      list.add(table[index]);
      list.add(obj);
      return list;
   }

}  // Hashtable


/*
  ----jGRASP exec: java EricGuan8thPeriodHashCode
 Enter the size of the array:  20
 
 Enter the number of items:  15
 
 The Load Factor is 0.75
 Item 0	-2094796157	17
 Item 1	-2094796156	16
 Item 2	-2094796155	15
 Item 3	-2094796154	14
 Item 4	-2094796153	13
 Item 5	-2094796152	12
 Item 6	-2094796151	11
 Item 7	-2094796150	10
 Item 8	-2094796149	9
 Item 9	-2094796148	8
 Item 10	-514171348	Collision at 8
 [Item 9, Item 10]	-514171348	8
 Item 11	-514171347	7
 Item 12	-514171346	6
 Item 13	-514171345	5
 Item 14	-514171344	4
 
 Search for:  Item 14
 Item 14 at index 4
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java EricGuan8thPeriodHashCode
 Enter the size of the array:  11
 
 Enter the number of items:  14
 
 The Load Factor is 1.2727272727272727
 Item 0	-2094796157	3
 Item 1	-2094796156	2
 Item 2	-2094796155	1
 Item 3	-2094796154	0
 Item 4	-2094796153	10
 Item 5	-2094796152	9
 Item 6	-2094796151	8
 Item 7	-2094796150	7
 Item 8	-2094796149	6
 Item 9	-2094796148	5
 Item 10	-514171348	Collision at 9
 [Item 5, Item 10]	-514171348	9
 Item 11	-514171347	Collision at 8
 [Item 6, Item 11]	-514171347	8
 Item 12	-514171346	Collision at 7
 [Item 7, Item 12]	-514171346	7
 Item 13	-514171345	Collision at 6
 [Item 8, Item 13]	-514171345	6
 
 Search for:  Item 9
 Item 9 at index 5
 
  ----jGRASP: operation complete.
 
*/