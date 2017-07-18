/**
 * Name:  Eric Guan                        
 * Period: 8
 * Name of the Lab: Graphs 0 - Adjacency Matrix Lab
 * Purpose of the Program: To gain a basic understanding of the adjacency matrix representation of a graph and to understand
                           how to write the methods
 * Due Date: 3/20
 * Date Submitted: See email
 * What I learned: I learned how an adjacency matrix works for graphs. 
 * How I feel about this lab: I am overall satisfied with this lab; it was not very difficult. 
 * What I wonder: N/a
 *
 * Most Difficult Method: getNeighbors, it took me the most time because I had to think about how to store the neighbors.  
 * Credits:  
 */



import java.util.*;
import java.io.*;
public class EricGuan8thPeriodIntroGraphs
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

   private int[][] grid = null;   //adjacency matrix representation
 

   public EricGuan8thPeriodIntroGraphs(int size)
   {
      grid = new int[size][size];
   }    
   
   // Note: addEdge only changes grid, not the vertex list
   public void addEdge(int source, int target)
   {
      grid[source][target]=1;
   } 
   // Note: removeEdge only changes grid, not the vertex list
   public void removeEdge(int source, int target)
   {
      grid[source][target]=0;
   }
   private boolean isEdge(int from, int to)
   {
      return grid[from][to]==1;
   }
   // display contents of ajacency matrix
   public void displayGrid()
   {
      for(int r = 0; r < grid.length; r++){
         for(int c = 0; c < grid[0].length; c++)
            System.out.print(" " + grid[r][c] + " ");
         System.out.println();
      }
   }  //displayGrid
   
   // count how many edges are in the graph
   public int edgeCount()
   {
      int result=0;
      for(int r = 0; r < grid.length; r++){
         for(int c = 0; c < grid[0].length; c++)
            if(grid[r][c]==1)
               result++;
      }
      return result;
   }  // edgeCount
   
    
   // return neighbors of "source" in a List structure
   // the neighbors of a source vertex are all the vertices reachable by traveling along one (1) edge.
   public List<Integer> getNeighbors(int sourceVertex)
   {
   
      List<Integer> neighbors = new ArrayList<Integer>();
      for (int k = 0; k < grid.length;k++) {
         if(grid[sourceVertex][k]==1)
            neighbors.add(k);
      }
      return neighbors; 
   }  // getNeighbors

   //Note: There are other methods that we don't include here for a graph
   // addVertex, removeVertex
   
}  // GraphAdjMat_shell


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