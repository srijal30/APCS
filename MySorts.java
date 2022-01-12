import java.util.ArrayList;

public class MySorts{

  //swaps items in the 2 indexes and returns the new ArrayList
  public static void swap(ArrayList swapee, int i1, int i2){
    Object temp = swapee.get(i1);
    swapee.set(i1, swapee.get(i2) );
    swapee.set(i2, temp);
  }

  /*
  ALGO: 
  0. Start at right most index.
  1. Looks at current value and compares it with the adjacent left value.
  2. Swap if the right value is less than the left value. 
  3. Watch me whip whip, nae nae..... Move the index to the left. 
  4. Continue from step 2 unless there is no left value, in which case continue from step 1.
  */
  public static void bubble( ArrayList<Comparable> data )
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
        swap(data, x, x-1);
      }
    }
  }

  /*
  ALGO:
  0. Start at right most index. 
  1. Compare with every value to the left, including the start.
  2. Swap with the least value.
  3. Move index to left by 1.
  4. Go back to step 1.
  */
  public static void selection(ArrayList<Comparable> data )
  {
    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;
    for(int pass = data.size() - 1; pass >= 0; pass--) {
      maxPos = 0;
      for(int i = 0; i <= pass; i++) {
        if (data.get(i).compareTo(data.get(maxPos)) > 0) {
          maxPos = i;
        }
      }
      swap(data, pass, maxPos);
    }
  }//end selectionSort

  
  /*
  ALGO:
  0. Create a partition, starting at index 0.
  1. Make the value to the left of the end of the partition the "new_value".
  2. If the new_value is less than the value to the right, swap the two.
  3. Repeat step 2 until the new_value is in the correct position inside the partition.
  4. Increase the size of the parition by 1 and start at step 1.
  */
  public static void insertion( ArrayList<Comparable> data )
  {
    for(int partition = 0; partition < data.size() - 1; partition++) {
      //partition marks first item in unsorted region
      //traverse sorted region from right to left
      for(int i = partition + 1; i > 0; i--) {
        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(i).compareTo(data.get(i - 1)) < 0 ) {
          swap(data, i, i - 1);
        }
        else{
          break;
        }
      }
    }
  }//end insertionSort

}//end of class
