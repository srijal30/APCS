// DIVORCE: Salaj Rijal, Michael Kamela, Ariel Fuchs
// APCS pd7
// HW51 -- implementing bubblesort
// 2022-01-04t
// time spent: 1 hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 * 
 * 1. Start at the right of the array and compare the last two values. 
 * 2. If the left value is greater than the right value, swap the values. 
 * 3. Shift the "pair" to the left by one and repeat steps 2-3 until you reach the "boundary", which
 * is the index that seperates items already in their correct places and items not.
 * 
 * DISCO:
 * 
 * Java is pass by reference for objects
 * 
 * In order to obtain a sorted version of an ArrayList but not affect the original, you need to make a copy.
 * 
 * You can use compareTo to generalize bubblesort.
 * 
 *
 * QCC
 * q0: If a pass requires no swaps, what do you know?
 * a0: That the whole array is sorted as no changes were needed
 * q1: After pass p, what do you know?
 * a1: after pass p you know that p elements are 100% in the right position
 * q2: How many passes are necessary to completely sort?
 * a2: the worst case sort would require length of array - 1 passes
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //HELPER METHODS

  // returns an ArrayList of random integers from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }

  //swaps items in the 2 indexes and returns the new ArrayList
  public static void swap(ArrayList swapee, int i1, int i2){
    Object temp = swapee.get(i1);
    swapee.set(i1, swapee.get(i2) );
    swapee.set(i2, temp);
  }

  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    //for each pass do this
    //we loop size of array - 1 times
    for( int i = 0; i < data.size()-1; i++){
      //for each comparison do this
      //we loop less and less for each pass
      for( int x = data.size()-1; x > i; x--){
        Comparable left = data.get(x-1);
        Comparable right = data.get(x);
        //check right is greater than or = to left
        if( right.compareTo(left) >= 0 ){
          continue;
        }
        //swap
        swap(data, x, x-1);
      }
    }
  }

  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    ArrayList<Comparable> data = new ArrayList<Comparable>();
    for( Comparable value: input ){
      data.add(value);
    }

    //for each pass do this
    //we loop size of array - 1 times
    for( int i = 0; i < data.size()-1; i++){
      //for each comparison do this
      //we loop less and less for each pass
      for( int x = data.size()-1; x > i; x--){
        Comparable left = data.get(x-1);
        Comparable right = data.get(x);
        //check right is greater than or = to left
        if( right.compareTo(left) >= 0 ){
          continue;
        }
        //swap
        swap(data, x, x-1);
      }
    }

    return data;
  }


  public static void main( String [] args )
  {
    /*===============for VOID methods=============

    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    bubbleSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );
    
    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    bubbleSortV(coco);
    System.out.println( "ArrayList coco after sorting:\n" + coco );
      ============================================*/

      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );
      
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
      /*==========for AL-returning methods==========
      ============================================*/
      
    }//end main

}//end class BubbleSort
