/*
The Sentinels: Perry Huang and Salaj Jr., Salaj Rijal and George
APCS
HW24 -- Get It While You Can/Testing Coin.java/Testing flips until they match over 2^16 times and then printing out the stats. 
2021-10-25
time spent: 1.0 hour

DISCO:
-You don't need to indent things in java so you can make code symmetrical. (java ignores spaces/indentations)

QCC:
-Why does upface need to be reset?
-How can we furter improve our code's.

POST-v0 MODS:
- Made the code look better and fixed some unnecessary code
- included reset method in default constructor
- use Math.random() instead of importing random

*/
public class Driver {

    public static void main( String[] args ) {
  
      //Old Tests
      /*===================TOP==========================
        Coin mine = new Coin();
        //test 1st overloaded constructor
        Coin yours = new Coin( "quarter" );
        //test 2nd overloaded constructor
        Coin wayne = new Coin( "dollar", "heads" );
        //test toString() methods of each Coin
        System.out.println("mine: " + mine);
        System.out.println("yours: " + yours);
        System.out.println("wayne: " + wayne);
        //test flip() method
        System.out.println("\nAfter flipping...");
        yours.flip();
        wayne.flip();
        System.out.println("yours: " + yours);
        System.out.println("wayne: " + wayne);
        //test equals() method
        if ( yours.equals(wayne) ) {
          System.out.println( "Matchee matchee!" );
        }
        else {
          System.out.println( "No match. Firestarter you can not be." );
        }
        ====================BOTTOM======================*/
    Coin Perry = new Coin("penny", "tails"); //Dynamic... is flipped
    Coin Salaj = new Coin("dollar", "heads"); //Static... not flipped
      
    int x = 6969; //Amount of heads needed
    int y = 68170; //Amount of matches needed
    
    while (Perry.getHeadsCtr() < x || Perry.getMatchCtr() < y) {
        Perry.flip();
      	Perry.equals(Salaj);
    }
      
    System.out.println(  "Number of Flips: "     +  Perry.getFlipCtr() +
                         "\nNumber of Matches: " + Perry.getMatchCtr() +
                         "\nNumber of Heads: "   + Perry.getHeadsCtr() +
                         "\nNumber of Tails "    + Perry.getTailsCtr() );

    }//end main()
  
  }//end class