/*
Name: Eric Guan  Period: 8
Name of the Lab: Lab 1 part 3
Purpose of the program: to be able to take in inputs for rational numbers and do simple mathematical functions with them
                        such as add, subtract, divide, and multiply
Due date:9-19-16
Date submitted:9-18-16
What I learned: I was able to review how to define classes and think about the logic behind a method to simplify fractions
How I feel about this lab: I have a positive feeling towards this part of the lab, I finished this part before parts 1 and 2
                           and did it the day it was assigned because I wanted the review.I think that I could have done the 
                           lab in a much more efficient way, however I did not have the time to change the code after I finished
                           it almost two weeks ago. I enjoyed it nonetheless because I was able to reexperience the fun
                           of working on cs labs and figuring them out. 
Who helped me: me and Adam El Sheikh discussed the logic behind the simplify method and I think we came to a similar conclusion
Who I helped: Kevin Liu, he did not know how to do the simplify method so I helped him out with the logic behind the while loop
             and finding the greatest common factor from two numbers
NOTE: I had so many additional print statements because I had some issues with changing the parameter so that other methods in
      the future would no longer work because of the change, so I printed everything out to make sure that whenever I called
      a method it was not changing the actual parameters that were put in.
*/

public class RationalNum{

   private int numerator;
   private int denominator;
   //simple constructor
   public RationalNum(int numerator, int denominator){
      this.numerator=numerator;
      this.denominator=denominator;
   }
   //two accessor methods
   public int getNumerator(){
      return numerator;
   }
   public int getDenominator(){
      return denominator;
   }
   //two modifier methods
   //Pre: none
   //Post: sets a new Numerator
   public void setNumerator(int a){
      numerator = a;
   }
   //Pre:none
   //Post: sets a new Denominator
   public void setDenominator(int a){
      denominator = a;
   }
   //pre:none
   //post:returns the sum of two RationalNums
   public RationalNum add(RationalNum num){
      RationalNum other = new RationalNum(this.getNumerator(), this.getDenominator());
      int a = this.getNumerator();
      int b = this.getDenominator();
      int c = num.getNumerator();
      int d = num.getDenominator();
      int firstNumerator = a*d;
      int firstDenominator = b*d;
      int secondNumerator = b*c;
      int secondDenominator = firstDenominator; //sets denominators equal
      other.setNumerator(secondNumerator+firstNumerator);
      other.setDenominator(secondDenominator);
      simplify(other);//simplifying after adding is easier than simplifying both then adding
      return other;
   }
   //pre:none
   //post:returns the difference between two RationalNums
   public RationalNum subtract(RationalNum num){
      RationalNum other = new RationalNum(this.getNumerator(), this.getDenominator());
      int a = other.getNumerator();
      int b = other.getDenominator();
      int c = num.getNumerator();
      int d = num.getDenominator();
      int firstNumerator = a*d;
      int firstDenominator = b*d;
      int secondNumerator = b*c;
      int secondDenominator = firstDenominator;
      if(firstNumerator>secondNumerator)
         other.setNumerator(firstNumerator-secondNumerator);
      else{
         other.setNumerator(secondNumerator-firstNumerator);
      }
      other.setDenominator(secondDenominator);  
      simplify(other);
      return other;   
   }
   //pre:none
   //post:returns the product of two RationalNums
   public RationalNum multiply(RationalNum num){
      RationalNum other = new RationalNum(this.getNumerator(), this.getDenominator());
      other.setNumerator(this.getNumerator()*num.getNumerator());
      other.setDenominator(this.getDenominator()*num.getDenominator());
      simplify(other);
      return other;
   }
   //pre:none
   //post:returns the quotient for two RationalNums
   public RationalNum divide(RationalNum num){
      RationalNum other = new RationalNum(this.getNumerator(), this.getDenominator());
      RationalNum other2 = new RationalNum(num.getNumerator(), num.getDenominator());
      int a = this.getNumerator();
      int b = this.getDenominator();
      int c = num.getNumerator();
      int d = num.getDenominator();
      int e = c;
      other2.setNumerator(d);
      other2.setDenominator(e);
      other.setNumerator(this.getNumerator()*num.getNumerator());
      other.setDenominator(this.getDenominator()*num.getDenominator());
      simplify(other);
      return other;
   }
   //pre:a non-simplified RationalNum
   //post:returns a simplified RationalNum
   public static RationalNum simplify(RationalNum num){
      int GreatestCommonFactor = 0;
      int a = num.getNumerator();
      int b = num.getDenominator();
      while (a != 0 && b != 0){
         if (a >= b) {
            a = a - b;
         }
         else
            b = b - a;
      }
      if (a == 0) 
         GreatestCommonFactor = b;
      else {
         GreatestCommonFactor = a;
      }
      num.setNumerator(num.getNumerator()/GreatestCommonFactor);
      num.setDenominator(num.getDenominator()/GreatestCommonFactor); 
      return num;
   }
   //pre:none
   //post:returns whether or not two RationalNums are equal to each other
   public boolean equals(RationalNum num){
      if(getNumerator()==num.getNumerator() && getDenominator()==num.getDenominator())
         return true;
      else 
         return false;   
   }
   //pre:a toString() that needs to be overriden
   //post:overrides the toString() so computer can actually print out RationalNums
   public String toString(){
      if(getNumerator()==0)
         return "" + 0;
      else   
         return getNumerator() + "/" + getDenominator();
   }
   public static void main(String [] args){
      RationalNum a = new RationalNum(3,5);
      RationalNum b = new RationalNum(4,6);
      RationalNum c = new RationalNum(6,11);
      RationalNum d = new RationalNum(7,8);
      RationalNum e = new RationalNum(4,6);
      RationalNum f = new RationalNum(3,9);
      RationalNum g = new RationalNum(4,5);
      RationalNum h = new RationalNum(6,7);
      RationalNum i = new RationalNum(6,7);
      System.out.println(a.divide(b));
      System.out.println(a);
      System.out.println(b);
      System.out.println(c.add(d));
      System.out.println(c);
      System.out.println(d); 
      System.out.println(e.subtract(f));
      System.out.println(e);
      System.out.println(f);
      System.out.println(g.multiply(h));
      System.out.println(g);
      System.out.println(h);
      System.out.println(h.subtract(i));
   }
}

/*
 ----jGRASP exec: java RationalNum
 2/5
 3/5
 4/6
 125/88
 6/11
 7/8
 1/3
 4/6
 3/9
 24/35
 4/5
 6/7
 0
 
  ----jGRASP: operation complete.
*/