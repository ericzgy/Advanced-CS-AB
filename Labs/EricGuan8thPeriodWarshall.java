/**
 * Name:                          
 * Period: 
 * Name of the Lab: 
 * Purpose of the Program: 
 * Due Date: 
 * Date Submitted: 
 * What I learned: 
 * How I feel about this lab: 
 * What I wonder: I
 *
 * Most Difficult Method: 
 * Credits:  
 */

import java.util.*;
import java.io.*;
class EricGuan8thPeriodWarshall
{
   private int[][] grid = null;   //adjacency matrix representation
   private Map<String, Integer> vertices = null;      // a map for associating vertex names to indices
   /*for the Extension*/  ArrayList<String> nameList = null;     // list of vertex names
	
   public EricGuan8thPeriodWarshall(int size)
   {
        grid = new int[size][size];
   }    
   public void addEdge(int source, int target)
   {
       grid[source][target]=1;
   }
   public void removeEdge(int source, int target)
   {
       grid[source][target]=0;   
   }
   
   // use the vertex TreeMap to get the integer value for a vertex
   public boolean isEdge(String from, String to)
   {
      return vertices.get(from)==vertices.get(to);
   }
   
   // this method uses an adjacency matrix to determine if there is an edge from "from" to "to"
   private boolean isEdge(int from, int to)
   {
      return grid[from][to]==1;
   }
   
   public Map<String, Integer> getVertices()  //needed for the extension
   {
           // you need to write this method
   }
   public void readNames(String fileName) throws FileNotFoundException
   {
      Scanner file = new Scanner(new File(fileName));
      int size =  file.nextInt() ;
      nameList = new ArrayList<String>();
      // start reading names from the file: cities.txt
      // Do two things here:
      // 1. create a TreeMap that stores <name, index> pairs; name of the map declared above is: vertices
      // 2. update the vertex list:  nameList
      
      
      
   }
   
   public void readGrid(String fileName) throws FileNotFoundException
   {
      Scanner file = new Scanner(new File(fileName));
      int size =  file.nextInt() ;
      grid = new int[size][size];
      
      // use nested for loops to initialize the adjacency matrix
      // your code goes here ...
   }
   
   // display the vertex map contents.  Refer to Graph 1 handout 
   public void displayVertices()
   {
      for(Map.entry<String,Integer> entry: vertices.entrySet()){
         System.out.print
      }
   }
   public void displayGrid()
   {

   }
   // count how many edges are in the graph represented by an adjacency matrix
   public int edgeCount()
   {

   }
   public List<Integer> getNeighbors(int from)
   {
             return null;
   }
   
   public List<String> getReachables(String from)  //Warshall extension
   {
      List<String> reachables = new ArrayList<String>();

      return reachables;
   }

   // Implement the Warshall algorithm.  The algorithm generates the all pairs reachability matrix (aka transitive closure matrix)
   public void allPairsReachability()   
   {
   
   }
   
   
   /****************************  No need to write the following two methods      
   public int getCost(String from, String to)
   {
      return getCost(vertices.get(from), vertices.get(to));
   }
   public int getCost(int from, int to)
   {
      return grid[from][to];
   }  
   ********************************************************************/

}  // end of GraphAdjMatrix_shell