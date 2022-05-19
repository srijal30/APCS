import java.util.ArrayList;

public class ALHeapMax
{
  private ArrayList<Integer> _heap;

  public ALHeapMax()
  {
    _heap = new ArrayList<Integer>();
  }


  public String toString()
  {
    return _heap.toString();
  }//O(n)


  public int size() { return _heap.size(); } //O(1)


  public boolean isEmpty() { return _heap.isEmpty(); } //O(1)


  public Integer peekMax()
  {
    if ( _heap.size() < 1 )
      return null;
    else
      return _heap.get(0);
  } //O(1)


  public void add( Integer addVal )
  {

    //Add value as last node, to maintain balance, completeness of tree
    _heap.add( addVal );

    int addValPos = _heap.size() - 1;
    int parentPos;

    while( addValPos > 0 ) { //potentially swap until reach root

      //pinpoint parent
      parentPos = (addValPos-1) / 2;

      if ( addVal.compareTo(_heap.get(parentPos)) > 0 ) { //addVal > parent
        swap( addValPos, parentPos );
        addValPos = parentPos;
      }
      else
        break;
    }
  } //O(logn)


  public Integer removeMax()
  {
    if ( _heap.size() == 0 )
      return null;

    //store root value for return at end of fxn
    Integer retVal = peekMax();

    //store val about to be swapped into root
    Integer foo = _heap.get( _heap.size() - 1);

    //swap last (rightmost, deepest) leaf with root
    swap( 0, _heap.size() - 1 );

    //lop off last leaf
    _heap.remove( _heap.size() - 1);

    // walk the now-out-of-place root node down the tree...
    int pos = 0;
    int maxChildPos;

    while( pos < _heap.size() ) {

      //choose child w/ max value, or check for child
      maxChildPos = maxChildPos(pos);

      //if no children, then i've walked far enough
      if ( maxChildPos == -1 )
        break;
      //if i am more than my most child, then i've walked far enough
      else if ( foo.compareTo( _heap.get(maxChildPos) ) >= 0 )
        break;
      //if i am < most child, swap with that child
      else {
        swap( pos, maxChildPos );
        pos = maxChildPos;
      }
    }
    return retVal;
  }//O(logn)


  private int maxChildPos( int pos )
  {
    int retVal;
    int lc = 2*pos + 1; //index of left child
    int rc = 2*pos + 2; //index of right child

    //pos is not in the heap or pos is a leaf position
    if ( pos < 0 || pos >= _heap.size() || lc >= _heap.size() )
      retVal = -1;
    //if no right child, then left child is only option for max
    else if ( rc >= _heap.size() )
      retVal = lc;
    //have 2 children, so compare to find most
    else if ( _heap.get(lc).compareTo(_heap.get(rc)) > 0 )
      retVal = lc;
    else
      retVal = rc;
    return retVal;
  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer maxOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) > 0 )
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
      ALHeapMax pile = new ALHeapMax();

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

      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
