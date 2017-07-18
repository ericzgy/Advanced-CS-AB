//Name:   Eric Guan
//Date:  1/23/17
// What I learned: I learned about heapsort, its complexity, and how to code to implement it on arrays. I also learned the 
//                recursive logic behind the heapdown method, as well as how to create and display heaps. This lab also reviewed
//                the Math.random() function, which I liked
// How I feel about this lab: I am ambivalent about this lab, as I felt that it was just another routine assignment. Of course,
//                           if forced to chooose an emotion I would say that I am somewhat happy with this lab, because I feel
//                           that I put in a lot of effort into understanding the method and the heap data structure in general.
// I am wondering: I can still get confused sometimes when tracing the heapdown method on longer heaps, so a better understanding 
//                of how the method works with larger k values would be great.
// Help from..: I asked my friend James Zhang to explain the logic of the heapdown method, because I was having great difficulty
//             understanding it. Thankfully, he dedicated more than an hour of his time explaining it to me in such a way that
//             I understood what the method was supposed to do, and how to write it recursively. 
//
public class EricGuanHeapSort_shell
{
   public static final int SIZE = 9;
	
   public static void main(String[] args)
   {
   /*Part 1: Given a heap, sort it. Do this part first.   
      double heap[] = {-1,99,80,85,17,30,84,2,16,1};
      display(heap);
      sort(heap);
      display(heap);  */
      
   //Part 2:  Generate 100 random numbers, make a heap, sort it.
      double[] heap = new double[SIZE + 1];
      createRandom(heap);
      display(heap);
      makeHeap(heap, SIZE);
      display(heap); 
      sort(heap);
      display(heap); 
   }
   
	//******* Part 1 ******************************************
   //pre:none
   //post:displays contents of heap as an array
   public static void display(double[] array)
   {
      for(int k = 1; k < array.length; k++)
         System.out.print(array[k] + "    ");
      System.out.println("\n");	
   }
   //pre:none
   //post:heap is sorted
   public static void sort(double[] array)
   {
      for(int k = array.length - 1; k > 1; k --){
         swap(array, k, 1);
         heapDown(array, 1, k - 1);
      }
      //swap(array, 1, 2);
   }
   //pre:none
   //post:swaps two elements in an array
   public static void swap(double[] array, int a, int b)
   {
      double c = array[a];
      array[a] = array[b];
      array[b] = c;
   }
   //pre:none
   //post:sorts specific region of array, leaving an unsorted section still there, except in one case where it completes the sort
   public static void heapDown(double[] array, int k, int size)
   {
      int left = 2*k;
      int right = 2*k+1;
      if(k > size || left > size)
         return;
      if(right > size && k != 0){//&& array[k] < array[left])
         if(array[left] > array[k])
            swap(array, k, left);
      }
      else{
         int max=0;  
         if (array[left]>array[right])
            max = left;
         else if(array[right]> array[left])
            max = right;
         if(array[k] < array[max]){
            swap(array, k, max);
            heapDown(array, max, size);
         }
      }
         
   
   }
   
   // ****** Part 2 *******************************************
   //pre:none
   //post:creates heap
   public static void makeHeap(double[] array, int size)
   {
      for(int k = size/2; k>=1; k--)
         heapDown(array, k, size);
   }
   //pre:none
   //post:creates array with random values from 1-100 formatted to 2 decimal places 
   public static void createRandom(double[] array)
   {  
      for(int k = 1; k <= SIZE; k++){
         int n;
         do
            n = (int)(Math.random() * 9000);
         while(n % 10 == 0);
         array[k] =  n / 100.0;
      }
   }
}


/*
Part 1:     
 ----jGRASP: connected to debugger.
 99.0    80.0    85.0    17.0    30.0    84.0    2.0    16.0    1.0    
 
1.0    2.0    16.0    17.0    30.0    80.0    84.0    85.0    99.0 
  ----jGRASP: process ended by user.
  
  
  Part 2:
  
       ----jGRASP exec: java EricGuanHeapSort_shell
 53.99    50.37    14.98    74.61    12.59    46.09    49.95    25.37    63.66    
 
 74.61    63.66    49.95    53.99    12.59    46.09    14.98    25.37    50.37    
 
 12.59    14.98    25.37    46.09    49.95    50.37    53.99    63.66    74.61    
 
 
  ----jGRASP: operation complete.
  */