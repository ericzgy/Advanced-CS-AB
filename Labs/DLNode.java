
  
public class DLNode <E>
{
   private E value;
   private DLNode prev;
   private DLNode next;
   public DLNode(E arg, DLNode <E> p, DLNode <E> n)
   {
      value=arg;
      prev=p;
      next=n;
   }
   public DLNode()
   {
      value=null;
      next=this;
      prev=this;
   }
   public void setValue(E arg)
   {
      value=arg;
   }
   public void setNext(DLNode <E> arg)
   {
      next=arg;
   }
   public void setPrev(DLNode <E> arg)
   {
      prev=arg;
   }
   public DLNode <E> getNext()
   {
      return next;
   }
   public DLNode <E> getPrev()
   {
      return prev;
   }
   public E getValue()
   {
      return value;
   }
}