/**
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    return _heap.toString();
  }//O(n)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    //meaningful stuff not implemeennted
    return _heap.size() <= 0;
  }//O(1)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
    return _heap.get(0);
  }//O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * add to latest positon. Keep on swapping up until in right place.
   */
  public void add( Integer addVal )
  {
    
    //add here
    _heap.add( addVal );

    int currentPos = _heap.size() - 1;
    while(  _heap.get(currentPos) < _heap.get( (currentPos - 1) / 2)  ){
      swap( currentPos, (currentPos - 1) /2 );
      currentPos = (currentPos - 1) /2;
    }
  }//O( logN )


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * swap latest node added with min. remove the min. keep on replacing latest node with min child until latest node becomes less than or equal to min child.
   */
  public Integer removeMin()
  {
    if( isEmpty() ) {
      System.out.println("You fool!");
      return -1;
    }
    int tmp = peekMin();

    //if only 1 item in heap
    if (_heap.size() < 2){
      _heap.remove(0);
    }
    else{
      swap( 0, _heap.size()-1 );
      _heap.remove( _heap.size()-1 );
    }

    int currentPos = 0;
    while( minChildPos(currentPos) != -1 &&  _heap.get(currentPos) > _heap.get( minChildPos(currentPos) ) ){
      swap( currentPos, minChildPos(currentPos ) );
      currentPos = minChildPos( currentPos );
    }

    return tmp;
  }//O( logN )


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
    int leftPos = 2 * pos + 1;
    int rightPos = 2 * pos + 2;
    int latest = _heap.size() - 1;
    
    //do we have to keep track of left and right pos
    if( latest < leftPos ) return -1;
    else if ( latest < rightPos ) return leftPos;
    else if( _heap.get(leftPos) <= _heap.get(rightPos) ) return leftPos;
    else return rightPos;
  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {
    ALHeap pile = new ALHeap();
    
      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);

      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      /*------------------------------
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()
  
}//end class ALHeap
