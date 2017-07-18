/*Eric Guan, Period 8
11/28/16 
Name of the Lab/Assignment: PrintQueue
Due date: 11/29/16 at 11:59
Date submitted: before the time it's due
What I learned: this assignment was the first time I had written code with queues in JGRASP, so it helped me to 
   become more familiar with teh queue class. In addition, I learned more about the Java Collections Framework
   because queue is a Collection Class through researching the methods and thinking about how I could use them in the lab.
How I feel about this lab: I am happy with this assignment because it was incredibly easy. It didn't take much time at all, yet
   still was able to reinforce the concepts discussed in class.
Most difficult method: n/a
Who helped me: Adam reminded me that queue is a collection class, which meant that my delete method was able to be simplified   
   a lot. 
Who I helped: no one       
*/
import java.io.*;
import java.util.*;

public class EricGuanPeriod8PrintQueue
{
   private static Scanner in;
   private static Queue<String> q;
   private static int jobNumber =100;
   
   public static void main(String[] args) throws Exception
   {
      q = new LinkedList<String>();
      in = new Scanner(System.in);
      String prompt = "Add, Print, Delete, eXit:  ";
      System.out.print(prompt);
      String str = in.next();
      while(!str.equals("X"))
      {
         if(str.equals("A"))
            add();
         else if(str.equals("P"))
            printJob();  
         else if(str.equals("D"))
            delete();
         else
            System.out.println("   invalid command");
         printQueue();
         System.out.print(prompt);
         str = in.next();
      }
      in.close();
   }
   //pre:none
   //post:String representation of jobNumber has been added and jobNumber increased by 1 afterwards
   public static void add()
   {
      q.add(Integer.toString(jobNumber++));
   }
   //pre:none
   //post:first element in queue has been removed
   public static void printJob()
   {
      q.remove();
   }
	//pre:none
   //post:removes jobNumber from queue if q contains it, prints out an error statement otherwise
   public static void delete()
   {
      if(q.contains(Integer.toString(jobNumber)))
         q.remove(Integer.toString(jobNumber));
      else
         System.out.println("Error--job does not exist");   
   }
   //pre:none
   //post:prints out q
   public static void printQueue()
   {
      System.out.println(q);
   }
}


/*
 ----jGRASP exec: java EricGuanPeriod8PrintQueue
 Add, Print, Delete, eXit:  A
 [100]
 Add, Print, Delete, eXit:  A
 [100, 101]
 Add, Print, Delete, eXit:  A
 [100, 101, 102]
 Add, Print, Delete, eXit:  P
 [101, 102]
 Add, Print, Delete, eXit:  A
 [101, 102, 103]
 Add, Print, Delete, eXit:  D
 Error--job does not exist
 [101, 102, 103]
 Add, Print, Delete, eXit:  D
 Error--job does not exist
 [101, 102, 103]
 Add, Print, Delete, eXit:  X
 
  ----jGRASP: operation complete.
*/