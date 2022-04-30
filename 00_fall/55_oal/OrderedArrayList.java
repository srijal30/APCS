/*
FullStackDevs = Salaj Rijal, Perry Huang, Ariel Fuchs
APCS
HW 55 -- Never Fear Big O is Here! -- Finding time complexity of ArrayList methods
2022-1-11
time: 1 hour

DISCO:
-binary case is weird

QCC:
-What would the time complexity of ArrayList.toString() be?

*/
import java.util.ArrayList;
public class OrderedArrayList
{
  //INSTANCE VARS
  private ArrayList<Integer> _data;

  //CONSTRUCTORS
  public OrderedArrayList()
  {
  	_data = new ArrayList<Integer>();
  }

  //METHODS
  /*
  best case: No items in ArrayList
  worst case: Infinite items in ArrayList
  reason: This is becasue in order to convert an ArrayList to a string you have to
  loop through all the values, which takes linear time. 
  time complexity: O(n)
  */
  public String toString()
  {
    return _data.toString();
  }

  /*
  best case: Remove the item at the end of the ArrayList
  worst case: Remove the first item of the ArrayList
  reason: This is because when you remove an item from a ArrayList, you are looping through all the values
  to the right of the removal index and shifting them to left by 1.
  time complexity: O(n)
  */
  public Integer remove( int i )
  {
    Integer value = _data.get(i);
    _data.remove(i);
    return value;
  }

  /*  
  best case: n/a
  worst case: n/a 
  reason: Only executes one line of code
  time complexity: O(1)
  */
  public int size()
  {
    return _data.size();
  }

  /*  
  best case: n/a
  worst case: n/a
  reason: Only executes one line of code
  time complexity: O(1)
  */
  public Integer get( int i )
  {
    return _data.get(i);
  }

  /*  
  best case: newVal will be the smallest value or equal to the smallest value in the ArrayList
  worst case: newVal will be the greatest value in the ArrayList
  reason: when you use addLinear you are looping through the whole ArrayList until you find a value in the ArrayList
  that is greater than or equal to newVal. Thus if newVal is the smallest, you only have to make one comparision, 
  and if newVal is the greatest you have to loop through the whole ArrayList.
  time complexity: O(n)
  */
  public void addLinear(Integer newVal)
  {
    if(size() == 0){
    	_data.add(newVal);
      return;
    }
    for(int i = 0; i < size(); i++){
      if(get(i)>= newVal){
    	  _data.add(i,newVal);
    	  return;
    	}
    }
    _data.add(newVal);
  }

  /*  
  best case: newVal is the middle value
  worst case: newVal is first, last, or not in it
  reason: binary search goes from the middle to the edges, so the first and last would be the worst case
  time complexity: O( log_2(n) )
  */
  public void addBinary(Integer newVal)
  {
    //algorithm is bad need to fix
    if( size() == 0){
      _data.add(newVal);
      return;
    }
    if( get(0) >= newVal){
      _data.add(0, newVal);
      return;
    }
    if( get( size()-1 ) <= newVal ){
      _data.add(newVal);
      return;
    }
    int hi = size()-1;
    int lo = 0;
    int mid = 0;
    int iterations =  1 + (int) (Math.log(hi)/Math.log(2));
    for( int i = 0; i < iterations ; i++){
      mid = lo + (hi-lo)/2;
      if( get(mid) <= newVal && get(mid+1) >= newVal){
        _data.add(mid+1, newVal);
        return;
      }
      if( newVal < get(mid) ){
        hi = mid;
      }
      else{
        lo = mid;
      }
    }
  }
  	
  public static void main( String[] args )
  {
    //Linear
    OrderedArrayList Ferd = new OrderedArrayList();
    //Binary
    OrderedArrayList Franz = new OrderedArrayList();
        
    Franz = new OrderedArrayList();
    for( int i = 0; i < 15; i++ ){
      int randomNumber = (int)(50*Math.random());
      Franz.addBinary( randomNumber);
      Ferd.addBinary( randomNumber);
    }

    System.out.println( Franz );
    System.out.println( Ferd );

  }//end main()

}//end class OrderedArrayList