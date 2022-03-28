/*
BlissUp -- Salaj Rijal / Lindsay Phung
APCS
HW27 -- FOR the Love of Strings -- Using FOR-LOOPS to do stuff
2021-10-28
time spent: 1 hour (6:40 - 7:40)

DISCO:
-somewords will cause a similar output as input, for eg "racecar"
-you can work backwards inside fenceF and reverseF
-the AP is a sort of dictionary which explains how to use the built-in java
methods

QCC:
-how can you only return a substring on 1 character?
-why should we use a for-loop when recursion is much simpler and cleaner to 
implement?
-from now on, can we use all methods listed in the AP?
*/

public class Rof {
  
    public static String fenceF(int posts) {
      String fence = "|";
      if (posts == 0) {
        return "";
      }
      for(int i = 1; i < posts; i += 1) {
        fence += "--|";
      }   
      return fence;
    }
  
    public static String reverseF(String s) {
      String result = "";
      for(int i = s.length()-1; i >= 0; i--) {
        result += s.substring(i,i+1);
      }
      return result;
    }
  
    public static String reverseR(String s) {
      //BC
      if (s.length() == 1){
        return s;
      }
      //RR
      return reverseR( s.substring(1) ) + s.substring(0, 1);
    }
  
    public static void main(String[] args){
      //Tests for fenceF
      System.out.println( "Tests for fenceF():");
      System.out.println( fenceF(0) + "...expecting ");    
      System.out.println( fenceF(1) + "...expecting |");
      System.out.println( fenceF(3) + "...expecting |--|--|");
      System.out.println( fenceF(6) + "...expecting |--|--|--|--|--|\n");
  
      
      //Tests for reverseF 
      System.out.println( "Tests for reverseF():");
      System.out.println( reverseF("A") + "...expecting A");
      System.out.println( reverseF("Banana") + "...expecting ananaB");    
      System.out.println( reverseF("Apple") + "...expecting elppA");
      System.out.println( reverseF("RACecar") + "...expecting raceCAR");
      System.out.println( reverseF("sHE bELIEveD") + "...expecting DevEILEb EHs\n");
  
      //Tests for reverseR
      System.out.println( "Tests for reverseR():");
      System.out.println( reverseR("A") + "...expecting A");
      System.out.println( reverseR("hey dawg") + "...expecting gwad yeh");    
      System.out.println( reverseR("pepsi") + "...expecting ispep");
      System.out.println( reverseR("wsg") + "...expecting gsw");
      System.out.println( reverseR("mi casa") + "...expecting asac im\n"); 
    }
  }