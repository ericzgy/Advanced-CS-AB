//*********************************************************************************************************************************
//Name:   Eric Guan
// Period:       8                                          Date: March 6th, 2017
// What I learned: I improved my skills with working with Maps and Sets. In addition, I practiced traversing through maps using the Map.Entry interface in the first add method, and more traditional for loops in the reverse method. 
// How I feel about this lab: I am happy with this lab, because it was easy enough for me to finish in time after getting off work, and difficult enough that it made me think about each method and boost my skills.
// What I wonder: Personally, I think that there is still some lasting confusion on the difference between Sets and Maps, because from what I understand, in a Set values are mapped to a location depending on a hashcode, and in a map values are mapped to a specific key. To me, these seem very similar so I would need more explanation as to in which cases do I use which structure. Thanks!
//***********************************************************************************************************************************

import java.io.*;
import java.util.*;
public class EricGuan8thPeriodDictionary
{
   public static void main(String[] args) throws Exception
   {
      try
      {
         System.setOut(new PrintStream(new FileOutputStream("dictionaryOutput.txt")));
      }
      catch(Exception e)
      {
      }
      Map<String, Set<String>> eng2spn = new TreeMap<String, Set<String>>();
      Scanner infile = new Scanner(new File("spanglish.txt"));
      while(infile.hasNext())
      {
         add(eng2spn, infile.next(), infile.next());
      }
      infile.close();
      System.out.println("ENGLISH TO SPANISH");
      display(eng2spn);
      System.out.println();
      Map<String, Set<String>> spn2eng = reverse(eng2spn);
      System.out.println("SPANISH TO ENGLISH");
      display(spn2eng);
   }
   public static void display(Map<String, Set<String>> m)
   {
      for(Map.Entry<String, Set<String>> entry:m.entrySet()){
         System.out.println("  " + entry.getKey() + "[" + entry.getValue() + "]");
      }
   }
   public static void add(Map<String, Set<String>> dictionary, String word, String translation)
   {
      if(dictionary.containsKey(word)){
         dictionary.get(word).add(translation);
      }
      else{      
         Set<String> temp = new HashSet<String>();
         boolean a = temp.add(translation);
         dictionary.put(word, temp);
      }
   }
   public static Map<String, Set<String>> reverse(Map<String, Set<String>> dictionary)
   {
      Map<String, Set<String>> result = new TreeMap<String, Set<String>>();
      for(String s: dictionary.keySet()){
         for(String k:dictionary.get(s)){
            add(result,s,k);
         }
      }
      return result;
         
   }
}
      /********************
	INPUT:
   	holiday
		fiesta
		holiday
		vacaciones
		party
		fiesta
		celebration
		fiesta
     <etc.>
  *********************************** 
	OUTPUT:
		ENGLISH TO SPANISH
			banana [banana]
			celebration [fiesta]
			computer [computadora, ordenador]
			double [doblar, doble, duplicar]
			father [padre]
			feast [fiesta]
			good [bueno]
			hand [mano]
			hello [hola]
			holiday [fiesta, vacaciones]
			party [fiesta]
			plaza [plaza]
			priest [padre]
			program [programa, programar]
			sleep [dormir]
			son [hijo]
			sun [sol]
			vacation [vacaciones]

		SPANISH TO ENGLISH
			banana [banana]
			bueno [good]
			computadora [computer]
			doblar [double]
			doble [double]
			dormir [sleep]
			duplicar [double]
			fiesta [celebration, feast, holiday, party]
			hijo [son]
			hola [hello]
			mano [hand]
			ordenador [computer]
			padre [father, priest]
			plaza [plaza]
			programa [program]
			programar [program]
			sol [sun]
			vacaciones [holiday, vacation]

**********************/