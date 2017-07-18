/**
 * Name:     Eric Guan                                    Period: 8
 * Name of the Lab: Polynomial Lab 
 * Purpose of the Program: 
 * Due Date: 3/13
 * Date Submitted: 3/13
 * What I learned: I learned how to represent a Polynomial in the form of a map. I also learned that using the Map.Entry() 
 *    interface for traversing a Map in a for-each loop isn't always the most efficient way. For part of add and all of 
 *    multiply, I realized that in some places using a for-each loop with the keySet() method worked better and was less of a 
 *    hassle.
 * How I feel about this lab: I am happy with this lab, because it prompted me to think outside the box and come up with a 
 *    solution. I had fun debugging my methods and seeing the program work in the end. 
 * What I wonder: I wonder how to get my toString method to print the correct way. I tried several ways to get it, such as
 *    using the Collections reverseOrder() method or using a 2 row 2d-array to store coefficients and exponents, but couldn't
 *    completely figure it out. The lab I have submitted has the correct output, just in reverse order. 
 * Most Difficult Method: For me, I think that the multiply and toString methods were most difficult. I outlined above just
 *    what made the toString method so challenging for me. The multiply method was difficult because I had to think of the logic
 *    behind it. Once I understood the algorithm, it was a piece of cake.
 * Credits: No one :)
 */
import java.util.*;
public class EricGuan8thPeriodPolynomial 
{
   public static void main(String[] args)
   {
      Polynomial poly = new Polynomial();
      poly.makeTerm(1, -4);
      poly.makeTerm(3, 2);
      poly.makeTerm(0, 2);
      System.out.println(poly.toString());
      double evaluateAt = 2.0;
      System.out.println("Evaluated at "+ evaluateAt +": " +poly.evaluateAt(evaluateAt));
   	   	
      Polynomial poly2 = new Polynomial();
      poly2.makeTerm(1, -5);
      poly2.makeTerm(4, 2);
      poly2.makeTerm(0, -3);
      poly2.makeTerm(2, 1); 
      System.out.println(poly2.toString());
   	
      System.out.println(poly.add(poly2));
      System.out.println(poly.multiply(poly2));
   }
}


class Polynomial
{
   private Map<Integer,Integer> poly = new TreeMap<Integer,Integer>();
   public void makeTerm(Integer exponent, Integer coefficient){
      poly.put(exponent,coefficient);
   }
   //pre:none
   //post:returns the value that happens when double x is plugged into the Polynomial expression
   public double evaluateAt(double x){
      double result = 0.0;
      for(Map.Entry<Integer,Integer> entry:poly.entrySet()){
         result+= Math.pow(x,entry.getKey())*entry.getValue();
      }
      return result; 
   }
   //pre:two Polynomial Objects
   //post:returns the  sum of the two
   public Polynomial add(Polynomial other){
      Polynomial result = new Polynomial();
      for(Integer i:this.poly.keySet()){
         result.poly.put(i,poly.get(i));
      }
      for(Map.Entry<Integer,Integer>entry:other.poly.entrySet()){
         if(result.poly.containsKey(entry.getKey())){
            int temp = result.poly.get(entry.getKey())+entry.getValue();
            result.poly.remove(entry.getKey());
            result.poly.put(entry.getKey(),temp);
         }
         else
            result.poly.put(entry.getKey(),entry.getValue());
      }
      return result;
   }
   //pre:two Polynomial Objects
   //post:returns the result of the two
   public Polynomial multiply(Polynomial other){
     Polynomial result = new Polynomial();
      for(Integer a:other.poly.keySet()){
         for(Integer b:this.poly.keySet()){
            int newExponent = a+b;
            if(result.poly.containsKey(newExponent)){
               int temp = result.poly.get(newExponent)+this.poly.get(b)*other.poly.get(a);
               result.poly.remove(newExponent);
               result.poly.put(newExponent,temp);
            }
            else
               result.poly.put(newExponent,(this.poly.get(b)*other.poly.get(a)));
         }
      }
      return result; 
   }
   //pre;none
   //post: prints out Polynomial 
   public String toString(){
      String result = "";
      for(Map.Entry<Integer,Integer> entry:poly.entrySet()){
         if(entry.getKey().equals(0))
            result+=" + "+entry.getValue().toString();
         else if(entry.getKey().equals(1))
            result = entry.getValue().toString() + "x" + result;
         else
            result = entry.getValue().toString() + "x^" + entry.getKey().toString() + " + " +result;     
      }
      
      return result;
   }
}
/*  
expected output
   2x^3 + -4x + 2
   10.0
   2x^4 + x^2 + -5x + -3
   2x^4 + 2x^3 + x^2 + -9x + -1
   4x^7 + -6x^5 + -6x^4 + -10x^3 + 22x^2 + 2x + -6
 */