// Froghats: Kevin Cheng, Alif Rahman, Salaj Rijal
// APCS pd8
// HW72 -- All About Face
// 2022-03-09
// Time spent: 1 hr

/***
 * class Parition (née Mysterion)
 * 
 * <h1>MYSTERION is PARTITION</h1>
 * The Mysterion method ... <YOUR TRIO'S DESCRIPTION HERE> 
 * <p>
 * <b>Note:</b> BLAH blah blah, yakkety schmakketty...
 * @author  Tom Holland, Zendaya (my gf - Tom Holland)
 * @version pi
 * @since   2022-03-08t 
 *
 * algo as pseudocode:
 * ------------------------------
 *     v = arr[c]
 *     swap arr[c], arr[b]  
 *     s = a
 *     for i in [a..b-1]
 *         if arr[i] < v
 *             swap arr[s], arr[i]
 *             s+=1
 *     swap arr[b], arr[s] 
 **/


public class Partition
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array 
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------


  /**
   * int partition(int[],int,int,int)
   * DESCRIP
   * 
   * @param arr input array of ints
   * @param loPos   
   * @param hiPos
   * @param pvtPos
   * @return int position of 
   *
   */
  public static int partition( int arr[], int loPos, int hiPos)
  {
    //pivot choosing mechanism, is just make loPos the pivot
    int pvtPos = loPos;
    int v = arr[pvtPos];

    //move pivot away from the chaos
    swap( pvtPos, hiPos, arr);
    int s = loPos;

    //put everything less than pivot to the left
    for( int i = loPos; i < hiPos; i++ ) {
      if ( arr[i] < v) {
        swap( i, s, arr );
        s++;}
    }

    //put pivot back
    swap(s,hiPos,arr);

    return s;
  }//end partition


  //main method for testing
  public static void main( String[] args )
  {

    //init test arrays of magic numbers
    int[] arr1 = {3,1,5};
    partition(arr1, 0, 0);
    printArr(arr1);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};


    // run partition on each array,
    // holding loPos & hiPos fixed, varying pvtPos...
    for( int testPIVOT = 0; testPIVOT < 5; testPIVOT++ ) {
      System.out.println("arr1: ");
      printArr(arr1);
      partition(arr1,0,4,testPIVOT);
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos=" 
                         + testPIVOT +"...");
      printArr(arr1);
      System.out.println("-----------------------");

      System.out.println("arr3:");
      printArr(arr3);
      partition(arr3,0,4,testPIVOT);
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos=" 
                         + testPIVOT +"...");
      printArr(arr3);
      System.out.println("-----------------------");

      System.out.println("arr4:");
      printArr(arr4);
      partition(arr4,0,4,testPIVOT);
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos=" 
                         + testPIVOT +"...");
      printArr(arr4);
      System.out.println("-----------------------");

      System.out.println("arr5:");
      printArr(arr5);
      partition(arr5,0,4,testPIVOT);
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos=" 
                         + testPIVOT +"...");
      printArr(arr5);
      System.out.println("-----------------------");
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }
  }//end main

//end class Partition
