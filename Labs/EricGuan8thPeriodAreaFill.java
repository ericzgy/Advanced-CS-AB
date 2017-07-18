//Eric Guan
//October 24th, 2016
/*
Name: Eric Guan     Period: 8
Name of the lab/assignment: Area Fill Lab
Purpose of the program: the purpose of the program is to read any text file into a 2-dimensional array of type char, take in a row and column number, then recursively traverse the array for characters that are directly touching that char with similar values, and change all those values to ‘*’. In addition, the program will print out the 2D array initially, and then after the fill method is called so the user can see the changes that have been made. 
Due date: 10/24/16 at 11:59
Date submitted: close to but definitely before the due date
What I learned: I learned two large things: tracing complicated recursive methods and working with 2D arrays. My knowledge of 2D arrays was extremely rusty, and at first I had to search up how to traverse it, instantiate it, etc. But now, as I have finished the lab, I am familiar with 2D arrays again and feel somewhat confident writing methods about them. Tracing recursion comes from the debug feature. I struggled a great deal with the fill method, so when I had to debug the method, there was a mind boggling amount of recursion and I had to trace it all. It took a great amount of time but I am happy that I traced it for so long because in the end it all worked out. 
How I feel about this lab: I enjoyed the experience that this lab provided. I like that the lab was not too short, and not too long. Another thing that I am really starting to enjoy is when you give us time in class to work on the lab. This is good because I can ask elite students such as Conor, Calvin, or Alice for help when I don’t understand the logic or forget how to do something. Having time in class also takes the burden off of me at home, which is greatly appreciated. 
Most difficult method: By far the most difficult method was the fill method. What took me the most time on the method was actually figuring out the base cases. At first I had 5 base cases: one for when the value is not equal to ch, and 4 for when the method was at the edge of an array. However, this is wrong because then it would only cover one value on an edge. So, I kept the not equal to ch base case and changed the other 4 to be the corners, and the method ended up working. 
Who helped me: Adam El Sheikh explained to me how to do the read method, which I was confused on at first. I was confused on what the integers on top were and how to use Scanner. But he told me to look at the Scanner API and what the integers were, and after that it was smooth sailing. Adam also helped me understand why the base cases should be at the corners, and not at the sides. 
Who I helped: no one
*/

