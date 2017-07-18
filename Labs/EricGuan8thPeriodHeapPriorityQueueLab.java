//Name:   Eric Guan
//Date:   1/16/17
// What I learned: I learned exactly how heaps work - their properties and how to manuipulate them. Admittedly, I don't always pay attention in class, so I found this lab to be somewhat difficult. However, I worked extremely hard on it to understand heaps and am happy that the code worked out. I'm not the best at writing main methods so there are not a lot of example outputs, so if you would like to more thoroughly test my code I would be happy to email the lab to you when I get home.
// How I feel about this lab: I have happy feelings about this lab, because it was necessary for me to understand the methods associated with the heap data structure. Without this lab, I would have been very lost moving forward. Thanks!
// I am wondering: How I could have printed oiut the array to make it look like a tree. I wrote a method before realizing I just needed a toString method, however the method printed out the heap backwards, and I gave up on it. If I had more time, I would have wanted to try to complete that method.
import java.util.*;
public class EricGuan8thPeriodHeapPriorityQueueLab <E>
{
   private static final int DFLT_CAPACITY = 1024;
   private Object items[];  // use a 1-D array instead of ArrayList
   private int numItems;  // number of elements in items

  
   public EricGuan8thPeriodHeapPriorityQueueLab()
   {
      items = new Object[10];
      numItems=0;
   }
   
   
   public EricGuan8thPeriodHeapPriorityQueueLab (int initialCapacity)
   {
      numItems=0;
      items = new Object[initialCapacity+1];
   }
   //pre:none
   //post:returns true if items is empty, false otherwise
   public boolean isEmpty()
   {
      return numItems==0;
   }
   //pre:items isn't empty
   //post:returns first element of items
   public Object peek()
   {
      return items[1]; 
    
   }
   //pre:items isn't empty
   //post:removes first element from array and bubbles down to account for it
   public Object remove()
   {
      Object result = items[1];
      items[1]=items[numItems];
      items[numItems]=null;
      numItems--;
      reheapDown(); 
      return result;
   }
   //pre:none
   //post:adds new value to heap and bubbles up to account for it
   public boolean add(Object obj)
   {
      if(items[1]==null){
         items[1]=obj;
         numItems++;
         return true;
      }
      else if(items[items.length-1]==null&&numItems<items.length)
         items[numItems+1]=obj;
      else{
         doubleCapacity();
         items[numItems+1]=obj;
      }      
      numItems++;
      reheapUp();
      return true;  
     
   }
   
      //pre:none
      //post:items is formatted correctly
   private void reheapDown()
   {
      Object temp;
      for(int k=1;k<=numItems;k++){
         Integer store1 = (Integer)items[k];
         if(k*2<=numItems){
            Integer store2 = (Integer)items[k*2];
            if(store1.compareTo(store2)>0){
               temp = items[k];
               items[k]=items[k*2];
               items[k*2]=temp;
            }
         }
         if(k*2+1<numItems){
            Integer store3 = (Integer)items[k*2+1];
            if(store1.compareTo(store3)>0){
               temp = items[k];
               items[k]=items[k*2+1];
               items[k*2+1]=temp;
            }
         }
      }
   }
   //pre:none
   //post:items is formatted correctly
   private void reheapUp()
   {
      Object temp;
      for(int k=numItems;k>1;k--){
         Integer store1 = (Integer)items[k];
         Integer store2 = (Integer)items[k/2];
         if(store1.compareTo(store2)<0){
            temp=items[k];
            items[k]=items[k/2];
            items[k/2]=temp;
         }
      }
         
   }
   //pre:items is filled 
   //post:items's size has doubled
   private void doubleCapacity()
   {
      Object[] newArray = new Object[items.length*2];  
      for(int k=1;k<=items.length-1;k++){
         newArray[k] = items[k];
      }   
      items = newArray;
   }
   //pre:none
   //post:now able to print out heap
   public String toString()
   {
      String heap = "";
      for(int i = 1; i <= numItems; i++)
         heap += items[i] + " ";
      return heap;
   }
   public static void main(String[] args){
      EricGuan8thPeriodHeapPriorityQueueLab first = new EricGuan8thPeriodHeapPriorityQueueLab();
      EricGuan8thPeriodHeapPriorityQueueLab second = new EricGuan8thPeriodHeapPriorityQueueLab(15);
     /* for(int k=1;k<5;k++){
         first.add(k);
      } */
      first.add(1);
      first.add(2);
      first.add(4);
      first.add(5);
      first.add(6);
      first.add(3);
      first.add(7);
      System.out.println(first);
      
      second.add(2);
      second.add(10);
      second.add(5);
      second.add(3);
      second.add(6);
      second.add(8);
      second.add(4);
      second.add(7);
      second.add(9);
      System.out.println(second);
      
      second.remove();
      System.out.println(second);
      //second.remove();
      //System.out.println(second);
   }
}  //HeapPriorityQueue_shell

/*

  ----jGRASP exec: java EricGuan8thPeriodHeapPriorityQueueLab
 1 2 3 5 6 4 7 
 2 3 4 7 6 8 5 10 9 
 4 6 3 9 7 8 5 10 
 
  ----jGRASP: operation complete.
 
*/