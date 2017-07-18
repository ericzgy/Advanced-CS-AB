/*
Name: Eric Guan  Period: 8
Names of the lab: Lab 1 part 1
Purpose of the program: define a polynomial interface that can be implemented by subclasses
Due Date: 9-19-16
Date submitted:9-18-16
What I learned:I was able to review how to write an interface and how to implement them in later classes
How I feel about this lab: see ArrayBasedPoly because I spent the most time there and I feel that parts 1 and 2
                           could be blended together  
Who helped me: no one
Who I helped: no one
*/
public interface Polynomials{
   //pre:
   int getDegree();
   double getCoefficient(int exponent);
   double Evaluate(double number);
   double[] getabp();
   Polynomials getSum(Polynomials P, Polynomials Pi);
   Polynomials getDifference(Polynomials P, Polynomials Pi);
   Polynomials findDerivative(Polynomials P);
}