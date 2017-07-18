/* Name: Eric Guan   Period: 8
Name of the Assignment: Lab 1 Part 3
Purpose of the Program: To be an array based implementation of the Polynomials class
                       that can return many things such as d/dx, degree, and can evaluate as well as
                       add and subtract polynomials
Due date: September 19 2016
Date submitted: September 18 2016
What I learned: This lab helped to reinforce the concepts of inheritanc for me. When I first started, 
               I found myself looking back to the Warriors.java program from two years ago, but as I got more into
               the lab I understood everything much better and was able to code without looking back. In addition, it 
               helped me to remember a lot of the Arrays methods and how they are stored in the memory. I learned the most
               from the toString method. I thought it was working multiple times, and would then test another case and find another
               flaw in it. I debugged it a lot and now understand the importance of testing many cases in order to properly print out
               what I want.
How I feel about this lab: I am actually REALLY happy with this lab, because of all the time I put in. Initially I had
                          no idea how to do it, and thought for a long time about the logic and if I should ask for help. However, 
                          I eventually figured it out. In total I spent probably 10 hours or more on this section alone, which
                          may be much longer than other people but I am still ok with because in the end I did it on my own.
Who helped me: Adam El Sheikh taught me how to initialize an ArrayBasedPoly. Example: Polynomial p = new ArrayBasedPoly(1,2,3);
               I did everything else myself :)
Who I helped: Sean Dumler, I told him how to do it (because he did not remember power rule) but he disagreed with
              my logic and we ultimately had different methods
*/

