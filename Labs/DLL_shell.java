// Eric Guan 10/2/16 Period 8
public class DLL_shell
{
   public static void main(String args[])
   {
      DLL <String> list = new DLL <String> ();	
   
      list.addLast("Apple");
      list.addLast("Banana");
      list.addLast("Cucumber");
      list.addLast("Dumpling");
      list.addLast("Escargot");
      System.out.println(list);
      System.out.println("Size: " + list.size());
      Object obj = list.remove(3);
      System.out.println(list);
      System.out.println("Size: " +list.size());
      System.out.println("Removed "+ obj);
      System.out.print("Add at 3:   ");
      list.add(3,"Cheese");
      System.out.println(list);
      System.out.println("Get values at 1 and first: " + list.get(0)+" and " + list.getFirst());
      System.out.println("No change: " +list);
      System.out.println( list.removeFirst() + " is now removed!"); 
      System.out.println(list);
      System.out.print("Add first:  ");
      list.addFirst("Anchovie");
      System.out.println(list);
      System.out.println("Size: " + list.size());
      System.out.print("Set the second:  ");
      list.set(2, "Rread");
      System.out.println(list);
   }
}

