// Fig. 21.14: QueueTest.java
// Class QueueTest.
package list;
public class QueueTest 
{
   public static void main(String[] args)
   {
      Queue queue = new Queue();  

      // use enqueue method
      queue.enqueue(1);
      queue.print();
      queue.enqueue(2);
      queue.print();
      queue.enqueue(3);
      queue.print();
      queue.enqueue(4);
      queue.print();

      // remove objects from queue
      queue.dequeue();
      queue.print();
      queue.dequeue();
      queue.print();
      queue.enqueue(2);
      queue.print();
   } 
} // end class QueueTest


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
