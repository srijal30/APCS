import java.util.ArrayList;

public class QuickSort{

  public static void swap( ArrayList<Comparable> arr, int i1, int i2){
    Comparable temp = arr.get(i1);
    arr.set(i1, arr.get(i2) );
    arr.set(i2, temp);
  }

  //end should be exclusive
  public static void quickSort(ArrayList<Comparable> arr, int start, int end){
    System.out.println(arr);
    if( end-start == 0) return;

    Comparable pivotVal = arr.get(end);
    int left = 0, right = 0;
    System.out.println("left");
    for(int x = start; arr.get(x).compareTo(pivotVal) <= 0; x++){
      left = x;
      if( left == end-1) break;
      System.out.println(left);
    } 
    System.out.println("right");
    for(int x = end-1; arr.get(x).compareTo(pivotVal) >= 0; x--) {
      right = x;
      if( right == start) break;
      System.out.println(right);
    }

    System.out.println(left + ": " + right);
    
    while( left < right ){
      swap(arr, left, right);
      for(int x = left+1; arr.get(x).compareTo(pivotVal) <= 0; x++){ 
        left = x;
        if( left == end-1 ) break;
      }
      for(int x = right-1; arr.get(x).compareTo(pivotVal) >= 0; x--){ 
        right = x;
        if(right == start) break;
      }
      System.out.println(left + ": " + right);

    }

    swap( arr, end, right);
    quickSort(arr, start, right );
    quickSort(arr, left+1, end );
  }

  public static void main(String[] args) {
    
    ArrayList<Comparable> tbs = new ArrayList<Comparable>();
    tbs.add(5);
    tbs.add(4);
    tbs.add(3);
    tbs.add(2);
    tbs.add(1);
    tbs.add(0);

    System.out.println( tbs );

    quickSort( tbs, 0, tbs.size()-1 );

    System.out.println( tbs );
  }
}