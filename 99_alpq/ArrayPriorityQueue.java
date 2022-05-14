/*
TNPG: Flying Sullen Actors
Roster: Salaj Rijal, Alif Rahman, Faiyaz Rafee
HW99 -- Some Are More Equal Than Others, Codified
2022-05-13
time spent: 0.7 hours
*/


import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {

    private ArrayList<Integer> foo = new ArrayList<Integer>();
    
    /*
    O(1)
    */
    public void add( int x ) {
        foo.add( (Integer) x  );
    }


    /*
    O(1)
    */
    public boolean isEmpty() {
        return foo.size() <= 0;
    }

    /*
    O(n) 
    */
    public int peekMin() {
        int currentMin = (int) foo.get(0);
        for( Integer val: foo){
            if( (int) val < currentMin  ){
                currentMin = (int) val;
            }

        }
        return currentMin;
    }
    
    /*
    O(n)
    */
    public int removeMin() {
        int minIndex = 0;
        for( int i = 0; i< foo.size(); i++ ){
            if( (int) foo.get(i) < (int) foo.get(minIndex) ){
                minIndex = i;
            }
        }
        int temp = foo.remove(minIndex);  
        return temp;
    }

    /*
    To String (pass thru from ArrayList)
    O(n)
    */
    public String toString() {
        return foo.toString();
    }
    
    public static void main(String[] args) {
      ArrayPriorityQueue poo = new ArrayPriorityQueue();
      poo.add(5);
      poo.add(3);
      poo.add(4);
      poo.add(7);
      poo.add(8);
      poo.add(1);
      System.out.println("poo: "+  poo);

      System.out.println();
      System.out.println("min: " + poo.peekMin());
      System.out.println("removeMin: " + poo.removeMin());
      System.out.println("min: " + poo.peekMin());
      System.out.println("removeMin: " + poo.removeMin());
      System.out.println("min: " + poo.peekMin());
      System.out.println("removeMin: " + poo.removeMin());

      System.out.println();
      System.out.println("poo: "+  poo);
    } //end of main method

} //end of class