import java.util.Scanner;
import java.io.*;
public class EricGuan8thPeriodAreaFill
{
   public static char[][] grid = null;

   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Filename: ");
      String filename = sc.next();
      grid = read(filename);
      display(grid);
      System.out.print("\nEnter ROW COL to fill from: ");
      int row = sc.nextInt();
      int col = sc.nextInt(); 
      fill(grid, row, col, grid[row][col]);
      display(grid);
      sc.close();
   }
   //pre:file exists and the text file has two integers at the top that tell the rows and columns
   //post: returns a char with the values inside of the text file after the two integers
   public static char[][] read(String filename)throws FileNotFoundException
   {
      Scanner infile = new Scanner(new File(filename+".txt"));
      int rows=infile.nextInt();
      int columns=infile.nextInt();
      char [][] result=new char[rows][columns];
      for(int k=0;k<result.length;k++){
         String temp=infile.next();
         for(int j=0;j<result[0].length;j++){
            result[k][j]=temp.charAt(j);
         }
      }
      return result;
   }
   //pre:none
   //prints out the values inside the 2D array for the user to see
   public static void display(char[][] g)
   {              
      for(int k=0;k<g.length;k++){
         for(int j=0;j<g[0].length;j++){
            System.out.print(g[k][j]);
         }
         System.out.println();
      }
   }
   //pre:r and c are values that are inside of the 2D array
   //post: changes g so that wherever there was a patch of connected characters equal to ch, they have all been replaced with '*'
   public static void fill(char[][] g, int r, int c, char ch) //recursive method
   {    
      if(g[r][c]!=ch){
         return;
      }   
      if((r==0&&c==0)||(r==0&&c==g[0].length-1)||(r==g.length-1 && c==0)||(r==g.length-1 && c==g[0].length)){
         g[r][c]='*';
         return;
      }
      if((r-1<0 || r+1==g.length)&&(!(c-1<0||c+1==g[0].length))){
         g[r][c]='*';
         fill(g,r,c-1,ch);
         fill(g,r,c+1,ch);
         if(r==0)
            fill(g,r+1,c,ch);
         else
            fill(g,r-1,c,ch);   
      }
      else if((c==0||c==g[0].length-1)&&(!(r-1<0||r+1==g.length))){
         g[r][c]='*';
         fill(g,r+1,c,ch);
         fill(g,r-1,c,ch);
      }
      else{
         g[r][c]='*';
         fill(g,r,c+1,ch);
         fill(g,r,c-1,ch);
         fill(g,r+1,c,ch);
         fill(g,r-1,c,ch);
         
      }
       
      
   }
}
/*
 ----jGRASP exec: java AreaFill_shell
 Filename: area2
 ..........00
 ...0....0000
 ...000000000
 0000.....000
 ............
 ..#########.
 ..#...#####.
 ......#####.
 ...00000....
 
 Enter ROW COL to fill from: 1 2
 **********00
 ***0****0000
 ***000000000
 0000.....000
 ............
 ..#########.
 ..#...#####.
 ......#####.
 ...00000....
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java AreaFill_shell
 Filename: area2
 ..........00
 ...0....0000
 ...000000000
 0000.....000
 ............
 ..#########.
 ..#...#####.
 ......#####.
 ...00000....
 
 Enter ROW COL to fill from: 1 3
 ..........**
 ...*....****
 ...*********
 ****.....***
 ............
 ..#########.
 ..#...#####.
 ......#####.
 ...00000....
 
  ----jGRASP: operation complete.
 

 ----jGRASP exec: java AreaFill_shell
 Filename: area
 xxxx............................
 ...xx...........................
 ..xxxxxxxxxxxx..................
 ..x.........xxxxxxx.............
 ..x...........0000xxxx..........
 ..xxxxxxxxxxxx0..000............
 ..xxxxxxxxx...0...00.....0000000
 ..........xx.......0000000000000
 .....xxxxxxxxx........0.........
 ....xx.................00000....
 ....xx.....................00...
 .....xxxxxxxxxxxxxxxxxx....00...
 ......................xx...00...
 .......................xxxx00000
 ............................0000
 
 Enter ROW COL to fill from: 2 4
 ****............................
 ...**...........................
 ..************..................
 ..*.........*******.............
 ..*...........0000****..........
 ..************0..000............
 ..*********...0...00.....0000000
 ..........**.......0000000000000
 .....*********........0.........
 ....**.................00000....
 ....**.....................00...
 .....******************....00...
 ......................**...00...
 .......................****00000
 ............................0000
 
  ----jGRASP: operation complete.
  
    
  ----jGRASP exec: java AreaFill_shell
 Filename: area3
 +++
 @+@
 @+@
 @@@
 
 Enter ROW COL to fill from: 0 1
 ***
 @*@
 @*@
 @@@
 
  ----jGRASP: operation complete.
      ----jGRASP exec: java AreaFill_shell
 Filename: area
 xxxx............................
 ...xx...........................
 ..xxxxxxxxxxxx..................
 ..x.........xxxxxxx.............
 ..x...........0000xxxx..........
 ..xxxxxxxxxxxx0..000............
 ..xxxxxxxxx...0...00.....0000000
 ..........xx.......0000000000000
 .....xxxxxxxxx........0.........
 ....xx.................00000....
 ....xx.....................00...
 .....xxxxxxxxxxxxxxxxxx....00...
 ......................xx...00...
 .......................xxxx00000
 ............................0000
 
 Enter ROW COL to fill from: 13 4
 xxxx............................
 ***xx...........................
 **xxxxxxxxxxxx..................
 **x.........xxxxxxx.............
 **x...........0000xxxx..........
 **xxxxxxxxxxxx0..000............
 **xxxxxxxxx...0...00.....0000000
 **********xx.......0000000000000
 *****xxxxxxxxx........0.........
 ****xx.................00000....
 ****xx.....................00...
 *****xxxxxxxxxxxxxxxxxx....00...
 **********************xx...00...
 ***********************xxxx00000
 ****************************0000
 
  ----jGRASP: operation complete.
 
 
*/