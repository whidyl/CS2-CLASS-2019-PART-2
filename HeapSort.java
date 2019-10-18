package ch9;

import java.util.Arrays;

public class HeapSort {
  /** Heap sort method */
  public static <E extends Comparable> void heapSort(E[] list) {
    // Create a Heap of integers
    Heap<E> heap = new Heap<E>();

    // Add elements to the heap
    for (int i = 0; i < list.length; i++)
      heap.add(list[i]);

    heap.printHeap();
    // Remove elements from the heap
    for (int i = list.length - 1; i >= 0; i--)
      list[i] = heap.remove();
  }
  
  /** A test method */
  public static void main(String[] args) {
    Integer[] list = new Integer[120];
    for (int i = 0; i < list.length; i++) {
      list[i] = (int)(Math.random()*200 - 100);
    }
    System.out.println("list: " + Arrays.toString(list));
    heapSort(list);
    System.out.println("list sorted: ");
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
  }
}
