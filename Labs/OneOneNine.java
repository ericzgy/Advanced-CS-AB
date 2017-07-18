//Eric Guan & Adam El Sheikh
import java.util.*;
public class OneOneNine{
   static int count = 0;
   public static void main(String[] args){
      Scanner util = new Scanner(System.in);
      int pls = util.nextInt();
      System.out.println(GreaterTwo(pls));
   }
   public static int GreaterTwo(int a){
   
   
      if(a<2){
         return count;
      }
      else {
         count++;
         return GreaterTwo(a/2);
      }
   }
}