public class ArrayBasedPoly implements Polynomials{
   private double[] abp; //stands for ArrayBasedPolynomial, abbreviated because typing it every time 
   public ArrayBasedPoly(double []abp){//would be exhaustive
      this.abp=abp;
   } 
   //pre:The Array of Polynomials is defined
   //post:method returns the degree of the Polynomial
   public  int getDegree(){
      int result = 0;
      for(int k=0;k<abp.length;k++){//traverses the array
         if(abp[k]!=0)
            result = k;//finds where there is a coefficient as the loop passes thru the array
      }
      return result;
   }
   //pre:the entered exponent is not greater than or equal to the length of the array
   //post:returns the coefficient of the polynomial at a given exponent
   public  double getCoefficient(int exponent){ 
      if(exponent>=abp.length)
      { //just in case the user makes a mistake and enters a number that is too large
         throw new IllegalArgumentException("Too Big: " + exponent);
      }
      try{
         return abp[exponent];
      }
      catch(IllegalArgumentException e){
         System.out.print("Entered Number is too large: " + e);
      } 
      return abp[exponent];  
   }
   //pre:none
   //post:returns the number that you get when you plug a number into a Polynomial
   public  double Evaluate(double number){
      int result = 0;
      for(int k=0;k<abp.length;k++){
         if(abp[k]!=0){ //plugs in the number but only where the coefficient is not 0
            result += Math.pow(number,k)*abp[k];
         }
      }
      return result;
   }
   //pre:none
   //post:returns the polynomial array
   public double[] getabp(){
      return abp;
   }
   //pre:both polynomials are defined
   //post: method returns a polynomial sum from two polynomials
   public Polynomials getSum(Polynomials P, Polynomials Po){
      int size = 0;
      if(P.getDegree()>Po.getDegree())
         size = P.getDegree()+1;
      else
         size = Po.getDegree()+1; //gets size of larger Array so the sum will be able to add everything
      double []answer = new double[size];
      Polynomials result = new ArrayBasedPoly(answer);   
      for(int k =0;k<=P.getDegree();k++){
         result.getabp()[k] = P.getabp()[k];//sets array equal to P
      }   
      for(int i = 0;i<=Po.getDegree();i++){
         result.getabp()[i] += Po.getabp()[i];//adds everything from Po to P
      }
      return result; //returns sum
   }
   //pre:both Polynomials are defined
   //post:returns a Polynomial difference from two Polynomials
   public Polynomials getDifference(Polynomials P, Polynomials Po){ //It's P-Po
      int size = 0;
      if(P.getDegree()>Po.getDegree())
         size = P.getDegree()+1;
      else
         size = Po.getDegree()+1;
      double []answer = new double[size];
      Polynomials result = new ArrayBasedPoly(answer);   
      for(int k =0;k<=P.getDegree();k++){//<= so I can access the entire array
         result.getabp()[k] = P.getabp()[k];
      }   
      for(int i = 0;i<=Po.getDegree();i++){
         result.getabp()[i] -= Po.getabp()[i];
      }
      return result;
   }
   //pre:Polynomials P is defined
   //post:returns the derivative of a Polynomial using the power rule
   public Polynomials findDerivative(Polynomials P){
      for(int k=0;k<P.getDegree();k++){
         P.getabp()[k] = P.getabp()[k+1]*(k+1);//shifts the array one over
      }
      P.getabp()[P.getDegree()] = 0;//changes the last value so it isn't still the old polynomial
      return P;
   }
   //pre:the toString method needs to be overriden
   //post:overrides the existing toString method so that a System.out.print() statement will 
   //     accurately print out the Polynomial rather than a location in memory
   public String toString(){
      String result = "";
      for(int k=abp.length-1;k>=0;k--){
         if(abp[k]!=0){//don't need to print anything if it's 0 in the array
            if(k==0){
               if(abp[k]<0)
                  result += abp[k]*-1 +"";
               else
                  result += abp[k] + "";
            }
            else if(abp[k]<0&&k!=abp.length-1){
               result += abp[k]*-1 + "x^" + k;//multiplied by -1 so there wouldn't be two "-" signs when printing
            }
            else {
               result += abp[k] + "x^" + k;
            }
         
            if(k-1>=0&&abp[k-1]<0){//checks to makes sure k-1 is still in array, then if abp[k-1] is negative so it can adda "-"
               result += " - ";
            }
            else if (k-1>=0&&abp[k-1]>0)
               result += " + ";
         }
         if(abp[k]==0&&k!=abp.length-1&&k-1>=0&&abp[k-1]<0){//this method and the next method are here to make sure that, if a
            result+=" - ";                               //Polynomial has a 0 in the middle, that when printed out it will 
         }                                               //still have a '+' or '-' between each degree of x
         if(abp[k]==0&&k!=abp.length-1&&k-1>=0&&abp[k-1]>0){
            result+=" + ";
         }
      }
      return result;
   }
   public static void main(String []args){
      double []test = {1,2,3,4};
      double []test2 = {100,-5,0,0,2};
      double []test3 = {0, 0, 31, -2, 5, 7};
      double []test4 = {2, 6, 0, -2, 10, 0, 8};
      Polynomials A = new ArrayBasedPoly(test);
      Polynomials B = new ArrayBasedPoly(test2);
      Polynomials C = new ArrayBasedPoly(test3);
      Polynomials D = new ArrayBasedPoly(test4);
      Polynomials E  = D.getDifference(D,A);
      System.out.println(E);
      System.out.println(C.getSum(C,B));
      System.out.println(D.getSum(D,C));
      System.out.println(C.getDifference(A,C));
      System.out.println(D.getDifference(D,A));
      System.out.println(B.findDerivative(B)); 
      System.out.println(D.findDerivative(D));
      System.out.println(B.getCoefficient(4));
      System.out.println(C.Evaluate(4)); 
      System.out.println(D.getDegree());
      System.out.println(C.getCoefficient(9));
   }//end of main
}//end of demo

/*

  ----jGRASP exec: java ArrayBasedPoly
 8.0x^6 + 10.0x^4 - 6.0x^3 - 3.0x^2 + 4.0x^1 + 1.0
 7.0x^5 + 7.0x^4 - 2.0x^3 + 31.0x^2 - 5.0x^1 + 100.0
 8.0x^6 + 7.0x^5 + 15.0x^4 - 4.0x^3 + 31.0x^2 + 6.0x^1 + 2.0
 -7.0x^5 - 5.0x^4 + 6.0x^3 - 28.0x^2 + 2.0x^1 + 1.0
 8.0x^6 + 10.0x^4 - 6.0x^3 - 3.0x^2 + 4.0x^1 + 1.0
 8.0x^3 - 5.0
 48.0x^5 + 40.0x^3 - 6.0x^2 + 6.0
 0.0
 8816.0
 5
 Exception in thread "main" java.lang.IllegalArgumentException: Too Big: 9
 	at ArrayBasedPoly.getCoefficient(ArrayBasedPoly.java:44)
 	at ArrayBasedPoly.main(ArrayBasedPoly.java:170)
 
  ----jGRASP wedge2: exit code for process is 1.
  ----jGRASP: operation complete.
*/