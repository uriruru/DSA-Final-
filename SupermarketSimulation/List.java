// Fig. 21.3: List.java
// ListNode and List class declarations.
package Listint;

// class to represent one node in a list
class ListNode 
{
   // package access members; List can access these directly
   int data; // data for this node
   ListNode nextNode; // reference to the next node in the list

   // constructor creates a ListNode that refers to object
   ListNode(int object) 
   { 
      this(object, null); 
   }  

   // constructor creates ListNode that refers to the specified
   // object and to the next ListNode
   ListNode(int object, ListNode node)
   {
      data = object;    
      nextNode = node;  
   } 

   // return reference to data in node
   int getData() 
   { 
      return data; 
   } 

   // return reference to next node in list
   ListNode  getNext() 
   { 
      return nextNode; 
   } 
} // end class ListNode<T>

// class List definition
public class List 
{
   private ListNode  firstNode;
   private ListNode  lastNode;
   private ListNode  currNode;
   private ListNode  prevNode;
   private String name; // string like "list" used in printing

   // constructor creates empty List with "list" as the name
   public List() 
   { 
      this("list"); 
   } 

   // constructor creates an empty List with a name
   public List(String listName)
   {
      name = listName;
      firstNode = lastNode = null;
   } 

   // insert item at front of List
   public void insertAtFront(int insertItem)
   {
      if (isEmpty()) // firstNode and lastNode refer to same object
         firstNode = lastNode = new ListNode (insertItem);
      else // firstNode refers to new node
         firstNode = new ListNode (insertItem, firstNode);
   } 

   //insert item in between
   public void insertInBetween (int insertItem)
   { 
      if (isEmpty()) // firstNode and lastNode refer to same object
         firstNode = lastNode = new ListNode (insertItem);
      else // firstNode refers to new node
       {
            prevNode = null;
            currNode = firstNode;
            while(currNode.data > insertItem && currNode.nextNode != null){
                prevNode = currNode;
                currNode = prevNode.nextNode;
            }   
            if(currNode.data > insertItem && currNode.nextNode == null)//insertAtBack
            {
                //call insertAtBack
                insertAtBack(insertItem);
            }
            else if(prevNode == null  ) //insertAtFront
            {
                //call insertAtfront
                insertAtFront(insertItem);
            }
            else //insertInBetween
            {
                //do the process of inbetween
                prevNode.nextNode = new ListNode (insertItem, currNode);
            }
       }    
   }
   
   public void removeInBetween(int removeItem)
   {
       
   }
   
   // insert item at end of List
   public void insertAtBack(int insertItem)
   {
      if (isEmpty()) // firstNode and lastNode refer to same object
         firstNode = lastNode = new ListNode (insertItem);
      else // lastNode's nextNode refers to new node
         lastNode = lastNode.nextNode = new ListNode (insertItem);
   } 
   public void reverseCopy() 
   {
      
       
   }
   // remove first node from List
   public int removeFromFront() throws EmptyListException
   {
      if (isEmpty()) // throw exception if List is empty
         throw new EmptyListException(name);

      int removedItem = firstNode.data; // retrieve data being removed

      // update references firstNode and lastNode 
      if (firstNode == lastNode)
         firstNode = lastNode = null;
      else
         firstNode = firstNode.nextNode;

      return removedItem; // return removed node data
   } // end method removeFromFront

   // remove last node from List
   public int removeFromBack() throws EmptyListException
   {
      if (isEmpty()) // throw exception if List is empty
         throw new EmptyListException(name);

      int removedItem = lastNode.data; // retrieve data being removed

      // update references firstNode and lastNode
      if (firstNode == lastNode)
         firstNode = lastNode = null;
      else // locate new last node
      { 
         ListNode current = firstNode;

         // loop while current node does not refer to lastNode
         while (current.nextNode != lastNode)
            current = current.nextNode;
   
         lastNode = current; // current is new lastNode
         current.nextNode = null;
      } 

      return removedItem; // return removed node data
   } 

   // determine whether list is empty
   public boolean isEmpty()
   { 
      return firstNode == null; // return true if list is empty
   } 
   
   public int peekFirstNode()
   {
       return firstNode.data;
   }
   

   // output list contents
   public void print()
   {
      if (isEmpty()) 
      {
         System.out.printf("Empty %s%n", name);
         return;
      }

      System.out.printf("The %s is: ", name);
      ListNode current = firstNode;

      // while not at end of list, output current node's data
      while (current != null) 
      {
         System.out.printf("%s ", current.data);
         current = current.nextNode;
      }

      System.out.println();
   } 
} // end class List<T>

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
