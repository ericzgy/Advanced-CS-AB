//Eric Guan
public class DLL  <E>      //DoubleLinkedList
{
   private int size;
   private DLNode <E> head = new DLNode <E> (); //dummy node--very useful--simplifies the code
   //pre:none
   //post:returns size of DLL
   public int size()
   {
      return size;
   }
   //pre:DLL is not empty(null)
   //post:inserts obj at position index.  increments size. 
   public void add(int index, E obj)
   {
      DLNode<E> temp=head;
      for(int k=0;k<index-1;k++){
         temp=temp.getNext();
      }
      DLNode<E> previous = temp.getPrev();
      DLNode<E> insert = new DLNode<E>(obj,previous,temp);
      previous.setNext(insert);
      temp.setPrev(insert);
      size++;
   }
   //pre:DLL is not empty(null)
   /*Post: return obj at position index.  
		*/
   public E get(int index)
   {
      for(int k=0;k<index;k++){
         head=head.getNext();
      }
      return head.getValue();
   }
   //pre:DLL is not empty(null)
    /* post:replaces obj at position index.  
		*/
   public void set(int index, E obj)
   {
      DLNode<E> temp=head;
      for(int k =0;k<index-1;k++){
         temp=temp.getNext();
      }
      temp.setValue(obj);
   }
   //pre:DLL is not empty(null)
 /*  post: removes the node from position index.  decrements size.
	  @return the object at position index.
	 */
   public E remove(int index)
   {
      DLNode<E> temp = head;
      for(int k=0;k<index-1;k++){
         temp=temp.getNext();
      }
      temp.getPrev().setNext(temp.getNext());
      temp.getNext().setPrev(temp.getPrev());
      size--;
      return temp.getValue();
   }
 /* pre:DLL is not empty(null)
   post: inserts obj at front of list; increases size;
	  */
   public void addFirst(E obj)
   {
      DLNode<E> temp = head;  
      DLNode<E> previous=temp.getPrev();
      DLNode<E> insert = new DLNode<E>(obj, previous, temp);
      temp.setPrev(insert);
      previous.setNext(insert);
      head=insert;  
      size++;
   }
	/* pre:none
   post:appends obj to end of list; increases size;
	    */
   public void addLast(E obj)
   {
      if(size==0){
         DLNode<E> dummy = new DLNode<E>(obj,null,null);
         head=dummy;
         head.setNext(dummy);
         head.setPrev(dummy);
      }
      else{
         DLNode<E> insert = new DLNode<E>(obj,head.getPrev(),head);
         head.getPrev().setNext(insert);
         head.setPrev(insert);
      }
      size++;
   }
   //pre:none
   //post:returns first value in a DLL
   public E getFirst()
   {
      return head.getValue();
   }
   //pre:none
   //post:returns last value in a DLL
   public E getLast()
   {
      DLNode<E> temp=head;
      temp=temp.getPrev();
      return temp.getValue();
   }
   //pre:DLL is not empty(null)
   //post:first node is removed from DLL
   public E removeFirst()
   {
      E first=head.getValue();
      DLNode<E> previous = head.getPrev();
      head=head.getNext();
      head.setPrev(previous);
      previous.setNext(head);
      size--;
      return first;
   }
   //pre:DLL is not empty(null)
   //post:last node has been removed
   public E removeLast()
   {
      DLNode<E> equal=head.getPrev();
      DLNode<E> previous = equal.getPrev();
      DLNode<E> next = equal.getNext();
      previous.setNext(next);
      next.setPrev(previous);
      size--;
      return equal.getValue();
   }
   //pre:none
   //post:prints out all values in nodes in DLL
   public String toString()
   {
      String result="";
      DLNode<E> temp=head;
      if(temp==null){
         result+="";
      }
      int k=0;
      while (k<size)
      {
         if (temp.getValue() != null)
         {
            result += temp.getValue()+ " ";
         }
         temp = temp.getNext();
         k++;
      }
      return result;
   }
}


/*
  ----jGRASP: connected to debugger.
 Apple Banana Cucumber Dumpling Escargot 
 Size: 5
 Apple Banana Dumpling Escargot 
 Size: 4
 Removed Cucumber
 Add at 3:   Apple Banana Cheese Dumpling Escargot 
 Get values at 1 and first: Apple and Apple
 No change: Apple Banana Cheese Dumpling Escargot 
 Apple is now removed!
 Banana Cheese Dumpling Escargot 
 Add first:  Anchovie Banana Cheese Dumpling Escargot 
 Size: 5
 Set the second:  Anchovie Rread Cheese Dumpling Escargot 
 
  ----jGRASP: process ended by user.
*/