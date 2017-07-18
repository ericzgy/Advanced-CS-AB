//Name:   Eric Guan
//Date:  February 28th 2017
// What I learned: I learned a lot about the Map data structure, like the methods and how to manipulate and trace code for them.
//                As I've said before, I am a hands-on learner, so labs - especially simple ones such as this help me a lot.
//                I first stumbled upon Map.Entry back in second quarter when working on the extra credit assignment about
//                researching Maps and/or Graphs, and was eager to try it out. It took me a lot of experimenting in class and out,
//                but I am happy with the results.
// How I feel about this lab: I am pleased with this lab,because it reinforced the knowledge I already had and allowed me to 
//                            reinforce it.  
// I am wondering: One thing that I noticed was that the last line of my output is different from the given output, in that
//                Meryl Streep comes first instead of Jack Nicholson. I traced and looked at my code, but I realized that if
//                the values are ArrayLists, and Meryl is added first, then I shouldn't change it to make Jack come first. I 
//                am still wondering what I should have done here to match the given output. 
import java.util.*;
public class EricGuan8thPeriodActingSchool{
   public static void main(String[] args) {
      Map<String, String> sGrades = new HashMap<String, String>();     //HashMap
      sGrades.put("Jack Nicholson", "A-");
      sGrades.put("Humphrey Bogart", "A+");
      sGrades.put("Audrey Hepburn", "A");
      sGrades.put("Meryl Streep", "A-");
      sGrades.put("Jimmy Stewart", "A");
      //First Task
      for(String s: sGrades.keySet()){
         System.out.print(s + " (" + sGrades.get(s) + ")");
         System.out.println();
      }
      //SECOND AND THIRD TASK
      Map<String, ArrayList<String>> newGrades = new HashMap<String, ArrayList<String>>();
      for(Map.Entry<String,String> entry: sGrades.entrySet()){
         if(newGrades.containsKey(entry.getValue()))
            newGrades.get(entry.getValue()).add(entry.getKey());
         else{
            ArrayList<String> a = new ArrayList<String>();
            a.add(entry.getKey());
            newGrades.put(entry.getValue(),a);  
         }
      }
      System.out.println();
      for(String s: newGrades.keySet()){
         System.out.print(s + newGrades.get(s));
         System.out.println();
      }
   }
}

/**********************
 Audrey Hepburn (A)
 Humphrey Bogart (A+)
 Jack Nicholson (A-)
 Jimmy Stewart (A)
 Meryl Streep (A-)
 
 A: [Audrey Hepburn, Jimmy Stewart]
 A+: [Humphrey Bogart]
 A-: [Jack Nicholson, Meryl Streep]
 
 *********************/