//Froghats: Kevin Cheng, Salaj Rijal, Alif Rahman
//APCS pd8
//HW78 -- Double Up -- Adding _tail
//2022-03-16t
//time spent: 1h

/*

DISCO:

QCC:

ALGO ADD:

ALGO REM:


*/


/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String _cargo;
  private LLNode _nextNode;
  private LLNode _prevNode;

  // constructor
  public LLNode( String value, LLNode next, LLNode prev )
  {
    _cargo = value;
    _nextNode = next;
    _prevNode = prev;
  }

  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return _cargo;
  }

  public LLNode getNext()
  {
    return _nextNode;
  }

  public LLNode getPrev()
  {
    return _prevNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public LLNode setNext( LLNode newNext )
  {
    LLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }

  public LLNode setPrev( LLNode newPrev ){
    LLNode foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return _cargo;
  }

}//end class LLNode
