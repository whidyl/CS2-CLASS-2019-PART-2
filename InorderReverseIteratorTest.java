/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liang.chpt25;

import java.util.ListIterator;

/**
 *
 * @author bobgils
 * 
 * CSC161 Binary Search Trees
 */
public class InorderReverseIteratorTest {
    public static void main(String[] args) {
      new InorderReverseIteratorTest();
    }

    private InorderReverseIteratorTest() {
      BSTwithReverseIterator<String> tree = new BSTwithReverseIterator<>();
      tree.insert("London");
      tree.insert("Paris");
      tree.insert("Berlin");
      tree.insert("Washington");
      tree.insert("Rome");

      System.out.println("Backward traversal");
      // Setup for backward traversal using class reverseIterator
      // the cursor is set to last element in list by the constructor  
      ListIterator<String> myIterator = tree.reverseIterator(tree.getSize());
      
      //Do backward traversal 
      while (myIterator.hasPrevious()) {
        System.out.println(myIterator.previous());
      } 
 
      tree = new BSTwithReverseIterator<>();
      tree.insert("Orange");
      tree.insert("Apple");
      tree.insert("Banana");
      tree.insert("Pear");
      tree.insert("Watermelon");

      // using class BST iterator
      System.out.println("\nForward traversal\n");    
      // Forward traversal using forward iterator
      for (String s: tree) {
        System.out.println(s);
      }

      // using class reverseIterator
      // the cursor is set to first element in list by the constructor
      myIterator = tree.reverseIterator(0);
      System.out.println("\nModifying the first element.");
      System.out.println(myIterator.next());
      myIterator.set("blank");  //set last element returned by next()
      System.out.println(myIterator.previous());
    
      // forward traverse the list from cursor postion
      System.out.println("\nforward traverse the list from cursor postion");      
      while(myIterator.hasNext()){
        System.out.println(myIterator.next());
      }
      
    }
}
