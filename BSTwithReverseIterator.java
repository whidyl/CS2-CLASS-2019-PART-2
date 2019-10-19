package Liang.chpt25;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 *
 * @author bobgils
 * Build an extended class BST that adds the method reverseIterator().
 * The class InorderReverseIterator implements the interface ListIterator<E>.
 * The class InorderReverseIterator implements the interface ListIterator<E>.
 *    - an internal ArrayList is built using an inorder search of the BST.  The elements
 *      of the list are returned by methods next() and previous().

 */
// class BSTwithReverseIterator
// @param <E> extends Comparable<E>
public class BSTwithReverseIterator <E extends Comparable<E>> extends BST<E>{

    //constructors
    BSTwithReverseIterator(){

    }

    public java.util.ListIterator<E> reverseIterator(int index) {
      return new InorderReverseIterator(index);
    }
           
    private class InorderReverseIterator implements java.util.ListIterator<E> {
        /** Inorder traversal from the root*/

        // Store the elements in a list
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0; // Point to the current element in list
        
        public InorderReverseIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }

        public InorderReverseIterator(int index) {
            current = index;
            inorder(); // Traverse binary tree and store elements in list
        }

        public void inorder() {
          inorder(root);
        }

        /** Recursive inorder traversal from a subtree */
        public void inorder(TreeNode root) {
          if (root == null)
              return;
          else {
          /*
          To be completed by student.
          */
          }
        }
        @Override /** More elements for traversing? */
        public boolean hasNext() {
          if (current < (list.size()))
            return true;

          return false;
        }

        @Override /** Get the current element and move to the next */
        public E next() {
          if (current < (list.size()))
          /*
          To be completed by student.
          */
            return E; // E is a place holder 
          else
              throw(new NoSuchElementException("Referencing beyond end of tree"));
        }

        @Override /** Remove the current element */
        public void remove() {
         /*
          To be completed by student.
          Here are the steps:
            1. Delete the current element
            2. Clear the list
            3. Rebuild the list
         */
        }

        public boolean hasPrevious() {
          if (current > 0)
            return true;

          return false;
        }

        public E previous() {
          if (current > 0)
            return list.get(--current);
          else
              throw(new NoSuchElementException("Referencing beyond end of tree"));
        }

        public int nextIndex() {
          return current;
        }

        public int previousIndex() {
          return current-1;
        }

        public void set(E e) {
            if (current > 0 && current <= list.size())
                list.set(current-1, e);
            else
                throw(new NoSuchElementException("Referencing beyond end of tree"));
        }

        public void add(E e) {
            list.add(current++, e);
        }
    }
}
