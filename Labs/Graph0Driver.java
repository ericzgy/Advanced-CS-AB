import java.util.Scanner;
import java.io.*;
public class Graph0Driver
{
   public static void main(String[] args)throws FileNotFoundException
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("Enter size of adjacency matrix: "); 
      int size = kb.nextInt();
      EricGuan8thPeriodIntroGraphs g = new EricGuan8thPeriodIntroGraphs(size);
      System.out.println("Adjacency Matrix");
      g.displayGrid();
      System.out.println("Add edges, source<space>target<enter>.  Enter -1 to end.");
      while(true)
      {
         int source = kb.nextInt();
         if( source == -1 ) 
            break;
         g.addEdge(source,kb.nextInt());
         g.displayGrid();
      }
      
      g.displayGrid();
      System.out.print("Remove an edge? ");
      if( kb.next().equalsIgnoreCase("Y"))
      {
         System.out.print("Remove which edge?  ");
         g.removeEdge( kb.nextInt(), kb.nextInt() );
         g.displayGrid();
      }
   			
      System.out.println("Number of edges: " + g.edgeCount());
      System.out.println("The neighbors of each vertex: ");
      for(int i=0; i<size; i++)
      {
         System.out.println(i + ": " +g.getNeighbors(i));
      }
   }  // main
}  // Graph0Driver

/*
  ----jGRASP exec: java Graph0Driver
 Enter size of adjacency matrix: 8
 Adjacency Matrix
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
 Add edges, source<space>target<enter>.  Enter -1 to end.
 0 2
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
 3 1
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  1  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
 5 4
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  1  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  1  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
 6 2
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  1  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  1  0  0  0 
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
 3 1
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  1  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  1  0  0  0 
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
 2 2
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  1  0  0  0  0  0 
  0  1  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  0  0  1  0  0  0 
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
 5 1
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  1  0  0  0  0  0 
  0  1  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  1  0  0  1  0  0  0 
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
 4 3
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  1  0  0  0  0  0 
  0  1  0  0  0  0  0  0 
  0  0  0  1  0  0  0  0 
  0  1  0  0  1  0  0  0 
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
 -1
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  1  0  0  0  0  0 
  0  1  0  0  0  0  0  0 
  0  0  0  1  0  0  0  0 
  0  1  0  0  1  0  0  0 
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
 Remove an edge? Y
 Remove which edge?  0 2
  0  0  0  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
  0  0  1  0  0  0  0  0 
  0  1  0  0  0  0  0  0 
  0  0  0  1  0  0  0  0 
  0  1  0  0  1  0  0  0 
  0  0  1  0  0  0  0  0 
  0  0  0  0  0  0  0  0 
 Number of edges: 6
 The neighbors of each vertex: 
 0: []
 1: []
 2: [2]
 3: [1]
 4: [3]
 5: [1, 4]
 6: [2]
 7: []
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java Graph0Driver
 Enter size of adjacency matrix: 4
 Adjacency Matrix
  0  0  0  0 
  0  0  0  0 
  0  0  0  0 
  0  0  0  0 
 Add edges, source<space>target<enter>.  Enter -1 to end.
 0
 0
  1  0  0  0 
  0  0  0  0 
  0  0  0  0 
  0  0  0  0 
 0 3
  1  0  0  1 
  0  0  0  0 
  0  0  0  0 
  0  0  0  0 
 2 1
  1  0  0  1 
  0  0  0  0 
  0  1  0  0 
  0  0  0  0 
 2 3
  1  0  0  1 
  0  0  0  0 
  0  1  0  1 
  0  0  0  0 
 1 2
  1  0  0  1 
  0  0  1  0 
  0  1  0  1 
  0  0  0  0 
 3 0
  1  0  0  1 
  0  0  1  0 
  0  1  0  1 
  1  0  0  0 
 -1
  1  0  0  1 
  0  0  1  0 
  0  1  0  1 
  1  0  0  0 
 Remove an edge? Y
 Remove which edge?  3 0
  1  0  0  1 
  0  0  1  0 
  0  1  0  1 
  0  0  0  0 
 Number of edges: 5
 The neighbors of each vertex: 
 0: [0, 3]
 1: [2]
 2: [1, 3]
 3: []
 
  ----jGRASP: operation complete.
 

*/