//Eric Guan
import java.util.*;
public class OneTwoTwo{
  
   public static void main(String args[])
   {
   iSpentOverTwoHoursOnThisBeforeThinkingOfTheSolution ();
   }
   public static void iSpentOverTwoHoursOnThisBeforeThinkingOfTheSolution (){
      String[] str = {"c","a","t","d","o","g"};
      int count =0;
      for(int a=0;a <str.length ;a++){
         for(int b=0; b<str.length;b++){
            for(int c = 0; c< str.length;c++){
               for(int d=0;d<str.length;d++) {
                  for(int e=0;e<str.length;e++) {
                     for(int f=0;f<str.length;f++) {
                     
                        if(a!=b && a!=c && a!=d && a!=e && a!=f && b!=c && b!=d && b!=e && b!=f && c!=d && c!=e && c!=f && d!=e && d!=f && e!=f ){
                           System.out.println(""+ str[a] + str[b]+str[c]+str[d]+str[e]+str[f]);
                           count ++;
                        }
                     }
                  }
               }	   
            
            
            }
         }
      }
      System.out.println(count);
   }
}
//Old Code, worked on this for a long period of time before figuring out the above solution^^
/*
public static void main(String []args){
      pleaseWork("catdog");
   }
   public static void pleaseWork(String s){
      String result[] = new String[s.length()];
      String rip = "";
      for(int j=0;j<s.length();j++){
         result[j] = s.substring(j,j+1);
      }
      for(int a=0;a<s.length();a++){
         rip += result[a];
         for(int b=0;b<s.length();b++){
            while(true){
               if(rip.indexOf(result[b])!= -1)
                  b++;
               else
                  break; 
            }
            rip += result[b];
            b=s.length();
            for(int c=0;c<s.length();c++){
               while(true){
                  if(rip.indexOf(result[c])!= -1)
                     c++;
                  else
                     break; 
               }
               rip += result[c];
               c=s.length();
               for(int d=0;d<s.length();d++){
                  while(true){
                     if(rip.indexOf(result[d])!= -1)
                        d++;
                     else
                        break; 
                  }
                  rip += result[d];
                  d=s.length();
                  for(int e=0;e<s.length();e++){
                     while(true){
                        if(rip.indexOf(result[e])!= -1)
                           e++;
                        else
                           break; 
                     }
                     rip += result[e];
                     e=s.length();
                     for(int f=0;f<s.length();f++){
                        while(true){
                           if(rip.indexOf(result[f])!= -1)
                              f++;
                           else
                              break; 
                        }
                        rip += result[f];
                        System.out.println(rip);
                        f=s.length();
                        //rip="";
                     }
                  }
               }
            }
         }
      }
      
   }

*/
