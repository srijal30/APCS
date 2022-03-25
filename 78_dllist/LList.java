/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 * new in v2: add-at-index, remove
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{ 

  //instance vars
  private DLLNode _head;
  private DLLNode _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _tail = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------
    
  public boolean add( String newVal )
  {
    //edge case when nothing is there
    if( _size == 0 ){
      _head = new DLLNode( newVal, null, null);
      _tail = _head;
      _size++;
      return true;
    }
    //if not edge case do normal algo
    _tail.setNext( new DLLNode(newVal, _tail, null ) );
    _tail = _tail.getNext();
    _size++;
    return true;
  }

  public String get( int index )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
    DLLNode tmp;
    //check which direction is faster to walk
    //walk forward
    if( index <= _size/2 ){
      tmp = _head;
      for( int i=0; i<index; i++ )
	      tmp = tmp.getNext();
    }
    //walk backward
    else{
      tmp = _tail;
      for( int i=_size; i>index; i--)
        tmp = tmp.getPrev();
    }
    //return the value of current
    return tmp.getCargo();
  }


  public String set( int index, String newVal )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
    DLLNode tmp;
    //check which direction is faster to walk
    //walk forward
    if( index <= _size/2 ){
      tmp = _head;
      for( int i=0; i<index; i++ )
        tmp = tmp.getNext();
    }
    //walk backward
    else{
      tmp = _tail;
      for( int i=_size; i>index; i--)
        tmp = tmp.getPrev();
    }
    String oldVal = tmp.getCargo();
    tmp.setCargo( newVal );
    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }
    
  //insert a node containing newVal at position index
  public void add( int index, String newVal ) {
    //check if out of bounds
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
    //check edge cases
    //if add at end
    if( index == _size-1){
      _tail.setNext( new DLLNode(newVal, _tail, null) );
      _tail = _tail.getNext();
      _size++;
      return;
    }
    //if add at front
    else if(index == 0){
      _head.setPrev( new DLLNode(newVal, null, _head) );
      System.out.println(" test " + _head);
      _head = _head.getPrev();
      _size++;
      return;
    }
    DLLNode tmp;
    //check which direction is faster to walk
    //walk forward
    if( index <= _size/2 ){
      tmp = _head;
      for( int i=0; i<index; i++ )
        tmp = tmp.getNext();
    }
    //walk backward
    else{
      tmp = _tail;
      for( int i=_size; i>index; i--)
        tmp = tmp.getPrev();
    }
    //set next of previous to new node
    tmp.getPrev().setNext( new DLLNode(newVal, tmp.getPrev(), tmp) );
    //set previous of current to new node
    tmp.setPrev( tmp.getPrev().getNext() );
	  //increment size attribute
	  _size++;
  }

  //remove node at pos index, return its cargo
  public String remove( int index ) {
    //check if out of bounds
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
    
      DLLNode tmp;
    //check which direction is faster to walk
    //walk forward
    if( index <= _size/2 ){
      tmp = _head;
      for( int i=0; i<index; i++ )
        tmp = tmp.getNext();
    }
    //walk backward
    else{
      tmp = _tail;
      for( int i=_size; i>index; i--)
        tmp = tmp.getPrev();
    }
    //set next of previous to the next of current
    tmp.getPrev().setNext( tmp.getNext() ); 
    //set the previous of next to the previous of current
    tmp.getNext().setPrev( tmp.getPrev() ); 
    _size--;
    return tmp.getCargo();
  }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "NULL-><-";
    DLLNode tmp = _head; //init tr
    System.out.println(tmp);
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "-><-";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }

  //main method for testing
  public static void main( String[] args )
  {

    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james );

    james.add(0,"whut");
    System.out.println( "...after add(0,whut): " );
    System.out.println( james );

    james.add(4,"phat");
    System.out.println( "...after add(4,phat): " );
    System.out.println( james );

    System.out.println( "...after remove last: " 
                        + james.remove( james._size-1) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );
  }

}//end class LList


