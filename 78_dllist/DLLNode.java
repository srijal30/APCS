/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class DLLNode
{
    //instance vars
    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next DLLNode
	private DLLNode _prevNode; //pointer to prev DLLNode

    // constructor -- initializes instance vars
    public DLLNode( String value, DLLNode prev, DLLNode next ) {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }
	public DLLNode getPrev() { return _prevNode; }
    public DLLNode getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) {
	String foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }

	public DLLNode setPrev( DLLNode newNext ) {
	DLLNode foo = getPrev();
	_nextNode = newNext;
	return foo;
    }

    //--------------^  MUTATORS  ^--------------

    // override inherited toString
    public String toString() { return _cargo.toString(); }

}//end class DLLNode

