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
public class Coin {
    //attributes aka instance vars
    private double value; //could possibly be float
    private String name, upFace;
    private int flipCtr, headsCtr, tailsCtr, matches;
    private double bias = 0.5;
    
    //Default Constructor
    public Coin() {
      reset("heads", .05);
    }
  
  
    //First Overloaded Constructer, takes String s name
    public Coin( String s ) {
      name = s;
    }
  
    //Second Overloaded Constructer, takes String s name, and String nowFace upFace
    public Coin( String s, String nowFace ) {
          name = s;
      upFace = nowFace;
    }
  
    // Accessors...
    public String getUpFace() {return upFace;}
    public int getFlipCtr()   {return flipCtr;}
    public double getValue()  {return value;}
    public int getHeadsCtr()  {return headsCtr;}
    public int getTailsCtr()  {return tailsCtr;}
    public int getMatchCtr()  {return matches;}
  
    //Assign value given name
    private double assignValue( String s ) {
      if ( s.equals("penny") ){ value = .01;}
      if ( s.equals("nickel") ){ value = .05;}
      if ( s.equals("dime") ){ value = .10;}
      if ( s.equals("quarter") ){ value = .25;}
      if ( s.equals("halfdollar") ){ value = .50;}
      if ( s.equals("dollar") ){ value = 1.0;}
      return value;
    }
  
    //Resets to default values
    public void reset( String s, double d ) {
      flipCtr = 0;
      tailsCtr = 0;
      headsCtr = 0;
      matches = 0;
      upFace = s;
      bias = d;
  
    }
  
    //Flips coin and updates
    public String flip() {
      double randomValue = Math.random();
      if (randomValue > bias ){
        flipCtr++;
        tailsCtr++;
        upFace = "tails";
        return "tails";
      }
      else{
        flipCtr++;
        headsCtr++;
        upFace = "heads";
        return "heads";
      }
    }
  
    //Check equivalence through upFace
    public boolean equals( Coin other ) {
      boolean isMatch = upFace.equals(other.getUpFace());
      if (isMatch) {
        matches++; 
      }
      return isMatch;
    }
    //Overide of toString Method
    public String toString() {return name + " -- " + upFace;}
  
  }//end class