// Fig. 21.13: Queue.java
// Queue uses class List.
package list;
public class Queue  extends list
{
   private List queueList;

   // constructor
   public Queue() 
   { 
      super("queue"); 
   } 

   // add object to queue
   public void enqueue(int object)
   { 
    insertAtBack(object); 
   }

   // remove object from queue
   public int dequeue() throws EmptyListException
   { 
      return removeFromFront(); 
   }

   // // determine if queue is empty
   // public boolean isEmpty()
   // {
   //    return isEmpty();
   // }

   // // output queue contents
   // public void print()
   // {
   //    print();
   // }
} // end class Queue


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
